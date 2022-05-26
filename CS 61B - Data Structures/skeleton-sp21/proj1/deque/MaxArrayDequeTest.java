package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;


public class MaxArrayDequeTest {
    public class intComparator1 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public class intComparator2 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    @Test
    public void maxArrayDequeTest1() {
        Comparator<Integer> c1 = new intComparator1();
        Comparator<Integer> c2 = new intComparator2();

        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<>(c1);
        mad1.addLast(1);
        mad1.addLast(2);
        mad1.addLast(3);
        mad1.addLast(4);

        assertEquals(4, (int) mad1.max());
        assertEquals(1, (int) mad1.max(c2));
    }

    @Test
    public void maxArrayDequeTest2() {
        Comparator<Integer> c1 = new intComparator1();
        Comparator<Integer> c2 = new intComparator2();

        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<>(c2);
        mad1.addLast(1);
        mad1.addLast(2);
        mad1.addLast(3);
        mad1.addLast(4);

        assertEquals(1, (int) mad1.max());
        assertEquals(4, (int) mad1.max(c1));
    }

}
