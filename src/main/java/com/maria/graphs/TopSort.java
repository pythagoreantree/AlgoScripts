package com.maria.graphs;

import java.util.*;

public class TopSort {

    //Not friends with graphs with cycles

    //topSort for DAG
    public static List<Integer> topSort(Map<Integer, List<Integer>> graph) {
        Integer[] topOrdering = new Integer[graph.size()];
        int pos = topOrdering.length - 1;
        Set<Integer> visited = new HashSet<>();

        for (Integer node: graph.keySet()) {
            pos = tsDFS(graph, node, visited, topOrdering, pos);
        }
        return Arrays.asList(topOrdering);
    }

    private static int tsDFS(Map<Integer, List<Integer>> graph, Integer node,
                              Set<Integer> visited, Integer[] topOrdering, int pos) {
        if (visited.contains(node)) return pos;
        visited.add(node);

        for (Integer neighbor: graph.get(node)) {
            pos = tsDFS(graph, neighbor, visited, topOrdering, pos);
        }
        topOrdering[pos] = node;
        pos -= 1;
        return pos;
    }

    public static List<String> topSortChar(Map<String, List<Edge>> graph) {
        String[] topOrdering = new String[graph.size()];
        int pos = topOrdering.length - 1;
        Set<String> visited = new HashSet<>();

        for (String node: graph.keySet()) {
            pos = tsCharDFS(graph, node, visited, topOrdering, pos);
        }
        return Arrays.asList(topOrdering);
    }

    private static int tsCharDFS(Map<String, List<Edge>> graph, String node,
                             Set<String> visited, String[] topOrdering, int pos) {
        if (visited.contains(node)) return pos;
        visited.add(node);

        for (Edge neighbor: graph.get(node)) {
            pos = tsCharDFS(graph, neighbor.to.toString(), visited, topOrdering, pos);
        }
        topOrdering[pos] = node;
        pos -= 1;
        return pos;
    }

    public static Object[] topSortCommon(Map<Object, List<Edge>> graph) {
        Object[] topOrdering = new Object[graph.size()];
        int pos = topOrdering.length - 1;
        Set<Object> visited = new HashSet<>();

        for (Object node: graph.keySet()) {
            pos = tsCommonDFS(graph, node, visited, topOrdering, pos);
        }
        return topOrdering;
    }

    private static int tsCommonDFS(Map<Object, List<Edge>> graph, Object node,
                                 Set<Object> visited, Object[] topOrdering, int pos) {
        if (visited.contains(node)) return pos;
        visited.add(node);

        for (Edge neighbor: graph.get(node)) {
            pos = tsCommonDFS(graph, neighbor.to, visited, topOrdering, pos);
        }
        topOrdering[pos] = node;
        pos -= 1;
        return pos;
    }

    public static List<Integer> ssspInt(Map<Object, List<Edge>> graph) {
       Object[] topOrdering = topSortCommon(graph);
       Integer[] pathLengths = new Integer[graph.size() + 1];
       Arrays.fill(pathLengths, null);
       pathLengths[0] = 0;

       for (Object node: topOrdering) {
           Integer nodeValue = Integer.valueOf(node.toString());
           if (pathLengths[nodeValue] == null) {
               pathLengths[nodeValue] = 0;
           }
           List<Edge> neighbors = graph.get(node);
           for (Edge neighbor: neighbors) {
               Integer neighborValue = (Integer) neighbor.to;
               if (pathLengths[neighborValue] == null) {
                   pathLengths[neighborValue] = pathLengths[nodeValue] + neighbor.weight;
               } else {
                   pathLengths[neighborValue] = Math.min(pathLengths[neighborValue], pathLengths[nodeValue] + neighbor.weight);
               }
           }
       }
       return Arrays.asList(pathLengths);
    }


    public static List<String> ssspChar(Map<String, List<Edge>> graph) {
        List<String> topOrdering = topSortChar(graph);
        Integer[] pathLengths = new Integer[graph.size()];
        String[] pathsStrings = new String[graph.size()];
        Arrays.fill(pathLengths, null);
        pathLengths[0] = 0;
        pathsStrings[0] = "";

        for (String node: topOrdering) {
            int nodeIndex = topOrdering.indexOf(node);
            List<Edge> neighbors = graph.get(node);
            for (Edge neighbor: neighbors) {
                int index = topOrdering.indexOf(neighbor.to);
                if (pathLengths[index] == null) {
                    pathLengths[index] = pathLengths[nodeIndex] + neighbor.weight;
                    pathsStrings[index] = node;
                } else {
                    if (pathLengths[index] > pathLengths[nodeIndex] + neighbor.weight) {
                        pathLengths[index] = pathLengths[nodeIndex] + neighbor.weight;
                        pathsStrings[index] = node;
                    }
                }
            }
        }
        return Arrays.asList(pathsStrings);
    }

    public static List<String> calcMinPath(List<String> topSort, List<String> paths) {
        Deque<String> minPath = new LinkedList<>();
        minPath.addFirst(topSort.get(topSort.size() - 1));
        int lastIndex = paths.size() - 1;
        while (lastIndex > 0) {
            String letter = paths.get(lastIndex);
            minPath.addFirst(letter);
            lastIndex = topSort.indexOf(letter);
        }
        return new ArrayList<>(minPath);
    }
}
