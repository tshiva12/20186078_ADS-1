class Stack {
	private Node first = null;
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
        oldfirst.next = first; 
        first = oldfirst;
        size++;
    }
   	public int pop() {
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
}
