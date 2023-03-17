package com.maria.strings;

public class CheckIfNumbersAreAscendingInSentence {

    public static boolean areNumbersAscending(String s) {
        int current = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && s.charAt(i) != ' ') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (current >= num) {
                    return false;
                }
                current = num;
            }
        }
        return true;
    }

    public static boolean areNumbersAscending2(String s) {
        int start = 0;
        String[] strs = s.split(" ");
        for (String str: strs) {
            if (str.chars().allMatch( Character::isDigit )) {
                int i = Integer.parseInt(str);
                if (i <= start) return false;
                start = i;
            }
        }
        return true;
    }
}
