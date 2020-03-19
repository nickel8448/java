package main.java.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DirectedGraphWithWeights {

    private HashMap<GraphNode, LinkedList<GraphNode>> adjacentVerticesByVertex;
    private Set<GraphNode> allNodesSet;

    /**
     * Constructor
     */
    DirectedGraphWithWeights() {
        adjacentVerticesByVertex = new HashMap<>();
        allNodesSet = new HashSet<>();
    }

    /**
     * Returns the number of vertices in the Graph
     * @return Returns the number of vertices
     */
    public int getNumberOfVertices() {
        return this.allNodesSet.size();
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
    public void addNode(int vertexA, int vertexB, int weight) {
        GraphNode vertexANode = new GraphNode(vertexA);
        GraphNode vertexBNode = new GraphNode(vertexB);
        allNodesSet.add(vertexANode);
        allNodesSet.add(vertexBNode);
        if(!adjacentVerticesByVertex.containsKey(vertexANode))
            adjacentVerticesByVertex.put(vertexANode,
                    new LinkedList<GraphNode>());
        vertexBNode.setWeight(weight);
        adjacentVerticesByVertex.get(vertexANode).add(vertexBNode);
    }

    /**
     * Returns all the vertices of the graph
     * @return All the vertices of the graph
     */
    public Iterable<Integer> getAllVertices() {
        Set<Integer> vertices = new HashSet<>();
        for(var key : adjacentVerticesByVertex.keySet()) {
            vertices.add(key.getNodeValue());
        }
        return vertices;
    }

    /**
     * Returns all the adjacent nodes
     * @param source Source node
     * @return Returns all the adjacent nodes
     */
    public Iterable<GraphNode> getAdjacentVertices(int source) {
        GraphNode tempNode = new GraphNode(source);
        return adjacentVerticesByVertex.get(tempNode);
    }

    public void printAllVertices() {
        for(GraphNode it : adjacentVerticesByVertex.keySet()) {
            System.out.print(it.getNodeValue() + " -> ");
            for(var node : getAdjacentVertices(it.getNodeValue())) {
                System.out.print("value: " + node.getNodeValue() +
                        "; weight: " + node.getWeight() + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraphWithWeights dg = new DirectedGraphWithWeights();
        dg.addNode(1, 2, 10);
        dg.addNode(1, 3, 15);
        dg.addNode(2, 4, 12);
        dg.addNode(3, 5, 10);
        dg.printAllVertices();
    }
}
