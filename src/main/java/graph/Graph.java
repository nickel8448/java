package main.java.graph;

public interface Graph {

  /**
   * Number of vertices in the graph
   *
   * @return Returns the number of vertices in the graph
   */
  int getNumberOfVertices();

  /**
   * Number of edges in the graph
   *
   * @return Returns the number of edges in the graph
   */
  int getNumberOfEdges();

  /**
   * Returns if the graph is a directed or undirected
   *
   * @return Returns true if directed and false if undirected
   */
  boolean isDirected();

  /**
   * Adds an edge v-w to the graph
   *
   * @param vertexA VertexA
   * @param vertexB VertexB
   */
  void addEdge(int vertexA, int vertexB);

  /**
   * Function gets all the vertices in the graph
   *
   * @return Returns an iterable of all the vertices in the graph
   */
  Iterable<Integer> getAllVertices();

  /**
   * Functions gets all the adjacent vertices to the the source
   *
   * @param source Vertex source
   * @return Returns an iterable of all the vertices adjacent to the source
   */
  Iterable<Integer> getAdjacentVertices(int source);

  /**
   * String representation of the graph
   *
   * @return Returns the string representation of the graph
   */
  String toString();
}
