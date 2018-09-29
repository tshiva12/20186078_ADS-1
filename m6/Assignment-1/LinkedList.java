public class LinkedList<E> {
	private class Node {
		E data;
		Node next;
	}
	Node head, tail;
	public void addAtHead(E data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) tail = node;
		head = node;
	}
	public void addAtTail(E data) {
		if (tail == null) {
			addAtHead(data);
			return;
		}
		Node node = new Node();
		node.data = data;
		tail.next = node;
		tail = tail.next;
	}
	public void deleteAtHead() {
		head = head.next;
	}
	public E popAtHead() {
		E data = head.data;
		head = head.next;
		return data;
	}
	public void deleteAtTail() {
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
	}
	public E popAtTail() {
		E data = tail.data;
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		return data;
	}
	public void insertAfter(int index, E data) {
		Node thead = head;
		for (int i = 0; i < index; i++)
			thead = thead.next;
		Node node = new Node();
		node.data = data;
		node.next = thead.next;
		thead.next = node;
	}
	public void removeAfter(int index) {
		Node thead = head;
		for (int i = 0; i < index; i++)
			thead = thead.next;
		thead.next = thead.next.next;
	}
	public void print() {
		Node thead = head;
		while(thead != null) {
			System.out.println(thead.data);
			thead = thead.next;
		}
	}
}