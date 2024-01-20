package me.statuxia.mask;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;

/**
 *
 */
public abstract class MaskedMaster implements Masked {

    private static final long MIN_POSITION = 0;
    private static final long MAX_POSITION = 63;
    private static final IllegalArgumentException POSITION_EXCEPTION = new IllegalArgumentException("Illegal position. Position must be between %d (inclusive) and %d (exclusive)!".formatted(MIN_POSITION, MAX_POSITION));
    protected final long mask;
    protected final boolean onlyPrimitive;
    protected long current;
    private long position;

    public MaskedMaster() throws IllegalAccessException {
        this.mask = 1;
        this.onlyPrimitive = true;
        initFields();
    }

    public MaskedMaster(boolean onlyPrimitive) throws IllegalAccessException {
        this.mask = 1;
        this.onlyPrimitive = onlyPrimitive;
        initFields();
    }

    public MaskedMaster(long mask) throws IllegalAccessException {
        this.mask = mask;
        this.onlyPrimitive = true;
        initFields();
    }

    public MaskedMaster(long mask, boolean onlyPrimitive) throws IllegalAccessException {
        this.mask = mask;
        this.onlyPrimitive = onlyPrimitive;
        initFields();
    }

    private long getMask() {
        if (position < MIN_POSITION || position >= MAX_POSITION) {
            throw POSITION_EXCEPTION;
        }
        if (Long.MAX_VALUE >> position < mask) {
            throw new IllegalArgumentException("Illegal position. Mask has reached its limit on %d".formatted(position - 1));
        }
        return mask << position++;
    }

    private long getCurrentMax() {
        return mask << (position - 1);
    }

    private void initFields() throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            boolean flag = false;
            if (!Modifier.isPublic(field.getModifiers())) {
                try {
                    Method method = this.getClass().getDeclaredMethod("get" +
                            field.getName().substring(0, 1).toUpperCase(Locale.ROOT) +
                            field.getName().substring(1));
                    if (Modifier.isPublic(method.getModifiers())) {
                        flag = true;
                        field.setAccessible(true);
                    }
                } catch (NoSuchMethodException e) {
                    continue;
                }
                if (!flag) {
                    continue;
                }
            }
            Object value = field.get(this);
            if (type.isPrimitive() && ((Number) value).longValue() == 0) {
                field.set(this, getMask());
            } else if (!onlyPrimitive && Number.class.isAssignableFrom(type)) {
                field.set(this, getMask());
            }
            if (flag) {
                field.setAccessible(false);
            }
        }
    }

    public void addToCurrent(long l) {
        if (l > getCurrentMax()) {
            throw new IllegalArgumentException("Illegal argument. %d isn't a mask!".formatted(l));
        }
    }

    public long getCurrent() {
        return current;
    }
}
