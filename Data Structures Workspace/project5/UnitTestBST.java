package project5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UnitTestBST {

	@Test
	public void testFirst() {
		try {
			BST<Integer> binTree = new BST<>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			binTree.add(i1);
			binTree.add(i2);
			binTree.add(i3);
			binTree.add(i4);
			binTree.add(i5);
			Integer s = binTree.first();
			assertEquals("The string is unsuccessfully", i5, s);
		} catch (IllegalArgumentException ex) {
			fail("Unknown exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
	
	
	
	@Test
	public void testLast() {
		try {
			BST<Integer> binTree = new BST<>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			binTree.add(i1);
			binTree.add(i2);
			binTree.add(i3);
			binTree.add(i4);
			binTree.add(i5);
			Integer s = binTree.last();
			assertEquals("The string is unsuccessfully", i1, s);
		} catch (IllegalArgumentException ex) {
			fail("Unknown exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
	
	
	
	@Test
	public void testToString() {
		try {
			BST<Integer> binTree = new BST<>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			binTree.add(i1);
			binTree.add(i2);
			binTree.add(i3);
			binTree.add(i4);
			binTree.add(i5);
			String s = binTree.toString();
			assertEquals("The string is unsuccessfully", "[14, 31, 42, 45, 48]", s);
		} catch (IllegalArgumentException ex) {
			fail("Unknown exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
	
	
	
	@Test
	public void testEqualsTrue() {
		try {
			BST<Integer> binTree1 = new BST<>();
			BST<Integer> binTree2 = new BST<>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			
			binTree1.add(i1);
			binTree1.add(i2);
			binTree1.add(i3);
			binTree1.add(i4);
			binTree1.add(i5);
			
			binTree2.add(i1);
			binTree2.add(i2);
			binTree2.add(i3);
			binTree2.add(i4);
			binTree2.add(i5);
			
			assertTrue("This should be true, is false", binTree1.equals​(binTree2));
		} catch (IllegalArgumentException ex) {
			fail("Unknown exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
	
	
	
	@Test
	public void testEqualsFalse() {
		try {
			BST<Integer> binTree1 = new BST<>();
			BST<Integer> binTree2 = new BST<>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			
			binTree1.add(i1);
			binTree1.add(i2);
			binTree1.add(i3);
			binTree1.add(i4);
			binTree1.add(i5);
			
			binTree2.add(i5);
			binTree2.add(i1);
			binTree2.add(i2);
			binTree2.add(i3);
			binTree2.add(i4);
			
			assertTrue("This should be true, is false", !binTree1.equals​(binTree2));
		} catch (IllegalArgumentException ex) {
			fail("Unknown exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
	
	
	
	@Test
	public void testToArray() {
		try {
			BST<Integer> binTree = new BST<>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			binTree.add(i1);
			binTree.add(i2);
			binTree.add(i3);
			binTree.add(i4);
			binTree.add(i5);
			Object[] result = binTree.toArray();	
			
			Object[] ans = new Object[]{14, 31, 42, 45, 48};
			assertEquals("The array is unsuccessfully", ans, result);
		} catch (IllegalArgumentException ex) {
			fail("Unknown exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
	
	
	
	@Test
	public void testGetRange() {
		try {
			BST<Integer> binTree = new BST<Integer>();
			Integer i1 = 48;
			Integer i2 = 31;
			Integer i3 = 42;
			Integer i4 = 45;
			Integer i5 = 14;
			Integer i6 = 14;
			Integer i7 = 14;
			binTree.add(i1);
			binTree.add(i2);
			binTree.add(i3);
			binTree.add(i4);
			binTree.add(i5);
			ArrayList<Integer> result = binTree.getRange​(i6, i1);
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(i5);
			ans.add(i3);
			ans.add(i1);
			ans.add(i2);
			ans.add(i4);
			
			assertEquals("The array is unsuccessfully", ans, result);
		} catch (IllegalArgumentException ex) {
			fail("Illegal exception thrown");
		} catch (Exception ex) {
			fail("Unknown exception thrown.");
		}
	}
}
