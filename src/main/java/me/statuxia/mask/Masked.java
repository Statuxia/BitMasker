package me.statuxia.mask;

/**
 * Interface for classes implementing storage of values for bitwise masks.
 *
 * <p>This interface provides a method for retrieving the current value of a bitwise mask.
 * The mask value is represented as an object, which should be a subclass of
 * the {@link Number} class.
 *
 * @param <T> The data type representing the value of the bitwise mask. Should be a subclass of Number.
 * @see Number
 */
public interface Masked<T extends Number> {

    /**
     * Retrieves the current value of the bitwise mask.
     *
     * @return The current value of the bitwise mask.
     */
    T getCurrent();
}
