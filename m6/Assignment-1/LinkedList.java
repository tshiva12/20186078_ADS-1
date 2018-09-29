class LinkedList {
	Node first = null;
    Node last = null;
	int size = 0;
   	private class Node {
   		String item;
        Node next;
        Node(String item) {
        	this.item = item;
        }
    }      
    public boolean isEmpty() {
        return size == 0;
    }
	public void push(String item) {
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
   	public String pop() {
        if (isEmpty()) {
            return null;
        }
        String item = first.item;
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
}
