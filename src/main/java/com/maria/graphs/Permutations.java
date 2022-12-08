package com.maria.graphs;

import java.util.*;

public class Permutations {

    public static final List<List<Integer>> allChains = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        allChains.clear();

        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        buildChains(new ArrayList<>(), nums, new HashSet<>(numSet));
        return allChains;
    }

    private static void buildChains(List<Integer> numList, int[] nums, Set<Integer> numSet) {
        if (numSet.isEmpty()) {
            allChains.add(numList);
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (numSet.contains(nums[j])) {
                List<Integer> currentList = new ArrayList<>(numList);
                Set<Integer> currentSet = new HashSet<>(numSet);
                currentList.add(nums[j]);
                currentSet.remove(nums[j]);
                buildChains(currentList, nums, currentSet);
            }
        }
    }

    //Second Solution
    public static List<List<Integer>> permute2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        return buildPermutations(nums, numSet);
    }

    private static List<List<Integer>> buildPermutations(int[] nums, Set<Integer> numSet) {
        if (numSet.size() == 1) {
            List<List<Integer>> all = new ArrayList<>();
            List<Integer> curList = new ArrayList<Integer>(numSet);
            all.add(curList);
            return all;
        }


        List<List<Integer>> resList = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            int current = nums[k];
            if (numSet.contains(current)) {
                Set<Integer> currentSet = new HashSet<>(numSet);
                currentSet.remove(current);
                List<List<Integer>> l = buildPermutations(nums, currentSet);
                for (List<Integer> l1: l) {
                    l1.add(0, current);
                    resList.add(l1);
                }
            }
        }
        return resList;
    }

}
