package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BsBeforeAsTest {

    @ParameterizedTest(name = "positive scenarios")
    @ValueSource(strings = { "aaabbb", "bbb" })
    void checkString(String s) {
        boolean expected = true;
        boolean actual = BsBeforeAs.checkString3(s);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "negative scenarios")
    @ValueSource(strings = { "abab" })
    void checkStringNegative(String s) {
        boolean expected = false;
        boolean actual = BsBeforeAs.checkString3(s);
        Assertions.assertEquals(expected, actual);
    }
}