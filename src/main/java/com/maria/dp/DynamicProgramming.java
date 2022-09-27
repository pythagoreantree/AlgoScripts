package com.maria.dp;

import java.util.*;

public class DynamicProgramming {

    /*
    * Task:
    * Say that you are a traveler on a 2D grid. You begin in the top-left corner
    * and your goal is to travel to the bottom-right corner. You may only move
    * down or right.
    *
    * In how many ways can you travel to the goal on a grid with dimensions m * n?
    *
    * Memoization.
    * */
    public static Map<String, Long> dp = new HashMap<>();
    public static long gridTraveler(int m, int n) {
        if (m == 0 || n == 0) return 0l;
        if (m == 1 && n == 1) return 1l;
        if (dp.containsKey(m + "," + n))
            return dp.get(m + "," + n);

        long ways = 0;
        ways += gridTraveler(m - 1, n);
        ways += gridTraveler(m, n - 1);
        dp.put(m + "," + n, ways);
        return dp.get(m + "," + n);
    }

    /*
    * Tabulation.
    * */
    public static long gridTravelerTabulation(int m, int n) {
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], 0);
        }
        dp[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i + 1 < m + 1) dp[i + 1][j] += dp[i][j];
                if (j + 1 < n + 1) dp[i][j + 1] += dp[i][j];
            }
        }
//        printMatrix(dp);
        return dp[m][n];
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /*
    * Calculate n-th number of the Fibonacci sequence.
    *
    * Tabulation.
    * */
    public static long fibTabulation(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < n + 1; i++) {
            if (i + 1 < n + 1) dp[i + 1] += dp[i];
            if (i + 2 < n + 1) dp[i + 2] += dp[i];
        }
        return dp[n];
    }

    /*
    * The function should return a boolean indicating whether or not it is possible
    * to generate the targetSum using numbers from the array.
    *
    * You may use an element of the array as many times as needed.
    *
    * All nums and non-negative.
    *
    * Memoization.
    * */
    public static Map<Integer, Boolean> dp2 = new HashMap<>();
    public static boolean canSum(int[] nums, int targetSum) {
        if (dp2.containsKey(targetSum)) return dp2.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num: nums) {
            int remainder = targetSum - num;
            boolean hasPath = canSum(nums, remainder);
            if (hasPath) {
                return true;
            }
        }
        dp2.put(targetSum, false);
        return false;
    }

    /*
    * The function should return an array containing any combination of elements
    * that add up to exactly the targetSum. If there is no combination that adds up to the targetSum
    * then return null.
    *
    * If there are multiple combinations, you may return any signle one.
    *
    * Memoization.
    * */
    public static Map<Integer, List<Integer>> dp3 = new HashMap<>();
    public static List<Integer> howSum(int[] nums, int targetSum) {
        if (dp3.containsKey(targetSum)) return dp3.get(targetSum);
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) return null;

        for (int num: nums) {
            int remainder = targetSum - num;
            List<Integer> path = howSum(nums, remainder);
            if (path != null) {
                path.add(num);
                return path;
            }
        }
        dp3.put(targetSum, null);
        return null;
    }

    /*
    *
    * */
    public static void bestSum(int[] nums, int targetSum) {

    }

}
