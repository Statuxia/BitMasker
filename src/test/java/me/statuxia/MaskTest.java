package me.statuxia;

import me.statuxia.mask.MaskUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaskTest {

    @Test
    public void testIsMask() {
        int mask1 = 6; // 110
        int mask2 = 2; // 010
        Assertions.assertTrue(MaskUtils.isMask(mask1, mask2));

        mask1 = 5; // 101
        mask2 = 3; // 011
        Assertions.assertFalse(MaskUtils.isMask(mask1, mask2));

        mask1 = 7; // 111
        Assertions.assertTrue(MaskUtils.isMask(mask1, mask2));
    }

    @Test
    public void testSumMasks() {
        int mask1 = 6; // 110
        int mask2 = 2; // 010
        int expected = 6; // 110
        Assertions.assertEquals(MaskUtils.sumMasks(mask1, mask2), expected);

        mask1 = 5; // 101
        mask2 = 3; // 011
        expected = 7; // 111
        Assertions.assertEquals(MaskUtils.sumMasks(mask1, mask2), expected);
    }

    @Test
    public void testMasks() {
        int mask1 = 6; // 110
        int mask2 = 2; // 010
        int expected = 4; // 100
        Assertions.assertEquals(MaskUtils.subMasks(mask1, mask2), expected);

        mask1 = 5; // 101
        mask2 = 3; // 011
        Assertions.assertEquals(MaskUtils.subMasks(mask1, mask2), expected);
    }
}
