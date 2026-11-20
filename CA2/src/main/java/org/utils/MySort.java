package org.utils;

import org.models.AuctionLot;

import java.util.Comparator;

public class MySort {

    public static <T> Node<T> insertionSort(Node<T> headRef, Comparator<T> c){
        Node<T> sorted = null;
        Node<T> firstCurrent = headRef;


        while (firstCurrent != null) {
            Node<T> next = firstCurrent.next;

            // sortedInsert
            Node<T> newnode = firstCurrent;
            if (sorted == null || c.compare(sorted.data, newnode.data)  >= 0) {
                newnode.next = sorted;
                sorted = newnode;
            } else {
                Node<T> current = sorted;

                while (current.next != null && c.compare(current.next.data, newnode.data) < 0) {
                    current = current.next;
                }
                newnode.next = current.next;
                current.next = newnode;
            }

            firstCurrent = next;

        }

        headRef = sorted;
        return headRef;
    }


    // Function to print linked list
    static void printlist(Node<AuctionLot> head)
    {
        while (head != null)
        {
            System.out.print(head.data.title + " ");
            head = head.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        MyLinkedList<AuctionLot> ALlist = new MyLinkedList<>();
        ALlist.insert(new AuctionLot("b", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("d", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("c", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("a", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("f", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("e", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("z", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("h", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("af", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("t", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.insert(new AuctionLot("d", "desc", "Chair", null, 24.5, "dsad"));

        System.out.println("Linked List before Sorting..");
        printlist(ALlist.first);

        ALlist.first = insertionSort(ALlist.first, (a,b) -> a.title.compareTo(b.title));

        System.out.println("\nLinkedList After sorting");
        printlist(ALlist.first);
    }
}
