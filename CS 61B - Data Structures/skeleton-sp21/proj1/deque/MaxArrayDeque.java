package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (this.size() == 0) {
            return null;
        }

        T maxItem = (T) this.get(0);
        for (Object item : this) {
            T thisItem = (T) item;
            if (comparator.compare(thisItem, maxItem) > 0) {
                maxItem = thisItem;
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        }

        T maxItem = (T) this.get(0);
        for (Object item : this) {
            T thisItem = (T) item;
            if (c.compare(thisItem, maxItem) > 0) {
                maxItem = thisItem;
            }
        }
        return maxItem;
    }

}
