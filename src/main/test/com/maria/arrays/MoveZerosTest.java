package com.maria.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    @Test
    void moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeros.moveZeroes(nums);
        for (int num: nums)
            System.out.print(num + " ");
    }
}