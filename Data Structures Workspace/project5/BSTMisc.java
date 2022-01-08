package project5;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test methods for any of the methods not covered by the other BST test classes.
 * (This is for simple methods, like isEmpty() that only need a couple of tests.)
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class BSTMisc {

    // Test cases for isEmpty()

    @Test
    public void isEmptyTrueInteger() {
        BST<Integer> bst = new BST<>();
        assertTrue(bst.isEmpty());
    }

    @Test
    public void isEmptyTrueMeteorite() {
        BST<Meteorite> bst = new BST<>();
        assertTrue(bst.isEmpty());
    }

    @Test
    public void isEmptyFalseInteger() {
        assertFalse(INTEGER_BST.isEmpty());
    }

    @Test
    public void isEmptyFalseMeteorite() {
        assertFalse(TEST_METEORITE_BST_FULL.isEmpty());
    }

    // Test cases for iterator implementation.

    @Test
    public void iteratorEmptyBST() {
        Iterator<Meteorite> i = new BST<Meteorite>().iterator();
        assertFalse(i.hasNext());
    }

    @Test
    public void iteratorIntegerBST() {
        Iterator<Integer> it = INTEGER_BST.iterator();
        for (int i = 1; i <= 10; i++) {
            assertEquals(i, (int)it.next());
        }
    }

    @Test
    public void iteratorMeteoriteBST() {
        Iterator<Meteorite> i = TEST_METEORITE_BST_FULL.iterator();
        assertEquals(METEORITE_15, i.next());
        assertEquals(METEORITE_7, i.next());
        assertEquals(METEORITE_5, i.next());
        assertEquals(METEORITE_14, i.next());
        assertEquals(METEORITE_6, i.next());
        assertEquals(METEORITE_3, i.next());
        assertEquals(METEORITE_12, i.next());
        assertEquals(METEORITE_8, i.next());
        assertEquals(METEORITE_18, i.next());
        assertEquals(METEORITE_16, i.next());
        assertEquals(METEORITE_2, i.next());
        assertEquals(METEORITE_1, i.next());
        assertEquals(METEORITE_10, i.next());
        assertEquals(METEORITE_4, i.next());
        assertEquals(METEORITE_17, i.next());
        assertEquals(METEORITE_9, i.next());
        assertEquals(METEORITE_13, i.next());
        assertEquals(METEORITE_11, i.next());
    }

    // Test toString() method.

    @Test
    public void toStringEmptyInteger() {
        assertEquals("[]", new BST<Integer>().toString());
    }

    @Test
    public void toStringEmptyMeteorite() {
        assertEquals("[]", new BST<Meteorite>().toString());
    }

    @Test
    public void toStringInteger() {
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", INTEGER_BST.toString());
    }

    @Test
    public void toStringMeteorite() {
        assertEquals(
                "[Adipiscing              7 2005  94168   73.60000   20.40000, " +
                        "Amet                    5 2019   3555   23.70000  157.30000, " +
                        "Consectetur             6 2016   7947  -32.70000   33.50000, " +
                        "Dolor                   3 1860   3911  -80.20000 -131.90000, " +
                        "Elit                    8 1974   7333  -90.00000  -83.50000, " +
                        "Ipsum                   2 2002   5325  -31.00000  -70.80000, " +
                        "Lorem                   1 1975    234   76.60000  -81.90000, " +
                        "Sit                     4 1776   1963   -8.30000 -166.40000, " +
                        "Suspendisse             9 1969  55555   90.00000  -32.10000]",

                TEST_METEORITE_BST_HALF.toString()
        );
    }

    // Test toArray()

    @Test
    public void toArrayEmptyInteger() {
        Object[] arr = new BST<Integer>().toArray();
        assertEquals(0, arr.length);
    }

    @Test
    public void toArrayEmptyMeteorite() {
        Object[] arr = new BST<Meteorite>().toArray();
        assertEquals(0, arr.length);
    }

    @Test
    public void toArrayInteger() {
        Object[] arr = INTEGER_BST.toArray();
        for (int i = 0; i < 10; i++) {
            assertEquals(i+1, (int)arr[i]);
        }
    }

    @Test
    public void toArrayMeteorite() {
        Object[] arr = TEST_METEORITE_BST_FULL.toArray();
        assertEquals(METEORITE_15, arr[0]);
        assertEquals(METEORITE_7, arr[1]);
        assertEquals(METEORITE_5, arr[2]);
        assertEquals(METEORITE_14, arr[3]);
        assertEquals(METEORITE_6, arr[4]);
        assertEquals(METEORITE_3, arr[5]);
        assertEquals(METEORITE_12, arr[6]);
        assertEquals(METEORITE_8, arr[7]);
        assertEquals(METEORITE_18, arr[8]);
        assertEquals(METEORITE_16, arr[9]);
        assertEquals(METEORITE_2, arr[10]);
        assertEquals(METEORITE_1, arr[11]);
        assertEquals(METEORITE_10, arr[12]);
        assertEquals(METEORITE_4, arr[13]);
        assertEquals(METEORITE_17, arr[14]);
        assertEquals(METEORITE_9, arr[15]);
        assertEquals(METEORITE_13, arr[16]);
        assertEquals(METEORITE_11, arr[17]);
    }

}
