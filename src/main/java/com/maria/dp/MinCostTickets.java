package com.maria.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostTickets {

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

    /**
     * Min Cost Tickets II
     */
    public static int minCostTicketsII(int[] days, int[] costs) {
        int[][] tickets = new int[][] {
                {1, costs[0]},
                {7, costs[1]},
                {30, costs[2]}
        };

        Map<Integer, Integer> dp2 = new HashMap<>();

        int ind = days.length - 1;
        while (ind >= 0) {

            for (int i = 0; i < 3; i++) {
                int j = ind;
                while (j < days.length && days[j] < days[ind] + tickets[i][0]){
                    j++;
                }
                int x = (j > (days.length - 1))? 0: dp2.get(days[j]);
                int calcCost = tickets[i][1] + x;
                if (!dp2.containsKey(days[ind])) {
                    dp2.put(days[ind], calcCost);
                } else {
                    dp2.put(days[ind], Math.min(dp2.get(days[ind]), calcCost));
                }

            }
            ind--;
        }
        return dp2.get(days[0]);
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
