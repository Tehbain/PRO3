import graphimplementation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Opg1 {
    public static void main(String[] args) {
        EdgeListGraph<Integer> yeetus1 = new EdgeListGraph<>();

        Integer[] verticies = {6,15,38,66,123};
        for (Integer vertex : verticies) {
            yeetus1.addVertex(vertex);
        }

        //Edging
        {
            //Fra v0, 6
            yeetus1.addEdge(0, 1, 23);
            yeetus1.addEdge(0, 2, 8);
            yeetus1.addEdge(0, 4, 7);

            //Fra v1, 15
            yeetus1.addEdge(1, 2, 10);
            yeetus1.addEdge(1, 3, 90);

            //Fra v2, 38
            yeetus1.addEdge(2, 3, 2);
            yeetus1.addEdge(2, 4, 55);

            //Fra v3, 66
            yeetus1.addEdge(3, 4, 76);

            //v4 er nu allerede fuldt forbundet.
        }

        //Opg1.2
        Function<Graph, Integer> biggusVert = (graph) -> {

            int biggus = 0;
            List<Integer> verts = graph.getVertices();

            for (Integer vertVal : verts) {
                if (vertVal > biggus) {
                    biggus = vertVal;
                }
            }
            return biggus;
        };
        biggusVert.apply(yeetus1);

        //Test
        System.out.println("TESTING, graph printEdges()");
        yeetus1.printEdges();

        System.out.println("REMOVING Edge(1,3):  " + yeetus1.remove(1,3));
        yeetus1.printEdges();

        System.out.println("   Vertice(4) = " + yeetus1.getVertices().get(4));
        System.out.println("REMOVING Vertice(4): " + yeetus1.remove(yeetus1.getVertex(4)));
        yeetus1.printEdges();

    }
}
