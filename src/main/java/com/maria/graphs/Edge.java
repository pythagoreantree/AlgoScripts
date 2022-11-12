package com.maria.graphs;

public class Edge {
    private Object to;
    private Integer weight;

    public Edge(Object to, Integer weight) {
        this.to = to;
        this.weight = weight;
    }

    public Object getTo() {
        return to;
    }

    public Integer getWeight() {
        return weight;
    }
}
