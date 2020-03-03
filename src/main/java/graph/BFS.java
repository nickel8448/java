package main.java.graph;

public class BFS {
    public static void main(String[] args) {
        Graph g1 = new Graph();
        g1.addEdge(0, 5);
        g1.addEdge(4, 3);
        g1.addEdge(0,1);
        g1.addEdge(9, 12);
        g1.addEdge(6, 4);
        g1.addEdge(5, 4);
        g1.addEdge(0, 2);
        System.out.println(g1.toString());
    }
}
