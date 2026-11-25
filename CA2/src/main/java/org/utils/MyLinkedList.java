package org.utils;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> implements Iterable<T> {
    public Node<T> first = null;
    public Iterator<T> itr = this.iterator();

    public void add(T data) {
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

    public void insertAfter(Node<T> prevNode, T data) {
        if (prevNode == null) {
            System.out.println("previous node cannot be null");
            return;
        }

        Node<T> newNode = new Node<>(data);

        newNode.next = prevNode.next;
        prevNode.next = newNode;
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

    public void printList() {
        Node<T> currNode = this.first;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }

        System.out.println();
    }


    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<>(first);
    }

}