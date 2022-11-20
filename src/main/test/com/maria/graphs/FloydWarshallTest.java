package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

class FloydWarshallTest {

    public static final Map<Integer, List<Edge>> graph = new HashMap<>();

    static {
        graph.put(1, List.of(new Edge(2, 3), new Edge(4, 7)));
        graph.put(2, List.of(new Edge(1, 8), new Edge(3, 2)));
        graph.put(3, List.of(new Edge(1, 5), new Edge(4, 1)));
        graph.put(4, List.of(new Edge(1, 2)));
    }

    @Test
    void transformGraphToMatrix() {
        Integer[][] adjMatrix = FloydWarshall.transformGraphToMatrix(graph);
        Arrays.stream(adjMatrix).forEach(row -> System.out.println(Arrays.asList(row)));
    }
}