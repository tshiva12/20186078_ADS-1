import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * Integer variable.
     */
    private int data;
    /**
     * Node variable.
     */
    private Node next;
    /**
     * Constructs the object.
     */
    Node() {
        // default Constructor is not used.
    }
    /**
     * Constructs the object.
     *
     * @param      data1  The getData
     */
    Node(final int data1) {
        this.data = data1;
        this.next = null;
    }
    /**
     * Gets the data.
     *
     * @return     The data.
     */
    public int getData() {
        return data;
    }
    /**
     * Gets the next.
     *
     * @return     The next.
     */
    public Node getNext() {
        return next;
    }
    /**
     * Sets the data.
     *
     * @param      data2  The data
     */
    public void setData(final int data2) {
        this.data = data2;
    }
    /**
     * Sets the next.
     *
     * @param      next1  The next
     */
    public void setNext(final Node next1) {
        this.next = next1;
    }
}
/**
 * Class for steque.
 */
class Steque {
    /**
     * Node variable.
     */
    private Node first;
    /**
     * Node variable.
     */
    private Node last;
    /**
     * Integer variable.
     */
    private int size = 0;
    /**
     * Constructs the object.
     */
    Steque() {
        first = null;
        last = null;
    }
    /**
     * add elements from the end. time complexity of enqueue is 1.
     *
     * @param      data  The data
     */
    public void enque(final int data) {
        Node temp = new Node(data);
        size++;
        if (first == null) {
            first = temp;
            last = temp;
            return;
        }
        last.setNext(temp);
        last = temp;
    }
    /**
     * add the element from the begining. Time complexity of the push is 1.
     *
     * @param      data  The data
     */
    public void push(final int data) {
        Node newnode = new Node(data);
        size++;
        if (first == null) {
            first = newnode;
            last = newnode;
            return;
        }
        newnode.setNext(first);
        first = newnode;
    }
    /**
     * removes the element from the begining in the list.
     * The time complexity of the pop is 1.
     *
     * @return     return remove item value.
     */
    public int pop() {
        if (first != null) {
            int item = first.getData();
            first = first.getNext();
            size--;
            return item;
        }
        return 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null || last == null;
    }
    /**
     * display the size of the list.
     *
     * @return     return size value.
     */
    public int size() {
        return size;
    }
    /**
     * display the output of the list.
     * Time complexity of the show is n.
     */
    public void show() {
        Node temp = first;
        if (first == null) {
            System.out.println("Steque is empty.");
            return;
        }
        while (temp.getNext() != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
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
        //default constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Steque steque = new Steque();
            while (scan.hasNext()) {
                String str = scan.nextLine();
                if (str.equals("")) {
                    break;
                }
                String[] tokens = str.split(" ");
                switch (tokens[0]) {
                    case "push" :
                    steque.push(
                        Integer.parseInt(tokens[1]));
                    steque.show();
                    break;
                    case "pop" :
                    steque.pop();
                    steque.show();
                    break;
                    case "enqueue" :
                    steque.enque(
                        Integer.parseInt(tokens[1]));
                    steque.show();
                    break;
                    default :
                    break;
                }
            }
            System.out.println();
        }
    }
}




