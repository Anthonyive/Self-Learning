package deque;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private T[] items;
    //    private int itemsLen;
    private int nextLast;

    /**
     * Creates an empty linked list deque.
     */
    public ArrayDeque() {
        /* I will insert items from the middle, which is between 3 and 4
        For example, nextFirst=3, nextLast=4, after addLast("a")
        0 1 2 3 4 5 6 7
        _ _ _ _ a _ _ _
        nextLast=5 and others remain the same.
         */

//        itemsLen = 8;
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    /**
     * resize items given a capacity
     *
     * @param capacity
     */
    private void resize(int capacity, boolean addFirst) {
        T[] a = (T[]) new Object[capacity];
        if (addFirst) {
            /*
            if the last operation is addFirst
             */
            System.arraycopy(items, nextFirst, a, 0, size - nextFirst);
            System.arraycopy(items, 0, a, size - nextFirst, nextFirst);
        } else {
            System.arraycopy(items, nextFirst + 1, a, 0, size - nextFirst - 1);
            System.arraycopy(items, 0, a, size - nextFirst - 1, nextFirst + 1);
        }

        items = a;
    }

    /**
     * check whether the items array is full (of non-nulls)
     *
     * @return true if full, false otherwise
     */
    private boolean isFull() {
        return size == items.length;
    }

    /**
     * find the index of nextFirst
     *
     * @return index of nextFirst
     */
    private int findNextFirst() {
        if (this.isFull()) {
            resize(items.length * 2, true);
            nextLast = items.length / 2;
            return items.length - 1;
        }
        int index = (nextFirst - 1) % items.length;
        if (index < 0) {
            return index + items.length;
        } else {
            return index;
        }
    }

    /**
     * find the index of nextLast
     *
     * @return index of nextLast
     */
    private int findNextLast() {
        if (this.isFull()) {
            resize(items.length * 2, false);
            nextFirst = items.length - 1;
            return items.length / 2;
        }
        int index = (nextLast + 1) % items.length;
        if (index < 0) {
            return index + items.length;
        } else {
            return index;
        }
    }

    /**
     * Adds an item of type T to the front of the deque. You can assume that item is never null.
     *
     * @param item value of certain generic type
     */
    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst = findNextFirst();
    }

    /**
     * Adds an item of type T to the back of the deque. You can assume that item is never null.
     *
     * @param item value of certain generic type
     */
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast = findNextLast();
    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of items in the deque.
     *
     * @return number of items
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        if (nextFirst < nextLast) {
            StringBuilder sb = new StringBuilder();
            for (int i = nextFirst + 1; i < nextLast - 1; i++) {
                sb.append(items[i]);
                sb.append(" ");
            }
            sb.append(items[nextLast - 1]);
            System.out.println(sb.toString());
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = nextFirst + 1; i < items.length; i++) {
                sb.append(items[i]);
                sb.append(" ");
            }

            if (nextLast == 0) {
                System.out.println(sb.toString());
                return;
            }

            for (int i = 0; i < nextLast - 1; i++) {
                sb.append(items[i]);
                sb.append(" ");
            }

            sb.append(items[nextLast - 1]);
            System.out.println(sb.toString());
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     *
     * @return a value in a generic type
     */
    public T removeFirst() {
        nextFirst = Math.floorMod(nextFirst + 1, items.length);
        T num = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return num;
    }


    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     *
     * @return
     */
    public T removeLast() {
        nextLast = Math.floorMod(nextLast - 1, items.length);
        T num = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return num;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     *
     * @param index
     * @return
     */
    public T get(int index) {
        int i = Math.floorMod(index + nextFirst + 1, items.length);
        return items[i];
    }
}
