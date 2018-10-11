import java.util.Scanner;
class Book implements Comparable<Book> {
    private String name;
    private String author;
    private String price;
    Book(String name, String author, String price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getPrice() {
        return this.price;
    }
    public int compareTo(Book that) {
        return this.name.compareTo(that.getName());
    }
}
class BST<Key extends Comparable<Key>, Value> {
    private Node root;  
    private class Node {
        private Book key;
        private String val;
        private Node left, right;
        public Node(Book key1, String val1) {
            this.key = key1;
            this.val = val1;
        }
    }
    BST() {
        root = null;
    }
    public void put(Book key, String val) {
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
    public String get(Book key) {
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
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                Book books = new Book(tokens[1], tokens[2], tokens[3]);
                bst.put(books, tokens[4]);
                break;
                case "get":
                books = new Book(tokens[1], tokens[2], tokens[3]);
                System.out.println(bst.get(books));
                break;
                default:
                break;
            }
        }
    }
}