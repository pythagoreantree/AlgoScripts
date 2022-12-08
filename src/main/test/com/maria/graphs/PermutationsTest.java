package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void permute1() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> resultLists = Permutations.permute(nums);
        System.out.println(resultLists);
    }

    @Test
    void permute2() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> resultLists = Permutations.permute2(nums);
        System.out.println(resultLists);
    }

}