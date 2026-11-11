package org.utils;

import java.io.Serializable;

public class Node<T> implements Serializable {
    public T data;
    public Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }
}
