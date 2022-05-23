package deque;

public class LinkedListDeque<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }


    private int size;
    private Node sentinel;

    /*
    Implementation: Doubly Linked Lists (Circular Sentinel)
     */

    /*
    Invariants:
    1. The last node's next is sentinel;
    2. The sentinel's prev is the last node;
     */

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque. You can assume that item is never null.
     *
     * @param item value of certain generic type
     */
    public void addFirst(T item) {
        if (sentinel.next == null) {
            Node node = new Node(item, sentinel, sentinel);
            sentinel.prev = node;
            sentinel.next = node;
            size += 1;
            return;
        }

        Node nextNode = sentinel.next;
        Node node = new Node(item, sentinel, nextNode);

        sentinel.next = node;
        nextNode.prev = node;

        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque. You can assume that item is never null.
     *
     * @param item value of certain generic type
     */
    public void addLast(T item) {
        if (sentinel.prev == null) {
            Node node = new Node(item, sentinel, sentinel);
            sentinel.prev = node;
            sentinel.next = node;
            size += 1;
            return;
        }

        Node prevNode = sentinel.prev;
        Node node = new Node(item, prevNode, sentinel);

        sentinel.prev = node;
        prevNode.next = node;

        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of items in the deque.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        Node p = sentinel;
        p = p.next;

        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     *
     * @return
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Node firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size -= 1;

        return firstNode.item;
    }


    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     *
     * @return
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        Node lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        size -= 1;

        return lastNode.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (this.isEmpty() || index >= size || index < 0) {
            return null;
        }
        Node p = sentinel;
        p = p.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    /**
     * Same as get, but uses recursion.
     *
     * @param index
     * @return
     */
    private Node getRecursiveHelper(int index) {
        if (index < 0) {
            return sentinel;
        }
        return getRecursiveHelper(index - 1).next;
    }

    public T getRecursive(int index) {
        if (this.isEmpty() || index >= size || index < 0) {
            return null;
        }

        Node node = getRecursiveHelper(index);
        return node.item;

    }
}
