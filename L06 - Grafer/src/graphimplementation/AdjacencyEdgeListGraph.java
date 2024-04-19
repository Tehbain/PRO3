package graphimplementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//OPG3
public class AdjacencyEdgeListGraph<V> implements Graph<V> {
  protected List<V> vertices = new ArrayList<>(); // Store vertices
  protected List<Edge> edges = new ArrayList<>(); // Store edges
  protected List<List<Edge>> neighbors = new ArrayList<>();

  /** Construct an empty graph */
  public AdjacencyEdgeListGraph() {
  }

  @Override /** Return the number of vertices in the graph */
  public int getSize() {
    return vertices.size();
  }
  @Override /** Return the number of edges in the graph */
  public int getNumEdges() {
    return edges.size()/2;
  }
  @Override /** Return the vertices in the graph */
  public List<V> getVertices() {
    return new ArrayList<>(vertices);
  }

  @Override
  /** Return the edges in the graph */
  public List<Edge> getEdges() {
     return new ArrayList<Edge>(edges);
  }
  @Override /** Return the object for the specified vertex */
  public V getVertex(int index) {
    return vertices.get(index);
  }

  @Override /** Return the index for the specified vertex object */
  public int getIndex(V v) {
    return vertices.indexOf(v);
  }

  @Override /** Return the neighbors of the specified vertex */
  public List<V> getNeighbors(V v) {
    int index = getIndex(v);
    Set<V> result = new HashSet<>();
    for (Edge e: edges){
      if (e.u == index){
        result.add(vertices.get(e.v));
      }else if(e.v== index){
        result.add(vertices.get(e.u));
      }
    }
    return new ArrayList<V>(result);
  }

  public List<Integer> getNeighborsIndex(V v) {
    int index = getIndex(v);
    Set<Integer> result = new HashSet<>();
    for (Edge e: edges){
      if (e.u == index){
        result.add(e.v);
      }else if(e.v== index){
        result.add(e.u);
      }
    }
    return new ArrayList<>(result);
  }

  //TODO skal blive hurtig ved at bruge nabolisten
  @Override /** Return the incident edges of vertex v */
  public List<Edge> getIncidentEdges(V v){
    int index = getIndex(v);
    Set<Edge> result = new HashSet<>();
    for (Edge e: edges){
      if (e.u == index){
        result.add(e);
      }else if(e.v== index){
        result.add(e);
      }
    }
    return new ArrayList<>(result);
  }

  @Override /** Return the degree for a specified vertex */
  public int getDegree(V v) {
    return getNeighbors(v).size();
  }

  @Override /** Print the edges */
  public void printEdges() {
    for (int i = 0; i < edges.size(); i++) {
      System.out.println(" (" + edges.get(i).u  + "," + edges.get(i).v +") : " + edges.get(i).element());
    }
  }

  @Override /** Clear the graph */
  public void clear() {
    vertices.clear();
    edges.clear();
  }
  
  @Override /** Add a vertex to the graph */  
  public boolean addVertex(V vertex) {
    if (!vertices.contains(vertex)) {
      vertices.add(vertex);
      return true;
    }
    else {
      return false;
    }
  }

 // @Override /** Add an edge to the graph */
  private boolean addEdge(Edge e) {
    if (e.u < 0 || e.u > getSize() - 1)
      throw new IllegalArgumentException("No such index: " + e.u);

    if (e.v < 0 || e.v > getSize() - 1)
      throw new IllegalArgumentException("No such index: " + e.v);
    
    if (!edges.contains(e)) {
      edges.add(e);
      return true;
    }
    else {
      return false;
    }
  }

  @Override /** Add an edge to the graph */
  public boolean addEdge(int u, int v) {
    return addEdge(new Edge(u, v, 0)) && addEdge(new Edge(v, u, 0)) ;
  }
  @Override /** Add an edge to the graph */
  public boolean addEdge(int u, int v, int e) {
    return addEdge(new Edge(u, v, e))&& addEdge(new Edge(v, u, e));
  }

  @Override /** Remove vertex v and return true if successful */  
  public boolean remove(V v) {
    boolean isSuccesful = false;

    List<Edge> incidentEdges = this.getIncidentEdges(v);

    for (Edge edge : incidentEdges) {
      this.remove(edge.u, edge.v);
      isSuccesful = true;
      // burde have decrementeret kanternes index for at få deres plads i arrayet til at svare til verticiernes nye plads i deres liste.
    }
    if (this.getIncidentEdges(v).isEmpty()) {
      vertices.remove(v);
    }

    return isSuccesful;
  }

  @Override /** Remove edge (u, v) and return true if successful */  
  public boolean remove(int u, int v) {
    // I denne slags graf er f.eks. (1,4) = (4,1)
    boolean succes = false;
    for (int i = 0; i < edges.size()-1; i++) {
      Edge edge = edges.get(i);
      if ((edge.u == u && edge.v == v) || (edge.v == u && edge.u == v)) {
        edges.remove(edge);
        succes = true;
        i--; //Size er nu mindre, checker derfor lige igen.
      }
    }
    return succes;
  }
}

