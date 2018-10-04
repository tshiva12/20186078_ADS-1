import java.util.Scanner;
class Node {
	int data;
	Node next;
	Node(int data) {
		this.data = data;
		this.next = null;
	}
	public int getData() {
        return data;
    }
    public Node getNext() {
        return next;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
class LinkedList {
	Node first;
	Node temp;
	int size;
	int count;
	Node result;
	Node reverse;
	LinkedList() {
		this.first = null;
		this.count = 1;
		this.size = 0;
		this.result = null;
	}
	public void insertAt(int index, int value) {
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
	public void show() {
		while (temp.getNext() != null) {
            System.out.print(temp.getData() + ", ");
            temp = temp.getNext();
        }
        System.out.println(temp.getData());
        temp = first;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList linked = new LinkedList();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "insertAt":
				linked.insertAt(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
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