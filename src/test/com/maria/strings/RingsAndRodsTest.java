package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingsAndRodsTest {

    @Test
    void countPoints1() {
        String rings = "B0B6G0R6R0R6G9";
        int ans = RingsAndRods.countPoints(rings);
        Assertions.assertEquals(1, ans);
    }

    @Test
    void countPoints2() {
        String rings = "B0R0G0R9R0B0G0";
        int ans = RingsAndRods.countPoints(rings);
        Assertions.assertEquals(1, ans);
    }
}