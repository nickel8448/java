package main.java.graph;

public class WeightedEdge {
    private GraphVertex source;
    private GraphVertex destination;
    private int edgeWeight;

    WeightedEdge(int edgeWeight, GraphVertex source, GraphVertex destination) {
        this.edgeWeight = edgeWeight;
        this.source = source;
        this.destination = destination;
    }

    public GraphVertex getSource() {
        return source;
    }

    public void setSource(GraphVertex source) {
        this.source = source;
    }

    public GraphVertex getDestination() {
        return destination;
    }

    public void setDestination(GraphVertex destination) {
        this.destination = destination;
    }

    public int getEdgeWeight() {
        return edgeWeight;
    }

    public void setEdgeWeight(int edgeWeight) {
        this.edgeWeight = edgeWeight;
    }
}
