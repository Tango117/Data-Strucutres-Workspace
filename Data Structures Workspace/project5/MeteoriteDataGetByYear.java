package project5;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test cases for the getByYear() method in the MeteoriteData class.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class MeteoriteDataGetByYear {

    @Test(expected = IllegalArgumentException.class)
    public void getByYearNegativeOne() {
        TEST_METEORITE_DATA.getByYear(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByYearIntegerMin() {
        TEST_METEORITE_DATA.getByYear(Integer.MIN_VALUE);
    }

    /*
     * I thought about putting a test here that tests for year zero, but it would immediately
     * fail because Meteorites cannot have a year <= 0. Is there a good way to test for year = 0?
     */

    @Test
    public void getByYearValidButNoResults() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByYear(1766).iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void getByYearArbitrary1() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByYear(1995).iterator();
        
        assertEquals(METEORITE_17, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void getByYearArbitrary2() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByYear(2002).iterator();

        assertEquals(METEORITE_2, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void getByYearArbitrary3() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByYear(1866).iterator();

        assertEquals(METEORITE_12, it.next());
        assertEquals(METEORITE_18, it.next());
        assertEquals(METEORITE_11, it.next());

        assertFalse(it.hasNext());
    }

}