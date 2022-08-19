package com.maria.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingTest {

    @Test
    void minCostTickets() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int minCost = DynamicProgramming.minCostTickets(days, costs);
        System.out.println(minCost);
    }
}