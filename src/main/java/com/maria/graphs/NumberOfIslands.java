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
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsII(i, j, grid);
                    numberOfIslands++;
                }
            }
        return numberOfIslands;
    }

    private static void dfsII(int i, int j, char[][] map) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) return;
        if (map[i][j] == '0') return;

        map[i][j] = '0';

        dfsII(i - 1, j, map);
        dfsII(i + 1, j, map);
        dfsII(i, j - 1, map);
        dfsII(i, j + 1, map);
    }

//    public static int perimeter;
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    if (i - 1 < 0 || grid[i - 1][j] == 0)
                        perimeter += 1;
                    if (i + 1 >= grid.length || grid[i + 1][j] == 0)
                        perimeter += 1;
                    if (j - 1 < 0 || grid[i][j - 1] == 0)
                        perimeter += 1;
                    if (j + 1 >= grid[0].length || grid[i][j + 1] == 0)
                        perimeter += 1;
                }
            }
        }
        return perimeter;
    }

    public static int islandPerimeterDFS(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs3(i, j, grid);
                }
            }
        }
        return -1;
    }

    private static int dfs3(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 1;
        if (grid[i][j] == 2)
            return 0;

        grid[i][j] = 2;
        int perimeter = 0;
        perimeter += dfs3(i - 1, j, grid);
        perimeter += dfs3(i + 1, j, grid);
        perimeter += dfs3(i, j - 1, grid);
        perimeter += dfs3(i, j + 1, grid);
        return perimeter;
    }

}
