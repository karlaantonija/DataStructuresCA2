package org.utils;

import java.util.Comparator;

public class MySearch {

    static <T> Node<T> middle(Node<T> start, Node<T> last)
    {
        if (start == null) {
            return null;
        }

        if (start == last) {
            return start;
        }

        Node<T> slow = start;
        Node<T> fast = start.next;

        while (fast != last) {
            fast = fast.next;
            slow = slow.next;
            if (fast != last) {
                fast = fast.next;
            }
        }

        return slow;

    }


    static <T> boolean binarySearchBool(Node<T> head, T data, Comparator<T> c) {
        MySort.insertionSort(head, c);

        Node<T> start = head;
        Node<T> last = null;

        while (true) {
            Node<T> mid = middle(start, last);

            if (mid == null) {
                return false;
            }

            if (mid.data == data) {
                return true;
            } else if (start == last) {
                break;
            } else if (c.compare(mid.data, data) < 0) {
                start = mid.next;
            } else if (c.compare(mid.data, data) > 0) {
                last = mid;
            }

        }

        return false;

    }

    static <T> T binarySearchNode(Node<T> head, T data, Comparator<T> c) {
        Node<T> start = head;
        Node<T> last = null;

        while (true) {
            Node<T> mid = middle(start, last);

            if (mid == null) {
                return null;
            }

            if (c.compare(mid.data, data) == 0) {
                // node found
                return mid.data;
            } else if (start == last) {
                break;
            } else if (c.compare(mid.data, data) < 0) {
                // upper area
                start = mid.next;
            } else if (c.compare(mid.data, data) > 0) {
                // lower area
                last = mid;
            }

        }

        // node not found
        return null;
    }

    static <T> Node<T> getLowerBound(Node<T> head, T data, Comparator<T> c) {
        Node<T> start = head;
        Node<T> last = null;

        while (true) {
            Node<T> mid = middle(start, last);

            if (mid == null) {
                return null;
            }

            if (c.compare(mid.data, data) == 0) {
                // node found - look for lower bound
                while (c.compare(mid.next.data, data) == 0) {
                    mid = mid.next;
                    if (mid.next == null) {
                        break;
                    }
                }
                return mid;
            } else if (start == last) {
                break;
            } else if (c.compare(mid.data, data) < 0) {
                // upper area
                start = mid.next;
            } else if (c.compare(mid.data, data) > 0) {
                // lower area
                last = mid;
            }

        }

        // node not found
        return null;
    }

    static <T> Node<T> getUpperBound(Node<T> head, T data, Comparator<T> c) {
        Node<T> start = head;
        Node<T> last = null;

        while (true) {
            Node<T> mid = middle(start, last);

            if (mid == null) {
                return null;
            }

            if (c.compare(mid.data, data) == 0) {
                // node found - look for upper bound
                while (c.compare(start.data, data) != 0) {
                    start = start.next;
                }
                return start;
            } else if (start == last) {
                break;
            } else if (c.compare(mid.data, data) < 0) {
                // upper area
                start = mid.next;
            } else if (c.compare(mid.data, data) > 0) {
                // lower area
                last = mid;
            }

        }

        // node not found
        return null;
    }

    static <T> MyLinkedList<T> searchForList2(Node<T> head, T data, Comparator<T> c) {
        MySort.insertionSort(head, c);

        Node<T> upperBound = getUpperBound(head, data, c);
        Node<T> lowerBound = getLowerBound(head, data, c);

        MyLinkedList<T> searchResults = new MyLinkedList<>();

        if (upperBound == null || lowerBound == null) {
            return null;
        }

//        System.out.println("UPPER: " + upperBound.data);
//        System.out.println("LOWER: " + lowerBound.data);

        searchResults.add(upperBound.data);

        while (c.compare(upperBound.next.data, lowerBound.data) == 0) {
            upperBound = upperBound.next;
            searchResults.add(upperBound.data);

            if (upperBound.next == null) {
                break;
            }
        }

        // clearing last items .next from initial list
        upperBound.next = null;

        return searchResults;

    }



}
