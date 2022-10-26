package com.maria.graphs;

import org.junit.jupiter.api.Test;

import java.util.*;

class TopSortTest {

    public static Map<Integer, List<Integer>> dag = new HashMap<>();
    public static Map<Object, List<Edge>> dag2 = new HashMap<>();
    public static Map<Integer, List<Integer>> tree = new HashMap<>();
    public static Map<String, List<Edge>> charGraph = new HashMap<>();

    static {
        dag.put(1, List.of(2, 3));
        dag.put(2, List.of(3, 4));
        dag.put(3, List.of(5, 6));
        dag.put(4, List.of(3, 6));
        dag.put(5, new ArrayList<>());
        dag.put(6, new ArrayList<>());
        dag.put(7, List.of(8));
        dag.put(8, new ArrayList<>());

        dag2.put(1, List.of(new Edge(2, 1), new Edge(3, 2)));
        dag2.put(2, List.of(new Edge(3, 6), new Edge(4, 5)));
        dag2.put(3, List.of(new Edge(5, 1), new Edge(6, 1)));
        dag2.put(4, List.of(new Edge(3, 2), new Edge(6, 11)));
        dag2.put(5, new ArrayList<>());
        dag2.put(6, new ArrayList<>());
        dag2.put(7, List.of(new Edge(8, 5)));
        dag2.put(8, new ArrayList<>());


        tree.put(1, List.of(2, 3));
        tree.put(2, List.of(4, 6));
        tree.put(3, List.of(5, 7));
        tree.put(4, List.of(8, 10));
        tree.put(5, List.of(9));
        tree.put(6, new ArrayList<>());
        tree.put(7, List.of(11, 13));
        tree.put(8, new ArrayList<>());
        tree.put(9, new ArrayList<>());
        tree.put(10, new ArrayList<>());
        tree.put(11, new ArrayList<>());
        tree.put(13, new ArrayList<>());

        List<CharEdge> localGraph = new ArrayList<>();
        localGraph.add(new CharEdge("A", "B", 3));
        localGraph.add(new CharEdge("A", "C", 6));
        localGraph.add(new CharEdge("B", "C", 4));
        localGraph.add(new CharEdge("B", "D", 4));
        localGraph.add(new CharEdge("B", "E", 11));
        localGraph.add(new CharEdge("C", "D", 8));
        localGraph.add(new CharEdge("C", "G", 11));
        localGraph.add(new CharEdge("D", "E", -4));
        localGraph.add(new CharEdge("D", "F", 5));
        localGraph.add(new CharEdge("D", "G", 2));
        localGraph.add(new CharEdge("E", "H", 9));
        localGraph.add(new CharEdge("F", "H", 1));
        localGraph.add(new CharEdge("G", "H", 2));
        localGraph.add(new CharEdge("H", null, 0));
        charGraph = GraphUtils.getAdjList(localGraph);

    }

    @Test
    void topSort() {
        System.out.println(TopSort.topSort(dag));
    }

    @Test
    void topSortTree() {
        System.out.println(TopSort.topSort(tree));
    }

    @Test
    void topSortCharWeightedGraph() {
        System.out.println(TopSort.topSortChar(charGraph));
    }

    @Test
    void ssspInt() {
        System.out.println(TopSort.ssspInt(dag2));
    }

    @Test
    void ssspChar() {
        List<String> paths = TopSort.ssspChar(charGraph);
        System.out.println(paths);

        List<String> topSort = TopSort.topSortChar(charGraph);
        List<String> minPath = TopSort.calcMinPath(topSort, paths);
        System.out.println(minPath);
    }
}