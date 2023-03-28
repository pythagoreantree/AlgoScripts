package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacificAtlanticOceanTest {

    @Test
    void pacificAtlantic() {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> ans = PacificAtlanticOcean.pacificAtlantic(heights);
        System.out.println(ans);
    }
}