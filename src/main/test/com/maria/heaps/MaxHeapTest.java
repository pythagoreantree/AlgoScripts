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
}