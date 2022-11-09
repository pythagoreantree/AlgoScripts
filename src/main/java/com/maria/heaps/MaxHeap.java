package com.maria.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap {

    private final List<Integer> heapArray = new ArrayList<>();

    public MaxHeap() {}

    public MaxHeap(List<Integer> array) {
        this.heapArray.clear();
        this.heapArray.addAll(array);
    }

    public Integer getMax() {
        checkHeapNonEmpty();
        return heapArray.get(0);
    }

    private void checkHeapNonEmpty() {
        if (heapArray.isEmpty()) {
            throw new UnsupportedOperationException("Cannot get maximum element of an empty heap");
        }
    }

    public Integer extractMax() {
        checkHeapNonEmpty();
        int lastElemIndex = heapArray.size() - 1;
        if (heapArray.size() == 1) {
            heapArray.clear();
            return heapArray.get(lastElemIndex);
        }

        Integer firstElement = heapArray.get(0);

        swapNodeValues(0, lastElemIndex);

        heapArray.remove(lastElemIndex);

        siftDown(0);

        return firstElement;
    }

    public void insertElement() {

    }

    public void buildHeapFromArray(Integer[] arr) {
        if (arr == null) {
            throw new NullPointerException("Input array is null");
        }
        heapArray.clear();
        heapArray.addAll(Arrays.asList(arr));
//        int lastIndex = heapArray.size() / 2 - 1;
        for (int i = heapArray.size() - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void siftUp(Integer idx) {
        checkIndex(idx);
        Index index = new Index(idx);

        while (index.getParentIndex() != -1) {

            Integer parentNode = getParentValue(index);
            Integer node = getNodeValue(index);
            if (parentNode < node) {
                swapNodeValues(index.getIndex(), index.getParentIndex());
                index.setIndex(index.getParentIndex());
            } else {
                return;
            }
        }

    }

    public void siftDown(Integer idx) {
        checkIndex(idx);
        Index index = new Index(idx);

        while (hasLeftChild(index) || hasRightChild(index)) {

            if (hasLeftChild(index) && hasRightChild(index)) {

                Integer nodeIndex = index.getIndex();
                Integer biggestIndex = getBiggestNodeIndex(index);

                if (biggestIndex == nodeIndex) return;

                swapNodeValues(nodeIndex, biggestIndex);
                index.setIndex(biggestIndex);

            } else if (hasLeftChild(index)) {

                swapNodeValues(index.getIndex(), index.getLeftIndex());
                index.setIndex(index.getLeftIndex());

            } else if (hasRightChild(index)) {

                throw new RuntimeException("ERROR: Heap Structure is not valid!");
            }
        }

    }

    private void checkIndex(Integer idx) {
        if (idx < 0 || idx >= heapArray.size()) {
            throw new IndexOutOfBoundsException("Index idx=" + idx + " is out of range. " +
                    "There is no such element in the heap");
        }
    }

    private Integer getBiggestNodeIndex(Index index) {

        Integer biggestValue = getNodeValue(index);
        Integer biggestIndex = index.getIndex();

        if (getLeftValue(index) > getNodeValue(index)) {
            biggestValue = getLeftValue(index);
            biggestIndex = index.getLeftIndex();
        }
        if (getRightValue(index) > biggestValue) {
            biggestIndex = index.getRightIndex();
        }
        return biggestIndex;
    }

    private Integer getRightValue(Index index) {
        return heapArray.get(index.getRightIndex());
    }

    private Integer getLeftValue(Index index) {
        return heapArray.get(index.getLeftIndex());
    }

    private Integer getNodeValue(Index index) {
        return heapArray.get(index.getIndex());
    }

    private Integer getParentValue(Index index) {
        return heapArray.get(index.getParentIndex());
    }

    private boolean hasRightChild(Index index) {
        return index.getRightIndex() < heapArray.size();
    }

    private boolean hasLeftChild(Index index) {
        return index.getLeftIndex() < heapArray.size();
    }

    private Integer getValueByIndex(Integer index) {
        return (index >= heapArray.size())? null: heapArray.get(index);
    }

    private void swapNodeValues(int index1, int index2) {
        Integer tmpValue = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, tmpValue);
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
