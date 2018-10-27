import java.util.Scanner;
class StudentData {
	private int rollnum;
	private String name;
	private Float total;
	StudentData(final int rollnum1, final String name1, final Float total1) {
		this.rollnum = rollnum1;
		this.name = name1;
		this.total = total1;
	}
	StudentData(final String name2, final Float total2) {
		this.name = name2;
		this.total = total2;
	}
	public int getRollNum() {
		return this.rollnum;
	}
	public String getName() {
		return this.name;
	}
	public Float getTotal() {
		return this.total;
	}
}
/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SequentialSearchST<Key, Value> {
    /**
     * Integer variable.
     */
    private int n;
    /**
     * Node variable.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Key variable.
         */
        private Key key;
        /**
         * Value variable.
         */
        private Value val;
        /**
         * Node variable.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      key1   The key 1
         * @param      val1   The value 1
         * @param      next1  The next 1
         */
        Node(final Key key1, final Value val1, final Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }
    /**
     * Constructs the object.
     */
    SequentialSearchST() {
    }
    /**
     * size method.
     *
     * @return     return size.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * contains method.
     *
     * @param      key   The key
     *
     * @return     true if empty, false otherwise.
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Get.
     *
     * @param      key   The key
     *
     * @return     return x value.
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }
    /**
     * Put.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
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
    /**
     * delete.
     * Time complexity logN.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        first = delete(first, key);
    }
    /**
     * delete.
     * Time complexity logN.
     *
     * @param      x     Node variable.
     * @param      key   The key
     *
     * @return     return x.
     */
    private Node delete(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    /**
     * Iterable.
     * Time complexity logN.
     *
     * @return     return queue.
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}
/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
    /**
     * Integer variable.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * Integer variable.
     */
    private int n;
    /**
     * Integer variable.
     */
    private int m;
    /**
     * Sequential variable.
     */
    private SequentialSearchST<Key, Value>[] st;
    /**
     * Constructs the object.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Constructs the object.
     * Time complexity N.
     *
     * @param      m1    integer variable.
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m1];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    /**
     * resize method.
     * Time complexity logN.
     *
     * @param      chains  The chains
     */
    private void resize(final int chains) {
        SeparateChainingHashST<Key, Value>
         temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }
    /**
     * Integer variable.
     */
    private final int z = 0x7fffffff;
    /**
     * hash function.
     *
     * @param      key   The key
     *
     * @return     key variable.
     */
    private int hash(final Key key) {
        return (key.hashCode() & z) % m;
    }
    /**
     * Size.
     * Time complexity 1.
     *
     * @return     return size.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Contains.
     * Time complexity logN.
     *
     * @param      key   The key
     *
     * @return     return boolean value.
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new
             IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }
    /**
     * Get.
     * Time complexity logN.
     *
     * @param      key   The key
     *
     * @return     return value.
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * Put.
     * Time complexity logN.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        /**
         * Integer variable.
         */
        final int ten = 10;
        if (key == null) {
            throw new
             IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= ten * m) {
            resize(2 * m);
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }
    /**
     * delete.
     * Time complexity logN.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
        if (m > INIT_CAPACITY && n <= 2 * m) {
            resize(m / 2);
        }
    }
    /**
     * Iterable.
     *
     * @return     return queue.
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // default constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<Integer, StudentData>
         hash = new SeparateChainingHashST<Integer, StudentData>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] tokens = scan.nextLine().split(",");
            hash.put(Integer.parseInt(tokens[0]), new StudentData(tokens[1], Float.parseFloat(tokens[2])));
        }
        int m = Integer.parseInt(scan.nextLine());
        for (int j = 1; j <= m; j++) {
        	String[] tokens1 = scan.nextLine().split(" ");
        	if (tokens1[2].equals("1")) {
        		int val1 = Integer.parseInt(tokens1[1]);
        		if (hash.contains(val1)) {
        			System.out.println(hash.get(val1).getName());
        		} else {
        			System.out.println("Student doesn't exists...");
        		}

        	} else if (tokens1[2].equals("2")) {
        		int val2 = Integer.parseInt(tokens1[1]);
        		if (hash.contains(val2)) {
        			System.out.println(hash.get(val2).getTotal());
        		} else {
        			System.out.println("Student doesn't exists...");
        		}
        	} else {
        		System.out.println("Student doesn't exists...");
        	}
        }
    }
} 