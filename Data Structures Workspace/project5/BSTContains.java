package project5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases for contains() method from the BST class.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class BSTContains {

    @Test
    public void intContainsArbitrary() {
    	System.out.println("hi");
    	System.out.println(TestObjects.INTEGER_BST.toStringTree());
        assertTrue(TestObjects.INTEGER_BST.contains​(4));
    }

    @Test
    public void intContainsBeginning() {
        assertTrue(TestObjects.INTEGER_BST.contains​(1));
    }

    @Test
    public void intContainsEnd() {
        assertTrue(TestObjects.INTEGER_BST.contains​(10));
    }

    @Test(expected = NullPointerException.class)
    public void intContainsNull() {
        TestObjects.INTEGER_BST.contains​(null);
    }

    @Test(expected = ClassCastException.class)
    public void intContainsInvalidObjectString() {
        TestObjects.INTEGER_BST.contains​("Test");
    }

    @Test(expected = ClassCastException.class)
    public void intContainsInvalidObjectOther() {
        TestObjects.INTEGER_BST.contains​(TestObjects.METEORITE_1);
    }


    @Test(expected = ClassCastException.class)
    public void intContainsInvalidObjectSelf() {
        TestObjects.INTEGER_BST.contains​(TestObjects.INTEGER_BST);
    }

    @Test
    public void intContainsFalseOneBelow() {
        assertFalse(TestObjects.INTEGER_BST.contains​(0));
    }

    @Test
    public void intContainsFalseOneAbove() {
        assertFalse(TestObjects.INTEGER_BST.contains​(11));
    }

    @Test
    public void intContainsFalseMinVal() {
        assertFalse(TestObjects.INTEGER_BST.contains​(Integer.MIN_VALUE));
    }

    @Test
    public void intContainsFalseMaxVal() {
        assertFalse(TestObjects.INTEGER_BST.contains​(Integer.MAX_VALUE));
    }

    @Test
    public void intContainsFalseArbitrary1() {
        assertFalse(TestObjects.INTEGER_BST.contains​(14579));
    }

    @Test
    public void intContainsFalseArbitrary2() {
        assertFalse(TestObjects.INTEGER_BST.contains​(25246789));
    }

    // TESTS FOR METEORITE BST

    @Test
    public void metContainsArbitrary() {
        assertTrue(TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.METEORITE_5));
    }

    @Test
    public void metContainsBeginning() {
        assertTrue(TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.METEORITE_1));
    }

    @Test
    public void metContainsEnd() {
        assertTrue(TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.METEORITE_9));
    }

    @Test(expected = NullPointerException.class)
    public void metContainsNull() {
        TestObjects.TEST_METEORITE_BST_HALF.contains​(null);
    }

    @Test(expected = ClassCastException.class)
    public void metContainsInvalidObjectString() {
        TestObjects.TEST_METEORITE_BST_HALF.contains​("Test");
    }

    @Test(expected = ClassCastException.class)
    public void metContainsInvalidObjectOther() {
        TestObjects.TEST_METEORITE_BST_HALF.contains​(437850);
    }


    @Test(expected = ClassCastException.class)
    public void metContainsInvalidObjectSelf() {
        TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.TEST_METEORITE_BST_HALF);
    }

    @Test
    public void metContainsFalseOneAbove() {
        assertFalse(TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.METEORITE_10));
    }

    @Test
    public void metContainsFalseArbitrary1() {
        assertFalse(TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.METEORITE_14));
    }

    @Test
    public void metContainsFalseArbitrary2() {
        assertFalse(TestObjects.TEST_METEORITE_BST_HALF.contains​(TestObjects.METEORITE_18));
    }

}