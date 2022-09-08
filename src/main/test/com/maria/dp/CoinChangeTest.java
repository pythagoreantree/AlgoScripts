package com.maria.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void coinChange1() {
        int[] coins = {1, 2, 5};
        int amount = 6;
        int minNum = CoinChange.coinChange(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(2, minNum);
    }

    @Test
    void coinChange2() {
        int[] coins = {1, 2, 5};
        int amount = 0;
        int minNum = CoinChange.coinChange(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(0, minNum);
    }

    @Test
    void coinChange3() {
        int[] coins = {2};
        int amount = 3;
        int minNum = CoinChange.coinChange(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(-1, minNum);
    }

    @Test
    void coinChange4(){
        int[] coins = {1, 2147483647};
        int amount = 2;
        int minNum = CoinChange.coinChange(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(2, minNum);
    }

    @Test
    void coinChange5() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int minNum = CoinChange.coinChange(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(3, minNum);
    }

    @Test
    @Disabled
    void coinChange6() {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        int minNum = CoinChange.coinChange(coins, amount);
        System.out.println(minNum);
        //        Assertions.assertEquals(2, minNum);
    }
    
    @Test
    void coinChangeIII() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int minNum = CoinChange.coinChangeIII(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(3, minNum);
    }

    @Test
    void coinChangeIII2() {
        int[] coins = {2};
        int amount = 3;
        int minNum = CoinChange.coinChangeIII(coins, amount);
        System.out.println(minNum);
        Assertions.assertEquals(-1, minNum);
    }

    @Test
    void coinChangeIII3() {
        int[] coins = {1, 2147483647};
        int amount = 2;
        int minNum = CoinChange.coinChangeIII(coins, amount);
        System.out.println(minNum);
//        Assertions.assertEquals(2, minNum);
    }

}