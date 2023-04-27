package com.maria.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {

    public static String symbols = "!?',;.";
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        List<String> bannedStrs = Arrays.asList(banned);
        Map<String, Integer> freqs = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!symbols.contains(String.valueOf(c))) {
                    sb.append(c);
                }
            }
            String rawWord = sb.toString();
            if (!bannedStrs.contains(rawWord)) {
                freqs.put(rawWord, freqs.getOrDefault(rawWord, 0) + 1);
            }
        }
        int maxCount = 0;
        String mostCommonWord = "";
        for (String key: freqs.keySet()) {
            if (freqs.get(key) > maxCount) {
                maxCount = freqs.get(key);
                mostCommonWord = key;
            }
        }
        return mostCommonWord;
    }
}
