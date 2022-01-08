package project5;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static project5.TestObjects.*;

/**
 * Test cases that explicitly test remove(), equals(), and iterator()
 * Cases also implicitly test add(), since elements must be added to the list before the other tests can occur.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
@SuppressWarnings("all")
public class MeteoriteDataMisc {

    // Test cases for equals()

    @Test
    public void equalsNull() {
        assertFalse(TEST_METEORITE_DATA.equals(null));
    }

    @Test
    public void equalsOtherTypeString() {
        assertFalse(TEST_METEORITE_DATA.equals("Test"));
    }

    @Test
    public void equalsOtherTypeBST() {
        assertFalse(TEST_METEORITE_DATA.equals(TEST_METEORITE_BST_FULL));
    }

    @Test
    public void equalsSelf() {
        assertTrue(TEST_METEORITE_DATA.equals(TEST_METEORITE_DATA));
    }

    @Test
    public void equalsEquivalent() {
        MeteoriteData equivalent = new MeteoriteData() {{
            add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
            add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
            add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
        }};

        assertTrue(TEST_METEORITE_DATA.equals(equivalent));
    }

    @Test
    public void equalsEquivalentAfterSameRemove() {
        MeteoriteData e1 = new MeteoriteData() {{
            add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
            add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
            add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
        }};

        MeteoriteData e2 = new MeteoriteData() {{
            add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
            add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
            add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
        }};

        e1.remove(METEORITE_1);
        e1.remove(METEORITE_5);
        e1.remove(METEORITE_10);
        e1.remove(METEORITE_15);

        e2.remove(METEORITE_1);
        e2.remove(METEORITE_10);
        e2.remove(METEORITE_5);
        e2.remove(METEORITE_15);

        assertTrue(e1.equals(e2));
    }

    @Test
    public void equalsEquivalentAfterDifferentRemove() {
        MeteoriteData e1 = new MeteoriteData() {{
            add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
            add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
            add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
        }};

        MeteoriteData e2 = new MeteoriteData() {{
            add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
            add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
            add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
        }};

        e1.remove(METEORITE_1);
        e1.remove(METEORITE_5);
        e1.remove(METEORITE_10);
        e1.remove(METEORITE_15);

        e2.remove(METEORITE_1);
        e2.remove(METEORITE_10);
        e2.remove(METEORITE_5);
        e2.remove(METEORITE_16);

        assertFalse(e1.equals(e2));
    }

    // Test cases for iterator()

    @Test
    public void iteratorEmptyBST() {
        Iterator<Meteorite> i = new MeteoriteData().iterator();
        assertFalse(i.hasNext());
    }

    @Test
    public void iteratorAfterRemove() {
        MeteoriteData e = new MeteoriteData() {{
            add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
            add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
            add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
        }};

        e.remove(METEORITE_1);
        e.remove(METEORITE_5);
        e.remove(METEORITE_10);
        e.remove(METEORITE_15);

        Iterator<Meteorite> i = e.iterator();
        assertEquals(METEORITE_7, i.next());
        assertEquals(METEORITE_14, i.next());
        assertEquals(METEORITE_6, i.next());
        assertEquals(METEORITE_3, i.next());
        assertEquals(METEORITE_12, i.next());
        assertEquals(METEORITE_8, i.next());
        assertEquals(METEORITE_18, i.next());
        assertEquals(METEORITE_16, i.next());
        assertEquals(METEORITE_2, i.next());
        assertEquals(METEORITE_4, i.next());
        assertEquals(METEORITE_17, i.next());
        assertEquals(METEORITE_9, i.next());
        assertEquals(METEORITE_13, i.next());
        assertEquals(METEORITE_11, i.next());
    }

    @Test
    public void iteratorWithRemove() {
        Iterator<Meteorite> i = TEST_METEORITE_DATA.iterator();
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

}