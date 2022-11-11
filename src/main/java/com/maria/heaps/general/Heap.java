package com.maria.heaps.general;

import java.util.List;

public interface Heap<T> {

    int size();

    T getTop();

    T extractTop();

    void increaseKey(Integer idx);

    void decreaseKey(Integer idx);

    void insert(T value);

    void delete(Integer idx);

    void buildHeapFromArray(T[] arr);

    void siftUp(Integer idx);

    void siftDown(Integer idx);

    List<T> getHeapArray();


}
