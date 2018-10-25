import java.util.Scanner;
import java.lang.Iterable;
import java.util.Iterator;
class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;
    private class Node {
        private Key key;
        private Value val;
        private Node next;
        public Node(Key key1, Value val1, Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }
    public SequentialSearchST() {
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
    public void delete(Key key) {
        first = delete(first, key);
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}
class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 
    public int size() {
        return n;
    } 
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        int i = hash(key);
        return st[i].get(key);
    }
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= 10*m) resize(2*m);
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> hash = new SeparateChainingHashST<String, Integer>();
        String str1 = scan.nextLine();
        String[] tokens = scan.nextLine().split(" ");
        for(int i = 0; i < tokens.length; i++) {
            if (hash.contains(tokens[i])) {
                hash.put(tokens[i], hash.get(tokens[i])); 
            } else {
                hash.put(tokens[i], 1);
            }
        }
        String[] tokens1 = scan.nextLine().split(" ");
        for (int i = 0; i < tokens1.length; i++) {
            if (hash.contains(tokens1[i]) ) {
                if (hash.get(tokens1[i]) == 0) {
                    System.out.print("No");
                } else {
                    hash.put(tokens1[i], hash.get(tokens1[i]));
                }
            } else {
                System.out.print("No");
            }
        }
        System.out.println("Yes");
    }
}
