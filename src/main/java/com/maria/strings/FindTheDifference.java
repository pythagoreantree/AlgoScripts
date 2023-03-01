package com.maria.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    public static char findTheDifference(String s, String t) {

        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);

        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);

        int i = 0;
        while (i < s.length()) {
            if (arr1[i] != arr2[i]) {
                return arr2[i];
            }
            i++;
        }
        return arr2[i];
    }
}
