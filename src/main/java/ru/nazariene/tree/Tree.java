package ru.nazariene.tree;

public interface Tree {

    void add(int value);

    boolean isEmpty();

    boolean contains(int value);

    void delete(int value);

    int[] traverseBFS();

    int[] traverseDFS();

}
