package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
    }

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());

        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void addRandomizedTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        int N = 30;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 1) {
                ad1.addLast(i);
            } else {
                ad1.addFirst(i);
            }
        }

        ad1.printDeque();
    }

    @Test
    public void addRemoveRandomizedTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        int N = 50;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                ad1.addFirst(i);
            } else if (operationNumber == 1) {
                ad1.addLast(i);
            } else if (operationNumber == 2) {
                if (ad1.isEmpty() == false) {
                    ad1.removeFirst();
                }
            } else {
                if (ad1.isEmpty() == false) {
                    ad1.removeLast();
                }
            }
        }

        ad1.printDeque();
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        int N = 30;
        for (int i = 0; i < N; i++) {
            ad1.addFirst(i);
        }

        for (int i = 0; i < N; i++) {
            assertEquals(30-i-1, (int) ad1.get(i));
        }

        assertEquals(null, ad1.get(N+1));
        assertEquals(null, ad1.get(-1));
    }
}
