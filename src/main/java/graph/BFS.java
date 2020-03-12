package main.java.graph;

import java.util.ArrayDeque;

public class BFS {

    private boolean[] visited;
    private int[] edgeTo;
    private final int source;

    public BFS(MultiGraph G, int source) {
        this.source = source;
        visited = new boolean[G.getNumberOfVertices()];
        edgeTo = new int[G.getNumberOfVertices()];
    }

    private void bfs(MultiGraph G, int source) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[source] = true;
        queue.add(source);
        while(!queue.isEmpty()) {
            int vertex = queue.pop();
            for(int adjVertex : G.getAdjacentVertices(vertex)) {
                if(!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    public boolean hasPathTo(int vertex){
        return visited[vertex];
    }

//    public static void main(String[] args) {
//        MultiGraph g1 = new MultiGraph();
//        g1.addEdge(0, 5);
//        g1.addEdge(4, 3);
//        g1.addEdge(0,1);
//        g1.addEdge(9, 12);
//        g1.addEdge(6, 4);
//        g1.addEdge(5, 4);
//        g1.addEdge(0, 2);
//        g1.addEdge(11, 12);
//        g1.addEdge(9, 10);
//        g1.addEdge(0, 6);
//        g1.addEdge(7, 8);
//        g1.addEdge(9, 11);
//        g1.addEdge(5, 3);
//        System.out.println(g1.toString());
//    }
}
