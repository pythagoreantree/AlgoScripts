package com.maria.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FloydWarshall {

    public static void startFloydWarshall(Map<Integer, List<Edge>> graph) {
        Integer[][] adjMatrix = transformGraphToMatrix(graph);

    }

    private static Integer[][] transformGraphToMatrix(Map<Integer, List<Edge>> graph) {
        int numberOfNodes = graph.size();
        int matrixNumberOfNodes = numberOfNodes + 1;
        Integer[][] matrix = new Integer[matrixNumberOfNodes][matrixNumberOfNodes];
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, 0));

        for (Map.Entry<Integer, List<Edge>> entry: graph.entrySet()) {
            Integer[] row = matrix[entry.getKey()];
            for (Edge edge: entry.getValue()) {
                Integer toNode = (Integer) edge.getTo();
                row[toNode] = edge.getWeight();
            }
        }
        return matrix;
    }
}
