package com.maria.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InterleavingStringsTest {

    @BeforeEach
    void clearMap() {
        InterleavingStrings.dp.clear();
    }

    @Test
    void isInterleave1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        boolean ans = InterleavingStrings.isInterleave(s1, s2, s3);
        System.out.println(ans);
    }

    @Test
    void isInterleave2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        boolean ans = InterleavingStrings.isInterleave(s1, s2, s3);
        System.out.println(ans);
    }

    @Test
    void isInterleave3() {
        String s1 = "ab", s2 = "a", s3 = "aab";
        boolean ans = InterleavingStrings.isInterleave(s1, s2, s3);
        System.out.println(ans);
    }

    @Test
    void isInterleave4() {
        String s1 = "a", s2 = "b", s3 = "a";
        boolean ans = InterleavingStrings.isInterleave(s1, s2, s3);
        System.out.println(ans);
    }

    @Test
    void isInterleave5() {
        String s1 = "aabd", s2 = "abdc", s3 = "aabdabcd";
        boolean ans = InterleavingStrings.isInterleave(s1, s2, s3);
        System.out.println(ans);
    }
}