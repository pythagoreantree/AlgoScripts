package com.maria.dp;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PaintHouseTest {

    @Test
    void minCost() {
        List<List<Integer>> costs = new ArrayList<>();
        List<Integer> row1 = new ArrayList();
        row1.add(17);
        row1.add(2);
        row1.add(17);

        List<Integer> row2 = new ArrayList();
        row2.add(16);
        row2.add(16);
        row2.add(5);

        List<Integer> row3 = new ArrayList();
        row3.add(14);
        row3.add(3);
        row3.add(19);

        costs.add(row1);
        costs.add(row2);
        costs.add(row3);

        int ans = PaintHouse.minCost(costs);
        System.out.println(ans);
        assertEquals(10, ans);
        PaintHouse.costList.clear();
        PaintHouse.dp.clear();
    }

    @Test
    void minCostII() {
        int[][] costs = new int[3][3];
        int[] row1 = {17, 2, 17};
        int[] row2 = {16, 16, 5};
        int[] row3 = {14, 3, 19};
        costs[0] = row1;
        costs[1] = row2;
        costs[2] = row3;

        int ans = PaintHouse.minCostII(costs);
        System.out.println(ans);
        assertEquals(10, ans);
        PaintHouse.dp2.clear();
    }

    /*@Test
    void testArr(){
        Map<String, Object> mp = new HashMap<>();
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        mp.put("abc", array);

        StringJoiner js = new StringJoiner("");
        for (Map.Entry<String, Object> entry: mp.entrySet()) {
            js.add(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(js.toString());
    }*/

}