package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphPathsTest {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static Map<Integer, List<Integer>> graph2 = new HashMap<>();

    static {
        graph.put(1, List.of(2));
        graph.put(2, List.of(1, 3, 4));
        graph.put(3, List.of(1, 2, 4, 5, 6));
        graph.put(4, List.of(2, 3, 6));
        graph.put(5, List.of(3));
        graph.put(6, List.of(3, 4));
        graph.put(7, List.of(8));
        graph.put(8, List.of(7));

        graph2.put(1, List.of(2, 3));
        graph2.put(2, List.of(3));
        graph2.put(3, List.of(4, 5, 6));
        graph2.put(4, List.of(2, 6));
        graph2.put(5, new ArrayList<>());
        graph2.put(6, new ArrayList<>());
        graph2.put(7, new ArrayList<>());
    }

    @Test
    void hasPath() {
        boolean hasPath1 = GraphPaths.hasPath(graph, 1, 3, new HashSet<>());
        System.out.println(hasPath1);
        assertTrue(hasPath1);

        boolean hasPath2 = GraphPaths.hasPath(graph, 3, 8, new HashSet<>());
        System.out.println(hasPath2);
        assertFalse(hasPath2);
    }
}