package project5;

import java.util.*;

/**
 * This class stores Meteorite objects.
 * This class uses a LinkedList storing system.
 * This class sorts Meteorite objects using Meteorite.compareTo().
 *
 * @author Brendan Tang, Joanna Klukowska
 * @version 12/6/2020
 */

public class BST<T extends Comparable<T>> {

	private BSTNode root; // reference to the root node of the tree
	private int size; // number of values stored in this tree
	private Comparator<T> comparator; // comparator object to overwrite the
	// natural ordering of the elements

	private boolean found; // helper variable used by the remove methods
	private boolean added; // helper variable used by the add method
	private boolean contain; // helper variable used by the contain method
	private int index; // helper variable used by the toArray method
	private Object[] treeArray; // helper variable used by the toArray method
	private ArrayList<T> treeRange;

	/**
	 * Constructs a new, empty tree, sorted according to the natural ordering of
	 * its elements.
	 */
	public BST() {

		root = null;
		size = 0;
		comparator = null;

	}

	/**
	 * Constructs a new, empty tree, sorted according to the specified
	 * comparator.
	 */
	public BST(Comparator<T> comparator) {

		this.comparator = comparator;

	}

	/**
	 * Adds the specified element to this tree if it is not already present. If
	 * this tree already contains the element, the call leaves the tree
	 * unchanged and returns false.
	 * 
	 * @param data
	 *            element to be added to this tree
	 * @return true if this tree did not already contain the specified element
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public boolean add(T data) {

		added = false;

		if (data == null)
			return added;

		// replace root with the reference to the tree after the new
		// value is added
		root = add(data, root);
		// update the size and return the status accordingly

		if (added)
			size++;

		return added;

	}

	/**
	 * Actual recursive implementation of add.
	 *
	 * This function returns a reference to the subtree in which the new value
	 * was added.
	 *
	 * @param data
	 *            element to be added to this tree
	 * 
	 * @param node
	 *            node at which the recursive call is made
	 */
	private BSTNode add(T data, BSTNode node) {

		if (node == null) {
			added = true;
			return new BSTNode(data);
		}

		// decide how comparisons should be done
		int comp = 0;

		if (comparator == null) // use natural ordering of the elements
			comp = node.data.compareTo(data);
		else // use the comparator
			comp = comparator.compare(node.data, data);

		// find the location to add the new value
		if (comp > 0) { // add to the left subtree
			node.left = add(data, node.left);
		} else if (comp < 0) { // add to the right subtree
			node.right = add(data, node.right);
		} else { // duplicate found, do not add
			added = false;
			return node;
		}

		return node;

	}

	/**
	 * Removes the specified element from this tree if it is present. Returns
	 * true if this tree contained the element (or equivalently, if this tree
	 * changed as a result of the call). (This tree will not contain the element
	 * once the call returns.)
	 * 
	 * @param target
	 *            object to be removed from this tree, if present
	 * @return true if this set contained the specified element
	 * @throws NullPointerException
	 *             if the specified element is null
	 */
	public boolean remove(T target) {

		// replace root with a reference to the tree after target was removed
		root = recRemove(target, root);

		// update the size and return the status accordingly
		if (found)
			size--;

		return found;

	}

	/**
	 * Actual recursive implementation of remove method: find the node to
	 * remove.
	 *
	 * This function recursively finds and eventually removes the node with the
	 * target element and returns the reference to the modified tree to the
	 * caller.
	 * 
	 * @param target
	 *            object to be removed from this tree, if present
	 * 
	 * @param node
	 *            node at which the recursive call is made
	 */
	private BSTNode recRemove(T target, BSTNode node) {

		if (node == null) { // value not found
			found = false;
			return node;
		}

		// decide how comparisons should be done
		int comp = 0;

		if (comparator == null) // use natural ordering of the elements
			comp = target.compareTo(node.data);
		else // use the comparator
			comp = comparator.compare(target, node.data);

		if (comp < 0) // target might be in a left subtree
			node.left = recRemove(target, node.left);
		else if (comp > 0) // target might be in a right subtree
			node.right = recRemove(target, node.right);
		else { // target found, now remove it
			node = removeNode(node);
			found = true;
		}

		return node;

	}

