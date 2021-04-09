package ru.nazariene.graph.princeton.model_princeton;

public class Edge {

    private int fromVertex;
    private int toVertex;
    private int weight;

    public Edge(int fromVertex, int toVertex, int weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public int getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(int fromVertex) {
        this.fromVertex = fromVertex;
    }

    public int getToVertex() {
        return toVertex;
    }

    public void setToVertex(int toVertex) {
        this.toVertex = toVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Edge reverse() {
        return new Edge(toVertex, fromVertex, weight);
    }

    public int either() {
        return fromVertex;
    }

    public int other(int v) {
        if (v == fromVertex) {
            return toVertex;
        }
        else {
            return fromVertex;
        }
    }

    public String toString() {
        return "from: " + fromVertex + ", to: " + toVertex + ", weight: " + weight;
    }
}
