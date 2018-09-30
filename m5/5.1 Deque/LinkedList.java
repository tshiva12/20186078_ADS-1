class Node{
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}
class LinkedList{
	Node first = null;
	int size = 0;
	Node last;
	public void pushRight(int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		if (first == null) {
			first = newNode;
			last = newNode;
			show();
		}
		else{
			last.next = newNode;
			last = newNode;
		}
		size++;
		show();		
	}
	public void pushLeft(int item) {
		Node newNode1 = new Node(item);
		newNode1.next = null;
		if (first == null) {
			first = newNode1;
			last = newNode1;
		} else{
			newNode1.next = first;
			first = newNode1;
		}
		size++;
		show();
	}
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;

	}
	public void popLeft() {
		if(size == 0) {
			System.out.println("Deck is empty");
			return;
		}
		Node temp = first;
		first = first.next;
		size--;
		show();
	}
	public void popRight() {
		if(size == 0) {
			System.out.println("Deck is empty");
			return;
		}
		Node temp = first;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		last = temp;
		temp.next = null;
		size--;
		show();
	}
	public void show() {
		if(size == 0 ) {
			System.out.println("[]");
			return;
		}
		Node temp1 = first;
		String str1 = "[";
		while(temp1.next!=null) {
			str1 += temp1.data + ", ";
			temp1 = temp1.next;
		}
		str1 += temp1.data + "]";
		System.out.println(str1);
	}
	public int size() {
		return size;
	}
}