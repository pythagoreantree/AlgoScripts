package com.maria.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticOcean {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        //first we need to fill pacific cells
        int m = heights.length;
        int n = heights[0].length;

        List<Tuple> pacificLine = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            pacificLine.add(new Tuple(0, j));
        }
        for (int i = 0; i < m; i++) {
            pacificLine.add(new Tuple(i, 0));
        }

        boolean[][] pacific = new boolean[m][n];
        for (Tuple coords: pacificLine) {
            dfs(coords.getX(), coords.getY(), heights, pacific);
        }
        System.out.println(pacific);

        List<Tuple> atlanticLine = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            atlanticLine.add(new Tuple(m - 1, j));
        }
        for (int i = 0; i < m; i++) {
            atlanticLine.add(new Tuple(i, n - 1));
        }

        boolean[][] atlantic = new boolean[m][n];
        for (Tuple coords: atlanticLine) {
            dfs(coords.getX(), coords.getY(), heights, atlantic);
        }
        System.out.println(atlantic);

        List<List<Integer>> resultCoords = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    resultCoords.add(List.of(i, j));
                }
            }
        }
        return resultCoords;
    }

    private static void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        if (visited[i][j]) return;

        visited[i][j] = true;
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) dfs(i - 1, j, heights, visited);
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) dfs(i + 1, j, heights, visited);
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) dfs(i, j - 1, heights, visited);
        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) dfs(i, j + 1, heights, visited);
    }


}
