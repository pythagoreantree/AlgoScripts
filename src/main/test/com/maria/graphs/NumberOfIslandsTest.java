package com.maria.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    public static final Integer[][] islands;
    public static final char[][] islandsII;
    public static final int[][] islandsIII;

    static {
        islands = new Integer[][]{
                    {0, 0, 1, 1},
                    {0, 1, 1, 1},
                    {1, 0, 1, 0},
                    {1, 0, 0, 0}
        };

        islandsII = new char[][]{
                {'0', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', '1', '0'},
                {'1', '0', '0', '0'}
        };

        islandsIII = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
    }

    @Test
    void countIslands() {
        int num = NumberOfIslands.countIslands(islands);
        System.out.println(num);
        Assertions.assertEquals(num, 2);
    }

    @Test
    void countIslandsII() {
        int num = NumberOfIslands.countIslandsII(islandsII);
        System.out.println(num);
        Assertions.assertEquals(num, 2);
    }

    @Test
    void islandPerimeter() {
        int perimeter = NumberOfIslands.islandPerimeterDFS(islandsIII);
        System.out.println(perimeter);
        Assertions.assertEquals(16, perimeter);
    }
}