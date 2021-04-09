package ru.nazariene.graph.princeton.mst;

import java.io.File;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import ru.nazariene.graph.princeton.model_princeton.AdjListGraphImpl;
import ru.nazariene.graph.princeton.model_princeton.Graph;

/**
 * Non-recursive impl of mst.DFS
 */
public class NonRecursiveDFS extends DFS {


    public NonRecursiveDFS(Graph graph, int startVertice) {
        super(graph, startVertice);
    }

    @Override
    protected void performDFS(Graph graph, int startVertice) {
        Stack<Integer> unvisitedStack = new Stack<>();
        unvisitedStack.push(startVertice);

        while (!unvisitedStack.empty()) {
            int vertice = unvisitedStack.pop();
            count++;
            marked[vertice] = true;
            for (int i : graph.adjacentTo(vertice)) {
                if (!marked(i)) {
                    unvisitedStack.push(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new AdjListGraphImpl(new In(new File("C:\\work\\SandBox\\Algo_playground\\model.Graph\\src\\main\\resources\\tinyGraph")));
        System.out.println(graph);

        DFS dfs = new NonRecursiveDFS(graph, 1);
        System.out.println(dfs.count());
        for (int i = 0; i < graph.V(); i++) {
            System.out.println("V = " + i + ": " + dfs.marked(i) + "\n");
        }
    }
}