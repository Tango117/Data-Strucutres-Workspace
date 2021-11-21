package project3;

import java.util.Arrays;

/**
 * This class represents a Queue using the Queue interface.
 *
 * @author Brendan Tang
 * @version 10/29/2020
 */

public class MyQueue<E> implements Queue<E> {

	private Object[] elements;
	private int size;
	private final static int INITIAL_SIZE = 10;
	private int front;
	private int back;

	/**
	* Default queue size is 10
	*/
	public MyQueue(){

		elements = new Object[INITIAL_SIZE];
		size = 0;
		front = 0;
		back = 0;

	}



	/**
	* Add an element to the back of this queue
	* @param item to be added to this queue
	* throws IllegalArgumentException if `item == null`
	*/
	@Override
	public void enqueue(E item) throws IllegalArgumentException{

		if(item == null)
			throw new IllegalArgumentException("Cannot enqueue null value");

		if(size == elements.length){
			increaseCapa();
		}

		size++;

		elements[back] = item;

		if(back == elements.length){
			back = 0;
		}
		else{
			back++;
		}

	}



	/**
	* Remove and return the element from the front of this queue.
	* @return the element from the front of this queue or null if this queue is empty
	*/
	@Override
	public E dequeue() {

		E temp = (E) elements[front];
		elements[front] = null;
		front++;
		size--;
		return temp;

	}



	/** Return the element from the front of this queue.
	* @return  the element from the top of this queue or null if this queue is empty
	*/
	@Override
	public E peek() {
		if(elements[front] == null)
			return null;

		return (E) elements[front];
	}



	/**
	* Determines if this queue is equal to `obj`.
	* @obj an Object that is compared to this queue for equality
	* @return true if this queue is equal to `obj` (same elements in the same order)
	*         false, otherwise
	*/
	@Override
	public boolean equals(Object obj) {

		// check if obj is this stack
		if (obj == this)
			return true;
		// check if obj is MyStack
		if(!(obj instanceof MyQueue))
			return false;
		// check if stacks are of the same length
		if (this.getSize() != ((MyQueue<?>) obj).getSize() ) {
			return false;
		}

		Object[] o1 = this.getElements();
		Object[] o2 = ((MyQueue<?>) obj).getElements();
		int f1 = this.getFront();
		int f2 = ((MyQueue<?>) obj).getFront();
		for(int x = 0; x < this.getSize(); x++) {

			if(f1 == this.getSize())
				f1 = 0;
			if(f2 == this.getSize())
				f2 = 0;

			if (!(o1[f1] == null || o2[f2] == null || o1[f1].equals(o2[f2])))
	    		return false;
			f1++;
			f2++;

		}

		return true;

	}



	/**
	* Returns a string representation of this queue. The string is constructed by
	* concatenating all elements of this queue separated by a comma and a single space.
	* The front of the queue should be the leftmost element and the back of the queue
	* should be the rightmost element. There should be no comma after the last element.
	* @return a string representation of this queue.
	*/
	public String toString () {

		String s = "";

		if(size > 0){
			s = elements[front].toString();
		}

		if(front == elements.length - 1){

			for(int x = 0; x < back; x++){
				s = s + ", " + elements[x].toString();
			}

		}else{

			for(int x = front + 1; x < back; x++){
				s = s + ", " + elements[x].toString();
			}

		}

		return s;

	}



	/**
	* Doubles the capacity of the queue and reorders the elements from 0 to size
	*/
	private void increaseCapa() {

		if(front != 0){
			Object[] copy = new Object[size * 2];
			Object[] a = Arrays.copyOfRange(elements, front, size);
			Object[] b = Arrays.copyOfRange(elements, 0, back);

			System.arraycopy(a, 0, copy, 0, a.length);
			System.arraycopy(b, 0, copy, a.length, b.length);
			elements = copy;
		}
		else{
			int newSize = elements.length * 2;
		    elements = Arrays.copyOf(elements, newSize);
		}

		front = 0;
		back = size;

	}



	// returns size
	private int getSize(){

		return this.size;

	}



	// returns elements
	private Object[] getElements(){

		return this.elements;

	}



	// returns front
	private int getFront(){

		return this.front;

	}

}
