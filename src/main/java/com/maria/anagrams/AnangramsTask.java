package com.maria.anagrams;

import java.util.*;

public class AnangramsTask {

    public static List<String> funWithAnagrams(List<String> text) {
        for (int i = 0; i < text.size(); i++){
            String str = text.get(i);
            Map<Character, Integer> sCharacters = convertToMap(str.toCharArray());
            List<String> toRemove = new ArrayList<>();
            for (int j = i + 1; j < text.size(); j++){
                Map<Character, Integer> oCharacters = convertToMap(text.get(j).toCharArray());
                if (isEqual(sCharacters, oCharacters)){
                    toRemove.add(text.get(j));
                }
            }
            text.removeAll(toRemove);
        }
        Collections.sort(text);
        return text;
    }

    public static Map<Character, Integer> convertToMap(char[] arr){
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            Character curr = Character.valueOf(arr[i]);
            if (charMap.containsKey(curr)){
                Integer val = charMap.get(curr);
                val += 1;
                charMap.put(curr, val);
            } else {
                charMap.put(curr, 1);
            }

        }
        return charMap;
    }

    public static boolean isEqual(Map<Character, Integer> m1, Map<Character, Integer> m2){
        for (Map.Entry<Character, Integer> entry: m2.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!m1.containsKey(key)){
                return false;
            } else {
                if (m1.get(key) != value){
                    return false;
                }
            }
        }
        return true;
    }

}
