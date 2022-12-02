package com.maria.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CelebrityTest {


    @Test
    void findCelebrity() {
        int label = Celebrity.findCelebrity(6);
        System.out.println(label);
        Assertions.assertEquals(2, label);
    }

    @Test
    void findCelebrityV2() {
        int label = Celebrity.findCelebrityWithStack(6);
        System.out.println(label);
        Assertions.assertEquals(2, label);
    }

    @Test
    void findCelebrityV3() {
        int label = Celebrity.findCelebrityWithGraph(6);
        System.out.println(label);
        Assertions.assertEquals(2, label);
    }

    @Test
    void findCelebrityV4() {
        int label = Celebrity.findCelebrityTwoPointers(6);
        System.out.println(label);
        Assertions.assertEquals(2, label);
    }
}