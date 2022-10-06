package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

class GraphTraversalsTest {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    static {
        graph.put(1, List.of(2));
        graph.put(2, List.of(1, 3, 4));
        graph.put(3, List.of(1, 2, 4, 5, 6));
        graph.put(4, List.of(2, 3, 6));
        graph.put(5, List.of(3));
        graph.put(6, List.of(3, 4));
        graph.put(7, new ArrayList<>());
        graph.put(8, new ArrayList<>());
    }

    @Test
    void dfs() {
        GraphTraversals.dfs(graph, 1, new HashSet<>());
    }

    @Test
    void dfsNFCG() {
        GraphTraversals.dfsNFCG(graph);
    }

    @Test
    void countConnectedComponents() {
        int num = GraphTraversals.countConnectedComponents(graph);
        System.out.println();
        System.out.println(num);
    }

    @Test
    void bfs() {
        GraphTraversals.bfs(graph, 1, new HashSet<>());
    }

    @Test
    void bfsNFCG() {
        GraphTraversals.bfsNFCG(graph);
    }
}