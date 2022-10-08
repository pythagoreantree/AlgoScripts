package com.maria.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphPaths {

    public static boolean hasPath(Map<Integer, List<Integer>> graph, Integer src, Integer dst, Set<Integer> visited) {
        if (src == dst) return true;

        List<Integer> neighbors = graph.get(src);
        for (Integer neighbor: neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                if (hasPath(graph, neighbor, dst, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
