package com.maria.graphs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {

    public static int countIslands(Integer[][] map) {
        Set<Tuple> visited = new HashSet<>();
        int numberOfIslands = 0;
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++) {
                Integer value = map[i][j];
                if (value == 0) continue;
                if (visited.contains(new Tuple(i, j))) continue;
                dfs(i, j, visited, map);
                numberOfIslands++;
            }
        return numberOfIslands;
    }

    private static void dfs(int i, int j, Set<Tuple> visited, Integer[][] map) {
        Tuple pos = new Tuple(i, j);
        if (i < 0 || i >= map.length) return;
        if (j < 0 || j >= map[0].length) return;
        if (map[i][j] == 0) return;
        if (visited.contains(pos)) return;
        visited.add(pos);

        dfs(i - 1, j, visited, map);
        dfs(i + 1, j, visited, map);
        dfs(i, j - 1, visited, map);
        dfs(i, j + 1, visited, map);
    }

    /*
    * This version is for LeetCode
    * */
    public static int countIslandsII(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                char value = grid[i][j];
                if (value == '0') continue;
                if (visited.contains(i+","+j)) continue;
                dfsII(i, j, visited, grid);
                numberOfIslands++;
            }
        return numberOfIslands;
    }

    private static void dfsII(int i, int j, Set<String> visited, char[][] map) {
        if (i < 0 || i >= map.length) return;
        if (j < 0 || j >= map[0].length) return;
        if (map[i][j] == '0') return;

        String pos = i + "," + j;
        if (visited.contains(pos)) return;
        visited.add(pos);

        dfsII(i - 1, j, visited, map);
        dfsII(i + 1, j, visited, map);
        dfsII(i, j - 1, visited, map);
        dfsII(i, j + 1, visited, map);
    }
}
