import java.util.Scanner;
// class Node {
// 	int data;
// 	Node next;
// 	Node(int data) {
// 		this.data = data;
// 	}
// }
// class Steque {
// 	Node first;
// 	Node last;
// 	int size = 0;
// 	// class Node {
// 	// 	int data;
// 	// 	Node next;
// 	// 	Node(int data) {
// 	// 		this.data = data;
// 	// 	}
// 	// }
// 	Steque() {
// 		first = null;
// 		last = null;
// 	}
// 	public void enque(int data) {
// 		Node oldLast = last;
// 		last = new Node(data);
// 		last.data = data;
// 		last.next = null;
// 		if (first == null)
// 			first = last;
// 		else
// 			oldLast.next = last;
// 	}
// 	public void push(int data) {
// 		Node oldFirst = first;
// 		first = new Node(data);
// 		first.data = data;
// 		first.next = oldFirst;
// 		if (last == null) 
// 			last = first;
// 	}
// 	public void pop() {
// 		if (isEmpty())
// 			System.out.println("No element exists in Steque");
// 		data = first.data;
// 		first = first.next;
// 		return data;
// 	}
// 	public boolean isEmpty() {
// 		return first == null || last == null;
// 	}
// 	// public int size() {
// 	// 	int count = 0;
// 	// 	for(int data : data) {
// 	// 		count++;
// 	// 	}
// 	// 	return count;
// 	// }
// 	public void show() {
// 		Node temp = first;
// 		while (temp.next != null) {
// 			System.out.print(temp.data + ", ");
// 			temp = temp.next;
// 		}
// 		System.out.println(temp.data);
// 	}
// } 
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
class Steque {
	Node first = null;
    Node last = null;
	int size = 0;
   	private class Node {
   		int item;
        Node next;
        Node(int item) {
        	this.item = item;
        }
    }      
    public boolean isEmpty() {
        return size == 0;
    }
	public void push(int item) {
        Node oldfirst = new Node(item);
        if (isEmpty()) {
            first = oldfirst;
            last = first;
            last.next = null;
            size++;
            return;
        }
        Node ofirst = last;
        last = oldfirst;
        ofirst.next = last; 
        last.next = null;
        size++;
    }
   	public int pop() {
        if (isEmpty()) {
            return 0;
        }
        int item = first.item;
        first = first.next;
        size--;
        return item;
    }
    public void show() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }
    public void enque(int data) {
		Node oldLast = last;
		last = new Node(data);
		last.item = data;
		last.next = null;
		if (first == null)
			first = last;
		else
			oldLast.next = last;
	}
}
