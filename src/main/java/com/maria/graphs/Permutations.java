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
}
