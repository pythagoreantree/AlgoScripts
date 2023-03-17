package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSmallerThanCurrentTest {

    @Test
    void smallerNumbersThanCurrent() {
        int[] nums = {8, 1, 2, 2, 3};
        int[] expected = {4, 0, 1, 1, 3};
        int[] actual = NumberSmallerThanCurrent.smallerNumbersThanCurrent(nums);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[] nums = {7, 7, 7};
        int[] exp = {0, 0, 0};
        int[] act = NumberSmallerThanCurrent.smallerNumbersThanCurrent(nums);
        Assertions.assertArrayEquals(exp, act);
    }
}