package com.maria.strings;

public class BsBeforeAs {

    public static boolean checkString(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) != 'b')
            start++;

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) != 'a')
            end--;
        return end < start;

    }

    public static boolean checkString2(String s) {

        int ia = s.lastIndexOf('a');
        int ib = s.indexOf('b');

        if (ia < 0 || ib < 0) return true;
        return  ia <= ib;

    }

    public static boolean checkString3(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'b' && s.charAt(i+1) == 'a')
                return false;
        }
        return true;
    }
}
