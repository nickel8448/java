package main.java.graph;

import java.util.*;

public class DirectedGraph implements Graph {

    private HashMap<Integer, LinkedList<Integer>> adjacentVerticesByVertex;
    private Set<Integer> allVerticesSet;

    /**
     * Constructor. It initializes the class variables
     */
    DirectedGraph() {
        adjacentVerticesByVertex = new HashMap<>();
        allVerticesSet = new HashSet<>();
    }

    /**
     * Returns the number of vertices in the graph
     * @return Number of vertices in the graph
     */
    public int getNumberOfVertices() {
        return this.allVerticesSet.size();
    }

    /**
     * Returns the number of edges in the graph
     * @return Number of edges in the graph
     */
    public int getNumberOfEdges() {
        int numberOfEdges = 0;
        for(var adjForVertices : adjacentVerticesByVertex.values()) {
            numberOfEdges += adjForVertices.size();
        }
        return numberOfEdges;
    }

    /**
     * Adds an edge from VertexA to VertexB
     * @param vertexA VertexA
     * @param vertexB VertexB
     */
    public void addEdge(int vertexA, int vertexB) {
        allVerticesSet.add(vertexA); allVerticesSet.add(vertexB);
        if(!adjacentVerticesByVertex.containsKey(vertexA))
            adjacentVerticesByVertex.put(vertexA, new LinkedList<>());
        adjacentVerticesByVertex.get(vertexA).add(vertexB);
    }

    /**
     * Creates a String for the class
     * @return String representation of the class
     */
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

    /**
     * Function gets all the vertices in the graph
     * @return Returns an iterable of all the vertices in the graph
     */
    public Iterable<Integer> getAllVertices() {
        return adjacentVerticesByVertex.keySet();
    }

    /**
     * Function gets all the vertices adjacent to the source
     * @param source Vertex source
     * @return Returns an iterable of all the vertices adjacent to the source
     */
    public Iterable<Integer> getAdjacentVertices(int source) {
        return adjacentVerticesByVertex.get(source);
    }

}
