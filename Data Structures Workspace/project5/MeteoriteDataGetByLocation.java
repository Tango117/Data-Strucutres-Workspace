package project5;

import org.junit.Test;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test cases for the getByLocation() method in the MeteoriteData class.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class MeteoriteDataGetByLocation {

    public static Location LOCATION_0 = new Location(0, 0);
    public static Location LOCATION_1 = new Location(-81.4, 123.7);
    public static Location LOCATION_2 = new Location(-29.0, -120.5);
    public static Location LOCATION_3 = new Location(58.0, 1.2);

    @Test(expected = IllegalArgumentException.class)
    public void getByLocationNullLoc() {
        TEST_METEORITE_DATA.getByLocation(null);
    }

    @Test
    public void getByLocationEmptyData() {
        assertNull(new MeteoriteData().getByLocation(LOCATION_0));
    }

    @Test
    public void getByLocationArbitrary0() {
        assertEquals(METEORITE_6, TEST_METEORITE_DATA.getByLocation(LOCATION_0));
    }

    @Test
    public void getByLocationArbitrary1() {
        assertEquals(METEORITE_8, TEST_METEORITE_DATA.getByLocation(LOCATION_1));
    }

    @Test
    public void getByLocationArbitrary2() {
        assertEquals(METEORITE_2, TEST_METEORITE_DATA.getByLocation(LOCATION_2));
    }

    @Test
    public void getByLocationArbitrary3() {
        assertEquals(METEORITE_7, TEST_METEORITE_DATA.getByLocation(LOCATION_3));
    }

}