	/**
	 * Actual recursive implementation of remove method: perform the removal.
	 *
	 * @param target
	 *            the item to be removed from this tree
	 * 
	 * @return a reference to the node itself, or to the modified subtree
	 */
	private BSTNode removeNode(BSTNode node) {

		T data;

		if (node.left == null) // handle the leaf and one child node with right
								// subtree
			return node.right;
		else if (node.right == null) // handle one child node with left subtree
			return node.left;
		else { // handle nodes with two children
			data = getPredecessor(node.left);
			node.data = data;
			node.left = recRemove(data, node.left);
			return node;
		}

	}

	/**
	 * Returns the information held in the rightmost node of subtree
	 *
	 * @param subtree
	 *            root of the subtree within which to search for the rightmost
	 *            node
	 * 
	 * @return returns data stored in the rightmost node of subtree
	 */
	private T getPredecessor(BSTNode subtree) {

		if (subtree == null) // this should not happen
			throw new NullPointerException("getPredecessor called with an empty subtree");

		BSTNode temp = subtree;

		while (temp.right != null)
			temp = temp.right;

		return temp.data;

	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {

		return size;

	}

	public String toStringTree() {

		StringBuffer sb = new StringBuffer();
		toStringTree(sb, root, 0);
		return sb.toString();

	}

	// uses preorder traversal to display the tree
	// WARNING: will not work if the data.toString returns more than one line
	private void toStringTree(StringBuffer sb, BSTNode node, int level) {

		// display the node
		if (level > 0) {
			for (int i = 0; i < level - 1; i++) {
				sb.append("   ");
			}
			sb.append("|--");
		}

		if (node == null) {
			sb.append("->\n");
			return;
		} else {
			sb.append(node.data + "\n");
		}

		// display the left subtree
		toStringTree(sb, node.left, level + 1);
		// display the right subtree
		toStringTree(sb, node.right, level + 1);

	}

	
	
	/**
	 * Returns true if this tree contains the specified element.
	 * More formally, returns true if and only if this tree contains an element e such that Objects.equals(o, e).
	 * @param o object to be checked for containment in this set
	 * @return true if this tree contains the specified element
	 * @throws NullPointerException natural ordering, or its comparator does not permit null elements
	 */
	public boolean contains​(Object o) throws NullPointerException {

		if (o == null && comparator == null)
			throw new NullPointerException("Cannot search for null object");
		if (this.root.data.equals(o))
			return true;

		T data = (T) o;
		contain = false;
		contain = contains(data, root);

		return contain;
	}

	
	
	
	private boolean contains(T data, BSTNode n) {

		if (n == null)
			return false;
		if(Objects.equals(data, n.data))
			return true;
		
		// decide how comparisons should be done
		int comp = 0;

		if (comparator == null) // use natural ordering of the elements
			comp = n.data.compareTo(data);
		else // use the comparator
			comp = comparator.compare(n.data, data);

		if (comp > 0)
			return contains(data, n.left);
		else
			return contains(data, n.right);

	}
	
	
	
	/**
	 * Returns true if this tree contains no elements.
	 * @return true if this tree contains no elements
	 */
	public boolean isEmpty() {

		if (this.root == null)
			return true;
		return false;

	}

	
	
	/**
	 * Returns an iterator over the elements in this tree in ascending order.
	 * @return an iterator over the elements in this tree in ascending order
	 */
	public Iterator<T> iterator() {
		
		ArrayList<T> itr;
		
		if(this.isEmpty()){
			itr = new ArrayList<T>();
			return itr.iterator();
		}else{
			itr = this.getRange​(this.first(), this.last());
			return itr.iterator();
		}

	}

	
	
	/**
	 * Returns a collection whose elements range from fromElement, inclusive, to toElement, inclusive.
	 * The returned collection/list is backed by this tree, 
	 * so changes in the returned list are reflected in this tree, and vice-versa.
	 * The returned collection should be organized according to the natural ordering of the elements.
	 * @param fromElement low endpoint (inclusive) of the returned collection
	 * @param toElement high endpoint (inclusive) of the returned collection
	 * @return a collection containing a portion of this tree whose elements range from fromElement, inclusive, to toElement, inclusive
	 * @throws IllegalArgumentException if fromElement is greater than toElement
	 * @throws NullPointerException if fromElement or toElement is null
	 */
	public ArrayList<T> getRange​(T fromElement, T toElement) throws IllegalArgumentException, NullPointerException {

		if (fromElement == null || toElement == null)
			throw new NullPointerException("fromElement or toElement is null");

		int comp = 0;

		if (comparator == null) // use natural ordering of the elements
			comp = fromElement.compareTo(toElement);
		else // use the comparator
			comp = comparator.compare(fromElement, toElement);

		if (comp > 0)
			throw new IllegalArgumentException("fromElement cannot be greater than toElement");

		treeRange = new ArrayList<T>();
		getRangeRec(root, fromElement, toElement);
		return treeRange;

	}

	
	
	private void getRangeRec(BSTNode n, T from, T to) {

		if(n == null)
			return;
		
		int comp1 = 0;
		int comp2 = 0;

		if (comparator == null){
			comp1 = from.compareTo(n.data);
			comp2 = to.compareTo(n.data);
		}else{ 
			comp1 = comparator.compare(from, n.data);
			comp2 = comparator.compare(to, n.data);
		}
		
		if (comp1 < 0) { 
            getRangeRec(n.left, from, to);
        } 
  
        if (comp1 <= 0 && comp2 >= 0) { 
            treeRange.add(n.data);
        } 
  
        if (comp2 > 0) { 
            getRangeRec(n.right, from, to);
        } 
		

	}

	
	
	/**
	 * Returns the first (lowest) element currently in this tree.
	 * @return the first (lowest) element currently in this tree
	 * @throws NoSuchElementException if this tree is empty
	 */
	public T first() throws NoSuchElementException {

		if (root == null)
			throw new NoSuchElementException("Binary Tree is empty");
		return firstItr(root);

	}
	
	

	private T firstItr(BSTNode n) {

		if (n.left == null) {
			return n.data;
		}

		return firstItr(n.left);
	}

	
	
	/**
	 * Returns the last (highest) element currently in this tree.
	 * @return the last (highest) element currently in this tree
	 * @throws NoSuchElementException if this tree is empty
	 */
	public T last() throws NoSuchElementException {

		if (root == null)
			throw new NoSuchElementException("Binary Tree is empty");
		return lastItr(root);

	}
	
	

	private T lastItr(BSTNode n) {

		if (n.right == null) {
			return n.data;
		}

		return lastItr(n.right);
	}

	
	
	/**
	 * Compares the specified object with this tree for equality. 
	 * Returns true if the given object is also a tree, the two trees have the same size, 
	 * and the inorder traversal of the two trees returns the same nodes in the same order.
	 * @param obj to see if equals
	 * @return a string representation of this collection
	 */
	public boolean equals​(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BST))
			return false;
		BST bst = (BST) obj;
		if (this.size() != bst.size())
			return false;
		if (this.toString().equals(bst.toString()))
			return true;
		return false;

	}

	
	
	/**
	 * Returns a string representation of this tree. 
	 * The string representation consists of a list of the tree's elements 
	 * in the order they are returned by its iterator (inorder traversal), 
	 * enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space).
	 * Elements are converted to strings as by String.valueOf(Object).
	 */
	public String toString() {

		if (root == null)
			return "[]";

		String list = this.toStringRec(root);
		return "[" + list.substring(0, list.length() - 2) + "]";

	}

	private String toStringRec(BSTNode n) {

		if (n.left == null && n.right == null)
			return String.valueOf(n.data) + ", ";
		else if (n.left == null)
			return String.valueOf(n.data) + ", " + this.toStringRec(n.right);
		else if (n.right == null)
			return this.toStringRec(n.left) + String.valueOf(n.data) + ", ";
		else
			return this.toStringRec(n.left) + String.valueOf(n.data) + ", " + this.toStringRec(n.right);

	}

	/**
	 * This function returns an array containing all the elements returned by this tree's iterator,
	 * in the same order, stored in consecutive elements of the array, starting with index 0. 
	 * The length of the returned array is equal to the number of elements returned by the iterator.
	 * @return an array, whose runtime component type is Object, containing all of the elements in this tree
	 */
	public Object[] toArray() {

		treeArray = new Object[size];

		if (root == null) {
			return treeArray;
		}

		index = 0;
		toArrayRec(root);

		return treeArray;

	}
	
	

	private void toArrayRec(BSTNode n) {

		if (n.left != null)
			toArrayRec(n.left);

		treeArray[index] = n.data;
		index++;

		if (n.right != null)
			toArrayRec(n.right);

	}
	
	

	/**
	 * Node class for this BST
	 */
	private class BSTNode implements Comparable<BSTNode> {

		T data;
		BSTNode left;
		BSTNode right;

		public BSTNode(T data) {
			this.data = data;
		}

		public BSTNode(T data, BSTNode left, BSTNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public int compareTo(BSTNode other) {
			if (BST.this.comparator == null)
				return this.data.compareTo(other.data);
			else
				return comparator.compare(this.data, other.data);
		}
	}

}
