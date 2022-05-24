package com.maria.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BinarySearchTest {

    @Test
//    @ParameterizedTest
//    @ValueSource(ints = {7, 8, 9})
    void search() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        //        int[] nums = {-1, 0, 3, 5, 9, 12};
        //        int target = 2;

        int pos = BinarySearch.search(nums, target);
        Assertions.assertEquals(4, pos);
        //        TPrinter.print(ans);
    }

    @Test
    void mySqrt() {
        int ans = BinarySearch.mySqrt(2147395599);
        Assertions.assertEquals(46339, ans);
        //        TPrinter.print(ans);
    }

    @Test
    void guessNumber() {
        int n = 10;
        int ans = BinarySearch.guessNumber(n);
        TPrinter.print(ans);
    }

    @Test
    void searchNonSortedArray() {
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 0, 1};
        int target = 8;
        //        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        //        int target = 1;
        //        int[] nums = {5, 1, 3};
        //        int target = 3;
        int pos = BinarySearch.searchNonSortedArray(nums, target);
        Assertions.assertEquals(6, pos);
        //        TPrinter.print(pos);
    }

    @Test
    void findMinInRotatedArray() {
        int[] nums = {5, 0, 1, 2, 3, 4};
        //        int[] nums = {1,2};
        int pos = BinarySearch.findMinInRotatedArray(nums);
        Assertions.assertEquals(0, pos);
        //        TPrinter.print(pos);
    }

    @Test
    void findPivot() {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        //        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        int pivot = BinarySearch.findPivot(arr, 0, arr.length - 1);
        Assertions.assertEquals(5, pivot);
        //        TPrinter.print(pivot);
    }

    @Test
    void findPeakElement() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int pos = BinarySearch.findPeakElement(nums);
        Assertions.assertEquals(5, pos);
        //        TPrinter.print(pos);
    }

    @Test
    void findPeakElementT3() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int pos = BinarySearch.findPeakElementT3V2(nums);
//        Assertions.assertEquals(5, pos);
        TPrinter.print(pos);
    }

    @Test
    void searchL() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        //        int[] nums = {};
        //        int target = 0;
        int pos = BinarySearch.searchL(nums, target);
        Assertions.assertEquals(3, pos);
        //        TPrinter.print(pos);
    }

    @Test
    void searchR() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        //        int[] nums = {};
        //        int target = 0;
        int pos = BinarySearch.searchR(nums, target);
        Assertions.assertEquals(4, pos);
        //        TPrinter.print(pos);
    }

    @Test
    void searchLR() {
        int[] nums = {5, 7, 7, 7, 9, 10};
        int target = 8;
        int[] ans = BinarySearch.searchLR(nums, target);
        Assertions.assertEquals(ans[0], -1);
        Assertions.assertEquals(ans[1], -1);
        //        TPrinter.printArray(ans);
    }

    @Test
    void searchRange() {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 4;
        int[] nums = {2, 2};
        int target = 2;
        TPrinter.printArray(BinarySearch.searchRange(nums, target));
    }

    @Test
    void findKClosestElements() {
//        int[] nums = {1,2,3,4,5};
//        int x = 3;
//        int k = 4;
        int[] nums = {1,2};
        int k = 1, x = 1;
//        int[] nums = {1,1,2,2,2,2,2,3,3};
//        int k = 3, x = 3;
        TPrinter.print(BinarySearch.findKClosestElements(nums, k, x));
    }

    @Test
    void search4() {
        int[] nums = {1,2,4,5,6};
        int target = 4;
        int pos = BinarySearch.search4(nums, target);
        TPrinter.print(pos);
    }

    @Test
    void myPow() {
//        double x = 2.0;
//        int n = 10;
        double x = 2.0;
        int n = -3;
//        double x = 2.1;
//        int n = 3;
        double ans = BinarySearch.myPow(x, n);
        TPrinter.print(ans);

    }
}
