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
        int label = Celebrity.findCelebrityV2(6);
        System.out.println(label);
        Assertions.assertEquals(2, label);
    }
}