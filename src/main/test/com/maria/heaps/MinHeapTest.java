package com.maria.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void siftUp() {
        List<Integer> testList = List.of(1, 3, 4, 7, 10, 11, 6, 2, 8);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.siftUp(7);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 2, 4, 3, 10, 11, 6, 7, 8);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void siftUpOneElement() {
        List<Integer> testOnlyRoot = List.of(1);
        MinHeap minHeap = new MinHeap(testOnlyRoot);
        System.out.println(minHeap.getHeapArray());

        minHeap.siftUp(0);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void siftDown() {
        List<Integer> testList = List.of(1, 10, 4, 2, 3, 6, 8, 5, 12, 13);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.siftDown(1);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 2, 4, 5, 3, 6, 8, 10, 12, 13);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void siftDownLeft() {
        List<Integer> testList = List.of(1, 13, 4, 5, 2, 6, 8, 10, 12, 3);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.siftDown(1);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 2, 4, 5, 3, 6, 8, 10, 12, 13);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }
}