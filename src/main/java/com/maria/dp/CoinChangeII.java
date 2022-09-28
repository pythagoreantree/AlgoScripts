package com.maria.dp;

import java.util.*;

public class CoinChangeII {

    /*
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * The answer is guaranteed to fit into a signed 32-bit integer.
     *
     * Tabulation.
     * */
    public static Set<String> set = new HashSet<>();
    public static int countSumCombinations(int[] nums, int targetSum) {
        set.clear();
        List<List<Integer>> finalList = helper(nums, targetSum);
        System.out.println(finalList);
        return finalList.size();
    }

    private static List<List<Integer>> helper(int[] nums, int targetSum) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i < targetSum + 1; i++) {
            dp.add(new ArrayList<>());
        }

        for (int i = 0; i < dp.size(); i++) {
            for (int j = 0; j < nums.length; j++) {

                if (i + nums[j] < dp.size()) {
                    List<List<Integer>> current = dp.get(i);
                    List<List<Integer>> newCurrent = new ArrayList<>();

                    if (current.isEmpty() && i + nums[j] == nums[j]) {
                        List<Integer> newList = new ArrayList<>();
                        newList.add(nums[j]);
                        newCurrent.add(newList);
                    } else {
                        for(List list: current) {
                            List<Integer> newList = new ArrayList<>(list);
                            newList.add(nums[j]);

                            Collections.sort(newList);
                            StringBuilder sb = new StringBuilder();
                            for (Integer n: newList) {
                                sb.append(n).append("+");
                            }
                            String s = sb.toString();
                            s = s.substring(0, s.length() - 1);

                            if (!set.contains(s)) {
                                set.add(s);
                                newCurrent.add(newList);
                            }
                        }
                    }
                    List<List<Integer>> allLists = dp.get(i + nums[j]);
                    allLists.addAll(newCurrent);
                    dp.set(i + nums[j], allLists);


                }

            }
        }
        return dp.get(targetSum);
    }
}
