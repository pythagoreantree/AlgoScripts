package com.maria.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostTicketsTest {

    @Test
    void minCostTickets0() {
        int[] days = {1, 2, 3, 5, 7};
        int[] costs = {2, 7, 15};
        int minCost = MinCostTickets.minCostTickets(days, costs);
        System.out.println(minCost);
        Assertions.assertEquals(7, minCost);
    }

    @Test
    void minCostTickets1() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int minCost = MinCostTickets.minCostTickets(days, costs);
        System.out.println(minCost);
        Assertions.assertEquals(11, minCost);
    }

    @Test
    void minCostTickets2() {
        int[] days = {1, 3, 7};
        int[] costs = {1, 4, 20};
        int minCost = MinCostTickets.minCostTickets(days, costs);
        System.out.println(minCost);
        Assertions.assertEquals(3, minCost);
    }

    @Test
    void minCostTickets3() {
        int[] days = {6,9,10,14,15,16,17,18,20,22,23,24,29,30,31,33,35,37,38,40,41,46,47,51,54,57,59,65,70,76,77,81,85,87,90,91,93,94,95,97,98,100,103,104,105,106,107,111,112,113,114,116,117,118,120,124,128,129,135,137,139,145,146,151,152,153,157,165,166,173,174,179,181,182,185,187,188,190,191,192,195,196,204,205,206,208,210,214,218,219,221,225,229,231,233,235,239,240,245,247,249,251,252,258,261,263,268,270,273,274,275,276,280,283,285,286,288,289,290,291,292,293,296,298,299,301,303,307,313,314,319,323,325,327,329,334,339,340,341,342,344,346,349,352,354,355,356,357,358,359,363,364};
        int[] costs = {21,115,345};
        int minCost = MinCostTickets.minCostTickets(days, costs);
        System.out.println(minCost);
        Assertions.assertEquals(3040, minCost);
    }
    @Test
    void minCostTickets4() {
        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = {3,13,45};
        int minCost = MinCostTickets.minCostTickets(days, costs);
        System.out.println(minCost);
        Assertions.assertEquals(44, minCost);
    }

    @BeforeEach
    void clearMap(){
        MinCostTickets.dp.clear();
        MinCostTickets.map.clear();
    }



    @Test
    void minCostTicketsII() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int minCost = MinCostTickets.minCostTicketsII(days, costs);
        System.out.println(minCost);
//        Assertions.assertEquals(11, minCost);
    }
}