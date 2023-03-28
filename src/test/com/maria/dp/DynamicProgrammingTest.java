package com.maria.dp;

import org.junit.jupiter.api.Test;

import javax.swing.*;

class DynamicProgrammingTest {

    @Test
    void gridTraveler() {
        long ans1 = DynamicProgramming.gridTraveler(2, 3);
        System.out.println(ans1);

        DynamicProgramming.dp.clear();

        long ans2 = DynamicProgramming.gridTraveler(3, 3);
        System.out.println(ans2);

        DynamicProgramming.dp.clear();

        long ans3 = DynamicProgramming.gridTraveler(1, 1);
        System.out.println(ans3);

        DynamicProgramming.dp.clear();

        long ans4 = DynamicProgramming.gridTraveler(18, 18);
        System.out.println(ans4);

        DynamicProgramming.dp.clear();
    }

    @Test
    void gridTravelerTabulation() {
        long ans = DynamicProgramming.gridTravelerTabulation(18, 18);
        System.out.println(ans);
    }

    @Test
    void fibTabulation() {
        long ans = DynamicProgramming.fibTabulation(6);
        System.out.println(ans);

        ans = DynamicProgramming.fibTabulation(8);
        System.out.println(ans);

        ans = DynamicProgramming.fibTabulation(50);
        System.out.println(ans);
    }

    @Test
    void canSum() {
        int[] nums1 = {5, 4, 3, 7};
        int targetSum = 7;
        System.out.println(DynamicProgramming.canSum(nums1, targetSum));

        int[] nums2 = {2, 4};
        System.out.println(DynamicProgramming.canSum(nums2, targetSum));

        int[] nums3 = {7, 10};
        int targetSum2 = 300;
        System.out.println(DynamicProgramming.canSum(nums3, targetSum2));
    }

    @Test
    void howSum() {
        int[] nums1 = {5, 4, 3, 7};
        int targetSum = 7;
        System.out.println(DynamicProgramming.howSum(nums1, targetSum));

        int[] nums2 = {2, 4};
        System.out.println(DynamicProgramming.howSum(nums2, targetSum));

        int[] nums3 = {7, 14};
        int targetSum2 = 300;
        System.out.println(DynamicProgramming.howSum(nums3, targetSum2));
    }

    @Test
    void bestSum() {
        DynamicProgramming.dp4.clear();

        int[] nums1 = {5, 4, 3, 7};
        int targetSum = 7;
        System.out.println(DynamicProgramming.bestSum(nums1, targetSum));

        DynamicProgramming.dp4.clear();

        int[] nums2 = {2, 3, 5};
        int targetSum2 = 8;
        System.out.println(DynamicProgramming.bestSum(nums2, targetSum2));

        DynamicProgramming.dp4.clear();

        int[] nums3 = {1, 4, 5};
        int targetSum3 = 8;
        System.out.println(DynamicProgramming.bestSum(nums3, targetSum3));

        DynamicProgramming.dp4.clear();

        int[] nums4 = {1, 2, 5, 25};
        int targetSum4 = 100;
        System.out.println(DynamicProgramming.bestSum(nums4, targetSum4));
    }

    @Test
    void canSumTabulation() {
        int[] nums1 = {5, 4, 3, 7};
        int targetSum1 = 7;
        System.out.println(DynamicProgramming.canSumTabulation(nums1, targetSum1));

        int[] nums2 = {2, 4};
        int targetSum2 = 7;
        System.out.println(DynamicProgramming.canSumTabulation(nums2, targetSum2));

        int[] nums3 = {7, 10};
        int targetSum3 = 300;
        System.out.println(DynamicProgramming.canSumTabulation(nums3, targetSum3));
    }

    @Test
    void howSumTabulation() {
        int[] nums1 = {5, 4, 3, 7};
        int targetSum1 = 7;
        System.out.println(DynamicProgramming.howSumTabulation(nums1, targetSum1));

        int[] nums2 = {2, 4};
        int targetSum2 = 7;
        System.out.println(DynamicProgramming.howSumTabulation(nums2, targetSum2));

        int[] nums3 = {7, 10};
        int targetSum3 = 300;
        System.out.println(DynamicProgramming.howSumTabulation(nums3, targetSum3));
    }

    @Test
    void bestSumTabulation() {
        int[] nums1 = {5, 4, 3, 7};
        int targetSum1 = 7;
        System.out.println(DynamicProgramming.bestSumTabulation(nums1, targetSum1));

        int[] nums2 = {2, 3, 5};
        int targetSum2 = 8;
        System.out.println(DynamicProgramming.bestSumTabulation(nums2, targetSum2));

        int[] nums3 = {1, 4, 5};
        int targetSum3 = 8;
        System.out.println(DynamicProgramming.bestSumTabulation(nums3, targetSum3));

        int[] nums4 = {1, 2, 5, 25};
        int targetSum4 = 100;
        System.out.println(DynamicProgramming.bestSumTabulation(nums4, targetSum4));
    }
}