package com.maria.graphs;

import java.util.*;

/*
* For undirected graphs.
* */
public class GraphTraversals {

    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    static {
        graph.put(1, List.of(2));
        graph.put(2, List.of(1, 3, 4));
        graph.put(3, List.of(1, 2, 4, 5, 6));
        graph.put(4, List.of(2, 3, 6));
        graph.put(5, List.of(3));
        graph.put(6, List.of(3, 4));
        graph.put(7, new ArrayList<>());
    }

    /*
    * DFS for a fully connected Graph.
    * */
    public static void dfs(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);

        System.out.print(node + " ");
        List<Integer> neighbors = graph.get(node);

        for (Integer neighbor: neighbors) {
            dfs(graph, neighbor, visited);
        }
    }

    /*
    * DFS version of not fully connected Graph.
    * */
    public static void dfsNFCG(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        for (Integer key: graph.keySet()) {
            if (!visited.contains(key)) {
                dfs(graph, key, visited);
            }
        }
    }

    /*
    * Count up connected components of a Graph.
    * */
    public static Integer countConnectedComponents(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (Integer key: graph.keySet()) {
            if (!visited.contains(key)) {
                count++;
                dfs(graph, key, visited);
            }
        }
        return count;
    }

    /*
     * BFS version for a fully connected Graph.
     * */
    public static void bfs(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {

        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(node);

        while(!queue.isEmpty()) {
            Integer current = queue.poll();

            if (visited.contains(current)) continue;
            visited.add(current);

            System.out.print(current + " ");

            List<Integer> neighbors = graph.get(current);
            for (Integer neighbor: neighbors) {
                queue.addLast(neighbor);
            }
        }
    }

    /*
     * BFS version of not fully connected Graph.
     * */
    public static void bfsNFCG(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        for (Integer node: graph.keySet()) {
            if (!visited.contains(node)) {
                bfs(graph, node, visited);
            }
        }
    }

}
