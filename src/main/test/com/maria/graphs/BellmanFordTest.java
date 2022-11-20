package com.maria.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordTest {

    public static final Map<Integer, List<Edge>> graph = new HashMap<>();
    public static final Map<Integer, List<Edge>> graph2 = new HashMap<>();

    static {
        graph.put(1, List.of(new Edge(2, 6), new Edge(3, 5), new Edge(4, 5)));
        graph.put(2, List.of(new Edge(5, -1)));
        graph.put(3, List.of(new Edge(2, -2), new Edge(5, 1)));
        graph.put(4, List.of(new Edge(3, -2), new Edge(6, -1)));
        graph.put(5, List.of(new Edge(7, 3)));
        graph.put(6, List.of(new Edge(7, 3)));
        graph.put(7, new ArrayList<>());

        graph2.put(1, List.of(new Edge(2, 4), new Edge(4, 5)));
        graph2.put(2, List.of(new Edge(4, 5)));
        graph2.put(3, List.of(new Edge(2, -10)));
        graph2.put(4, List.of(new Edge(3, 3)));
    }

    @Test
    void startBellManFord1() {
        Integer[] distances = BellmanFord.startBellManFord(graph);
        System.out.println(Arrays.asList(distances));
    }

    @Test
    void startBellManFord2() {
        Integer[] distances = BellmanFord.startBellManFord(graph2);
        System.out.println(Arrays.asList(distances));
    }

    @Test
    void transformAdjListToPairs1() {
        List<EdgeExt> edges = BellmanFord.transformAdjListToPairs(graph);
        System.out.println(edges);
    }

    @Test
    void transformAdjListToPairs2() {
        List<EdgeExt> edges = BellmanFord.transformAdjListToPairs(graph2);
        System.out.println(edges);
    }

    @Test
    void hasNegativeCycle() {
        boolean hasNegCycle = BellmanFord.hasNegativeCycle(graph2);
        System.out.println(hasNegCycle);
        Assertions.assertTrue(hasNegCycle);
        Assertions.assertFalse(BellmanFord.hasNegativeCycle(graph));
    }
}