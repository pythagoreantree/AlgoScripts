package com.maria.anagrams;

import com.maria.binarysearch.TPrinter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnangramsTest {

    @Test
    void funWithAnagrams() {
        List<String> anagrams = new ArrayList<>();
        anagrams.add("code");
//        anagrams.add("doce");
//        anagrams.add("framer");
//        anagrams.add("ecod");
//        anagrams.add("frmear");
        List<String> result = AnangramsTask.funWithAnagrams(anagrams);
        TPrinter.print(result);
    }

    @Test
    void convertToMap() {
        char[] arr = {'a', 'b', 'c', 'a'};
        TPrinter.print(AnangramsTask.convertToMap(arr));
    }

    @Test
    void isEqual() {
        char[] arr1 = {'a', 'b', 'c', 'a'};
        char[] arr2 = {'a', 'b', 'c'};
        Map<Character, Integer> m1 = AnangramsTask.convertToMap(arr1);
        Map<Character, Integer> m2 = AnangramsTask.convertToMap(arr2);
        System.out.println(AnangramsTask.isEqual(m1, m2));
    }
}