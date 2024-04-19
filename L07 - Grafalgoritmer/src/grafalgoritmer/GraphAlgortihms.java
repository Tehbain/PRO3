package grafalgoritmer;

import java.util.*;

public class GraphAlgortihms {
    /**
     * Returnerer en liste af grafens knuder fundet ved et dybddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        List<V> verticies = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.getSize()];
        isVisited[graph.getIndex(v)] = true;
        verticies.add(v);
        dfs(graph, graph.getIndex(v), isVisited, verticies);
        return verticies;
    }
    private static <V> void dfs(Graph<V> graph, int index, boolean[] isVisited, List<V> verticies) {
        isVisited[index] = true;
        for (V dims : graph.getVertices()) {
            if (isVisited[graph.getIndex(dims)] == false) {
                isVisited[graph.getIndex(dims)] = true;
                verticies.add(dims);
                dfs(graph, graph.getIndex(dims), isVisited,verticies);
            } else {
                
            }
        }
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        // TODO Opgave 3
        return null;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        // TODO Opgave 4
        return false;
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        // TODO Opgave 5
        return false;
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Set<Edge> mst(Graph<V> graph) {
        // TODO Opgave 7
        return null;
    }

}
