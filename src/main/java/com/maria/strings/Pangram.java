package com.maria.strings;

import java.util.Arrays;

public class Pangram {

    public static boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            int index = (sentence.charAt(i) - 'a');
            if (arr[index] == false) {
                arr[index] = true;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == false)
                return false;
        }
        return true;
    }
}
