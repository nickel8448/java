package main.java.graph;

import java.util.HashMap;

public class DFS {

    private boolean[] visited;
    private HashMap<Integer, Integer> parentMap;  // HashMap to record parent

    /**
     * Constructor which accepts a Graph and runs DFS on all the vertices
     * @param graph graph
     */
    DFS(Graph graph) {
        visited = new boolean[graph.getNumberOfVertices()];
        parentMap = new HashMap<>();
        DFSVisit(graph);
    }

    /**
     * Constructor which accepts the Graph and source vertex to start DFS
     * @param graph graph
     * @param source source of the graph
     */
    DFS(Graph graph, int source) {
        visited = new boolean[graph.getNumberOfVertices()];
        parentMap = new HashMap<>();
        DFSVisit(graph, source);
    }

    /**
     * The function will visit all the nodes in the Graph and do a DFS on the
     * graph
     */
    private void DFSVisit(Graph graph) {
        for(int source : graph.getAllVertices()) {
            if(!visited[source]) {
                parentMap.put(source, null);
                DFSUtil(graph, source);
            }
        }
    }

    /**
     * The function will visit all the nodes starting at the source vertex
     * If the graph is not strongly connected, this will not visit all the nodes
     * @param source source for the graph
     */
    private void DFSVisit(Graph graph, int source) {
        DFSUtil(graph, source);
    }

    private void DFSUtil(Graph graph, int source) {
        visited[source] = true;
        System.out.println(source);
        if(graph.getAdjacentVertices(source) != null) {
            for (int vertex : graph.getAdjacentVertices(source)) {
                if (!visited[vertex]) {
                    parentMap.put(vertex, source);
                    DFSUtil(graph, vertex);
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



}
