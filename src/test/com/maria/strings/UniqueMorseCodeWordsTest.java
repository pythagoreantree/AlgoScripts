package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueMorseCodeWordsTest {

    @Test
    void uniqueMorseRepresentations1() {
        String[] words = {"gin","zen","gig","msg"};
        int ans = UniqueMorseCodeWords.uniqueMorseRepresentations2(words);
        Assertions.assertEquals(2, ans);
    }

    @Test
    void uniqueMorseRepresentations2() {
        String[] words = {"a"};
        int ans = UniqueMorseCodeWords.uniqueMorseRepresentations2(words);
        Assertions.assertEquals(1, ans);
    }
}