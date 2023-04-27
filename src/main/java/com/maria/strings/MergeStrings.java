package com.maria.strings;

public class MergeStrings {

    public static String mergeAlternately(String word1, String word2) {
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < word1.length() && p2 < word2.length()) {
            if (p1 == p2) {
                sb.append(word1.charAt(p1));
                p1++;
            } else if (p2 < p1) {
                sb.append(word2.charAt(p2));
                p2++;
            }
        }
        while (p1 < word1.length()) {
            sb.append(word1.charAt(p1++));
        }
        while (p2 < word2.length()) {
            sb.append(word2.charAt(p2++));
        }
        return sb.toString();
    }

    public static String mergeAlternately2(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int p1 = 0, p2 = 0, p3 = 0;
        int n1 = word1.length(), n2 = word2.length();
        char[] res = new char[n1 + n2];
        while (p1 < n1 && p2 < n2) {
            res[p3++] = arr1[p1++];
            res[p3++] = arr2[p2++];
        }
        while (p1 < n1) {
            res[p3++] = arr1[p1++];
        }
        while (p2 < n2) {
            res[p3++] = arr2[p2++];
        }
        return String.valueOf(res);
    }

    public static String mergeAlternately3(String word1, String word2) {
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1++));
            sb.append(word2.charAt(p2++));
        }
        while (p1 < word1.length()) {
            sb.append(word1.charAt(p1++));
        }
        while (p2 < word2.length()) {
            sb.append(word2.charAt(p2++));
        }
        return sb.toString();
    }
}
