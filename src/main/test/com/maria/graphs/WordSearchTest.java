package com.maria.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void exist() {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";

        boolean ans = WordSearch.exist(board, word);
        System.out.println(ans);
        Assertions.assertTrue(ans);
    }

    @Test
    void exist2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";

        boolean ans = WordSearch.exist(board, word);
        System.out.println(ans);
        Assertions.assertTrue(ans);
    }
}