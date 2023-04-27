package com.maria.strings;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0)
            return 0;
        int res = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            res++;
            i--;
        }
        return res;
    }

    public static int lengthOfLastWord2(String s) {
        int l = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                l++;
            } else {
                if (l > 0)
                    return l;
            }
        }
        return l;
    }

    public static int lengthOfLastWord3(String s) {
        char[] arr = s.toCharArray();
        int len = 0;
        boolean flag = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != ' ' && flag != true) {
                flag = true;
            }
            if (flag && arr[i] != ' ')
                len++;
            else if (flag && arr[i] == ' ')
                break;
        }
        return len;
    }
}
