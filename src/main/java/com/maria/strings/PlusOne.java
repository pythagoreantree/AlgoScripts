package com.maria.strings;

public class PlusOne {

    public int[] plusOne1(int[] digits) {
        int pos = digits.length - 1;
        while (pos >= 0) {
            if (digits[pos] < 9) {
                digits[pos]++;
                return digits;
            }
            pos--;
        }
        int[] newarr = new int[digits.length + 1];
        newarr[0] = 1;
        for (int i = 1; i < newarr.length; i++) {
            newarr[i] = digits[i - 1];
        }
        return newarr;
    }

    public int[] plusOne2(int[] digits) {
        int pos = digits.length - 1;
        digits = incrementByOne(pos, digits);
        return digits;
    }

    private int[] incrementByOne(int pos, int[] digits) {
        if (pos < 0) {
            //add new first element
            int[] newarr = new int[digits.length + 1];
            newarr[0] = 1;
            for (int i = 1; i < newarr.length; i++) {
                newarr[i] = digits[i - 1];
            }
            return newarr;
        }
        int elem = digits[pos];
        if (elem == 9) {
            digits[pos] = 0;
            digits = incrementByOne(pos - 1, digits);
        } else {
            digits[pos] = elem + 1;
        }
        return digits;

    }

    public int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
