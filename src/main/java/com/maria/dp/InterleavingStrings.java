package com.maria.dp;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }

        boolean firstResult = false;
        int i = 1;
        while (i <= s1.length() && i <= s3.length() && s1.substring(0, i).equals(s3.substring(0, i))) {
            firstResult = isInterleave(s1.substring(i), s2, s3.substring(i));
            if (firstResult) {
                break;
            };
            i++;
        }

        boolean secondResult = false;
        int j = 1;
        while (j <= s2.length() && j <= s3.length() && s2.substring(0, j).equals(s3.substring(0, j))) {
            secondResult = isInterleave(s1, s2.substring(j), s3.substring(j));
            if (secondResult) {
               break;
            };
            j++;
        }
        return firstResult || secondResult;
    }


    //Greedy failed; case
    //"ab"
    //"bc"
    //"babc"
    /*public static boolean isInterleaveII(String s1, String s2, String s3) {

        while (!s3.isEmpty()) {
            if (s1.isEmpty() && s2.isEmpty()) {
                return false;
            }

            int p1 = s1.length() - 1;
            int p2 = s2.length() - 1;
            int p3 = s3.length() - 1;

            if (p1 >= 0 && s1.charAt(p1) == s3.charAt(p3)) {
                while (p1 >= 0 && p3 >= 0 && s1.charAt(p1) == s3.charAt(p3)) {
                    p1--;
                    p3--;
                }
                s3 = s3.substring(0, p3 + 1);
                s1 = s1.substring(0, p1 + 1);
            } else if (p2 >= 0 && s2.charAt(p2) == s3.charAt(p3)) {
                while (p2 >= 0 && p3 >= 0 && s2.charAt(p2) == s3.charAt(p3)) {
                    p2--;
                    p3--;
                }
                s3 = s3.substring(0, p3 + 1);
                s2 = s2.substring(0, p2 + 1);
            } else {
                return false;
            }

        }
        if (s1.isEmpty() && s2.isEmpty()) return true;
        return false;
    }*/

    /*public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleaveII(s1, s2, s3, "");
    }*/

    public static Map<String, Boolean> dp = new HashMap<>();
    /*public static boolean isInterleaveII(String s1, String s2, String s3, String path) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }
        if (dp.containsKey(path)) {
            dp.get(path);
        }

        boolean firstResult = false;
        int i = 1;
        while (i <= s1.length() && i <= s3.length() && s1.substring(0, i).equals(s3.substring(0, i))) {
            String locStr = String.copyValueOf(path.toCharArray());
            locStr += "1";
            firstResult = isInterleaveII(s1.substring(i), s2, s3.substring(i), locStr);
            if (firstResult) {
                break;
            };
            i++;
        }

        boolean secondResult = false;
        int j = 1;
        while (j <= s2.length() && j <= s3.length() && s2.substring(0, j).equals(s3.substring(0, j))) {
            String locStr = String.copyValueOf(path.toCharArray());
            locStr += "2";
            secondResult = isInterleaveII(s1, s2.substring(j), s3.substring(j), locStr);
            if (secondResult) {
                break;
            };
            j++;
        }
        boolean result = firstResult || secondResult;
        dp.put(path, result);
        return dp.get(path);
    }*/

    public static boolean isInterleaveIII(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int rows = s1.length();
        int cols = s2.length();
        boolean[][] dp = new boolean[rows + 1][cols + 1];
        dp[rows][cols] = true;
        for (int i = rows; i >= 0; i--) {
            for (int j = cols; j >= 0; j--) {
                if (i < rows && s3.charAt(i + j) == s1.charAt(i) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < cols && s3.charAt(i + j) == s2.charAt(j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

}
