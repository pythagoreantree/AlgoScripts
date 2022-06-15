package com.maria.morepractices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sun.lwawt.macosx.CTextPipe;

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
        int[] result = Common.intersectionOfTwoArraysIIBinSearch(nums1, nums2);
        Arrays.sort(ans);
        Arrays.sort(result);
        Assertions.assertEquals(ans.length, result.length);
        for (int i = 0; i < result.length; i++) {
            Assertions.assertEquals(ans[i], result[i]);
        }
    }
}