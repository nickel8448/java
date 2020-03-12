package main.java.graph;

public class GraphPlayground {

    static void isCyclicTestingUndirected() {
        Graph undirectedGraph = new MultiGraph();
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 7);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 8);
        undirectedGraph.addEdge(2, 5);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 5);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(4, 5);
        undirectedGraph.addEdge(5, 6);
        undirectedGraph.addEdge(5, 6);
        undirectedGraph.addEdge(6, 7);
        undirectedGraph.addEdge(6, 8);
        DFS dfs = new DFS(undirectedGraph);
        dfs.printParentDictionary();
    }

    static void isCyclicTestingUndirectedSmallGraph() {
        Graph graph = new MultiGraph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        DFS dfs = new DFS(graph);
        dfs.printParentDictionary();
        System.out.println(dfs.isCyclic());
        System.out.println("Added new edge 3-0");
        graph.addEdge(3, 0);
        System.out.println(dfs.isCyclic());
    }

    static void DFSTesting() {
        DirectedGraph graph  = new DirectedGraph();
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
        DFS dfs = new DFS(graph);
        dfs.topologicalSort();
    }


    public static void main(String[] args) {
        DFSTesting();
    }
}
