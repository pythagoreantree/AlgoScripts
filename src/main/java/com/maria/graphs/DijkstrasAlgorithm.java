package com.maria.graphs;

import com.maria.heaps.general.AMinHeap;

import java.util.*;

public class DijkstrasAlgorithm {

    public static final Integer BIG_CONST = 2^30;

    public static void dijkstras(Map<Integer, List<Edge>> graph, Integer startNode) {
        Set<Integer> visited = new HashSet<>();
        int numberOfNodes = graph.size();
        Integer[] dist = new Integer[numberOfNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Integer[] prev = new Integer[numberOfNodes];
        Arrays.fill(prev, null);

        List<Edge> startNodeList = null;
        for (Integer node: graph.keySet()) {
            if (node == startNode) {
                startNodeList = new ArrayList<>(graph.get(node));
            }
        }
        if (startNodeList == null) {
            throw new RuntimeException("Cannot build graph paths for this node. " +
                    "Neighbors list is empty.");
        }
        AMinHeap<NodeMinPath<Integer>> heap = new AMinHeap<>();
        heap.insert(new NodeMinPath<>(startNode, 0));
//        System.out.println(heap.getHeapArray());
//        System.out.println(Arrays.asList(dist));
        while (!heap.isEmpty()) {
            NodeMinPath<Integer> current = heap.extractTop();
//            if (dist[current.getIndex()] < current.getMinPathLength()) continue;
            System.out.println("Current top is " + current);
            visited.add(current.getIndex());
            for (Edge edge: graph.get(current.getIndex())) {
                Integer to = (Integer) edge.getTo();
                if (visited.contains(to)) continue;
                //fill dist
                Integer newMinPath = current.getMinPathLength() + edge.getWeight();
                if (newMinPath < dist[to]) {
                    dist[to] = newMinPath;
                    prev[to] = current.getIndex();
                    heap.insert(new NodeMinPath<>(to, newMinPath));
                }
            }
        }
        System.out.println(Arrays.asList(dist));
        System.out.println(Arrays.asList(prev));
        List<Integer> path = reconstructPath(prev, dist, 0, numberOfNodes - 1);
        System.out.println(path);
    }

    private static List<Integer> reconstructPath(Integer[] prev, Integer[] dist, int start, int end) {
        List<Integer> path = new ArrayList<>();
        if (dist[end].equals(BIG_CONST)) {
            throw new RuntimeException("These is no path between nodes " + start + " and " + end);
        }
        for (Integer i = end; i != null; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        return path;
    }
}
