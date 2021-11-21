package project3;

/**
 * This class represents a Stack using the Stack interface.
 *
 * @author Brendan Tang
 * @version 10/29/2020
 */

public class MyStack<E> implements Stack<E> {

  private Node top;
  private Node bottom;
  private int size;

  public MyStack() {
    this.top = null;
    this.bottom = null;
    this.size = 0;
  }



  /**
	* Add an element to the top of this stack
	* @param item to be added to this stack
	* @throws IllegalArgumentException if `item == null`
	*/
  @Override
	public void push(E item) {

    Node n = new Node(item);
    size++;

    if(this.top == null){
      this.bottom = n;
    }
    else{
      n.next = this.top;
    }

    this.top = n;

	}



  /**
	* Remove and return the element from the top of this stack
	* @return the element from the top of this stack or null if this stack is empty
	*/
	@Override
  public E pop() {

		size--;

		if(this.top == null)
			return null;

		E temp = (E) top.data;
		top = top.next;
		return temp;

	}



  /** Return the element from the top of this stack.
	* @return  the element from the top of this stack or null if this stack is empty
	*/
	@Override
	public E top() {

    if(this.top == null)
      return null;

		return (E) bottom.data;

	}



  /**
  * Determines if this stack is equal to `obj`.
  * @obj an Object that is compared to this stack for equality
  * @return true if this stack is equal to `obj` (same elements in the same order)
  *         false, otherwise
  */
  @Override
  public boolean equals(Object obj) {

		// check if obj is this stack
		if (obj == this)
			return true;
	  // check if obj is MyStack
	  if(!(obj instanceof MyStack))
      return false;

	  // check if stacks are of the same length
	  if (this.getSize() != ((MyStack<?>) obj).getSize() ) {
      return false;
	  }

	  Node o1 = this.top;
	  Node o2 = ((MyStack) obj).getTopNode();

	  // iterate over both stacks, comparing corresponding pairs of elements
	  for(int x = 0; x < this.getSize(); x++) {
      if (!(o1.data == null || o2.data == null || o1.equals(o2)))
        return false;

      o1 = o1.next;
	    o2 = o2.next;
	  }

	  return true;

	}



  /**
	* Returns a string representation of this stack. The string is constructed by
	* concatenating all elements of this stack separated by a comma and a single space.
	* The bottom of the stack should be the leftmost element and the top of the stack
	* should be the rightmost element. There should be no comma after the last element.
	* @return a string representation of this stack.
	*/
  @Override
  public String toString () {

		String s = "";

	  Node current = this.top;

		if(size > 0)
			s = current.data.toString();

		for(int x = 1; x < size; x++){
			current = current.next;
			s = s + ", " + current.data.toString();
		}

		return s;

	}



  // returns size
  public int getSize(){

    return this.size;

  }



  // returns top Node
	private Node getTopNode(){

		return this.top;

  }



  // Node class singly linked
  private class Node implements Comparable<Node> {

    Object data;
    Node next;

    Node (Object data){
      this.data = data;
    }

    public String toString () {
      return data.toString();
    }

    public boolean equals(Object o) {
      if(this == o) return true;

      if(!(o instanceof MyStack.Node)){
        return false;
      }

      Node other = (Node) o;

      if (!this.data.equals(other.data)){
        return false;
      }

      return true;
    }

    public int compareTo (Node n){
      return ((MyStack<E>.Node) data).compareTo((MyStack<E>.Node) n.data);
    }

  }

}
