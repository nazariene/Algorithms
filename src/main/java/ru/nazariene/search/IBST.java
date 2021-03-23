package ru.nazariene.search;

public interface IBST<Key extends Comparable<Key>, Value> {

    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);
}
