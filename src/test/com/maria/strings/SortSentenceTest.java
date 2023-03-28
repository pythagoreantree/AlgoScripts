package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortSentenceTest {

    @Test
    void sortSentence() {
        String s = "is2 sentence4 This1 a3";
        String actual = SortSentence.sortSentence(s);
        String expected = "This is a sentence";
        Assertions.assertEquals(expected, actual);
    }
}