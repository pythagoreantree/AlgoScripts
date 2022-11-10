package com.maria.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class MinHeap {

    private final List<Integer> heapArray = new ArrayList<>();

    public MinHeap() {}

    public MinHeap(List<Integer> array) {
        this.heapArray.clear();
        this.heapArray.addAll(array);
        //may be need a check to validate the structure
    }

    public int size() {
        return heapArray.size();
    }

    public Integer getMin() {
        checkHeapNonEmpty();
        return heapArray.get(0);
    }

    public Integer extractMin() {
        checkHeapNonEmpty();

        int lastIndex = heapArray.size() - 1;

        Integer firstElement = heapArray.get(0);

        swapNodeValues(0, lastIndex);

        heapArray.remove(lastIndex);

        if (!heapArray.isEmpty())
            siftDown(0);

        return firstElement;
    }


    private void checkHeapNonEmpty() {
        if (heapArray.isEmpty()) {
            throw new UnsupportedOperationException("Cannot get minimum element of an empty heap");
        }
    }

    public void increaseKey(Integer idx) {
        isIndexInArray(idx);
        Integer value = heapArray.get(idx);
        value++;
        heapArray.set(idx, value);
        siftDown(idx);
    }

    public void decreaseKey(Integer idx) {
        isIndexInArray(idx);
        Integer value = heapArray.get(idx);
        value--;
        heapArray.set(idx, value);
        siftUp(idx);
    }

    public void decreaseKey(Integer idx, Integer delta) {
        isIndexInArray(idx);
        Integer value = heapArray.get(idx);
        value -= delta;
        if (value > heapArray.get(idx)) {
            System.out.println("Result value " + value + " is greater" +
                    "than the current value. Can't decrease the key");
            return;
        }
        heapArray.set(idx, value);
        siftUp(idx);
    }

    public void insert(Object value) {
        requireNonNull(value, "Can't insert null into " +
                "a priority queue.");
        Integer nodeValue = (Integer) value;
        heapArray.add(nodeValue);
        siftUp(heapArray.size() - 1);
    }

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

    public void buildHeapFromArray(Integer[] arr) {
        this.heapArray.clear();
        this.heapArray.addAll(Arrays.asList(arr));

        for (int i = 0; i < heapArray.size(); i++) {
            siftDown(i);
        }
    }

    public void siftUp(Integer idx) {
        /*if (heapArray.isEmpty()) {
            throw new RuntimeException("This heap is empty. Nothing to sift up.");
        }*/
        isIndexInArray(idx);
        Index index = new Index(idx);

        while (index.getParentIndex() != -1 && getParentValue(index) > getNodeValue(index)) {
            swapNodeValues(index.getIndex(), index.getParentIndex());
            index.setIndex(index.getParentIndex());
        }
    }

    public void siftDown(Integer idx) {
        isIndexInArray(idx);
        Index index = new Index(idx);

        while (hasChildren(index)) {

            if (hasLeftChild(index) && hasRightChild(index)) {

                Integer indexOfNode = index.getIndex();
                Integer indexOfSmallestValue = getSmallestValue(index);
                if (indexOfSmallestValue == indexOfNode) return;
                swapNodeValues(indexOfNode, indexOfSmallestValue);
                index.setIndex(indexOfSmallestValue);

            } else if (hasLeftChild(index)) {

                if (getLeftValue(index) < getNodeValue(index)) {
                    swapNodeValues(index.getIndex(), index.getLeftIndex());
                    index.setIndex(index.getLeftIndex());
                }
                return;

            } else if (hasRightChild(index)) {
                throw new RuntimeException("ERROR: Heap Structure is not valid!");
            }
        }
    }

    private Integer getSmallestValue(Index index) {

        Integer smallestIndex = index.getIndex();
        Integer smallestValue = getNodeValue(index);

        if (getLeftValue(index) < smallestValue) {
            smallestIndex = index.getLeftIndex();
            smallestValue = getLeftValue(index);
        }
        if (getRightValue(index) < smallestValue) {
            smallestIndex = index.getRightIndex();
        }
        return smallestIndex;
    }

    private boolean hasChildren(Index index) {
        return hasLeftChild(index) || hasRightChild(index);
    }

    private boolean hasRightChild(Index index) {
        return index.getRightIndex() < heapArray.size();
    }

    private boolean hasLeftChild(Index index) {
        return index.getLeftIndex() < heapArray.size();
    }

    private void isIndexInArray(Integer idx) {
        if (idx < 0 || idx >= heapArray.size()) {
            throw new IndexOutOfBoundsException("Index " + idx +
                    " is out of bounds of the heap. Heap size: " + heapArray.size());
        }
    }

    private void swapNodeValues(int index1, int index2) {
        Integer tmpValue = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, tmpValue);
    }

    private Integer getNodeValue(Index index) {
        return heapArray.get(index.getIndex());
    }

    private Integer getParentValue(Index index) {
        return heapArray.get(index.getParentIndex());
    }

    private Integer getLeftValue(Index index) {
        return heapArray.get(index.getLeftIndex());
    }

    private Integer getRightValue(Index index) {
        return heapArray.get(index.getRightIndex());
    }

    public List<Integer> getHeapArray() {
        return heapArray;
    }

    public class Index {

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
