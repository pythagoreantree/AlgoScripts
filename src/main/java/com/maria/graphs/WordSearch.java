package com.maria.graphs;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] wordInSymbols = word.toCharArray();
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordInSymbols[0]) {
                    boolean[][] visited = new boolean[m][n];
                    if (containsWord(i, j, board, 0, wordInSymbols, visited)) return true;
                }
            }
        }

        return false;
    }

    private static boolean containsWord(int i, int j, char[][] board, int counter, char[] wordInSymbols, boolean[][] visited) {
        if (counter >= wordInSymbols.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;

        if (board[i][j] == wordInSymbols[counter]) {
            visited[i][j] = true;
            counter++;

            if (containsWord(i - 1, j, board, counter, wordInSymbols, visited)) return true;
            if (containsWord(i + 1, j, board, counter, wordInSymbols, visited)) return true;
            if (containsWord(i, j - 1, board, counter, wordInSymbols, visited)) return true;
            if (containsWord(i, j + 1, board, counter, wordInSymbols, visited)) return true;
            visited[i][j] = false;
        }

        return false;
    }

    /*private static boolean bfs(int i, int j, char[][] board, char[] wordBySymbol) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int counter = 0;

        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(i, j));

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int x = current.getX();
            int y = current.getY();
            visited[x][y] = true;

            counter++;
            if (counter == wordBySymbol.length) return true; //?
            char next = wordBySymbol[counter];


            if (x - 1 >= 0 && !visited[x - 1][y] && next == board[x - 1][y]) {
                queue.add(new Tuple(x - 1, y));
            }
            if (x + 1 < board.length && !visited[x + 1][y] && next == board[x + 1][y]) {
                queue.add(new Tuple(x + 1, y));
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && next == board[x][y - 1]) {
                queue.add(new Tuple(x, y - 1));
            }
            if (y + 1 < board[0].length && !visited[x][y + 1] && next == board[x][y + 1]) {
                queue.add(new Tuple(x, y + 1));
            }
        }

        return false;
    }*/
}
