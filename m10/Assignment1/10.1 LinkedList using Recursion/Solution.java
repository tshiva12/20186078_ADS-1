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
	 * Integer variable.
	 */
	private Node next;
	/**
	 * Constructs the object.
	 */
	Node() {
		// default constructor is not used.
	}
	/**
	 * Constructs the object.
	 *
	 * @param      data  The data
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
     * @param      data  The data
     */
    public void setData(final int data2) {
        this.data = data2;
    }
    /**
     * Sets the next.
     *
     * @param      next  The next
     */
    public void setNext(final Node next1) {
        this.next = next1;
    }
}
/**
 * List of linkedlist.
 */
class LinkedList {
	/**
	 * Node first.
	 */
	private Node first;
	/**
	 * Node temp;
	 */
	private Node temp;
	/**
	 * integer variable.
	 */
	private int size;
	/**
	 * Integer variable.
	 */
	private int count;
	/**
	 * Node result.
	 */
	private Node result;
	/**
	 * Node reverse;
	 */
	private Node reverse;
	/**
	 * Constructs the object.
	 */
	LinkedList() {
		this.first = null;
		this.count = 1;
		this.size = 0;
		this.result = null;
	}
	/**
	 * insertAt method is used to add the elements in a particular index.
	 * Time complexity of insertAt method is 1.
	 *
	 * @param      index  The index
	 * @param      value  The value
	 */
	public void insertAt(final int index, final int value) {
		Node newnode = new Node(value);
		if (size < index || index < 0) {
			System.out.println("Can't insert at this position.");
		}
		if (first == null) {
			first = newnode;
			temp = first;
			size++;
			return;
		} else if (index == 0) {
			newnode.setNext(first);
			first = newnode;
			temp = first;
			size++;
			return;
		} else if (index == count) {
			newnode.setNext(temp.getNext());
			temp.setNext(newnode);
			temp = first;
			count = 1;
			size++;
			return;
		}
		temp = temp.getNext();
		count++;
		insertAt(index, value);
	}
	/**
	 * reverse method is used to reverse the given array.
	 * Time complexity of reverse method is 1.
	 */
	public void reverse() {
		if (size == 0) {
			System.out.println("No elements to reverse.");
		}
		reverse = temp.getNext();
		temp.setNext(result);
		result = temp;
		if (reverse == null) {
			first = temp;
			result = null;
			return;
		}
		temp = reverse;
		reverse();

	}
	/**
	 * show method is used to display the output.
	 * Time complexity of show method is N.
	 */
	public void show() {
		while (temp.getNext() != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
        temp = first;
	}
}
/**
 * class Solution.
 */
public final class Solution {
	/**
	 * Constructs the object Solution.
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
		LinkedList linked = new LinkedList();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "insertAt":
				linked.insertAt(Integer.parseInt(tokens[1]),
				 Integer.parseInt(tokens[2]));
				linked.show();
				break;
				case "reverse":
				linked.reverse();
				linked.show();
				break;
				default:
				break;

			}
		}
	}
}