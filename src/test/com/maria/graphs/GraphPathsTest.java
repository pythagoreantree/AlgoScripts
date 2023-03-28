package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphPathsTest {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static List<List<Integer>> graphInPairs = new ArrayList<>();
    public static List<List<Integer>> graphInPairs2 = new ArrayList<>();
    public static Map<Integer, List<Edge>> awfulDAG = new HashMap<>();

    static {
        graph.put(1, List.of(2));
        graph.put(2, List.of(1, 3, 4));
        graph.put(3, List.of(1, 2, 4, 5, 6));
        graph.put(4, List.of(2, 3, 6));
        graph.put(5, List.of(3));
        graph.put(6, List.of(3, 4));
        graph.put(7, List.of(8));
        graph.put(8, List.of(7));

        graphInPairs.add(List.of(1, 2));
        graphInPairs.add(List.of(3, 1));
        graphInPairs.add(List.of(4, 3));
        graphInPairs.add(List.of(3, 5));
        graphInPairs.add(List.of(5, 1));
        graphInPairs.add(List.of(6, 7));

        graphInPairs2.add(List.of(1, 2));
        graphInPairs2.add(List.of(2, 3));
        graphInPairs2.add(List.of(3, 4));
        graphInPairs2.add(List.of(1, 5));
        graphInPairs2.add(List.of(5, 4));
//        graphInPairs2.add(List.of(6, 7));
//        graphInPairs2.add(List.of(7, 4));

        awfulDAG.put(1, List.of(new Edge(2, 2), new Edge(3, 3)));
        awfulDAG.put(2, List.of(new Edge(3, 2), new Edge(4, 1)));
        awfulDAG.put(3, List.of(new Edge(4, 5), new Edge(5, 7), new Edge(6, 8)));
        awfulDAG.put(4, List.of(new Edge(6, 2)));
        awfulDAG.put(5, new ArrayList<>());
        awfulDAG.put(6, List.of(new Edge(7, 1)));
        awfulDAG.put(7, new ArrayList<>());
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

    @Test
    void pairsToAdvList() {
        Map<Integer, List<Integer>> resultGraph = GraphPaths.pairsToAdvListUndirected(graphInPairs);
        System.out.println(resultGraph);
    }

    @Test
    void pairsToAdvListDirected() {
        Map<Integer, List<Integer>> resultGraph = GraphPaths.pairsToAdvListDirected(graphInPairs);
        System.out.println(resultGraph);
    }

    @Test
    void shortestPathBFS() {
        Map<Integer, List<Integer>> resultGraph = GraphPaths.pairsToAdvListDirected(graphInPairs2);
        System.out.println(resultGraph);
        int num = GraphPaths.shortestPathBFS(resultGraph, 1, 4);
        System.out.println(num);
    }

    @Test
    void topologicalSort() {
        List<Integer> tsResult = GraphPaths.topologicalSort(graph);
        System.out.println(tsResult);
    }

    @Test
    void topologicalSort2() {
        List<Integer> topsort = GraphPaths.topologicalSort2(awfulDAG);
        System.out.println(topsort);
    }

    @Test
    void singleSourceShortestPath() {
        GraphPaths.singleSourceShortestPath(awfulDAG);
    }
}