package com.maria.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] wordBySymbols = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordBySymbols[0]) {
                    boolean found = bfs(i, j, board, wordBySymbols);
                    if (found) return true;
                }
            }
        }

        return false;
    }

    private static boolean bfs(int i, int j, char[][] board, char[] wordBySymbol) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int counter = 0;

        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(i, j));

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int x = current.getX();
            int y = current.getY();
            if (board[x][y] == wordBySymbol[counter] && !visited[x][y]) {
                counter++;
                visited[x][y] = true;
                if (counter == wordBySymbol.length) return true;
                //добавляю в очередь с разных сторон
                if (x - 1 >= 0 && !visited[x - 1][y]) queue.add(new Tuple(x - 1, y));
                if (x + 1 < board.length && !visited[x + 1][y]) queue.add(new Tuple(x + 1, y));
                if (y - 1 >= 0 && !visited[x][y - 1]) queue.add(new Tuple(x, y - 1));
                if (y + 1 < board[0].length && !visited[x][y + 1]) queue.add(new Tuple(x, y + 1));
            }
        }

        return false;
    }
}
