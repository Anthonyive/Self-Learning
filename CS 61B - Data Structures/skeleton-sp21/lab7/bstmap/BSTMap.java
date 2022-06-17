package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class BSTNode {
        private K key;
        private V val;
        private BSTNode left;
        private BSTNode right;
        int size; // record the subtree sizes

        public BSTNode(K k, V v, int size) {
            this.key = k;
            this.val = v;
            this.size = size;
        }
    }

    private BSTNode root;

    public BSTMap() {
    }

    public void printInOrder() {

    }

    @Override
    public void clear() {
        root = null;
    }

    private boolean containsKey(K key, BSTNode n) {
        if (n == null) {
            return false;
        }
        if (key.equals(n.key)) {
            return true;
        }
        return containsKey(key, n.left) | containsKey(key, n.right);
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(key, root);
    }


    private V get(K key, BSTNode n) {
        if (n == null) {
            return null;
        }
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            return get(key, n.left);
        } else if (cmp > 0) {
            return get(key, n.right);
        } else {
            return n.val;
        }
    }

    @Override
    public V get(K key) {
        return get(key, root);
    }

    public int size(BSTNode n) {
        if (n == null) {
            return 0;
        }
        return n.size;
    }

    @Override
    public int size() {
        return size(root);
    }

    private BSTNode put(K key, V value, BSTNode n) {
        if (n == null) {
            return new BSTNode(key, value, 1);
        }

        int cmp = key.compareTo(n.key);

        if (cmp < 0) {
            n.left = put(key, value, n.left);
        } else if (cmp > 0) {
            n.right = put(key, value, n.right);
        } else {
            n.val = value;
        }

        n.size = 1 + size(n.left) + size(n.right);

        return n;
    }

    @Override
    public BSTMap put(K key, V value) {
        root = put(key, value, root);
        return this;
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
