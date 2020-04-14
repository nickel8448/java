package main.java.graph;

import java.util.HashMap;

public class ConnectedComponents {

    HashMap<Integer, Integer> preClock;
    HashMap<Integer, Integer> postClock;
    int time;
    Graph graph;

    ConnectedComponents(Graph graph) {
        preClock = new HashMap<>();
        postClock = new HashMap<>();
        time = 1;
        this.graph = graph;
    }

    /**
     * Functions returns the number of connected components in an undirected
     * graph
     * @param graph Graph to search in
     * @return Number of connected components
     */
    public int numConnectedComponents(MultiGraph graph) {
        int numConnected = 0;
        boolean[] visited = new boolean[graph.getNumberOfVertices()];
        HashMap<Integer, Integer> connectingMap = new HashMap<>();
        for(int vertex : graph.getAllVertices()) {
            if(!visited[vertex]) {
                numConnected++;
                dfs(vertex, visited, graph, connectingMap, numConnected);
            }
        }
        return numConnected;
    }

    private void dfs(int source, boolean[] visited, MultiGraph graph,
                           HashMap<Integer, Integer> connectingMap,
                           int connectedNum) {
        // Marking the node to be visited
        visited[source] = true;
        // Storing pre number
        preClock.put(source, time++);
        // Adding source to the connecting number
        connectingMap.put(connectedNum, source);
        // Traversing the graph
        if(graph.getAdjacentVertices(source) != null) {
            for(int vertex : graph.getAdjacentVertices(source)) {
                if(!visited[vertex]) {
                    dfs(vertex, visited, graph, connectingMap, connectedNum);
                }
            }
        }
        postClock.put(source, time++);
    }

    public void printPrePostTime() {
        for(int vertex : graph.getAllVertices()) {
            System.out.print(vertex + ": " + preClock.get(vertex) + ", " +
                    postClock.get(vertex));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MultiGraph graph = new MultiGraph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 1);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println(cc.numConnectedComponents(graph));
        cc.printPrePostTime();
    }
}
