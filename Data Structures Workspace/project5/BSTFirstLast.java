package project5;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the first() and last() methods in the BST class.
 * (Grouped together because of similar functionality and requirements.)
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class BSTFirstLast {

    // Test cases for first()

    @Test(expected = NoSuchElementException.class)
    public void firstIntegerEmpty() {
        BST<Integer> bst = new BST<>();
        bst.first();
    }

    @Test(expected = NoSuchElementException.class)
    public void firstMeteoriteEmpty() {
        BST<Meteorite> bst = new BST<>();
        bst.first();
    }

    @Test
    public void firstIntegerValid() {
        assertEquals(1, (int)TestObjects.INTEGER_BST.first());
    }

    @Test
    public void firstMeteoriteValid() {
        assertEquals(TestObjects.METEORITE_15, TestObjects.TEST_METEORITE_BST_FULL.first());
    }

    // Test cases for last()

    @Test(expected = NoSuchElementException.class)
    public void lastIntegerEmpty() {
        BST<Integer> bst = new BST<>();
        bst.last();
    }

    @Test(expected = NoSuchElementException.class)
    public void lastMeteoriteEmpty() {
        BST<Meteorite> bst = new BST<>();
        bst.last();
    }

    @Test
    public void lastIntegerValid() {
        assertEquals(10, (int)TestObjects.INTEGER_BST.last());
    }

    @Test
    public void lastMeteoriteValid() {
        assertEquals(TestObjects.METEORITE_11, TestObjects.TEST_METEORITE_BST_FULL.last());
    }

}