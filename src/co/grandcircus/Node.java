package co.grandcircus;

public class Node {


	private Node next; //we have a node inside of itself
	private String data;
	
	public Node() {
	}
	
	public Node(Node next, String data) {
		this.next = next;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		if (next != null) {
			return data + " -> ";
		}
		return data;
	}
	
}
