package com.maria.anagrams;

import com.maria.binarysearch.TPrinter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnangramsTaskTest {

    @Test
    void funWithAnagrams() {
        List<String> anagrams = new ArrayList<>();
        anagrams.add("code");
        anagrams.add("doce");
        anagrams.add("ecod");
        anagrams.add("frame");
        anagrams.add("fmera");
        anagrams.add("cdeo");
        List<String> result = AnangramsTask.funWithAnagrams(anagrams);
        TPrinter.print(result);
    }

    @Test
    void convertToMap() {
        String s = "abcsa";
        TPrinter.print(AnangramsTask.getCharacters(s));
    }

    @Test
    void isEqual() {
        String s1 = "abca";
        String s2 = "aabc";
        Map<Character, Integer> m1 = AnangramsTask.getCharacters(s1);
        Map<Character, Integer> m2 = AnangramsTask.getCharacters(s2);
        System.out.println(AnangramsTask.isEqual(m1, m2));
    }

    @Test
    void removeAnagrams() {
        String[] anagrams = {"code", "doce", "ecod", "framer", "fmera", "cdeo"};
        List<String> result = AnangramsTask.removeAnagrams(anagrams);
        TPrinter.print(result);
    }
}