package com.maria.strings;

import java.util.Arrays;

public class SortSentence {

    public static String sortSentence(String s) {
        String[] strs = s.split(" ");
        String[] sntns = new String[9];
        for (String str: strs) {
            int i = Integer.parseInt(str.substring(str.length() - 1));
            String line = str.substring(0, str.length() - 1);
            sntns[i - 1] = line;
        }
        StringBuilder sb = new StringBuilder();
        for (String word: sntns) {
            if (word != null)
                sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
