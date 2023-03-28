package com.maria.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

class FloydWarshallTest {

    public static final Map<Integer, List<Edge>> graph = new HashMap<>();

    static {
        graph.put(1, List.of(new Edge(2, 3), new Edge(4, 7)));
        graph.put(2, List.of(new Edge(1, 8), new Edge(3, 2)));
        graph.put(3, List.of(new Edge(1, 5), new Edge(4, 1)));
        graph.put(4, List.of(new Edge(1, 2)));
    }

    @Test
    void transformGraphToMatrix() {
        Integer[][] adjMatrix = FloydWarshall.transformGraphToMatrix(graph);
        Arrays.stream(adjMatrix).forEach(row -> System.out.println(Arrays.asList(row)));
    }


    /*
    * Right result:
    * [0, 3, 5, 6]
    * [5, 0, 2, 3]
    * [3, 6, 0, 1]
    * [2, 5, 7, 0]
    * */
    @Test
    void startFloydWarshall() {
        Integer[][] result = FloydWarshall.startFloydWarshall(graph);
        FloydWarshall.printMatrix(result);
        int numberOfElements = graph.size();
        Integer[][] expected = new Integer[numberOfElements][numberOfElements];
        expected[0] = new Integer[]{0, 3, 5, 6};
        expected[1] = new Integer[]{5, 0, 2, 3};
        expected[2] = new Integer[]{3, 6, 0, 1};
        expected[3] = new Integer[]{2, 5, 7, 0};

        IntStream.range(0, result.length)
                .forEachOrdered(index -> Assertions.assertArrayEquals(result[index], expected[index]));
    }
}