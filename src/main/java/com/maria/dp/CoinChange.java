package com.maria.dp;

import java.util.*;

public class CoinChange {

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

    public static int coinChangeII(int[] coins, int amount) {
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

    /**
     * Coin Change III
     */
    private static Map<Integer, Integer> dp3 = new HashMap<>();
    public static int coinChangeIII(int[] coins, int amount) {
        dp3.clear();
        return calcSum(amount, coins);
    }
    private static int calcSum(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp3.containsKey(amount)) {
            return dp3.get(amount);
        }

        if (!dp3.containsKey(amount)) {
            dp3.put(amount, -1);
        }

        for (int i = (coins.length - 1); i >= 0; i--) {
            int coin = coins[i];

            int s = calcSum(amount - coin, coins);
            int currNum = dp3.get(amount);
            if (s >= 0 && currNum < 0) {
                dp3.put(amount, s + 1);
            } else if (s >= 0 && currNum >= 0) {
                if ((s + 1) < currNum) {
                    dp3.put(amount, s + 1);
                }
            }
        }

        return dp3.get(amount);
    }
}
