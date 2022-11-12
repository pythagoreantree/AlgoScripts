package com.maria.graphs;

public interface Changeable<T> {

    public void increase();

    public void decrease();

    public void increaseByValue(Integer value);

    public void decreaseByValue(Integer value);
}
