package com.maria.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class BinarySearchTest {

    @DisplayName("My Binary Search")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.DataProvider#searchDataProvider")
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

    @DisplayName("Guess Number")
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
    @MethodSource("com.maria.DataProvider#findMinInRotatedArrayProvider")
    void findMinInRotatedArray(int[] nums, int ans) {
        int pos = BinarySearch.findMinInRotatedArray(nums);
        Assertions.assertEquals(ans, pos);
//        TPrinter.print(pos);
    }


    @DisplayName("Find Pivot")
    @ParameterizedTest(name = "{index}) nums: {0}, ans: {1}")
    @MethodSource("com.maria.DataProvider#findPivotProvider")
    void findPivot(int[] nums, int ans) {
        int pivot = BinarySearch.findPivot(nums, 0, nums.length - 1);
        Assertions.assertEquals(ans, pivot);
        //        TPrinter.print(pivot);
    }

    @DisplayName("Find Peak Element")
    @ParameterizedTest(name = "{index}) nums: {0}, ans: {1}")
    @MethodSource("com.maria.DataProvider#findPeakElement")
    void findPeakElement(int[] nums, int ans) {
        int pos = BinarySearch.findPeakElement(nums);
        Assertions.assertEquals(ans, pos);
//        TPrinter.print(pos);
    }

    @DisplayName("Find Peak Element V3")
    @ParameterizedTest(name = "{index}) nums: {0}, ans: {1}")
    @MethodSource("com.maria.DataProvider#findPeakElement")
    void findPeakElementT3(int[] nums, int ans) {
        int pos = BinarySearch.findPeakElementT3V2(nums);
        Assertions.assertEquals(ans, pos);
//        TPrinter.print(pos);
    }

    @DisplayName("Search Left Occurence")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.DataProvider#searchLeftProvider")
    void searchL(int[] nums, int target, int ans) {
        int pos = BinarySearch.searchL(nums, target);
        Assertions.assertEquals(ans, pos);
//      TPrinter.print(pos);
    }

    @DisplayName("Search Right Occurence")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.DataProvider#searchRightProvider")
    void searchR(int[] nums, int target, int ans) {
        int pos = BinarySearch.searchR(nums, target);
        Assertions.assertEquals(ans, pos);
//      TPrinter.print(pos);
    }

    @DisplayName("Search Left and Right Occurences")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.DataProvider#searchLeftRightProvider")
    void searchLR(int[] nums, int target, int[] res) {
        int[] ans = BinarySearch.searchLR(nums, target);
        Assertions.assertEquals(ans[0], res[0]);
        Assertions.assertEquals(ans[1], res[1]);
//      TPrinter.printArray(ans);
    }


    @DisplayName("Search Range")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.DataProvider#searchRangeProvider")
    void searchRange(int[] nums, int target, int[] res) {
        int[] ans = BinarySearch.searchRange(nums, target);
        Assertions.assertEquals(ans[0], res[0]);
        Assertions.assertEquals(ans[1], res[1]);
//        TPrinter.printArray(ans);
    }

    @DisplayName("Find K Closest Elements")
    @ParameterizedTest(name = "{index}) nums: {0}, x: {1}, k: {2}")
    @MethodSource("com.maria.DataProvider#findKClosestElementsProvider")
    void findKClosestElements(int[] nums, int x, int k, List<Integer> result) {
        List<Integer> neighbours = BinarySearch.findKClosestElements(nums, k, x);
        for (int i = 0; i < neighbours.size(); i++){
            Assertions.assertEquals(result.get(i), neighbours.get(i));
        }
//        TPrinter.print(neighbours);
    }

    @DisplayName("Search Variant 4")
    @ParameterizedTest(name = "{index}) nums: {0}, target: {1}")
    @MethodSource("com.maria.DataProvider#search4Provider")
    void search4(int[] nums, int target, int result) {
        int pos = BinarySearch.search4(nums, target);
        Assertions.assertEquals(result, pos);
//        TPrinter.print(pos);
    }

    @DisplayName("My Power Function")
    @ParameterizedTest(name = "{index}) x: {0}, n: {1}")
    @CsvSource({
            "2.0, 10, 1024.0",
            "2.0, -3, 0.125",
            "2.1, 3, 9.262"
    })
    void myPow(double x, int n, double result) {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        double ans = BinarySearch.myPow(x, n);
        Assertions.assertEquals(df.format(result), df.format(ans));
//        TPrinter.print(ans);
    }

    @DisplayName("Valid Perfect Square")
    @ParameterizedTest(name = "{index}) num: {0}, ans: {1}")
    @CsvSource({
            "14, false",
            "16, true",
            "808201, true",
            "5, false"
    })
    void isPerfectSquare(int num, boolean ans) {
        boolean result = BinarySearch.isPerfectSquare(num);
        Assertions.assertEquals(ans, result);
    }

    @DisplayName("Find Smallest Letter Greater Than Target")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#findLetterProvider")
    void nextGreatestLetter(char[] letters, char target, char ans) {
        char result = BinarySearch.nextGreatestLetter(letters, target);
        Assertions.assertEquals(ans, result);
    }

    @DisplayName("Find Minimum in Rotated Sorted Array")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#findMin2Provider")
    void findMinInRotatedArray2(int[] nums, int ans) {
        int result = BinarySearch.findMinInRotatedArray2(nums);
        Assertions.assertEquals(ans, result);
    }

    @DisplayName("Find Minimum in Rotated Sorted Array II")
    @ParameterizedTest
    @MethodSource("com.maria.DataProvider#findMinWithDuplicatesProvider")
    void findMinInRotatedArrayWithDuplicates(int[] nums, int ans) {
        int result = BinarySearch.findMinInRotatedArrayWithDuplicates2(nums);
        Assertions.assertEquals(ans, result);
    }
}
