package org.example;

import java.util.Iterator;

public class Something implements Iterable{

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }
}
class MyIterator implements Iterator {

    private int[] num = {1, 2, 3, 4, 5, 6};
    private int cursor = -1;

    @Override
    public boolean hasNext() {
        return cursor < num.length - 1;
    }

    @Override
    public Object next() {
        cursor++;
        return num[cursor];
    }
}
