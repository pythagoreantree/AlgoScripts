package com.maria.strings;

public class CapitalizeTitle {

    public static String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] words = title.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 2) {
                sb.append(words[i].toLowerCase());
            } else {
                sb.append(words[i].substring(0,1).toUpperCase())
                        .append(words[i].substring(1).toLowerCase());
            }
            if (i != words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static String capitalizeTitle2(String title) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < title.length(); i++) {
            start = i;
            if (title.charAt(i) != ' ') {
                while (i < title.length() && title.charAt(i) != ' ') {
                   i++;
                }
                if (i - start > 2) {
                    char c = title.charAt(start++);
                    if (c >= 'a' && c <= 'z') {
                        sb.append((char) (c - 32));
                    } else {
                        sb.append(c);
                    }
                }
                while (start < i) {
                    char c = title.charAt(start++);
                    if (c >= 'A' && c <= 'Z') {
                        sb.append((char) (c + 32));
                    } else {
                        sb.append(c);
                    }
                }
                if (i != title.length()) sb.append(' ');
            }
        }
        return sb.toString();
    }
}
