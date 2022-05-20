package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> alistnoresizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyalist = new BuggyAList<>();

        alistnoresizing.addLast(4);
        buggyalist.addLast(4);

        alistnoresizing.addLast(5);
        buggyalist.addLast(5);

        alistnoresizing.addLast(6);
        buggyalist.addLast(6);

        assertEquals(alistnoresizing.size(), buggyalist.size());

        assertEquals(alistnoresizing.removeLast(), buggyalist.removeLast());
        assertEquals(alistnoresizing.removeLast(), buggyalist.removeLast());
        assertEquals(alistnoresizing.removeLast(), buggyalist.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size1 = L1.size();
                int size2 = L2.size();
                System.out.println("size: " + size1);
            } else if (operationNumber == 2) {
                if (L1.size() > 0) {
                    int num = L1.getLast();
                    System.out.println("getLast(" + num + ")");
                }
                if (L2.size() > 0) {
                    int num = L2.getLast();
                    System.out.println("getLast(" + num + ")");
                }
            } else if (operationNumber == 3) {
                if (L1.size() > 0) {
                    int num = L1.removeLast();
                    System.out.println("removeLast(" + num + ")");
                }
                if (L2.size() > 0) {
                    int num = L2.removeLast();
                    System.out.println("removeLast(" + num + ")");
                }
            }
        }
    }
}
