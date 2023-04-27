package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringsTest {

    @Test
    void mergeAlternately1() {
        String word1 = "abc", word2 = "pqr";
        String res = MergeStrings.mergeAlternately(word1, word2);
        Assertions.assertEquals(res, "apbqcr");
    }

    @Test
    void mergeAlternately2() {
        String word1 = "ab", word2 = "pqrs";
        String res = MergeStrings.mergeAlternately(word1, word2);
        Assertions.assertEquals(res, "apbqrs");
    }

    @Test
    void mergeAlternately3() {
        String word1 = "abcd", word2 = "pq";
        String res = MergeStrings.mergeAlternately(word1, word2);
        Assertions.assertEquals(res, "apbqcd");
    }
}