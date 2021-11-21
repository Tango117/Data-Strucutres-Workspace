package project3;

import java.util.*;

/**
 * This class represents a List using the List interface.
 *
 * @author Brendan Tang
 * @version 10/29/2020
 */

public class MyList<E> implements List<E>{

  private Node head;
  private Node tail;
  private int size;

  public MyList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }



  /**
	* Adds an element 'item' at position `pos`, shifts elements starting at `pos` by
	* one position to the right (higher position values)
	* @param item the element to be added to this list
	* @param pos postion at which `item` should be added
  * @return true if the element was added successfully, false otherwise
	* throws NoSuchElementException if `pos` < 0 or `pos` > size
	* throws IllegalArgumentException if `item == null`
	*/
  @Override
  public boolean add(E item, int pos) throws NoSuchElementException, IllegalArgumentException {

    if(pos < 0 || pos > size) {
      throw new NoSuchElementException("Position out of bounds");
    }

    if(item == null){
      throw new IllegalArgumentException("Entry cannot be null");
    }

    Node n = new Node(item);

    if(this.head == null){
      this.head = n;
      this.tail = n;
      size++;
      return true;
    }

    if(pos == 0){
      n.next = head;
      this.head.prev = n;
      this.head = n;
      size++;
      return true;
    }

    if(pos == size){
      n.prev = tail;
      this.tail.next = n;
      this.tail = n;
      size++;
      return true;
    }

    Node current = this.head;

    for(int x = 0; x < pos - 1; x++){
      current = current.next;
    }

    n.prev = current;
    n.next = current.next;
    current.next.prev = n;
    current.next = n;
    size++;

	  return true;

  }



  /**
	* Removes and returns an element at position `pos`, shifts elements starting
	* at `pos+1` by one to the left (lower position values)
	* @param pos the position from which the element should be removed
	* @return the element removed from the list
	* throws NoSuchElementException if pos < 0 or pos >= size
	*/
  @Override
  public E remove(int pos) throws NoSuchElementException{

    if(pos < 0 || pos >= size) {
      throw new NoSuchElementException("Position out of bounds");
    }

    Node current = this.head;

    for(int x = 0; x < pos; x++){
      current = current.next;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
    size--;

    return (E) current.data;

  }



  /**
	* Removes and returns an element equal to `item`, shifts elements starting
	* at the next position by one to the left (lower position values)
	* @param item element to remove
	* @return the removed element, or null if element equal to `item` is not in this list
	*/
  @Override
  public E remove (E item) {

    int index = find(item);

    if(index > 0)
      return remove(index);

    return null;

  }



  /**
	* Determines if 'item' is in the list and if so returns its position
	* @param item to locate in this list
	* @return position of `item` in this list or -1 if `item` is not found in this list
	*/
  @Override
  public int find (E item) {

    Node current = this.head;

    for(int x = 0; x < size; x++){
			if(current.data == item){
				return x;
			}
      current = current.next;
		}

		return -1;

  }



  /**
	* Retrieves and returns an element from position `pos`
	* @param pos the position of item to return
	* @return element stored at position `pos`
	* throws NoSuchElementException if pos < 0 or pos >= size
	*/
  @Override
  public E get( int pos) throws NoSuchElementException {

    if(pos < 0 || pos >= size) {
      throw new NoSuchElementException("Position out of bounds");
    }

    Node current = this.head;

    for(int x = 0; x < pos; x++){
      current = current.next;
    }

    return (E) current.data;
  }



  /**
	* Returns the current number of elements in this list
	* @return the number of elements in this list
	*/
  @Override
  public int size() {

    return this.size;

  }


  /**
  * Removes all elements from this list, so it is once again empty.
  */
  @Override
  public void clear() {

    this.head = null;
    this.tail = null;
    this.size = 0;

  }


  /**
	* Determines if this list is equal to `obj`.
	* @param obj an Object that is compared to this list for equality
	* @return true if this list is equal to `obj` (same elements in the same order)
	*         false, otherwise
	*/
  @Override
  public boolean equals(Object obj) {

    // check if obj is this list
    if (obj == this)
      return true;
    // check if obj is MyList
    if(!(obj instanceof MyList))
      return false;

    // check if lists are of the same length
    if (this.size() != ((MyList<?>) obj).size() ) {
      return false;
    }

    // iterate over both lists, comparing corresponding pairs of elements
	  for(int x = 0; x < this.size(); x++) {
      E o1 = this.get(x);
      Object o2 = ((MyList<?>) obj).get(x);
      if (!(o1 == null || o2 == null || o1.equals(o2)))
        return false;

	    }
	    return true;

  }


  /**
	* Returns a string representation of this list. The string is constructed by
	* concatenating all elements of this list separated by a comma and a single space.
	* There should be no comma after the last element.
	* @return a string representation of this list.
	*/
  @Override
  public String toString () {

    String s = "";

    Node current = this.top;

		if(size > 0){
			s = current.data.toString();
		}

		for(int x = 1; x < size; x++){
      current = current.next;
			s = s + ", " + current.data.toString();
	  }

	  return s;

  }



  // Node class doubly linked
  private class Node implements Comparable<Node> {

    Object data;
    Node next;
    Node prev;

    Node (Object data){
      this.data = data;
    }

    public String toString () {
      return data.toString();
    }

    public boolean equals(Object o) {
      if(this == o) return true;

      if(!(o instanceof MyList.Node)){
        return false;
      }

      Node other = (Node) o;

      if (!this.data.equals(other.data)){
        return false;
      }

      return true;
    }

    public int compareTo (Node n){
      return ((MyList<E>.Node) data).compareTo((MyList<E>.Node) n.data);
    }

  }

}
