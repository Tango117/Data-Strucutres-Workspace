package project5;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test cases for the getRange() method in the BST class.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class BSTGetRange {

    @Test(expected = NullPointerException.class)
    public void testRangeNullPointerInteger1() {
        INTEGER_BST.getRange​(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testRangeNullPointerInteger2() {
        INTEGER_BST.getRange​(1, null);
    }

    @Test(expected = NullPointerException.class)
    public void testRangeNullPointerMeteorite1() {
        TEST_METEORITE_BST_FULL.getRange​(null, METEORITE_11);
    }

    @Test(expected = NullPointerException.class)
    public void testRangeNullPointerMeteorite2() {
        TEST_METEORITE_BST_FULL.getRange​(METEORITE_15, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRangeIllegalArgumentInteger() {
        INTEGER_BST.getRange​(10, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRangeIllegalArgumentMeteorite() {
        TEST_METEORITE_BST_FULL.getRange​(METEORITE_11, METEORITE_15);
    }

    @Test
    public void testRangeEmptyInteger() {
        BST<Integer> bst = new BST<>();
        assertEquals(0, bst.getRange​(1, 10).size());
    }

    @Test
    public void testRangeEmptyMeteorite() {
        BST<Meteorite> bst = new BST<>();
        assertEquals(0, bst.getRange​(METEORITE_15, METEORITE_11).size());
    }

    @Test
    public void testRangeIntegerAll() {
        ArrayList<Integer> al = INTEGER_BST.getRange​(1, 10);
        for (int i = 0; i < 10; i++) {
            assertEquals(i+1, (int)al.get(i));
        }
    }

    @Test
    public void testRangeIntegerHalf1() {
        int min = 1;
        int max = 5;

        ArrayList<Integer> al = INTEGER_BST.getRange​(min, max);
        for (int i = min; i <= max; i++) {
            assertEquals(i, (int)al.get(i-min));
        }

        assertEquals(max-min+1, al.size());
    }

    @Test
    public void testRangeIntegerHalf2() {
        int min = 6;
        int max = 10;

        ArrayList<Integer> al = INTEGER_BST.getRange​(min, max);
        for (int i = min; i <= max; i++) {
            assertEquals(i, (int)al.get(i-min));
        }

        assertEquals(max-min+1, al.size());
    }

    @Test
    public void testRangeIntegerArbitrary1() {
        int min = 4;
        int max = 8;

        ArrayList<Integer> al = INTEGER_BST.getRange​(min, max);
        for (int i = min; i <= max; i++) {
            assertEquals(i, (int)al.get(i-min));
        }

        assertEquals(max-min+1, al.size());
    }

    @Test
    public void testRangeIntegerArbitrary2() {
        int min = 2;
        int max = 7;

        ArrayList<Integer> al = INTEGER_BST.getRange​(min, max);
        for (int i = min; i <= max; i++) {
            assertEquals(i, (int)al.get(i-min));
        }

        assertEquals(max-min+1, al.size());
    }

    @Test
    public void testRangeMeteoriteAll() {
        ArrayList<Meteorite> al = TEST_METEORITE_BST_FULL.getRange​(METEORITE_15, METEORITE_11);
        assertEquals(METEORITE_15, al.get(0));
        assertEquals(METEORITE_7, al.get(1));
        assertEquals(METEORITE_5, al.get(2));
        assertEquals(METEORITE_14, al.get(3));
        assertEquals(METEORITE_6, al.get(4));
        assertEquals(METEORITE_3, al.get(5));
        assertEquals(METEORITE_12, al.get(6));
        assertEquals(METEORITE_8, al.get(7));
        assertEquals(METEORITE_18, al.get(8));
        assertEquals(METEORITE_16, al.get(9));
        assertEquals(METEORITE_2, al.get(10));
        assertEquals(METEORITE_1, al.get(11));
        assertEquals(METEORITE_10, al.get(12));
        assertEquals(METEORITE_4, al.get(13));
        assertEquals(METEORITE_17, al.get(14));
        assertEquals(METEORITE_9, al.get(15));
        assertEquals(METEORITE_13, al.get(16));
        assertEquals(METEORITE_11, al.get(17));

        assertEquals(18, al.size());
    }

    @Test
    public void testRangeMeteoriteHalf1() {
        ArrayList<Meteorite> al = TEST_METEORITE_BST_FULL.getRange​(METEORITE_15, METEORITE_18);
        assertEquals(METEORITE_15, al.get(0));
        assertEquals(METEORITE_7, al.get(1));
        assertEquals(METEORITE_5, al.get(2));
        assertEquals(METEORITE_14, al.get(3));
        assertEquals(METEORITE_6, al.get(4));
        assertEquals(METEORITE_3, al.get(5));
        assertEquals(METEORITE_12, al.get(6));
        assertEquals(METEORITE_8, al.get(7));
        assertEquals(METEORITE_18, al.get(8));

        assertEquals(9, al.size());
    }

    @Test
    public void testRangeMeteoriteHalf2() {
        ArrayList<Meteorite> al = TEST_METEORITE_BST_FULL.getRange​(METEORITE_16, METEORITE_11);
        assertEquals(METEORITE_16, al.get(0));
        assertEquals(METEORITE_2, al.get(1));
        assertEquals(METEORITE_1, al.get(2));
        assertEquals(METEORITE_10, al.get(3));
        assertEquals(METEORITE_4, al.get(4));
        assertEquals(METEORITE_17, al.get(5));
        assertEquals(METEORITE_9, al.get(6));
        assertEquals(METEORITE_13, al.get(7));
        assertEquals(METEORITE_11, al.get(8));

        assertEquals(9, al.size());
    }

    @Test
    public void testRangeMeteoriteArbitrary1() {
        ArrayList<Meteorite> al = TEST_METEORITE_BST_FULL.getRange​(METEORITE_12, METEORITE_10);
        assertEquals(METEORITE_12, al.get(0));
        assertEquals(METEORITE_8, al.get(1));
        assertEquals(METEORITE_18, al.get(2));
        assertEquals(METEORITE_16, al.get(3));
        assertEquals(METEORITE_2, al.get(4));
        assertEquals(METEORITE_1, al.get(5));
        assertEquals(METEORITE_10, al.get(6));

        assertEquals(7, al.size());
    }

    @Test
    public void testRangeMeteoriteArbitrary2() {
        ArrayList<Meteorite> al = TEST_METEORITE_BST_FULL.getRange​(METEORITE_5, METEORITE_8);
        assertEquals(METEORITE_5, al.get(0));
        assertEquals(METEORITE_14, al.get(1));
        assertEquals(METEORITE_6, al.get(2));
        assertEquals(METEORITE_3, al.get(3));
        assertEquals(METEORITE_12, al.get(4));
        assertEquals(METEORITE_8, al.get(5));

        assertEquals(6, al.size());
    }

}