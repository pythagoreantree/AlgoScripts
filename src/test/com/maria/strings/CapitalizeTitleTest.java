package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTitleTest {

    @Test
    void capitalizeTitle1() {
        String title = "capiTalIze tHe titLe";
        String ans = CapitalizeTitle.capitalizeTitle2(title);
        Assertions.assertEquals("Capitalize The Title", ans);
    }

    @Test
    void capitalizeTitle2() {
        String title = "First leTTeR of EACH Word";
        String ans = CapitalizeTitle.capitalizeTitle2(title);
        Assertions.assertEquals("First Letter of Each Word", ans);
    }
}