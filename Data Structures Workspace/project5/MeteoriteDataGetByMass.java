package project5;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test cases for the getByMass() method in the MeteoriteData class.
 *
 * @author Harrison Douglass
 * @version 1.1
 */
public class MeteoriteDataGetByMass {

    @Test(expected = IllegalArgumentException.class)
    public void getByMassBothParamsInvalid() {
        TEST_METEORITE_DATA.getByMass(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByMassMassInvalid() {
        TEST_METEORITE_DATA.getByMass(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByMassDeltaInvalid() {
        TEST_METEORITE_DATA.getByMass(2, -1);
    }

    @Test
    public void getByMassEmptyCollection() {
        assertNull(new MeteoriteData().getByMass(50, 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByMassEmptyCollectionBothParamsInvalid() {
        new MeteoriteData().getByMass(-1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByMassEmptyCollectionMassInvalid() {
        new MeteoriteData().getByMass(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByMassEmptyCollectionDeltaInvalid() {
        new MeteoriteData().getByMass(2, -1);
    }

    @Test
    public void getByMassValidButNoResults() {
    	System.out.println(TEST_METEORITE_DATA.getByMass(1294, 357));
        assertNull(TEST_METEORITE_DATA.getByMass(1294, 357));
    }

    @Test
    public void getByMassArbitrary1() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByMass(2374, 335).iterator();

        assertEquals(METEORITE_16, it.next());

        assertFalse(it.hasNext());
    }

    @Test
    public void getByMassArbitrary2() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByMass(916, 831).iterator();

        assertEquals(METEORITE_12, it.next()); // Dolor                  30 1875    645   49.40000   90.20000
        assertEquals(METEORITE_1, it.next());  // Lorem                   1 1975    234   76.60000  -81.90000
        assertEquals(METEORITE_11, it.next()); // Volutpat                2 1866    654   55.00000  112.00000

        assertFalse(it.hasNext());
    }

    @Test
    public void getByMassArbitrary3() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByMass(4092, 616).iterator();

        assertEquals(METEORITE_5, it.next());  // Amet                    5 2019   3555   23.70000  157.30000
        assertEquals(METEORITE_3, it.next());  // Dolor                   3 1860   3911  -80.20000 -131.90000

        assertFalse(it.hasNext());
    }

    @Test
    public void getByMassArbitrary4() {
        Iterator<Meteorite> it = TEST_METEORITE_DATA.getByMass(7088, 855).iterator();

        assertEquals(METEORITE_14, it.next()); // Amet                   50 1855   7353   76.80000   57.40000
        assertEquals(METEORITE_8, it.next());  // Elit                    8 1974   7333  -90.00000  -83.50000
        assertEquals(METEORITE_10, it.next()); // Lorem                  10 1901   7333   26.40000  137.50000
        assertEquals(METEORITE_13, it.next()); // Turpis                  4 1922   6308  -77.50000  -77.00000

        assertFalse(it.hasNext());
    }

}