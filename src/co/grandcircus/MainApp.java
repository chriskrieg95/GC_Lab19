package co.grandcircus;

public class MainApp {

	public static void main(String[] args) {

		
		System.out.println("MyArrayList starts here: ");
		MyArrayList list = new MyArrayList();
		list.addAtBeginning("Hello");
		list.addAtEnd("Hello2");
		list.addAtEnd("Hello3");
		list.addAtEnd("Hello4");
		System.out.println(list);
		list.removeAt(2);
		//hello3 should be removed
		System.out.println(list);
		list.insertAt(2, "Hello3");
		//hello 3 should be added back to the list
		System.out.println(list);
		
		
		System.out.println("\nMyLinkedList starts here: ");
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtBeginning("help");
		linkedList.addAtEnd("help1");
		linkedList.addAtEnd("help2");
		linkedList.addAtEnd("help3");
		System.out.println(linkedList);
		linkedList.removeAt(2);
		//help2 should be removed
		System.out.println(linkedList);
		linkedList.insertAt(2, "help2");
		System.out.println(linkedList);
//		linkedList.removeFromEnd();
//		System.out.println(linkedList);
		
		
		
		
		
	}

}
