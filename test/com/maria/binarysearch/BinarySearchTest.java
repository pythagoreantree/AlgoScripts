package com.maria.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class BinarySearchTest {

    @DisplayName("My Binary Search")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.binarysearch.DataProvider#searchDataProvider")
    void search(int[] nums, int target, int ans) {
        int pos = BinarySearch.search(nums, target);
        Assertions.assertEquals(ans, pos);
//      TPrinter.print(ans);
    }

    @DisplayName("Sqrt Function")
    @ParameterizedTest(name = "{index}) the sqrt of {0} is {1}")
    @CsvSource({
        "2147395599, 46339"
    })
    void mySqrt(int number, int sqrt) {
        int ans = BinarySearch.mySqrt(number);
        Assertions.assertEquals(sqrt, ans);
//      TPrinter.print(ans);
    }

    @Test
    void guessNumber() {
        int n = 10;
        int ans = BinarySearch.guessNumber(n);
        TPrinter.print(ans);
    }

    @DisplayName("Search Non Sorted Array")
    @ParameterizedTest(name = "{index}) {0}")
    @ArgumentsSource(SearchNonSortedProvider.class)
    void searchNonSortedArray(String caseName, ArrTarget arrTarget) {
        int pos = BinarySearch.searchNonSortedArray(arrTarget.getNums(), arrTarget.getTarget());
        Assertions.assertEquals(arrTarget.getResult(), pos);
//      TPrinter.print(pos);
    }

    @DisplayName("Find Minimum In a Rotated Array")
    @ParameterizedTest(name = "{index}) nums: {0}, ans: {1}")
    @MethodSource("com.maria.binarysearch.DataProvider#findMinInRotatedArrayProvider")
    void findMinInRotatedArray(int[] nums, int ans) {
        int pos = BinarySearch.findMinInRotatedArray(nums);
        Assertions.assertEquals(ans, pos);
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
