package com.maria.strings;

public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] word = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            word[indices[i]] = s.charAt(i);
        }
        return new String(word);
    }
}
