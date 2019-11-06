package co.grandcircus;

import java.util.Arrays;

public class MyArrayList implements MyList {
	
	private String[] arr = new String[4];
	private int myLength = 0;
	
	// we will use this method as a helper method inside this class 
	private boolean isFull() {
		return arr.length == myLength;
	}
	
	// we will use this as a helper method as well to dynamically increase the size 
	// of the array
	private void doubleLength() {
		// make a copy of the array that is twice as long 
		arr = Arrays.copyOf(arr, arr.length*2);
	}

	@Override
	public void addAtBeginning(String data) {
		if(isFull()) {
			doubleLength();
		}
		//loop backwards and shift all the items over to make room for the new data
		for (int i = myLength; i > 0; i--) {
			arr[i] = arr[i-1]; // this is assigning the element that was before it to the new index
		}
		//assign the new piece of data to the first index
		arr[0] = data;
		myLength++;
		
	}

	@Override
	public void removeFromBeginning() {

		myLength--;
		String[] newArr = new String[myLength];
		for (int i = 1; i < arr.length; i++) {
			newArr[i-1] = arr[i];
		}
		arr = Arrays.copyOf(newArr, myLength);
		
		//antonella's solution
		if (myLength != 0) {
			for (int i = 0;  i < newArr.length -1; i++) {
				arr[i] = arr[i+1];
			}
			myLength--;
		}
		
	}

	@Override
	public void addAtEnd(String data) {
		if(isFull()) {
			doubleLength();
		}
		arr[myLength] = data;
		myLength++;

	}

	@Override
	public void removeFromEnd() {
		if(myLength != 0) {
			//clear the slot and decrement the length
			arr[myLength-1] = null;
			myLength--;
		}
		
	}

	@Override
	public String get(int index) {
		if(index >= myLength) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		return arr[index];
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
		//Starting index would be the element being removed
		//we remove that element by overwriting it with the next element
		for (int i = index; i < myLength-1; i++) {
			arr[i] = arr[i+1];
		}
		myLength--;
		return true;
	}

	@Override
	public boolean insertAt(int index, String item) {
		myLength++;
		if(isFull()) {
			doubleLength();
		} 
		if (index >= myLength) {
			return false;
		}
		//step 1: make room for the new guy
		for (int i = index; i <= myLength + 1; i++) {
			arr[i + 1] = arr[i]; 
		}
		//step 2: drop him in at the specified index
		arr[index] = item;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < myLength; i++) {
			sb.append(arr[i]);
			if(i != myLength -1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString(); //replace this
	}

}
