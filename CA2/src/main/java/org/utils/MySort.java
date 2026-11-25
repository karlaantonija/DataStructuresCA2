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
            System.out.println(head.data.title + " " + head.data.type);
            head = head.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        MyLinkedList<AuctionLot> ALlist = new MyLinkedList<>();
        ALlist.add(new AuctionLot("b", "desc", "Apple", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("d", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("c", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("a", "desc", "Table", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("f", "desc", "Apple", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("e", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("test", "2", "Desk", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("z", "rew", "Apple", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("h", "desc", "Chair", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("af", "desc", "Table", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("test", "1", "Apple", null, 24.5, "dsad"));
        ALlist.add(new AuctionLot("d", "desc", "Table", null, 24.5, "dsad"));

        System.out.println("Linked List before Sorting..");
        printlist(ALlist.first);

        ALlist.first = insertionSort(ALlist.first, (a,b) -> a.title.compareTo(b.title));

        System.out.println("\nLinkedList After sorting");
        printlist(ALlist.first);

        AuctionLot ALtoSearchFor = new AuctionLot("test", "null", "Chair", null, 0, "null");

        System.out.println("\nFinding object:");
        System.out.println(MySearch.binarySearchNode(ALlist.first, ALtoSearchFor, (a,b) -> a.title.compareTo(b.title)));

        System.out.println("\nFinding multiple objects");

        ALlist.first = insertionSort(ALlist.first, (a,b) -> a.type.compareTo(b.type));
        //printlist(ALlist.first);

        MyLinkedList<AuctionLot> searchResults = MySearch.searchForList2(ALlist.first, ALtoSearchFor, (a,b) -> a.type.compareTo(b.type));

        System.out.println(" ");
        if (searchResults.first != null) {
            printlist(searchResults.first);
        } else {
            System.out.println("Empty list - no entries match");
        }

//        System.out.println("UPPER:");
//        System.out.println(MySearch.getUpperBound(ALlist.first, ALtoSearchFor, (a,b) -> a.type.compareTo(b.type)).data);
//
//        System.out.println("LOWER:");
//        System.out.println(MySearch.getLowerBound(ALlist.first, ALtoSearchFor, (a,b) -> a.type.compareTo(b.type)).data);


    }
}
