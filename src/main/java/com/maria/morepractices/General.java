package com.maria.morepractices;

import java.util.Arrays;

public class General {

    public static boolean areOccurrencesEqual1(String s) {
        int[] chrs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            chrs[pos]++;
        }
        char first = s.charAt(0);
        int num = first - 'a';
//        for (int i = 0; i < chrs.length; i++) {
//            System.out.print(((char)('a'+ i))+ ":" + chrs[i] + ",");
//        }
        for (int i: chrs) {
            if (i != 0 && chrs[num] != i) {
                return false;
            }
        }
        return true;
    }
}
