package com.maria.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaxHeapTest {

    @Test
    void siftDown() {
        List<Integer> arrayList1 = List.of(16, 4, 10, 7, 14, 9, 3, 2, 1, 8);
        System.out.println(arrayList1);
        MaxHeap maxHeap = new MaxHeap(arrayList1);
        maxHeap.siftDown(1);
        System.out.println(maxHeap.getHeapArray());
        List<Integer> arrayListExpected1 = List.of(16, 14, 10, 7, 8, 9, 3, 2, 1, 4);
        Assertions.assertIterableEquals(arrayListExpected1, maxHeap.getHeapArray());

        List<Integer> arrayList2 = List.of(5, 4, 10, 7, 14, 9, 3, 2, 1, 8);
        System.out.println(arrayList2);
        maxHeap = new MaxHeap(arrayList2);
        maxHeap.siftDown(0);
        System.out.println(maxHeap.getHeapArray());
        List<Integer> arrayListExpected2 = List.of(10, 4, 9, 7, 14, 5, 3, 2, 1, 8);
        Assertions.assertIterableEquals(arrayListExpected2, maxHeap.getHeapArray());
    }

    @Test
    void siftUp() {
        List<Integer> arrayList3 = List.of(24, 14, 10, 7, 4, 9, 3, 2, 1, 18);
        System.out.println(arrayList3);
        MaxHeap maxHeap = new MaxHeap(arrayList3);
        maxHeap.siftUp(9);
        System.out.println(maxHeap.getHeapArray());
        List<Integer> arrayListExpected3 = List.of(24, 18, 10, 7, 14, 9, 3, 2, 1, 4);
        Assertions.assertIterableEquals(arrayListExpected3, maxHeap.getHeapArray());

        List<Integer> arrayList4 = List.of(24);
        System.out.println(arrayList4);
        maxHeap = new MaxHeap(arrayList4);
        maxHeap.siftUp(0);
        System.out.println(maxHeap.getHeapArray());
        List<Integer> arrayListExpected4 = List.of(24);
        Assertions.assertIterableEquals(arrayListExpected4, maxHeap.getHeapArray());
    }

    @Test
    void buildHeapFromArray() {
        List<Integer> randomList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(randomList);
        Integer[] randomArray = randomList.toArray(new Integer[10]);
        System.out.println(randomList);
        MaxHeap heap = new MaxHeap();
        heap.buildHeapFromArray(randomArray);
        System.out.println(heap.getHeapArray());
    }

    @Test
    void getMax() {
        List<Integer> testList1 = List.of(24, 18, 10, 7, 14, 9, 3, 2, 1, 4);
        MaxHeap maxHeap = new MaxHeap(testList1);
        Integer maxElem = maxHeap.getMax();
        System.out.println(maxElem);
        Assertions.assertEquals(24, maxElem);
    }

    @Test
    void extractMax() {
        List<Integer> testList = List.of(24, 18, 10, 7, 14, 9, 3, 2, 1, 4);
        MaxHeap maxHeap = new MaxHeap(testList);
        System.out.println(maxHeap.getHeapArray());

        Integer maxElem = maxHeap.extractMax();
        List<Integer> result = maxHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(18, 14, 10, 7, 4, 9, 3, 2, 1);

        System.out.println("Max Element: " + maxElem);
        System.out.println(result);

        Assertions.assertIterableEquals(rightAnswer, result);
        Assertions.assertEquals(24, maxElem);

    }

    @Test
    void increaseKey() {
        List<Integer> testList = List.of(24, 14, 10, 7, 14, 9, 3, 2, 1, 4);
        MaxHeap maxHeap = new MaxHeap(testList);
        System.out.println(maxHeap.getHeapArray());

        maxHeap.increaseKey(4);
        List<Integer> result = maxHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(24, 15, 10, 7, 14, 9, 3, 2, 1, 4);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }

    @Test
    void decreaseKey() {
        List<Integer> testList = List.of(24, 14, 10, 7, 14, 9, 3, 2, 1, 4);
        MaxHeap maxHeap = new MaxHeap(testList);
        System.out.println(maxHeap.getHeapArray());

        maxHeap.decreaseKey(1);
        List<Integer> result = maxHeap.getHeapArray();
        List<Integer> rightAnswer = List.of(24, 14, 10, 7, 13, 9, 3, 2, 1, 4);
        System.out.println(result);
        Assertions.assertIterableEquals(rightAnswer, result);
    }
}