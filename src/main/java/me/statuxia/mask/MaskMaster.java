package me.statuxia.mask;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;

/**
 * An abstract class implementing the Masked interface with a Long data type.
 * This class provides functionality for managing and manipulating bitwise masks.
 *
 * <p>The class supports the storage and retrieval of Long values representing bitwise masks.
 * It includes methods for initializing mask fields, obtaining the current mask value,
 * and adding values to the current mask.
 *
 * <p>The bitwise mask is represented by a Long value, and the class ensures that the
 * position of the mask is within valid bounds (0 (inclusive) to 63 (exclusive)).
 *
 * <p>Instances of this class can be created with various configurations, allowing
 * customization of the mask and the use of primitive types.
 *
 * @see Masked
 */
public abstract class MaskMaster implements Masked<Long> {

    private static final long MIN_POSITION = 0;
    private static final long MAX_POSITION = 63;
    private static final IllegalArgumentException POSITION_EXCEPTION = new IllegalArgumentException("Illegal position. Position must be between %d (inclusive) and %d (exclusive)!".formatted(MIN_POSITION, MAX_POSITION));
    protected final long mask;
    protected final boolean onlyPrimitive;
    protected long current;
    private long position;

    /**
     * Default constructor that initializes the mask with the value 1 and restricts
     * the usage to primitive types only.
     *
     * @throws IllegalAccessException If there is an issue accessing class fields.
     */
    public MaskMaster() throws IllegalAccessException {
        this.mask = 1;
        this.onlyPrimitive = true;
        initFields();
    }

    /**
     * Constructor that allows customization of whether only primitive types can be used.
     *
     * @param onlyPrimitive True if only primitive types are allowed, false otherwise.
     * @throws IllegalAccessException If there is an issue accessing class fields.
     */
    public MaskMaster(boolean onlyPrimitive) throws IllegalAccessException {
        this.mask = 1;
        this.onlyPrimitive = onlyPrimitive;
        initFields();
    }

    /**
     * Constructor that allows customization of the initial mask value.
     *
     * @param startPos The initial mask value.
     * @throws IllegalAccessException If there is an issue accessing class fields.
     */
    public MaskMaster(long startPos) throws IllegalAccessException {
        this.mask = startPos;
        this.onlyPrimitive = true;
        initFields();
    }

    /**
     * Constructor that allows customization of both the initial mask value and
     * whether only primitive types can be used.
     *
     * @param startPos      The initial mask value.
     * @param onlyPrimitive True if only primitive types are allowed, false otherwise.
     * @throws IllegalAccessException If there is an issue accessing class fields.
     */
    public MaskMaster(long startPos, boolean onlyPrimitive) throws IllegalAccessException {
        this.mask = startPos;
        this.onlyPrimitive = onlyPrimitive;
        initFields();
    }

    /**
     * Retrieves the current mask and updates the position for the next mask.
     *
     * @return the current mask.
     * @throws IllegalArgumentException if the position is out of bounds or the mask has reached its limit.
     */
    private long getMask() {
        if (position < MIN_POSITION || position >= MAX_POSITION) {
            throw POSITION_EXCEPTION;
        }
        if (Long.MAX_VALUE >> position < mask) {
            throw new IllegalArgumentException("Illegal position. Mask has reached its limit on %d".formatted(position - 1));
        }
        return mask << position++;
    }

    /**
     * Gets the maximum value that the current mask can reach without updating the position.
     *
     * @return the maximum value of the current mask.
     */
    private long getCurrentMax() {
        return mask << (position - 1);
    }

    /**
     * Initializes fields by masking primitive types or all types based on configuration.
     *
     * @throws IllegalAccessException if field initialization encounters an issue.
     */
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

    /**
     * Adds a value to the current mask, ensuring it does not exceed the maximum allowed value.
     *
     * @param value the value to add to the current mask.
     * @throws IllegalArgumentException if the argument is not a valid mask.
     */
    public void addToCurrent(long value) {
        if (value > getCurrentMax()) {
            throw new IllegalArgumentException("Illegal argument. %d isn't a mask!".formatted(value));
        }
        current = MaskUtils.sumMasks(current, value);
    }

    /**
     * Retrieves the current value of the bitwise mask.
     *
     * @return The current value of the bitwise mask.
     */
    public Long getCurrent() {
        return current;
    }
}
