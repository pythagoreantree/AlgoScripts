package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedStringsTest {

    @Test
    void balancedStringSplit() {
        String test1 = "RLRRLLRLRL";
        int expected = 4;
        int actual = BalancedStrings.balancedStringSplit(test1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String test2 = "RLRRRLLRLL";
        int expected = 2;
        int actual = BalancedStrings.balancedStringSplit(test2);
        Assertions.assertEquals(expected, actual);
    }
}