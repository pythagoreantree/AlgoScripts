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
    public boolean isDisorderedWithParent(T parent, T node) {
        return ((Comparable) parent).compareTo(node) < 0;
    }

    @Override
    public boolean isLeftChosen(T leftValue, T value) {
        return ((Comparable)leftValue).compareTo(value) > 0;
    }

    @Override
    public boolean isRightChosen(T rightValue, T value) {
        return ((Comparable)rightValue).compareTo(value) > 0;
    }

}
