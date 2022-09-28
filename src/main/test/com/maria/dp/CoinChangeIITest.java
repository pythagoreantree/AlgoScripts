package com.maria.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeIITest {

    @Test
    void countSumCombinations() {
        int[] nums1 = {1, 2, 5};
        int targetSum1 = 5;
        System.out.println(CoinChangeII.countSumCombinations(nums1, targetSum1));
    }

    @Test
    void countSumCombinations2() {
        int[] nums1 = {2};
        int targetSum1 = 3;
        System.out.println(CoinChangeII.countSumCombinations(nums1, targetSum1));
    }
}