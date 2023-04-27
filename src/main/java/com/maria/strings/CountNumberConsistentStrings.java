package com.maria.strings;

import java.util.HashSet;
import java.util.Set;

public class CountNumberConsistentStrings {

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<Character>();
        for (char c: allowed.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (String w: words) {
            count++;
            for (int i = 0; i < w.length(); i++) {
                if (!set.contains(w.charAt(i))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static int countConsistentStrings2(String allowed, String[] words) {
        int res = 0;
        boolean[] booleans = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            booleans[allowed.charAt(i) - 'a'] = true;
        }
        for (String word : words) {
            if (checkWord(word, booleans)) {
                res++;
            }
        }
        return res;
    }

    public static boolean checkWord(String word, boolean[] booleans) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!booleans[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
