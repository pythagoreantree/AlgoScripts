package com.maria.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelebrityTest {


    @Test
    void findCelebrity() {
        int label = Celebrity.findCelebrity(6);
        System.out.println(label);
    }
}