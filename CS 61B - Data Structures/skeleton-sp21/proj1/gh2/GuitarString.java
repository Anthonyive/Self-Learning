package gh2;

import deque.ArrayDeque;
import deque.Deque;
// TODO: maybe more imports

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /**
     * Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday.
     */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayDeque<>();

        int capacity = (int) Math.round(SR / frequency);

        int i = 0;
        while (i < capacity) {
            buffer.addLast(0.0);
            i += 1;
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        int i = 0;
        while (i < buffer.size()) {
            buffer.removeLast();
            double r = Math.random() - 0.5;
            buffer.addFirst(r);
            i += 1;
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        Double n1 = buffer.removeFirst();
        Double n2 = buffer.get(0);

        Double n = DECAY * (1.0 / 2.0) * (n1 + n2);
        buffer.addLast(n);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        Double n = buffer.get(0);
        return n;
    }
}
