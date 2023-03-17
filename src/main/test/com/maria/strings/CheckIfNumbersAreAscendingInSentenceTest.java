package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfNumbersAreAscendingInSentenceTest {

    @Test
    void areNumbersAscending() {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        boolean actual = CheckIfNumbersAreAscendingInSentence.areNumbersAscending(s);
        boolean expected = true;
        Assertions.assertEquals(
                expected,
                actual
        );
    }
}