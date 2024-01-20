package me.statuxia.mask;

/**
 * Utility class for performing bitwise operations on masks.
 */
public class MaskUtils {

    /**
     * Computes the bitwise OR of two long masks.
     *
     * @param mask  the first long mask.
     * @param mask2 the second long mask.
     * @return the result of bitwise OR operation.
     */
    public static long sumMasks(long mask, long mask2) {
        return mask | mask2;
    }

    /**
     * Computes the bitwise OR of two integer masks.
     *
     * @param mask  the first integer mask.
     * @param mask2 the second integer mask.
     * @return the result of bitwise OR operation.
     */
    public static long sumMasks(int mask, int mask2) {
        return mask | mask2;
    }

    /**
     * Computes the bitwise OR of a long mask and a Masked instance.
     *
     * @param mask  the long mask.
     * @param mask2 the Masked instance containing a long mask.
     * @return the result of bitwise OR operation.
     */
    public static long sumMasks(long mask, Masked<? extends Long> mask2) {
        return mask | mask2.getCurrent();
    }

    /**
     * Computes the bitwise OR of an integer mask and a Masked instance.
     *
     * @param mask  the integer mask.
     * @param mask2 the Masked instance containing an integer mask.
     * @return the result of bitwise OR operation.
     */
    public static int sumMasks(int mask, Masked<? extends Integer> mask2) {
        return mask | mask2.getCurrent();
    }

    /**
     * Computes the bitwise AND NOT of two long masks.
     *
     * @param mask  the first long mask.
     * @param mask2 the second long mask.
     * @return the result of bitwise AND NOT operation.
     */
    public static long subMasks(long mask, long mask2) {
        return mask & ~mask2;
    }

    /**
     * Computes the bitwise AND NOT of two integer masks.
     *
     * @param mask  the first integer mask.
     * @param mask2 the second integer mask.
     * @return the result of bitwise AND NOT operation.
     */
    public static int subMasks(int mask, int mask2) {
        return mask & ~mask2;
    }

    /**
     * Computes the bitwise AND NOT of a long mask and a Masked instance.
     *
     * @param mask  the long mask.
     * @param mask2 the Masked instance containing a long mask.
     * @return the result of bitwise AND NOT operation.
     */
    public static long subMasks(long mask, Masked<? extends Long> mask2) {
        return mask & ~mask2.getCurrent();
    }

    /**
     * Computes the bitwise AND NOT of an integer mask and a Masked instance.
     *
     * @param mask  the integer mask.
     * @param mask2 the Masked instance containing an integer mask.
     * @return the result of bitwise AND NOT operation.
     */
    public static int subMasks(int mask, Masked<? extends Integer> mask2) {
        return mask & ~mask2.getCurrent();
    }

    /**
     * Checks if a long mask contains another long mask.
     *
     * @param mask  the long mask.
     * @param mask2 the long mask to check against.
     * @return true if the mask contains the other mask, false otherwise.
     */
    public static boolean isMask(long mask, long mask2) {
        return (mask & mask2) == mask2;
    }

    /**
     * Checks if an integer mask contains another integer mask.
     *
     * @param mask  the integer mask.
     * @param mask2 the integer mask to check against.
     * @return true if the mask contains the other mask, false otherwise.
     */
    public static boolean isMask(int mask, int mask2) {
        return (mask & mask2) == mask2;
    }

    /**
     * Checks if a long mask contains the mask from a Masked instance.
     *
     * @param mask  the long mask.
     * @param mask2 the Masked instance containing a long mask to check against.
     * @return true if the mask contains the other mask, false otherwise.
     */
    public static boolean isMask(long mask, Masked<? extends Long> mask2) {
        return (mask & mask2.getCurrent()) == mask2.getCurrent();
    }

    /**
     * Checks if an integer mask contains the mask from a Masked instance.
     *
     * @param mask  the integer mask.
     * @param mask2 the Masked instance containing an integer mask to check against.
     * @return true if the mask contains the other mask, false otherwise.
     */
    public static boolean isMask(int mask, Masked<? extends Integer> mask2) {
        return (mask & mask2.getCurrent()) == mask2.getCurrent();
    }
}