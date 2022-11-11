package com.maria.heaps.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

public abstract class AbstractHeap<T> implements Heap<T> {

    private final List<T> heapArray = new ArrayList<>();

    @Override
    public int size() {
        return heapArray.size();
    }

    @Override
    public T getTop() {
        checkHeapNonEmpty();
        return heapArray.get(0);
    }

    @Override
    public T extractTop() {
        checkHeapNonEmpty();

        int lastIndex = heapArray.size() - 1;

        T firstElement = heapArray.get(0);

        swapNodeValues(0, lastIndex);

        heapArray.remove(lastIndex);

        if (!heapArray.isEmpty())
            siftDown(0);

        return firstElement;
    }

    private void checkHeapNonEmpty() {
        if (heapArray.isEmpty()) {
            throw new UnsupportedOperationException("Cannot get top element of an empty heap");
        }
    }

    public void increaseKey(Integer idx) {
        isIndexInArray(idx);
        T value = getHeapArray().get(idx);
        if (!(value instanceof Integer)) {
            throw new UnsupportedOperationException("This operation" +
                    "is supported for Integer only!");
        }
        Integer nodeValue = (Integer) value;
        nodeValue++;
        getHeapArray().set(idx, (T) nodeValue);
        fixHeaOnIncrease(idx);
    }

    public void decreaseKey(Integer idx) {
        isIndexInArray(idx);
        T value = getHeapArray().get(idx);
        if (!(value instanceof Integer)) {
            throw new UnsupportedOperationException("This operation" +
                    "is supported for Integer only!");
        }
        Integer nodeValue = (Integer) value;
        nodeValue--;
        getHeapArray().set(idx, (T) nodeValue);
        fixHeaOnDecrease(idx);
    }

    public abstract void fixHeaOnIncrease(Integer idx);

    public abstract void fixHeaOnDecrease(Integer idx);

    @Override
    public void insert(T value) {
        requireNonNull(value, "Can't insert null into " +
                "a priority queue.");
        heapArray.add(value);
        siftUp(heapArray.size() - 1);
    }

    @Override
    public void delete(Integer idx) {
        isIndexInArray(idx);
        int lastIndex = heapArray.size() - 1;
        if (idx == lastIndex) {
            heapArray.remove(lastIndex);
            return;
        }
        swapNodeValues(idx, lastIndex);
        heapArray.remove(lastIndex);
        siftDown(idx);
    }

    @Override
    public void buildHeapFromArray(T[] arr) {
        if (arr == null) {
            throw new NullPointerException("Input array is null!");
        }
        heapArray.clear();
        heapArray.addAll(Arrays.asList(arr));
        for (int i = heapArray.size() - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void siftUp(Integer idx) {
        isIndexInArray(idx);
        Index index = new Index(idx);

        while (index.getParentIndex() != -1 && ifDisorderedWithParent(index)) {
            swapNodeValues(index.getIndex(), index.getParentIndex());
            index.setIndex(index.getParentIndex());
        }
    }

    public void siftDown(Integer idx) {
        isIndexInArray(idx);
        Index index = new Index(idx);

        while (hasChildren(index)) {
            Integer indexOfNode = index.getIndex();
            Integer suitableIndex = heapify(index);
            if (suitableIndex == indexOfNode) return;
            swapNodeValues(indexOfNode, suitableIndex);
            index.setIndex(suitableIndex);
        }
    }

    public abstract boolean ifDisorderedWithParent(Index idx);

    public abstract Integer heapify(Index idx);

    protected void swapNodeValues(int index1, int index2) {
        T tmpValue = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, tmpValue);
    }

    private void isIndexInArray(Integer idx) {
        if (idx < 0 || idx >= heapArray.size()) {
            throw new IndexOutOfBoundsException("Index idx=" + idx + " is out of range. " +
                    "There is no such element in the heap");
        }
    }

    @Override
    public List<T> getHeapArray() {
        return heapArray;
    }

    protected boolean hasChildren(Index index) {
        return hasLeftChild(index) || hasRightChild(index);
    }

    protected boolean hasRightChild(Index index) {
        return index.getRightIndex() < heapArray.size();
    }

    protected boolean hasLeftChild(Index index) {
        return index.getLeftIndex() < heapArray.size();
    }

    protected T getNodeValue(Index index) {
        return heapArray.get(index.getIndex());
    }

    protected T getParentValue(Index index) {
        return heapArray.get(index.getParentIndex());
    }

    protected T getLeftValue(Index index) {
        return heapArray.get(index.getLeftIndex());
    }

    protected T getRightValue(Index index) {
        return heapArray.get(index.getRightIndex());
    }

    protected class Index {

        private Integer index;

        public Index(Integer index) {
            this.index = index;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getParentIndex() {
            if (index == 0) {
                return -1;
            }
            return (index - 1)/2;
        }

        public Integer getLeftIndex() {
            return 2*index + 1;
        }

        public Integer getRightIndex() {
            return 2*index + 2;
        }
    }
}
