public class LinkedList<E> {
	private class Node {
		E data;
		Node next;
	}
	Node head, tail;
	public void addFirst(E data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) tail = node;
		head = node;
	}
	public void addLast(E data) {
		if (tail == null) {
			addFirst(data);
			return;
		}
		Node node = new Node();
		node.data = data;
		tail.next = node;
		tail = tail.next;
	}
	public void deleteFirst() {
		head = head.next;
	}
	public E popFirst() {
		E data = head.data;
		head = head.next;
		return data;
	}
	public void deletelast() {
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
	}
	public E poplast() {
		E data = tail.data;
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		return data;
	}
	public void addindex(int index, E data) {
		Node thead = head;
		for (int i = 0; i < index; i++)
			thead = thead.next;
		Node node = new Node();
		node.data = data;
		node.next = thead.next;
		thead.next = node;
	}
	public void removeindex(int index) {
		Node thead = head;
		for (int i = 0; i < index; i++)
			thead = thead.next;
		thead.next = thead.next.next;
	}
	public void show() {
		Node thead = head;
		while(thead != null) {
			System.out.println(thead.data);
			thead = thead.next;
		}
	}
}