package co.grandcircus;

public class MyLinkedList implements MyList {
	
	private Node head;
	private int myLength = 0;
	
	
	// created a helper method to get the node at a certain location
	// to help us prevent some code duplication
	private Node getNodeAt(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			if (node == null) {
				return null;
			}
			node = node.getNext();
		}
		return node;
	}

	@Override
	public void addAtBeginning(String data) {
		//add a new Node and set it to the head
		head = new Node(head, data);
		myLength++;
	}

	@Override
	public void removeFromBeginning() {

		head = head.getNext();
		myLength--;
		
	}

	@Override
	public void addAtEnd(String data) {
		// check to make sure the list is not empty!
		// if empty add to the beginning (hint: we have some code for that!)
		if(myLength == 0) {
			addAtBeginning(data);
		}
		//create a new node 
		Node newNode = new Node(null, data);
		//get the last node in the linkedlist
		//Node endNode = getNodeAt(myLength-1);
		getNodeAt(myLength-1).setNext(newNode);
		//increase the length
		myLength++;
	}

	@Override
	public void removeFromEnd() {
		if (myLength < 2) {
			removeFromBeginning();
		}
		//set the second to last node to null (myLength-2)
		getNodeAt(myLength-2).setNext(null);
		
	}

	@Override
	public String get(int index) {
		if(index >= myLength) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		return getNodeAt(index).getData();
	}

	@Override
	public int size() {
		return myLength;
	}
	
	@Override
	public boolean removeAt(int index) {
		if(index >= myLength) {
			return false;
		} 
		Node nextNode = getNodeAt(index+1);
		//Set node at specified index to null
		getNodeAt(index).setNext(null);
		//Set the previous node to the node after the node that was just set to null
		getNodeAt(index-1).setNext(nextNode);
		myLength--;
		return true;
	}
	
	@Override
	public boolean insertAt(int index, String item) {
		if(index > myLength) {
			return false;
		}
		Node newNode = new Node(getNodeAt(index) ,item);
		getNodeAt(index - 1).setNext(newNode);
		//Increases the length
		myLength++;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node node = head;
		//follow the links between the nodes until it reaches the end
		while(node != null) {
			sb.append(node);
			node = node.getNext();
		}
		sb.append("]");
		return sb.toString();
	}


}
