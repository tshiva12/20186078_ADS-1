class Node {
	int data;
	Node next;
	Node () {

	}
	Node(int data) {
		this.data = data;
	}
}
class Steque {
	Node first;
	Node last;
	int size;
	Steque() {
		first = null;
		last = null;
	}
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
	public int pop() {
		if (first != null) {
			int item = first.data;
			first = first.next;
			size--;
			return item;
		}
		return 0;
	}
	public boolean isEmpty() {
		return first == null || last == null;
	}
	public int size() {
		return size;
	}
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