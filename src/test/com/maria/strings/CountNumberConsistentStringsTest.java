package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountNumberConsistentStringsTest {

    @Test
    void countConsistentStrings1() {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        int ans = CountNumberConsistentStrings.countConsistentStrings(allowed, words);
        Assertions.assertEquals(2, ans);
    }

    @Test
    void countConsistentStrings2() {
        String allowed = "abc";
        String[] words = {"a","b","c","ab","ac","bc","abc"};
        int ans = CountNumberConsistentStrings.countConsistentStrings(allowed, words);
        Assertions.assertEquals(7, ans);
    }

    @Test
    void countConsistentStrings3() {
        String allowed = "cad";
        String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};
        int ans = CountNumberConsistentStrings.countConsistentStrings(allowed, words);
        Assertions.assertEquals(4, ans);
    }
}