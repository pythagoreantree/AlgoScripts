package com.maria.strings;

public class CheckIfTwoStringArraysEquivalent {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : word1)
            sb.append(s1);
        String f = sb.toString();
        sb = new StringBuilder();
        for (String s2 : word2)
            sb.append(s2);
        String s = sb.toString();
        return (f == s) || (f != null && f.equals(s));
    }

    public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int p1 = 0, p2 = 0;
        int i = 0, j = 0;
        while (p1 < word1.length && p2 < word2.length) {
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            i++;
            if (i >= word1[p1].length()) {
                p1++;
                i = 0;
            }
            j++;
            if (j >= word2[p2].length()) {
                p2++;
                j = 0;
            }
        }
        if (p1 < word1.length && i < word1[p1].length()) {
            return false;
        }
        if (p2 < word2.length && j < word2[p2].length()) {
            return false;
        }
        return true;
    }
}
