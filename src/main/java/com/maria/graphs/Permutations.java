package com.maria.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {

    public static final Map<Integer, List<Tuple>> pairs = new HashMap<>();
    public static List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            pairs.put(i, new ArrayList<>());
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int a = nums[i];
                    int b = nums[j];
                    pairs.get(i).add(new Tuple(a, b));
                }
            }
        }
        return null;
    }
}
