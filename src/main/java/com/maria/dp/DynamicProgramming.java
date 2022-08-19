package com.maria.dp;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    public static Map<Integer, Integer> dp = new HashMap<>();

    public static int minCostTickets(int[] days, int[] costs) {
        map.put(1, costs[0]);
        map.put(7, costs[1]);
        map.put(30, costs[2]);
        return countCost(days, 0);
    }

    public static Map<Integer, Integer> map = new HashMap<>();
    public static int countCost(int[] days, int index){
        if (index == days.length) {
            return 0;
        }
        if (dp.containsKey(index)){
            return dp.get(index);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int d = entry.getKey();
            int c = entry.getValue();
            int j = index;
            while (j < days.length && days[j] < days[index] + d){
                j++;
            }
            int calcCost = c + countCost(days, j);
            if (!dp.containsKey(index)){
                dp.put(index, Integer.MAX_VALUE);
            }
            dp.put(index, Math.min(dp.get(index), calcCost));
        }
        return dp.get(index);
    }

    /*public static int countCost1(int[] days, int[] costs, int index, int totalCost) {
        totalCost += costs[0];
        int j = index + 1;
        //if EOF then stop
        if (j == days.length) {
            return totalCost;
        }
        if (dp.containsKey(days[j])){
            return dp.get(days[j]);
        }
        //if cost less than minimum now its minimum
        int one = countCost1(days, costs, j, totalCost);
        int two = countCost2(days, costs, j, totalCost);
        int three = countCost3(days, costs, j, totalCost);
        int minVal = Math.min(one, Math.min(two, three));
        dp.put(days[index], minVal);
        return minVal;
    }

    public static int countCost2(int[] days, int[] costs, int index, int totalCost) {
        totalCost += costs[1];
        int j = index;
        while (j < days.length && days[j] <= (days[index] + 6)){
            j++;
        }
        if (j == days.length) {
            return totalCost;
        }
        if (dp.containsKey(days[j])){
            return dp.get(days[j]);
        }
        //if cost less than minimum now its minimum
        int one = countCost1(days, costs, j, totalCost);
        int two = countCost2(days, costs, j, totalCost);
        int three = countCost3(days, costs, j, totalCost);
        int minVal = Math.min(one, Math.min(two, three));
        dp.put(days[index], minVal);
        return minVal;
    }

    public static int countCost3(int[] days, int[] costs, int index, int totalCost) {
        totalCost += costs[2];
        int j = index;
        while (j < days.length && days[j] <= (days[index] + 29)){
            j++;
        }
        //if EOF then stop
        if (j == days.length) {
            return totalCost;
        }
        if (dp.containsKey(days[j])){
            return dp.get(days[j]);
        }
        //if cost less than minimum now its minimum
        int one = countCost1(days, costs, j, totalCost);
        int two = countCost2(days, costs, j, totalCost);
        int three = countCost3(days, costs, j, totalCost);
        int minVal = Math.min(one, Math.min(two, three));
        dp.put(days[index], minVal);
        return minVal;
    }*/
}
