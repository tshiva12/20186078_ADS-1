import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * String variable.
     */
    private String name;
    /**
     * String variable.
     */
    private String author;
    /**
     * String variable.
     */
    private String price;
    /**
     * Constructs the object.
     *
     * @param      name1    The name
     * @param      author1  The author
     * @param      price1   The price
     */
    Book(final String name1, final String author1, final String price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public String getPrice() {
        return this.price;
    }
    /**
     * compareTo method is comparing the name.
     * Time complexity is 1.
     *
     * @param      that  The that
     *
     * @return     return true otherwise false.
     */
    public int compareTo(final Book that) {
        return this.getName().compareTo(that.getName());
    }
}
/**
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BST<Key extends Comparable<Key>, Value> {
    /**
     * Node variable.
     */
    private Node root;
    /**
     * Node class.
     */
    private class Node {
        /**
        * Book variable.
        */
        private Book key;
        /**
         * String variable.
        */
        private String val;
        /**
        * Node left and Node right.
        */
        private Node left, right;
        /**
         * Constructs the object.
         *
         * @param      key1  The key 1
         * @param      val1  The value 1
         */
        Node(final Book key1, final String val1) {
            this.key = key1;
            this.val = val1;
        }
    }
    /**
     * Constructs the object.
     */
    BST() {
        root = null;
    }
    /**
     * put method adds the key value pairs.
     * Time complexity is logN.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final String val) {
        Node z = new Node(key, val);
        if (root == null) {
            root = z;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.getName().compareTo(x.key.getName());
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left  = z;
        } else {
            parent.right = z;
        }
    }
    /**
     * get method is used to give the key value of the book details.
     * Time complexity is logN.
     *
     * @param      key   The key
     *
     * @return     return key.
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.key.getName());
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
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
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            final int three = 3;
            final int four = 4;
            switch (tokens[0]) {
                case "put":
                Book books = new Book(tokens[1], tokens[2], tokens[three]);
                bst.put(books, tokens[four]);
                break;
                case "get":
                books = new Book(tokens[1], tokens[2], tokens[three]);
                System.out.println(bst.get(books));
                break;
                default:
                break;
            }
        }
    }
}




