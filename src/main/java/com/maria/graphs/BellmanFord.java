package com.maria.graphs;

import java.util.*;

public class BellmanFord {

    private static final Integer BIG_CONST = 2^30;

    public static Integer[] startBellManFord(Map<Integer, List<Edge>> graph) {
        if (graph.isEmpty()) {
            throw new RuntimeException("The graph is empty.");
        }
        //first it's better to transform adjlist to pairs of vertices
        List<EdgeExt> edgeList = transformAdjListToPairs(graph);

        if (edgeList.isEmpty()) {
            throw new RuntimeException("The graph is empty. No edges found!");
        }

        int numberOfVertices = graph.size();
        //and initialize dist array
        Integer[] dist = new Integer[graph.size() + 1];
        Arrays.fill(dist, BIG_CONST);
        dist[0] = 0;
        //we count from thee first node, but theoretically,
        //we can choose any startNode and any sequence of edges
        dist[1] = 0;

        //Now I need to calc distances
        for (int i = 0; i < numberOfVertices - 1; i++) {
            for (EdgeExt edge: edgeList) {
                Integer firstNode = (Integer) edge.getFrom();
                Integer secondNode = (Integer) edge.getTo();
                if (dist[firstNode] + edge.getWeight() < dist[secondNode]) {
                    dist[secondNode] = dist[firstNode] + edge.getWeight();
                }
            }
        }

        //Here I will detect a negative cycle

        return dist;
    }

    public static List<EdgeExt> transformAdjListToPairs(Map<Integer, List<Edge>> graph) {
        List<EdgeExt> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Edge>> entry: graph.entrySet()) {
            Integer node = entry.getKey();
            List<Edge> neighbors = entry.getValue();
            for (Edge neighbor: neighbors) {
                EdgeExt edge = new EdgeExt(node, neighbor.getTo(), neighbor.getWeight());
                edges.add(edge);
            }
        }
        return edges;
    }
}
