package com.maria.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FloydWarshall {

    private static final Integer BIG_CONST = Double.valueOf(Math.pow(2.0, 30.0)).intValue();

    public static Integer[][] startFloydWarshall(Map<Integer, List<Edge>> graph) {
        Integer[][] aMatrix = transformGraphToMatrix(graph);

        for (int k = 0; k < graph.size(); k++) {
            for (int i = 0; i < aMatrix.length; i++) {
                for (int j = 0; j < aMatrix.length; j++) {
                    aMatrix[i][j] = Math.min(aMatrix[i][j], aMatrix[i][k] + aMatrix[k][j]);
                }
            }
        }
        return aMatrix;
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
                    matrix[row][col] = BIG_CONST;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(Integer[][] matrix) {
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.asList(row)));
    }
}
