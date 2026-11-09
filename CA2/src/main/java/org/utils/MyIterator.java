package org.utils;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private Node<T> pos;

    public MyIterator(Node<T> fnode) {pos = fnode;}

    @Override
    public boolean hasNext() {
        return pos != null;
    }

    @Override
    public T next() {
        Node<T> temp = pos;
        pos = pos.next;
        return temp.data;
    }

}
