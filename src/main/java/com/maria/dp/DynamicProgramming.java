package com.maria.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}
