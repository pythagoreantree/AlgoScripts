package com.maria.dp;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    public static Map<Integer, Integer> dp = new HashMap<>();

    public static int minCostTickets(int[] days, int[] costs) {
        int a = countCost(days, costs, 0, costs[0]);
        int b = countCost(days, costs, 0, costs[1]);
        int c = countCost(days, costs, 0, costs[2]);
        return Math.min(a, Math.min(b, c));
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

    public static int countCost(int[] days, int[] costs, int index, int cost){
        int endNum = 0;
        if (cost == costs[0])
            //i need just next index
            endNum = days[index];
        else if (cost == costs[1])
            endNum = days[index] + 6;
        else if (cost == costs[2])
            endNum = days[index] + 29;
        //if (totalCost > minimum)
        //    return;
        //find first number greater than end number
        int j = index;
        while (j < days.length && days[j] <= endNum){
            j++;
        }
        //if EOF then stop
        if (j == days.length) {
            return cost;
        }
        if (dp.containsKey(j)){
            return dp.get(j);
        }
        //if cost less than minimum now its minimum
        int one = cost + countCost(days, costs, j, costs[0]);
        int two = cost + countCost(days, costs, j, costs[1]);
        int three = cost + countCost(days, costs, j, costs[2]);
        int minVal = Math.min(one, Math.min(two, three));
        dp.put(index, minVal);
        return minVal;
    }
}
