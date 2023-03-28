package com.maria.strings;

public class TruncateSentence {

    public static String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ')
                k--;
            if (k == 0) {
                return s.substring(0, i);
            }
        }
        return s;
    }
}
