package com.maria.yandex30;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class Histogram {

    public static final void hist() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(Paths.get("src","main", "resources","input.txt").toAbsolutePath().toString());
            Scanner scanner = new Scanner(fis);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.next());
            }
            String s = sb.toString();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
//            System.out.println(arr);

            int counter = 0, innerc = 1, max = -1;
            for (int k = 1; k < arr.length; k++) {
                if (arr[k] != arr[k - 1]) {
                    counter++;
                    if (innerc > max) {
                        max = innerc;
                    }
                    innerc = 1;
                } else {
                    innerc++;
                }
            }
            counter++;
            if (innerc > max) {
                max = innerc;
            }
            max++;

            char[][] h = new char[max][counter];

            int ind = 0, i = 0, j = 0;
            char current = arr[ind++];
            h[i++][j] = current;
            h[i][j] = '#';

            while (ind < arr.length) {
                if (arr[ind] != current) {
                    current = arr[ind];
                    i = 0; j++;
                    h[i++][j] = current;
                    h[i][j] = '#';
                } else {
                    h[++i][j] = '#';
                }
                ind++;
            }
            printHist(h);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printHist(char[][] h) {
        for (int i = h.length - 1; i >= 0; i--) {
            for (int j = 0; j < h[0].length; j++) {
                if (h[i][j] == '\0') {
                    System.out.print(' ');
                } else {
                    System.out.print(h[i][j]);
                }

            }
            System.out.print("\n");
        }
    }
}
