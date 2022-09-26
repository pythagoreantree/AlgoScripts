package com.maria.anagrams;

import java.lang.reflect.Array;
import java.util.*;

public class AnangramsTask {

    /*
    * Bad Implementation O(n^2). But still can be.
    * */
    public static List<String> funWithAnagrams(List<String> text) {
        for (int i = 0; i < text.size(); i++){
            String str = text.get(i);


//            Map<Character, Integer> sCharacters = getCharacters(str);
            List<String> toRemove = new ArrayList<>();
            for (int j = i + 1; j < text.size(); j++) {
                if (areAnagrams(text.get(i), text.get(j)))
                    toRemove.add(text.get(j));
//                Map<Character, Integer> oCharacters = getCharacters(text.get(j));
//                if (isSimilar(sCharacters, text.get(j))){
//                    toRemove.add(text.get(j));
//                }
            }
            text.removeAll(toRemove);
        }
        Collections.sort(text);
        return text;
    }

    /*
    * Map case.
    * */
    public static List<String> clearAnagrams(List<String> text) {
        Map<String, String> map = new HashMap<>();
        for (String str: text) {
            String sortedStr = getSorted(str);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, str);
            }
        }
        List<String> finalList = new ArrayList<>(map.values());
        Collections.sort(finalList);
        return finalList;
    }

    public static Map<Character, Integer> getCharacters(String s){
        if (s == null) return null;
        if (s.isEmpty()) return new HashMap<>();

        char[] arrChar = s.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c: arrChar) {
            if (!charMap.containsKey(c)) {
                charMap.put(c, 0);
            }
            charMap.put(c, charMap.get(c) + 1);
        }
        return charMap;
    }

    public static boolean isEqual(Map<Character, Integer> m1, Map<Character, Integer> m2){
        if (m1.keySet().size() != m2.keySet().size()) return false;
        Set<Character> set = new TreeSet<>();
        set.addAll(m1.keySet());
        set.addAll(m2.keySet());
        for (Character keyChar: set) {
            if (!m1.containsKey(keyChar) || !m2.containsKey(keyChar)) {
                return false;
            }
            if (m1.get(keyChar) != m2.get(keyChar)) {
                return false;
            }
        }
        return true;
    }

    /*
    * Another way is to have Map of characters and work with this map, removing unpleasant characters.
    * */
    public static boolean isSimilar(Map<Character, Integer> m1, String s) {
        Map<Character, Integer> mp = new HashMap<>(m1);
        for(char c: s.toCharArray()) {
            if (!mp.containsKey(c)) return false;
            int val = mp.get(c) - 1;
            if (val == 0) mp.remove(c);
            else mp.put(c, val);
        }
        return mp.isEmpty();
    }

    /*
    * Sort every String to compare
    * */
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) return true;
        if (s1.isEmpty() || s2.isEmpty()) return false;

        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        s1 = Arrays.toString(arr1);

        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        s2 = Arrays.toString(arr2);

        return s1.equals(s2);
    }

    public static String getSorted(String s) {
        if (s == null || s.isEmpty()) return s;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static List<String> removeAnagrams(String[] arr) {
        List<String> ans = new ArrayList<>();
        HashSet<String> found = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            word = getSorted(word);
            if (!found.contains(word)) {
                ans.add(arr[i]);
                found.add(word);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static List<String> removeAnagramsII(String[] words) {
        List<String> list = new ArrayList<>();

        list.add(words[0]);
        for (int i = 1; i < words.length ; i++) {
            String one = getSorted(words[i - 1]);
            String two = getSorted(words[i]);
            if (!one.equals(two)) {
                list.add(words[i]);
            }
        }

        return list;
    }

    public static void removeAtIndex(String[] arr, int index) {
        if (index == arr.length - 1) {
            arr[index] = null;
        }
        int i = index;
        while (i + 1 < arr.length) {
            arr[i] = arr[i + 1];
            if (i + 1 == arr.length - 1) {
                arr[i + 1] = null;
            }
            i++;
        }
    }

}
