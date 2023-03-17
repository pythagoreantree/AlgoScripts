package com.maria.strings;

public class BalancedStrings {

    public static int balancedStringSplit(String s) {
        int balance = 0;
        int counter = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                counter++;
            }
            i++;
        }
        return counter;
    }
}
