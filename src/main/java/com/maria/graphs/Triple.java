package com.maria.graphs;

import java.util.Objects;

public class Triple extends Tuple {

    private int value;

    public Triple(int x, int y, int value) {
        super(x, y);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Triple triple = (Triple) o;
        return super.equals(o) && value == triple.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
