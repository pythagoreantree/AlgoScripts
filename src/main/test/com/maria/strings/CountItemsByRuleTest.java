package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountItemsByRuleTest {

    @Test
    void countMatches() {
        List<List<String>> items = List.of (
                List.of("phone","blue","pixel"),
                List.of("computer","silver","lenovo"),
                List.of("phone","gold","iphone")
        );
        String ruleKey = "color", ruleValue = "silver";
        int expected = 1;
        int actual = CountItemsByRule.countMatches(items, ruleKey, ruleValue);
        Assertions.assertEquals(expected, actual);
    }
}