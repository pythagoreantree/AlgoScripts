package com.maria.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    void testRob1() {
        int[] houses = {1, 2, 3, 1, 2, 1};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(6, maxSum);
    }

    @Test
    void testRob2() {
        int[] houses = {1, 2, 3, 1};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(4, maxSum);
    }

    @Test
    void testRob3() {
        int[] houses = {2, 7, 9, 3, 1};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(12, maxSum);
    }

    @Test
    void testRob4() {
        int[] houses = {1};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(1, maxSum);
    }

    @Test
    void testRob5() {
        int[] houses = {1, 2};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(2, maxSum);
    }

    @Test
    void testRob6() {
        int[] houses = {1, 3, 1};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(3, maxSum);
    }


    @Test
    void testRob7() {
        int[] houses = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(7102, maxSum);
    }

    @Test
    void testRob8() {
        int[] houses = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int maxSum = HouseRobber.rob(houses);
        System.out.println(maxSum);
        Assertions.assertEquals(0, maxSum);
    }
}