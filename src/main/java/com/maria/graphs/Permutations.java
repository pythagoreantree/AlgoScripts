package com.maria.graphs;

import java.util.*;

public class Permutations {

    public static final Map<Integer, List<Tuple>> pairs = new HashMap<>();
    public static List<List<Integer>> permute(int[] nums) {
        Set<Integer> allNumbers = new HashSet<Integer>();
        for(int num: nums) {
            allNumbers.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            pairs.put(i, new ArrayList<>());
            int a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int b = nums[j];
                    pairs.get(i).add(new Tuple(a, b));
                }
            }
        }

        List<List<Integer>> allChains = new ArrayList<>();
        //для каждой начальной цифры будем строить цепочки
        for (int k = 0; k < nums.length; k++) {
            //для каждой цепочки у нас будет свое множество значений
            Set<Integer> numsK = new HashSet<>(allNumbers);
            int currentNum = nums[k];
            numsK.remove(currentNum);
            List<Integer> chain = new ArrayList<>();
            chain.add(currentNum);
            List<List<Integer>> allCurrentChains = new ArrayList<>();
            while (!numsK.isEmpty()) {
                List<Tuple> currentNumPairs = pairs.get(currentNum);
                for(Tuple pair: currentNumPairs) {
                    if (pair.getX() == currentNum && numsK.contains(pair.getY())) {
                        List<Integer> l1 = new ArrayList<>(chain);
                        currentNum = pair.getY();
                        numsK.remove(currentNum);
                        l1.add(currentNum);
                        allCurrentChains.add(l1);
                    }
                }
            }
        }
        return null;
    }
}
