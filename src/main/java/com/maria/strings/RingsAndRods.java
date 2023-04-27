package com.maria.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RingsAndRods {

    public static int countPoints(String rings) {
        boolean[][] arr = new boolean[10][3];
        char[] rr = rings.toCharArray();
        for (int i = 0; i < rr.length; i++) {
            if (Character.isDigit(rr[i])) {
                int pos = Character.getNumericValue(rr[i]);
                switch (rr[i - 1]) {
                    case 'R':
                        arr[pos][0] = true;
                        break;
                    case 'G':
                        arr[pos][1] = true;
                        break;
                    case 'B':
                        arr[pos][2] = true;
                        break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean contains = true;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != true)
                    contains = false;
            }
            if (contains)
                res++;
        }
        return res;
    }

    public static int countPoints2(String rings) {
        List<Set<Character>> list = new ArrayList<>();
        int k = 0;
        while (k < 10) {
            list.add(new HashSet<>());
            k++;
        }
        int res = 0;
        char[] rr = rings.toCharArray();
        for (int i = 0; i < rr.length; i++) {
            if (Character.isDigit(rr[i])) {
                int pos = Character.getNumericValue(rr[i]);
                Set<Character> s = list.get(pos);
                int sz = s.size();
                s.add(rr[i - 1]);
                if (sz == 2 && s.size() == 3) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int countPoints3(String rings) {
        int[][] arr = new int[10][3];
        for (int i = 1; i < rings.length(); i += 2) {
            char a = rings.charAt(i - 1);
            int b = rings.charAt(i) - '0';
            int j = 2;
            if (a == 'R')
                j = 0;
            else if (a == 'G')
                j = 1;
            arr[b][j] = 1;
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += arr[i][j];
            }
            if (sum == 3)
                count++;
        }
        return count;
    }

    public static int countPoints4(String rings) {
        int R = 1, B = 2, G = 4;
        // Binary 1 --> 001    2 --> 010   4 --> 100
        /*
        We will use the Property of OR That OR of a number with
        it self gives the same number . so no matter how many
        time same color appear .The value remain same.

        But when all three color will present in a rod then OR
        Operation will maximize and produced output 7
        */
        int arr[] = new int[10];
        int count = 0;

        for (int i = 0; i < rings.length(); i += 2) {
            char ch = rings.charAt(i);
            int index = rings.charAt(i + 1) - '0';
            arr[index] |= (ch == 'R')? 1: (ch == 'B')? 2: 4;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] == 7) {
                count++;
            }
        }
        return count;
    }
}
