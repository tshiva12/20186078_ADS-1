import java.util.Scanner;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
	}
}
class LinkedList {
	int size;
	int count;
	Node first, last;
	String result = "";
	LinkedList(int size, int count) {
		this.size = size;
		this.count = count;
	}
	public void JosephusProblem() {
		Node newNode = new Node(0);
		first = newNode;
		last = newNode;
		for (int i = 1; i < size; i++) {
			Node newNode1 = new Node(i);
			last.next = newNode1;
			last = newNode1;
		}
		int i;
		Node temp;
		while (size != 1) {
			for (i= 1; i < count; i++) {
				temp = first;
				first = first.next;
				last.next = temp;
				last = temp;
			}
			result += first.data + " ";
			first = first.next;
			i = 1;
			size--;
		}
		result += first.data;
		System.out.println(result);
	}
}