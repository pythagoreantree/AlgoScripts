package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordTest {

    public static final Map<Integer, List<Edge>> graph = new HashMap<>();

    static {
        graph.put(1, List.of(new Edge(2, 6), new Edge(3, 5), new Edge(4, 5)));
        graph.put(2, List.of(new Edge(5, -1)));
        graph.put(3, List.of(new Edge(2, -2), new Edge(5, 1)));
        graph.put(4, List.of(new Edge(3, -2), new Edge(6, -1)));
        graph.put(5, List.of(new Edge(7, 3)));
        graph.put(6, List.of(new Edge(7, 3)));
        graph.put(7, new ArrayList<>());
    }

    @Test
    void startBellManFord() {
        Integer[] distances = BellmanFord.startBellManFord(graph);
        System.out.println(Arrays.asList(distances));
    }

    @Test
    void transformAdjListToPairs() {
        List<EdgeExt> edges = BellmanFord.transformAdjListToPairs(graph);
        System.out.println(edges);
    }
}