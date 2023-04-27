package com.maria.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {

    public static Map<String, String> m = new HashMap<>();

    static {
        m.put("a", ".-");
        m.put("b", "-...");
        m.put("c", "-.-.");
        m.put("d", "-..");
        m.put("e", ".");
        m.put("f", "..-.");
        m.put("g", "--.");
        m.put("h", "....");
        m.put("i", "..");
        m.put("j", ".---");
        m.put("k", "-.-");
        m.put("l", ".-..");
        m.put("m", "--");
        m.put("n", "-.");
        m.put("o", "---");
        m.put("p", ".--.");
        m.put("q", "--.-");
        m.put("r", ".-.");
        m.put("s", "...");
        m.put("t", "-");
        m.put("u", "..-");
        m.put("v", "...-");
        m.put("w", ".--");
        m.put("x", "-..-");
        m.put("y", "-.--");
        m.put("z", "--..");
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> t = new HashSet<>();
        for (String s: words) {
            String[] arr = s.split("");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(m.get(arr[i]));
            }
            t.add(sb.toString());
        }
        return t.size();
    }

    public static int uniqueMorseRepresentations2(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",
                ".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> t = new HashSet<>();
        for (String s: words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(arr[s.charAt(i) - 'a']);
            }
            t.add(sb.toString());
        }
        return t.size();
    }
}
