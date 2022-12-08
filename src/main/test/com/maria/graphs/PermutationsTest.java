package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void permute() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> resultLists = Permutations.permute2(nums);
        System.out.println(resultLists);
    }
}