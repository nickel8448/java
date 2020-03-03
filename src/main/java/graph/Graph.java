package main.java.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of a Multi Graph
 */
public class Graph implements GraphInterface {
    private int numberOfVertices;
    private int numberOfEdges;  // Number of edges

    private HashMap<Integer, LinkedList<Integer>> adj;  // adjacency list

    Graph() {
        adj = new HashMap<>();
    }

    /**
     * Returns the number of vertices
     * @return Number of vertices in the graph
     */
    public int numVertices() {
        return this.numberOfVertices;
    }

    /**
     * Number of edges in the graph
     * @return Returns the number of edges in the graph
     */
    public int numEdges() {
        return this.numberOfEdges;
    }


    public void addVertex(int v) {
        adj.putIfAbsent(v, new LinkedList<>());
        ++numberOfVertices;
    }


    public void addEdge(int v, int w) {
        if(adj.containsKey(v)) {
            adj.get(v).add(w);
            ++numberOfEdges;
        } else if(adj.containsKey(w)) {
            adj.get(w).add(v);
            ++numberOfEdges;
        } else if (adj.containsKey(v) && adj.containsKey(w)) {
            adj.get(v).add(w);
            adj.get(w).add(v);
            ++numberOfEdges;
        } else {
            addVertex(v);
            addVertex(w);
            adj.get(w).add(v);
            adj.get(v).add(w);
            ++numberOfEdges;
        }
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (int key : adj.keySet()) {
            returnString.append(key).append(": ");
            LinkedList<Integer> nodesList = adj.get(key);
            returnString.append(Arrays.toString(nodesList.toArray()));
        }
        return returnString.toString();
    }

    public Iterable<Integer> getAdjacentVertices(int v) {

    }
}
