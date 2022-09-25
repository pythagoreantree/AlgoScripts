package com.maria.dp;

import java.util.*;

public class PaintHouse {

    public static final List<List<Integer>> costList = new ArrayList<>();
    public static int minCost(List<List<Integer>> costs) {
        //get first array
        if (costs == null || costs.size() == 0) return 0;
        costList.addAll(costs);
        List<Integer> firstCosts = costList.get(0);
        Integer[] result = new Integer[3];
        int color = -1; //0,1,2
        for (int i = 0; i < 3; i++) {
            color = i;
            result[i] = firstCosts.get(i) + f(color, 1);
        }
        return Math.min(result[0], Math.min(result[1], result[2]));
    }

    public static Map<String, Integer> dp = new HashMap<>();
    private static int f(int color, int index) {
        if (index == costList.size())
            return 0;
        if (dp.containsKey(index + "-" + color))
            return dp.get(index + "-" + color);
        List<Integer> line = costList.get(index);
        if (color == 0) {
            int one = line.get(1) + f(1, index + 1);
            int two = line.get(2) + f(2, index + 1);
            dp.put(index + "-" + color, Math.min(one, two));
            return dp.get(index + "-" + color);
        } else if (color == 1) {
            int one = line.get(0) + f(0, index + 1);
            int two = line.get(2) + f(2, index + 1);
            dp.put(index + "-" + color, Math.min(one, two));
            return dp.get(index + "-" + color);
        } else if (color == 2) {
            int one = line.get(0) + f(0, index + 1);
            int two = line.get(1) + f(1, index + 1);
            dp.put(index + "-" + color, Math.min(one, two));
            return dp.get(index + "-" + color);
        }
        return -1;
    }

    public static int minCostII(int[][] costs) {
        //get first array
        if (costs == null || costs.length == 0) return 0;
        int[] firstCosts = costs[0];
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = firstCosts[i] + f1(i, 1, costs);
        }
        return Math.min(result[0], Math.min(result[1], result[2]));
    }

    public static Map<String, Integer> dp2 = new HashMap<>();
    private static int f1(int color, int index, int[][] costs) {
        if (index == costs.length)
            return 0;
        if (dp2.containsKey(index + "-" + color))
            return dp2.get(index + "-" + color);
        int[] line = costs[index];
        int one = -1, two = -1;
        switch (color) {
            case 0:
                one = line[1] + f1(1, index + 1, costs);
                two = line[2] + f1(2, index + 1, costs);
                break;
            case 1:
                one = line[0] + f1(0, index + 1, costs);
                two = line[2] + f1(2, index + 1, costs);
                break;
            case 2:
                one = line[0] + f1(0, index + 1, costs);
                two = line[1] + f1(1, index + 1, costs);
                break;
        }
        dp2.put(index + "-" + color, Math.min(one, two));
        return dp2.get(index + "-" + color);
    }
}
