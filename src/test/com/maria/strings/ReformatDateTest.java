package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReformatDateTest {

    @Test
    void reformatDate1() {
        String date = "20th Oct 2052";
        String ans = ReformatDate.reformatDate1(date);
        Assertions.assertEquals("2052-10-20", ans);
    }

    @Test
    void reformatDate2() {
        String date = "6th Jun 1933";
        String ans = ReformatDate.reformatDate1(date);
        Assertions.assertEquals("1933-06-06", ans);
    }

    @Test
    void reformatDate3() {
        String date = "26th May 1960";
        String ans = ReformatDate.reformatDate1(date);
        Assertions.assertEquals("1960-05-26", ans);
    }
}