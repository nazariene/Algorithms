package ru.nazariene.graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.nazariene.graph.model.Edge;
import ru.nazariene.graph.model.Graph;
import ru.nazariene.graph.model.UnweightedDirectionalGraph;
import ru.nazariene.graph.model.UnweightedGraph;

public class BFSTest {

    @Test
    public void testUnweightedDirectionalGraph() {
        Graph graph = new UnweightedDirectionalGraph();

        GraphGenerator.smallGraph().forEach(graph::addEdge);

        BFS bfs = new BFS();
        List<Edge> result = bfs.perform(graph, 0);

        Assert.assertEquals(5, result.size());
        Assert.assertEquals(0, result.get(0).getFrom());
        Assert.assertEquals(1, result.get(0).getTo());
        Assert.assertEquals(0, result.get(1).getFrom());
        Assert.assertEquals(2, result.get(1).getTo());
        Assert.assertEquals(1, result.get(2).getFrom());
        Assert.assertEquals(3, result.get(2).getTo());
        Assert.assertEquals(2, result.get(3).getFrom());
        Assert.assertEquals(4, result.get(3).getTo());
        Assert.assertEquals(3, result.get(4).getFrom());
        Assert.assertEquals(5, result.get(4).getTo());

        result = bfs.perform(graph, 5);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(5, result.get(0).getFrom());
        Assert.assertEquals(4, result.get(0).getTo());
        Assert.assertEquals(4, result.get(1).getFrom());
        Assert.assertEquals(3, result.get(1).getTo());
    }

    @Test
    public void testUnweightedGraph() {

        Graph graph = new UnweightedGraph();

        GraphGenerator.smallGraph().forEach(graph::addEdge);

        BFS bfs = new BFS();
        List<Edge> result = bfs.perform(graph, 0);

        Assert.assertEquals(5, result.size());
        Assert.assertEquals(0, result.get(0).getFrom());
        Assert.assertEquals(1, result.get(0).getTo());
        Assert.assertEquals(0, result.get(1).getFrom());
        Assert.assertEquals(2, result.get(1).getTo());
        Assert.assertEquals(1, result.get(2).getFrom());
        Assert.assertEquals(3, result.get(2).getTo());
        Assert.assertEquals(2, result.get(3).getFrom());
        Assert.assertEquals(4, result.get(3).getTo());
        Assert.assertEquals(3, result.get(4).getFrom());
        Assert.assertEquals(5, result.get(4).getTo());

        result = bfs.perform(graph, 5);
        Assert.assertEquals(5, result.size());
        Assert.assertEquals(5, result.get(0).getFrom());
        Assert.assertEquals(3, result.get(0).getTo());
        Assert.assertEquals(5, result.get(1).getFrom());
        Assert.assertEquals(4, result.get(1).getTo());
        Assert.assertEquals(3, result.get(2).getFrom());
        Assert.assertEquals(1, result.get(2).getTo());
        Assert.assertEquals(4, result.get(3).getFrom());
        Assert.assertEquals(2, result.get(3).getTo());
        Assert.assertEquals(1, result.get(4).getFrom());
        Assert.assertEquals(0, result.get(4).getTo());
    }
}
