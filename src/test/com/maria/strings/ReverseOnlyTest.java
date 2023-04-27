package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseOnlyTest {

    @Test
    void reverseOnlyLetters1() {
        String s = "ab-cd";
        String ans = ReverseOnly.reverseOnlyLetters(s);
        Assertions.assertEquals("dc-ba", ans);
    }

    @Test
    void reverseOnlyLetters2() {
        String s = "a-bC-dEf-ghIj";
        String ans = ReverseOnly.reverseOnlyLetters(s);
        Assertions.assertEquals("j-Ih-gfE-dCba", ans);
    }

    @Test
    void reverseOnlyLetters3() {
        String s = "Test1ng-Leet=code-Q!";
        String ans = ReverseOnly.reverseOnlyLetters(s);
        Assertions.assertEquals("Qedo1ct-eeLg=ntse-T!", ans);
    }
}