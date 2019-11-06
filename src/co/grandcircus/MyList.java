package co.grandcircus;

public interface MyList {

	void addAtBeginning(String data);
	
	void removeFromBeginning();
	
	void addAtEnd(String data);
	
	void removeFromEnd();
	
	String get(int index);
	
	int size(); // returns how many items are in the list
	
	boolean removeAt(int index);
	
	boolean insertAt(int index, String item);
	
}
