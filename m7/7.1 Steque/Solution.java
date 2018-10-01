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
	Steque() {
		first = null;
		last = null;
	}
	public void enque(int data) {
		// Node temp = new Node();
  //       if (last == null || first == null) {
  //           temp.data = data;
  //           temp.next = null;
  //           first = temp;
  //           last = temp;
  //       } else {
  //           Node oldlast = last;
  //           temp.data = data;
  //           temp.next = null;
  //           oldlast.next = temp;
  //           last = temp;
  //       }
  //       size++;
        Node node = new Node();
		node.data = data;
		size++;
		if (last == null) {
			last = node;
			first = node;
			return;
		}
		last.next = node;
		first = last.next;
	}
	public void push(int data) {
		// Node oldFirst = first;
		// first.data = data;
		// first.next = oldFirst;
		// if (last == null) 
		// 	last = first;
		// Node newnode = new Node();
		Node node = new Node();
		node.data = data;
		node.next = first;
		first = node;
		size++;
  //       if (first == null) {
  //           newnode.data = data;
  //           newnode.next = null;
  //           first = newnode;
  //           last = newnode;
  //       } else {
  //           Node oldfirst = first;
  //           newnode.data = data;
  //           newnode.next = oldfirst;
  //           first = newnode;
  //       }
  //       size++;
	}
	public void pop() {
		if (first == null) {
			return;
		}
		first = first.next;
		size--;
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
		if (first.next == null) {
			System.out.println(first.data);
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
		for (int i = 0; i < n; i++) {
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