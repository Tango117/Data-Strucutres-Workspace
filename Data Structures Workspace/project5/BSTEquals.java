package project5;

import org.junit.Test;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test cases for the equals() method in the BST class.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
@SuppressWarnings("all")
public class BSTEquals {

	@Test
	public void equalsNullMeteorite() {
		assertFalse(TEST_METEORITE_BST_FULL.equals​(null));
	}

	@Test
	public void equalsNullInteger() {
		assertFalse(INTEGER_BST.equals​(null));
	}

	@Test
	public void equalsOtherMeteorite() {
		assertFalse(TEST_METEORITE_BST_FULL.equals​(INTEGER_BST));
	}

	@Test
	public void equalsOtherInteger() {
		assertFalse(INTEGER_BST.equals​(TEST_METEORITE_BST_FULL));
	}

	@Test
	public void equalsSelfMeteorite() {
		assertTrue(TEST_METEORITE_BST_FULL.equals​(TEST_METEORITE_BST_FULL));
	}

	@Test
	public void equalsSelfInteger() {
		assertTrue(INTEGER_BST.equals​(INTEGER_BST));
	}

	@Test
	public void equalsOtherEquivalentMeteorite() {
		BST<Meteorite> equivalent = new BST<Meteorite>() {
			{
				add(METEORITE_1);
				add(METEORITE_2);
				add(METEORITE_3);
				add(METEORITE_4);
				add(METEORITE_5);
				add(METEORITE_6);
				add(METEORITE_7);
				add(METEORITE_8);
				add(METEORITE_9);
				add(METEORITE_10);
				add(METEORITE_11);
				add(METEORITE_12);
				add(METEORITE_13);
				add(METEORITE_14);
				add(METEORITE_15);
				add(METEORITE_16);
				add(METEORITE_17);
				add(METEORITE_18);
			}
		};
		assertTrue(TEST_METEORITE_BST_FULL.equals​(equivalent));
	}

	@Test
	public void equalsOtherEquivalentInteger() {
		BST<Integer> equivalent = new BST<Integer>() {
			{
				add(5);
				add(3);
				add(2);
				add(4);
				add(1);
				add(10);
				add(8);
				add(6);
				add(7);
				add(9);
			}
		};
		assertTrue(INTEGER_BST.equals​(equivalent));
	}

}