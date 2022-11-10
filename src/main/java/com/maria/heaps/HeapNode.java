package com.maria.heaps;

/**
 * Made for HeapTree, Not Sure it is needed.
 * May be it would be cool to convert Heap to Tree
 * and Tree back to an array.
 */
public class HeapNode {

    private Integer value;
    private Integer index;

    private boolean isRoot = false;

    public HeapNode(Integer index) {
        this.index = index;
    }

    public HeapNode(Integer index, Integer value) {
        this.index = index;
        this.value = value;
    }

    public HeapNode(Integer index, boolean isRoot) {
        this.index = index;
        this.isRoot = isRoot;
    }

    public HeapNode(Integer value, Integer index, boolean isRoot) {
        this.value = value;
        this.index = index;
        this.isRoot = isRoot;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public int getParentIndex() {
        if (isRoot)
            return -1;
        return (index - 1)/2;
    }

    public int getLeftChildIndex() {
        return 2*index + 1;
    }

    public int getRightChildIndex() {
        return 2*index + 2;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
