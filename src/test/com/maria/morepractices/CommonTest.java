package com.maria.morepractices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CommonTest {

    @DisplayName("Intersection of Two Arrays")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#intersectionOfTwoArraysProvider")
    void intersectionOfTwoArrays(int[] nums1, int[] nums2, int[] ans) {
        int[] result = Common.intersectionOfTwoArraysBinSearch(nums1, nums2);
        Arrays.sort(ans);
        Arrays.sort(result);
        Assertions.assertEquals(ans.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(ans[i], result[i]);
        }
    }

    @DisplayName("Intersection of Two Arrays II")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#intersectionOfTwoArraysIIProvider")
    void intersectionOfTwoArraysII(int[] nums1, int[] nums2, int[] ans) {
        int[] result = Common.intersectionOfTwoArraysIIv2(nums1, nums2);
        Arrays.sort(ans);
        Arrays.sort(result);
        Assertions.assertEquals(ans.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(ans[i], result[i]);
        }
    }

    @DisplayName("Two Sum II - Input array is sorted")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#twoSumProvider")
    void twoSum(int[] nums, int target, int[] ans) {
        int[] result = Common.twoSumV4(nums, target);
        Assertions.assertEquals(ans[0], result[0]);
        Assertions.assertEquals(ans[1], result[1]);
    }


    @DisplayName("Find the Duplicate Number")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#findDuplicateNumberProvider")
    void findDuplicate(int[] nums, int ans) {
        int result = Common.findDuplicate(nums);
        Assertions.assertEquals(ans, result);
    }

    @DisplayName("Median of Two Sorted Arrays")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#findMedianTwoSortedProvider")
    void findMedianOfTwoSortedArrays(int[] nums1, int[] nums2, double ans) {
        double result = Common.getMedian(nums1, nums2);
        System.out.println(result);
    }
}