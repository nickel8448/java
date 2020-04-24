package main.java.graph;

import java.util.Comparator;

public class GraphVertex implements Comparator<GraphVertex> {
    private int value;

    GraphVertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(this.value).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        GraphVertex other = (GraphVertex) obj;
        if(value != other.getValue()) return false;
        return true;
    }

    /**
     * Compares two nodes. The comparison is based on the value in the node
     * @param one
     * @param two
     * @return
     */
    public int compare(GraphVertex one, GraphVertex two) {
        if(one.value == two.value) return 0;
        return one.value > two.value ? 1 : -1;
    }
}