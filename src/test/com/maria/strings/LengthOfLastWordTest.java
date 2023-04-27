package com.maria.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {

    @Test
    void lengthOfLastWord1() {
        String s = "Hello World";
        int ans = LengthOfLastWord.lengthOfLastWord(s);
        Assertions.assertEquals(5, ans);
    }

    @Test
    void lengthOfLastWord2() {
        String s = "   fly me   to   the moon  ";
        int ans = LengthOfLastWord.lengthOfLastWord(s);
        Assertions.assertEquals(4, ans);
    }

    @Test
    void lengthOfLastWord3() {
        String s = "luffy is still joyboy";
        int ans = LengthOfLastWord.lengthOfLastWord(s);
        Assertions.assertEquals(6, ans);
    }

    @Test
    void lengthOfLastWord4() {
        String s = "a";
        int ans = LengthOfLastWord.lengthOfLastWord(s);
        Assertions.assertEquals(1, ans);
    }
}