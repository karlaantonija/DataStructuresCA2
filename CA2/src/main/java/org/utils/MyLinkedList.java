package org.utils;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> implements Iterable<T> {
    public Node<T> first = null;
    public Iterator<T> itr = this.iterator();

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.first == null) {
            this.first = newNode;
        } else {
            Node<T> last = this.first;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
    }

    public void removeNode(T data) {
        Node<T> nodeToDelete = new Node<>(data);

        // If removing item is the first
        if (Objects.equals(this.first.data, nodeToDelete.data)) {
            this.first = this.first.next;
            //System.out.println("REMOVED FIRST NODE");
        } else {

            // If removing a random item in the list
            Node<T> currNode = this.first.next;
            Node<T> prev = this.first;

            while (currNode != null) {
                if (Objects.equals(currNode.data, nodeToDelete.data)) {
                    prev.next = currNode.next;
                    //System.out.println("REMOVED NODE");
                    break;
                } else {
                    prev = currNode;
                    currNode = currNode.next;
                }
            }

            //if (currNode == null) {
            //System.out.println("NODE NOT IN LIST");
            //}
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(first);
    }

}