package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.maria.graphs.DijkstrasAlgorithm.dijkstras;

class DijkstrasAlgorithmTest {

    public static Map<Integer, List<Edge>> graph = new HashMap<>();

    static {
        graph.put(0, List.of(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, List.of(new Edge(3, 1)));
        graph.put(2, List.of(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, List.of(new Edge(4,3)));
        graph.put(4, new ArrayList<>());
    }

    @Test
    void dijkstras1() {
        dijkstras(graph, 0);
    }
}