package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostCommonWordTest {

    @Test
    void mostCommonWord1() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String ans = MostCommonWord.mostCommonWord(paragraph, banned);
        Assertions.assertEquals("ball", ans);
    }
}