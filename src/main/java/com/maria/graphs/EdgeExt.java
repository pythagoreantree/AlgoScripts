package com.maria.graphs;

public class EdgeExt extends Edge {

    private Object from;

    public EdgeExt(Object from, Object to, Integer weight) {
        super(to, weight);
        this.from = from;
    }

    public EdgeExt(Object to, Integer weight) {
        super(to, weight);
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return " (" + from + ", " + getTo() + ")";
    }
}
