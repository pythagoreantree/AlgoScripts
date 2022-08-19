package com.maria.dp;

public class DynamicProgramming {

    public static int minimum = 6000;

    public static int minCostTickets(int[] days, int[] costs) {
        countCost(days, costs, 0, costs[0], 0);
        countCost(days, costs, 0, costs[1], 0);
        countCost(days, costs, 0, costs[2], 0);
        return minimum;
    }

    public static void countCost(int[] days, int[] costs, int index, int cost, int totalCost){
        int endNum = 0;
        switch(cost){
            case 2:
                endNum = days[index];
                break;
            case 7:
                endNum = days[index] + 6;
                break;
            case 15:
                endNum = days[index] + 29;
                break;
        }
        totalCost += cost;
//        if (totalCost > minimum)
//            return;
        //find first number greater than end number
        int j = 0;
        while (j < days.length && days[j] <= endNum){
            j++;
        }
        //if EOF then stop
        if (j == days.length) {
            if (totalCost < minimum) {
                minimum = totalCost;
            }
            return;
        }
        //if cost less than minimum now its minimum
        countCost(days, costs, j, costs[0], totalCost);
        countCost(days, costs, j, costs[1], totalCost);
        countCost(days, costs, j, costs[2], totalCost);

    }
}
