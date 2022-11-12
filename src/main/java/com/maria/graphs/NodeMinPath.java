package com.maria.graphs;

public class NodeMinPath<T> implements Changeable<T>, Comparable<NodeMinPath<T>> {
    private final T index;
    private Integer minPathLength;

    public NodeMinPath(T index, Integer minPathLength) {
        this.index = index;
        this.minPathLength = minPathLength;
    }

    public T getIndex() {
        return index;
    }

    public Integer getMinPathLength() {
        return minPathLength;
    }

    public void increase() {
        minPathLength++;
    }

    public void decrease() {
        minPathLength--;
    }

    public void increaseByValue(Integer value) {
        minPathLength += value;
    }

    public void decreaseByValue(Integer value) {
        minPathLength -= value;
    }

    @Override
    public String toString() {
        return "NodeMinPath (" + index + ", " + minPathLength + ")";
    }

    @Override
    public int compareTo(NodeMinPath<T> o) {
       int comparisonResult = compareByPathLength(o.minPathLength);
       if (comparisonResult == 0) {
           Comparable<T> thisIndexValue = (Comparable) this.index;
           if (thisIndexValue.compareTo(o.index) != 0) {
               comparisonResult = thisIndexValue.compareTo(o.index) > 0? 1: -1;
           }
       }
       return comparisonResult;
    }

    private int compareByPathLength(Integer minPathLength) {
        if (this.minPathLength == minPathLength) return 0;
        return this.minPathLength > minPathLength? 1: -1;
    }
}
