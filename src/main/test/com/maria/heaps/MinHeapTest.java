package com.maria.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void siftUpEmpty() {
        MinHeap minHeap = new MinHeap();
        System.out.println(minHeap.getHeapArray());

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            minHeap.siftUp(0);
        });

        String expectedMessage = "Index 0 is out of bounds of the heap. Heap size: 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
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
    void siftUpSortedHeap() {
        List<Integer> testOnlyRoot = List.of(1, 2, 3, 4, 5, 8);
        MinHeap minHeap = new MinHeap(testOnlyRoot);
        System.out.println(minHeap.getHeapArray());

        minHeap.siftUp(4);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 2, 3, 4, 5, 8);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void siftUpNoSuchIndex() {
        List<Integer> testList = List.of(1, 2, 3, 4, 5, 8);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            minHeap.siftUp(6);
        });

        String expectedMessage = "Index 6 is out of bounds of the heap. Heap size: 6";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
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

    @Test
    void buildHeapFromArray() {
        Integer[] testArray = {1, 5, 7, 2, 6, 8, 3, 4, 9, 10, 11};
        MinHeap minHeap = new MinHeap();
        System.out.println(Arrays.asList(testArray));

        minHeap.buildHeapFromArray(testArray);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 2, 3, 4, 6, 8, 7, 5, 9, 10, 11);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void getMin() {
        List<Integer> testList = List.of(1, 2, 3);
        MinHeap minHeap = new MinHeap(testList);
        Integer minElem = minHeap.getMin();
        System.out.println(minElem);
        Assertions.assertEquals(1, minElem);
    }

    @Test
    void extractMin() {
        List<Integer> testList = List.of(1, 2, 4, 5, 3, 6, 8, 10, 12, 7);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        Integer minElem = minHeap.extractMin();
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(2, 3, 4, 5, 7, 6, 8, 10, 12);

        System.out.println("Min Element: " + minElem);
        System.out.println(result);

        Assertions.assertIterableEquals(rightAnswer, result);
        Assertions.assertEquals(1, minElem);
    }

    @Test
    void extractRoot() {
        List<Integer> testList = List.of(1);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        Integer minElem = minHeap.extractMin();
        List<Integer> result = minHeap.getHeapArray();

        System.out.println("Min Element: " + minElem);
        System.out.println(result);

        Assertions.assertTrue(result.isEmpty());
        Assertions.assertEquals(1, minElem);
    }


    @Test
    void increaseKey() {
        List<Integer> testList = List.of(1, 2, 10, 4, 2, 7, 9, 5, 6, 3);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.increaseKey(1);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 2, 10, 4, 3, 7, 9, 5, 6, 3);

        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void decreaseKey() {
        List<Integer> testList = List.of(1, 2, 10, 4, 2, 7, 9, 5, 6, 3);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.decreaseKey(4);
        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 1, 10, 4, 2, 7, 9, 5, 6, 3);

        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void decreaseKeyByDelta() {
        List<Integer> testList = List.of(1, 2, 11, 4, 10, 7, 9, 5, 6, 12);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.decreaseKey(7, 4);

        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 1, 11, 2, 10, 7, 9, 4, 6, 12);

        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void insert() {
        List<Integer> testList = List.of(1, 5, 8, 5, 10, 11, 8, 12, 15, 20);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.insert(4);

        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 4, 8, 5, 5, 11, 8, 12, 15, 20, 10);

        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void delete() {
        List<Integer> testList = List.of(1, 2, 9, 4, 5, 19, 29, 8, 4, 6, 10);
        MinHeap minHeap = new MinHeap(testList);
        System.out.println(minHeap.getHeapArray());

        minHeap.delete(1);

        List<Integer> result = minHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(1, 4, 9, 4, 5, 19, 29, 8, 10, 6);

        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

}