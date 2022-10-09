package com.maria.graphs;

import java.util.*;

public class GraphPaths {

    /*
    * For Undirected Graph. For directed is much simpler.
    * */
    public static boolean hasPath(Map<Integer, List<Integer>> graph, Integer src, Integer dst, Set<Integer> visited) {
        if (src == dst) return true;
        if (visited.contains(src)) return false;
        visited.add(src);

        List<Integer> neighbors = graph.get(src);
        for (Integer neighbor: neighbors) {
            if (hasPath(graph, neighbor, dst, visited)) {
                return true;
            }
        }

        return false;
    }

    public static Map<Integer, List<Integer>> pairsToAdvListUndirected(List<List<Integer>> pairs)  {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> pair: pairs) {
            int first = pair.get(0);
            int second = pair.get(1);
            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new ArrayList<>());
            }

            List<Integer> firstList = graph.get(first);
            if (!firstList.contains(second)) {
                firstList.add(second);
                graph.put(first, firstList);
            }

            List<Integer> secondList = graph.get(second);
            if (!secondList.contains(first)) {
                secondList.add(first);
                graph.put(second, secondList);
            }
        }
        return graph;
    }

    public static Map<Integer, List<Integer>> pairsToAdvListDirected(List<List<Integer>> pairs)  {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> pair: pairs) {
            int first = pair.get(0);
            int second = pair.get(1);
            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<>());
            }

            List<Integer> firstList = graph.get(first);
            if (!firstList.contains(second)) {
                firstList.add(second);
                graph.put(first, firstList);
            }
        }
        return graph;
    }

    /*
    * Length of shortest path.
    * */
    public static int shortestPathBFS(Map<Integer, List<Integer>> graph, Integer src, Integer dst) {
        Set<Integer> visited = new HashSet<>();
        Deque<List<Integer>> queue = new LinkedList<>();
        queue.addLast(List.of(src, 0));

        while(!queue.isEmpty()) {
            List<Integer> elem = queue.pollFirst();
            Integer node = elem.get(0);
            if (node == dst) return elem.get(1);
            List<Integer> neighbors = graph.get(node);
            for(Integer neighbor: neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.addLast(List.of(neighbor, elem.get(1) + 1));
                }
            }
        }
        return -1;
    }

    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> ordering = new ArrayList<>();
        for (Integer key: graph.keySet()) {
            if (!visited.contains(key)) {
                topsortDFS(graph, key, visited, ordering);
            }
        }
        Collections.reverse(ordering);
        return ordering;
    }

    private static void topsortDFS(Map<Integer, List<Integer>> graph, Integer node,
                                            Set<Integer> visited, List<Integer> tsList) {
        if (visited.contains(node)) return;
        visited.add(node);

        List<Integer> neighbors = graph.get(node);
        for (Integer neighbor: neighbors) {
            topsortDFS(graph, neighbor, visited, tsList);
        }
        tsList.add(node);
        return;
    }


}
