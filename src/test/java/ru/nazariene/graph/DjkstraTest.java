package ru.nazariene.graph;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import ru.nazariene.graph.model.Graph;
import ru.nazariene.graph.model.WeightedDirectionalGraph;

public class DjkstraTest {

    @Test
    public void testDjkstra() {
        Graph graph = new WeightedDirectionalGraph();
        GraphGenerator.smallWeightedGraph().forEach(graph::addEdge);
        Djkstra djkstra = new Djkstra();
        Stack<Integer> result = djkstra.perform(graph, 0, 6);

        Assert.assertEquals(5, result.size());
        Assert.assertEquals(Integer.valueOf(0), result.pop());
        Assert.assertEquals(Integer.valueOf(4), result.pop());
        Assert.assertEquals(Integer.valueOf(5), result.pop());
        Assert.assertEquals(Integer.valueOf(2), result.pop());
        Assert.assertEquals(Integer.valueOf(6), result.pop());
    }
}
