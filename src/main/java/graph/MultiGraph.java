package main.java.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of a Multi Graph
 */
public class MultiGraph implements Graph {

    private HashMap<Integer, LinkedList<Integer>> adjacentVerticesByVertex;  // adjacency list
    private final boolean ISDIRECTED = false;

    MultiGraph() {
        adjacentVerticesByVertex = new HashMap<>();
    }

    /**
     * Returns the number of vertices
     * @return Number of vertices in the graph
     */
    public int getNumberOfVertices() {
        return this.adjacentVerticesByVertex.size();
    }

    /**
     * Number of edges in the graph
     * @return Returns the number of edges in the graph
     */
    public int getNumberOfEdges() {
        int edgesBothWays = 0;
        for(var adjForVertice : adjacentVerticesByVertex.values()) {
            edgesBothWays += adjForVertice.size();
        }
        return edgesBothWays / 2;
    }

    /**
     * Returns if the graph is directed
     * @return
     */
    public boolean isDirected() {
        return ISDIRECTED;
    }


    /**
     * Adds a multi edge from VertexA -> VertexB and VertexB -> VertexA
     * @param vertexA VertexA
     * @param vertexB VertexB
     */
    public void addEdge(int vertexA, int vertexB) {
        if(!adjacentVerticesByVertex.containsKey(vertexA)) {
            adjacentVerticesByVertex.put(vertexA, new LinkedList<>());
        }
        adjacentVerticesByVertex.get(vertexA).add(vertexB);
        if(!adjacentVerticesByVertex.containsKey(vertexB)) {
            adjacentVerticesByVertex.put(vertexB, new LinkedList<>());
        }
        adjacentVerticesByVertex.get(vertexB).add(vertexA);
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append(String.format("(%d:%d) ", getNumberOfVertices(),
                getNumberOfEdges()));
        for (int key : adjacentVerticesByVertex.keySet()) {
            returnString.append(key).append(": ");
            LinkedList<Integer> nodesList = adjacentVerticesByVertex.get(key);
            returnString.append(Arrays.toString(nodesList.toArray()));
            returnString.append(' ');
        }
        return returnString.toString();
    }


    public Iterable<Integer> getAdjacentVertices(int vertex) {
        return adjacentVerticesByVertex.get(vertex);
    }

    public Iterable<Integer> getAllVertices() {
        return adjacentVerticesByVertex.keySet();
    }
}
