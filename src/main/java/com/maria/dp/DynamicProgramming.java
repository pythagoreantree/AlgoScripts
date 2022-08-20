package com.maria.dp;

import com.maria.Main;

import java.util.*;

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

    public static Map<Long, Integer> stepsForSum = new HashMap<>();
    public static List<Integer> dp2;
    public static int gAmount;
    public static int coinChange(int[] coins, int amount){
        gAmount = amount;
        dp2 = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            dp2.add(-1);
        }
        return coinCalc(coins, amount, 0);
    }

    public static int coinCalc(int[] coins, int amount, int iter){
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (dp2.get(gAmount - amount) >= 0)
            return dp2.get(gAmount - amount);

        for (int i = 0; i < coins.length; i++) {
            int res = coinCalc(coins, amount - coins[i], iter + 1);
            if (res != -1){
                if (dp2.get(iter) == -1) {
                    dp2.set(iter, res + 1);
                } else {
                    dp2.set(iter, Math.min(dp2.get(iter), res + 1));
                }
            }
        }
        return dp2.get(iter);
    }

    public static int calcAmount(int[] coins, int amount, long sum){
        if (Long.valueOf(amount).equals(sum))
            return 0;
        if (Long.valueOf(amount) < sum)
            return -1;
        if (stepsForSum.containsKey(sum))
            return stepsForSum.get(sum);

        if (!stepsForSum.containsKey(sum)){
            stepsForSum.put(sum, -1);
        }

        for (int i = 0; i < coins.length; i++) {
            long interSum = sum + coins[i];
            int res = -1;
            if (interSum <= Long.valueOf(amount)) {
                res = calcAmount(coins, amount, interSum);
            }
            //if smth good is returned
            if (res != -1) {
                int value = stepsForSum.get(sum);
                value = (value == -1) ? res + 1 : Math.min(value, res + 1);
                stepsForSum.put(sum, value);
            }
        }

        return stepsForSum.get(sum);
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[amount] != (amount + 1) ? dp[amount] : -1;
    }
}
