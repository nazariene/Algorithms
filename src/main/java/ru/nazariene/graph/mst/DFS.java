package ru.nazariene.graph.mst;

import java.io.File;

import edu.princeton.cs.algs4.In;
import ru.nazariene.graph.model.AdjListGraphImpl;
import ru.nazariene.graph.model.Graph;


/**
 * Depth-first search
 */
public class DFS {
    protected int count;
    protected boolean[] marked;

    public DFS(Graph graph, int startVertice) {
        marked = new boolean[graph.V()];
        performDFS(graph, startVertice);
    }

    protected void performDFS(Graph graph, int startVertice) {
        count++;
        marked[startVertice] = true;
        Iterable<Integer> adjToVertice = graph.adjacentTo(startVertice);
        for (int adjV : adjToVertice) {
            if (!marked[adjV]) {
                performDFS(graph, adjV);
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean marked(int v) {
        return marked[v];
    }


    public static void main(String[] args) {
        Graph graph = new AdjListGraphImpl(new In(new File("C:\\work\\SandBox\\Algo_playground\\Graph\\src\\main\\resources\\tinyGraph")));
        System.out.println(graph);

        DFS dfs = new DFS(graph, 1);
        System.out.println(dfs.count());
        for (int i = 0; i < graph.V(); i++) {
            System.out.println("V = " + i + ": " + dfs.marked(i) + "\n");
        }

    }
}
