package com.maria.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FloydWarshall {

    public static void startFloydWarshall(Map<Integer, List<Edge>> graph) {
        Integer[][] adjMatrix = transformGraphToMatrix(graph);

    }

    public static Integer[][] transformGraphToMatrix(Map<Integer, List<Edge>> graph) {
//        int numberOfNodes = graph.size();
        int matrixNumberOfNodes = graph.size();
        Integer[][] matrix = new Integer[matrixNumberOfNodes][matrixNumberOfNodes];
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, 0));

        for (Map.Entry<Integer, List<Edge>> entry: graph.entrySet()) {
            Integer[] row = matrix[entry.getKey() - 1];
            for (Edge edge: entry.getValue()) {
                Integer toNode = (Integer) edge.getTo();
                row[toNode - 1] = edge.getWeight();
            }
        }

        for (int row = 0; row < matrixNumberOfNodes; row++) {
            for (int col = 0; col < matrixNumberOfNodes; col++) {
                if (row != col && matrix[row][col] == 0) {
                    matrix[row][col] = Integer.MAX_VALUE;
                }
            }
        }
        return matrix;
    }
}
