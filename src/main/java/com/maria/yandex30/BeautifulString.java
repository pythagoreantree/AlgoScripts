package com.maria.yandex30;

import java.util.Scanner;

public class BeautifulString {

    public static final int countLongest(String s, int k) {

//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        String s = scanner.next();
        if (k >= s.length()) return s.length();

        int max = -1;
        int i = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            int counter = 0;
            while (i < s.length() && s.charAt(i) == cur) {
                i++;
                counter++;
            }

            counter += Math.min(k, s.length() - i);

            int eInd = i + k;
            while (eInd < s.length() && s.charAt(eInd) == cur) {
                eInd++;
                counter++;
            }
            if (counter > max) {
                max = counter;
            }
        }
        return max;
    }
}
