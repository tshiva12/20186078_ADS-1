/**
 * Class for node.
 */
class Node {
	/**
	 * Integer variable.
	 */
	int data;
	/**
	 * Node variable.
	 */
	Node next;
	/**
	 * Constructs the object.
	 */
	Node () {
		// default Constructor is not used.
	}
	/**
	 * Constructs the object.
	 *
	 * @param      data  The data
	 */
	Node(int data) {
		this.data = data;
	}
}
/**
 * Class for steque.
 */
class Steque {
	/**
	 * Node variable.
	 */
	Node first;
	/**
	 * Node variable.
	 */
	Node last;
	/**
	 * Integer variable.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	Steque() {
		first = null;
		last = null;
	}
	/**
	 * add elements from the end.
	 * time complexity of enqueue is 1.
	 *
	 * @param      data  The data
	 */
	public void enque(int data) {
		Node temp = new Node();
        if (last == null || first == null) {
            temp.data = data;
            temp.next = null;
            first = temp;
            last = temp;
        } else {
            Node oldlast = last;
            temp.data = data;
            temp.next = null;
            oldlast.next = temp;
            last = temp;
        }
        size++;
	}
	/**
	 * add the element from the begining.
	 * Time complexity of the push is 1.
	 *
	 * @param      data  The data
	 */
	public void push(int data) {
		Node newnode = new Node();
        if (first == null) {
            newnode.data = data;
            newnode.next = null;
            first = newnode;
            last = newnode;
        } else {
            Node oldfirst = first;
            newnode.data = data;
            newnode.next = oldfirst;
            first = newnode;
        }
        size++;
	}
	/**
	 * removes the element from the begining in the list.
	 * The time complexity of the pop is 1.
	 *
	 * @return     return remove item value.
	 */
	public int pop() {
		if (first != null) {
			int item = first.data;
			first = first.next;
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
        while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
} 