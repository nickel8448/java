package main.java.graph;

public class GraphPlayground {

    static void DFSTesting() {
        Graph graph = new DirectedGraph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 0);
        graph.addEdge(3, 5);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 2);
        graph.addEdge(5, 4);
        graph.addEdge(6, 0);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(10, 12);
        graph.addEdge(11, 12);
        graph.addEdge(11, 4);
        graph.addEdge(12, 9);
        System.out.println("Number of vertices: " + graph.getNumberOfVertices());
        DFS dfs = new DFS(graph);
        dfs.printParentDictionary();
    }


    public static void main(String[] args) {
        DFSTesting();
    }
}
