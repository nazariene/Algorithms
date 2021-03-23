package ru.nazariene.graph.mst;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import ru.nazariene.graph.model.*;

public class Kruskal {

    private Queue<Edge> mst = new LinkedList<>();

    public Kruskal(WeightedGraph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        for (Edge e : graph.edges()) {
            pq.add(e);
        }

        WeightedQuickUnionUF unionUF = new WeightedQuickUnionUF(graph.V());


        //System.out.println(pq);
        while (!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge edge = pq.poll();
            int one = edge.getFromVertex();
            int another = edge.getToVertex();
            if (!unionUF.connected(one, another)) {
                unionUF.union(one, another);
                mst.add(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraphAdjListImpl(new In(new File("C:\\work\\SandBox\\Algo_playground\\Graph\\src\\main\\resources\\tinyWeightedGraph")));
        System.out.println(graph);

        Kruskal kruskal = new Kruskal(graph);


        System.out.println(kruskal.edges());
        /*for (int i = 0; i < graph.V(); i++) {
            System.out.println("V = " + i + ": " + kruskal.marked(i) + "\n");
        }*/
    }
}
