package com.maria.heaps.general;

public class AMaxHeap<T> extends AbstractHeap<T> {

    @Override
    public void fixHeaOnIncrease(Integer idx) {
        siftUp(idx);
    }

    @Override
    public void fixHeaOnDecrease(Integer idx) {
        siftDown(idx);
    }

    @Override
    public boolean ifDisorderedWithParent(Index index) {
        return ((Comparable) getParentValue(index)).compareTo(getNodeValue(index)) < 0;
    }

    @Override
    public Integer heapify(Index index) {

        Integer biggestIndex = index.getIndex();
        T biggestValue = getNodeValue(index);

        if (((Comparable)getLeftValue(index)).compareTo(biggestValue) > 0) {
            biggestValue = getLeftValue(index);
            biggestIndex = index.getLeftIndex();
        }
        if (((Comparable)getRightValue(index)).compareTo(biggestValue) > 0) {
            biggestIndex = index.getRightIndex();
        }
        return biggestIndex;
    }
}
