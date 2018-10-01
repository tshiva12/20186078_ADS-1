import java.util.Scanner;
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
	// private int data;
	Node first;
	Node last;
	int size;

	public void enque(int data) {
		Node obj = new Node(data);
		if(size == 0) {
			first = obj;
			last = obj;
			size++;
			return;
		}
		last.next = obj;
		last = obj;
		size++;
	}
	public void push(int data) {
		Node oldFirst = first;
		first = new Node();
		first.data = data;
		first.next = oldFirst;
		if (last == null) 
			last = first;
	}
	public void pop() {
		if (first == null) {
			return;
		}
		first = first.next;
		size++;
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
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 1; i < n; i++) {
			Steque steque = new Steque();
			while(scan.hasNext()) {
				String tokens[] = scan.nextLine().split(" ");
				switch(tokens[0]) {
					case "push" :
					steque.push(Integer.parseInt(tokens[1]));
					steque.show();
					break;
					case "pop" :
					steque.pop();
					steque.show();
					break;
					case "enque" :
					steque.enque(Integer.parseInt(tokens[1]));
					steque.show();
					break;
					default :
					break;
				}
			}
		}
	}
}