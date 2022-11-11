package com.maria.heaps.general;

public class AMinHeap<T> extends AbstractHeap<T> {

    @Override
    public void fixHeaOnIncrease(Integer idx) {
        siftDown(idx);
    }

    @Override
    public void fixHeaOnDecrease(Integer idx) {
        siftUp(idx);
    }

    @Override
    public boolean ifDisorderedWithParent(Index index) {
        return ((Comparable) getParentValue(index)).compareTo(getNodeValue(index)) > 0;
    }


    @Override
    public Integer heapify(Index index) {

        Integer smallestIndex = index.getIndex();
        T smallestValue = getNodeValue(index);

        if (index.getLeftIndex() < size() &&
                ((Comparable) getLeftValue(index)).compareTo(smallestValue) < 0) {
            smallestIndex = index.getLeftIndex();
            smallestValue = getLeftValue(index);
        }
        if (index.getRightIndex() < size()
                && ((Comparable)getRightValue(index)).compareTo(smallestValue) < 0) {
            smallestIndex = index.getRightIndex();
        }
        return smallestIndex;
    }
}
