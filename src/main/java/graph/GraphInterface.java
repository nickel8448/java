package main.java.graph;

import java.util.LinkedList;

public interface GraphInterface {

    /**
     * Number of vertices in the graph
     * @return Returns the number of vertices in the graph
     */
    int numVertices();

    /**
     * Number of edges in the graph
     * @return Returns the number of edges in the graph
     */
    int numEdges();

    /**
     * Adds an edge v-w to the graph
     * @param v Vertex
     * @param w Edge
     */
    void addEdge(int v, int w);

    /**
     * String representation of the graph
     * @return Returns the string representation of the graph
     */
    String toString();

}
