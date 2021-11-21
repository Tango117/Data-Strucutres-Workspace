package project2;

import java.util.Collections;
/**
 * This class stores Meteorite objects.
 * This class uses a LinkedList storing system.
 * This class sorts Meteorite objects using Meteorite.compareTo().
 *
 * @author Brendan Tang
 * @version 10/7/2020
 */

public class MeteoriteLinkedList {

  private Node head;
  private Node tail;
  private int size;


  /**
   * Constructs a new MeteoriteLinkedList object, default constructor
   */
  public MeteoriteLinkedList () {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }


  /**
   * Constructs a new MeteoriteLinkedList object and populates it with MeteoriteList object
   * @param list MeteoriteList list for MeteoriteLinkedList, valid not null
   * @throws IllegalArgumentException  if list is null
   */
  public MeteoriteLinkedList (MeteoriteList list) throws IllegalArgumentException{
    if(list == null)
      throw new IllegalArgumentException("Cannot pass empty MeteoriteList.");

    // Sorts list
    Collections.sort(list);

    if(list.size() > 0){
      for(Meteorite m: list){
        this.add(m);
      }

    }

  }



  /**
	 * Returns the size of this MeteoriteLinkedList object.
	 * @return the size value of this MeteoriteLinkedList object
	 */
  public int getSize(){
    return this.size;
  }


  /**
	 * Adds Meteorite object in correct position in sorted this MeteoriteLinkedList.
   * Returns true if added or false if did not add.
   * @param m the Meteorite object to add
	 * @return true if successfully added into this MeteoriteLinkedList,
   * false if did not add due to duplicate copy already existing in this MeteoriteLinkedList
   * @throws IllegalArgumentException if the Meteorite object is null
	 */
  public boolean add (Meteorite m) throws IllegalArgumentException{
    if(m == null)
      throw new IllegalArgumentException("Cannot add null Meteorite.");

    Node n = new Node(m);

    // For Empty MeteoriteLinkedList
    if(this.head == null){
      this.head = n;
      this.tail = n;
      this.size = 1;
      return true;
    }

    //For adding to front of MeteoriteLinkedList
    if(n.data.compareTo(this.head.data) < 0){
      n.next = this.head;
      this.head = n;
      return true;
    }

    Node current = this.head;

    //For adding in the middle of MeteoriteLinkedList
    if(current != null){
      while(current.next != null){

        if(current.equals(n))
          return false;

        if(n.data.compareTo(current.next.data) < 0){
          n.next = current.next;
          current.next = n;
          this.size++;
          return true;
        }

        current = current.next;
      }

      // For adding to the end of MeteoriteLinkedList
      if(current.equals(n))
        return false;

      current.next = n;
      this.tail = current.next;
    }

    this.size++;
    return true;
  }



  /**
	 * Removes Meteorite object in sorted this MeteoriteLinkedList.
   * @param name the name value for the to be removed Meteorite object
   * @param id the ID value for the to be removed Meteorite object
	 * @return the Meteorite object if successfully removed, returns null if not found in this MeteoriteLinkedList
   * @throws IllegalArgumentException if the Meteorite object is null
	 */
  public Meteorite remove (String name, int id) {

    // Returns null if name is null
    if(name == null)
      return null;

    // Returns null if remove from empty this MeteoriteLinkedList
    if(head == null)
      return null;

    Meteorite rem = new Meteorite(name, id);

    // Remove Head
    if(this.head.data.equals(rem)){
      Meteorite data = this.head.data;
      this.head = this.head.next;
      return data;
    }

    Node current = this.head;

    while(current.next != null){

      //Remove Midway
      if(current.next.data.equals(rem)){
        Meteorite data = current.next.data;

        // Remove Tail
        if(current.next == this.tail){
          current.next = null;
          return data;
        }
        current.next = current.next.next;
        return data;
      }

      current = current.next;
    }
    return null;
  }



  /**
	 * Returns the string representation of this MeteoriteLinkedList.
	 * @return the string representation of this MeteoriteLinkedList object
	 */
  public String toString(){
    if(head == null)
      return null;

    Node current = head;
    String txt = "";
    while(current.next != null){
      txt = String.format(txt + "%s%n", current.data.toString());
      current = current.next;
    }
    return String.format(txt + "%s", current.data.toString());
  }



  private class Node implements Comparable<Node> {

    Meteorite data;
    Node next;

    Node (Meteorite data){
      this.data = data;
    }

    public String toString () {
      return data.toString();
    }

    public boolean equals(Object o) {
      if(this == o) return true;

      if(!(o instanceof Node)){
        return false;
      }

      Node other = (Node) o;

      if (!this.data.equals(other.data)){
        return false;
      }

      return true;
    }

    public int compareTo (Node n){
      return data.compareTo(n.data);
    }

  }

}
