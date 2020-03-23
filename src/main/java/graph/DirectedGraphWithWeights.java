package main.java.graph;

import java.util.*;

public class DirectedGraphWithWeights {

    private HashMap<GraphVertex, LinkedList<WeightedEdge>>
            adjacentVerticesByVertex;
    private Set<GraphVertex> vertexSet;

    /**
     * Constructor
     */
    DirectedGraphWithWeights() {
        adjacentVerticesByVertex = new HashMap<>();
        vertexSet = new HashSet<>();
    }

    /**
     * Returns the number of vertices in the Graph
     * @return Returns the number of vertices
     */
    public int getNumberOfVertices() {
        return this.vertexSet.size();
    }

    /**
     * Returns if the graph is directed
     * @return
     */
    public boolean isDirected() {
        return true;
    }

    /**
     * Returns the number of edges
     * @return Returns the number of edges
     */
    public int getNumberOfEdges() {
        int numberOfEdges = 0;
        for(var vertices : this.adjacentVerticesByVertex.values()) {
            numberOfEdges += vertices.size();
        }
        return numberOfEdges;
    }

    /**
     * Adds a node to the graph. VertexA -> VertexB, adding a node creates an
     * edge between VertexA and VertexB with the specified weight
     * @param vertexA Vertex A
     * @param vertexB Vertex B
     * @param weight Weight of the edge
     */
    public void addEdge(int vertexA, int vertexB, int weight) {
        GraphVertex graphVertexA = new GraphVertex(vertexA);
        GraphVertex graphVertexB = new GraphVertex(vertexB);
        vertexSet.add(graphVertexA);
        vertexSet.add(graphVertexB);
        WeightedEdge weightedEdge = new WeightedEdge(weight, graphVertexA,
                graphVertexB);
        if(!adjacentVerticesByVertex.containsKey(graphVertexA))
            adjacentVerticesByVertex.put(graphVertexA, new
                    LinkedList<WeightedEdge>());
        adjacentVerticesByVertex.get(graphVertexA).add(weightedEdge);
    }

    /**
     * TODO: Modify this function
     * Returns all the vertices of the graph
     * @return All the vertices of the graph
     */
    public Iterable<Integer> getAllVertices() {
        Set<Integer> vertices = new HashSet<>();
        for(var key : adjacentVerticesByVertex.keySet()) {
            vertices.add(key.getValue());
        }
        return vertices;
    }

    /**
     * Returns all the adjacent nodes
     * @param source Source node
     * @return Returns all the adjacent nodes
     */
    public Iterable<WeightedEdge> getAdjacentVertices(int source) {
        GraphVertex tempNode = new GraphVertex(source);
        return adjacentVerticesByVertex.get(tempNode);
    }

    /**
     * Prints all the vertices of the graph
     */
    public void printAllVertices() {
        for(GraphVertex vertex : adjacentVerticesByVertex.keySet()) {
            System.out.print(vertex.getValue() + " -> ");
            for(var edges : getAdjacentVertices(vertex.getValue())) {
                System.out.print("value: " + edges.getDestination().getValue() +
                        "; weight: " + edges.getEdgeWeight() + " -> ");
            }
            System.out.println();
        }
    }

    public void calculateShortedPath(int source) {
        Set<GraphVertex> visitedVertices = new HashSet<>();
        GraphVertex sourceVertex = new GraphVertex(source);
        HashMap<GraphVertex, Integer> shortestPathMap = new HashMap<>();
        
        // Set the value of all vertex -> weight to infinity and to the source
        // to 0
        for(GraphVertex vertex : vertexSet) {
            if(vertex.equals(sourceVertex)) shortestPathMap.put(sourceVertex, 0);
            else shortestPathMap.put(vertex, Integer.MAX_VALUE);
        }

        // TODO: Move this to a function later
        // Get all the nodes which can be visited from the start node
        for(WeightedEdge edge : adjacentVerticesByVertex.get(sourceVertex)) {
            shortestPathMap.put(edge.getDestination(), edge.getEdgeWeight());
        }

        visitedVertices.add(sourceVertex);
        // The function will work until there are no more nodes to visit
        while(true) {
            // Next closest vertex
            GraphVertex currentVertex = getLowestWeightVertex(shortestPathMap,
                    visitedVertices);

            if(visitedVertices.size() == vertexSet.size()) {
                break;
            }

            visitedVertices.add(currentVertex);
            // Get the adjacent vertices to the currentVertex and update the
            // shortestPathMap
            if(adjacentVerticesByVertex.containsKey(currentVertex)) {
                for(WeightedEdge edge : adjacentVerticesByVertex.get(currentVertex)) {
                    if(!visitedVertices.contains(edge.getDestination())) {
                        int edgeWeightCumulative =
                                shortestPathMap.get(currentVertex) +
                                        edge.getEdgeWeight();
                        int edgeDestinationWeight =
                                shortestPathMap.get(edge.getDestination());
                        if(edgeWeightCumulative < edgeDestinationWeight) {
                            shortestPathMap.put(edge.getDestination(),
                                    edgeWeightCumulative);
                        }
                    }
                }
            }
        }
        System.out.println(shortestPathMap);
    }

    /**
     * Gets
     * @param shortestPathMap
     * @param visitedVertices
     * @return
     */
    private GraphVertex getLowestWeightVertex(
            HashMap<GraphVertex, Integer> shortestPathMap,
            Set<GraphVertex> visitedVertices) {
        int lowestWeight = Integer.MAX_VALUE;
        GraphVertex lowestVertex = null;
        for(GraphVertex vertex : vertexSet) {
            if(!visitedVertices.contains(vertex)) {
                if(shortestPathMap.get(vertex) < lowestWeight) {
                    lowestWeight = shortestPathMap.get(vertex);
                    lowestVertex = vertex;
                }
            }
        }
        return lowestVertex;
    }

    public static void main(String[] args) {
        DirectedGraphWithWeights dg = new DirectedGraphWithWeights();
        dg.addEdge(1, 2, 10);
        dg.addEdge(1, 3, 15);
        dg.addEdge(2, 4, 12);
        dg.addEdge(2, 6, 6);
        dg.addEdge(3, 5, 10);
        dg.addEdge(4, 5, 2);
        dg.addEdge(4, 6, 1);
        dg.addEdge(6, 5, 5);
        dg.printAllVertices();
        dg.calculateShortedPath(1);
    }
}
