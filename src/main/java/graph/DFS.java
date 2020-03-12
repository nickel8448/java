package main.java.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DFS {

    private boolean[] visited;
    private HashMap<Integer, Integer> parentMap;  // HashMap to record parent
    private Graph graph;

    /**
     * Constructor which accepts a Graph and runs DFS on all the vertices
     * @param graph graph
     */
    DFS(Graph graph) {
        visited = new boolean[graph.getNumberOfVertices()];
        parentMap = new HashMap<>();
        this.graph = graph;
        DFSVisit();
    }

    /**
     * Constructor which accepts the Graph and source vertex to start DFS
     * @param graph graph
     * @param source source of the graph
     */
    DFS(Graph graph, int source) {
        visited = new boolean[graph.getNumberOfVertices()];
        parentMap = new HashMap<>();
        this.graph = graph;
        DFSVisit(source);
    }

    /**
     * The function will visit all the nodes in the Graph and do a DFS on the
     * graph
     */
    private void DFSVisit() {
        for(int source : graph.getAllVertices()) {
            if(!visited[source]) {
                parentMap.put(source, null);
                DFSUtil(source);
            }
        }
    }

    /**
     * The function will visit all the nodes starting at the source vertex
     * If the graph is not strongly connected, this will not visit all the nodes
     * @param source source for the graph
     */
    private void DFSVisit(int source) {
        DFSUtil(source);
    }

    private void DFSUtil(int source) {
        visited[source] = true;
        System.out.println(source);
        if(graph.getAdjacentVertices(source) != null) {
            for (int vertex : graph.getAdjacentVertices(source)) {
                if (!visited[vertex]) {
                    parentMap.put(vertex, source);
                    DFSUtil(vertex);
                }
            }
        }
    }

    /**
     * Prints the dictionary of parent and children
     */
    public void printParentDictionary() {
        System.out.println(parentMap);
    }

    public boolean isCyclic() {
        visited = new boolean[this.graph.getNumberOfVertices()];
        for (int source : this.graph.getAllVertices()) {
            if(graph.isDirected()) {
                boolean[] recStack = new boolean[this.graph.getNumberOfVertices()];
                if (isCyclicUtilDirected(source, recStack)) return true;
            }
            else {
                if(!visited[source])
                    if(isCyclicUtilUndirected(source, -1)) return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtilUndirected(int source, int parent) {
        System.out.println(source);
        visited[source] = true;
        if(graph.getAdjacentVertices(source) != null) {
            for(int vertex : this.graph.getAdjacentVertices(source)) {
                if(!visited[vertex]) {
                    if (isCyclicUtilUndirected(vertex, source)) return true;
                } else if (visited[vertex] && vertex != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtilDirected(int source, boolean[] recStack) {
        System.out.println(source);
        if(recStack[source]) return true;
        if(visited[source]) return false;
        recStack[source] = true;
        visited[source] = true;
        if(graph.getAdjacentVertices(source) != null) {
            for (int vertex : this.graph.getAdjacentVertices(source)) {
                if (isCyclicUtilDirected(vertex, recStack)) return true;
            }
        }
        recStack[source] = false;
        return false;
    }

    public void topologicalSort() {
        visited = new boolean[this.graph.getNumberOfVertices()];
        // List to store nodes for topological order
        List<Integer> order = new ArrayList<>();
        for(int source : this.graph.getAllVertices()) {
            topologicalSortUtil(source, order);
        }
        Collections.reverse(order);
        System.out.println(order);
    }

    private void topologicalSortUtil(int source, List<Integer> order) {
        visited[source] = true;
        if(graph.getAdjacentVertices(source) != null) {
            for(int vertex : graph.getAdjacentVertices(source)) {
                if(!visited[source]) {
                    topologicalSortUtil(vertex, order);
                }
            }
        }
        order.add(source);
    }

}
