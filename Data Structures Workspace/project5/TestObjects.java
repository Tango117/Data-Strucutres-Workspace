package project5;

import org.junit.Test;

/**
 * Test meteorites and data structures containing meteorites.
 * Note: This class contains no actual test cases, but is required for test cases in other classes.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class TestObjects {

    // Test Integer BST

    public static final BST<Integer> INTEGER_BST = new BST<Integer>() {{
        add(5); add(3); add(2); add(4); add(1); add(10); add(8); add(6); add(7); add(9);
    }};

    // Test Meteorite Objects

    public static final Meteorite METEORITE_1 = new Meteorite("Lorem", 1) {{
        setMass(234); setYear(1975); setLocation(new Location(76.6, -81.9));
    }};

    public static final Meteorite METEORITE_2 = new Meteorite("Ipsum", 2) {{
        setMass(5325); setYear(2002); setLocation(new Location(-31.0, -70.8));
    }};

    public static final Meteorite METEORITE_3 = new Meteorite("Dolor", 3) {{
        setMass(3911); setYear(1860); setLocation(new Location(-80.2, -131.9));
    }};

    public static final Meteorite METEORITE_4 = new Meteorite("Sit", 4) {{
        setMass(1963); setYear(1776); setLocation(new Location(-8.3, -166.4));
    }};

    public static final Meteorite METEORITE_5 = new Meteorite("Amet", 5) {{
        setMass(3555); setYear(2019); setLocation(new Location(23.7, 157.3));
    }};

    public static final Meteorite METEORITE_6 = new Meteorite("Consectetur", 6) {{
        setMass(7947); setYear(2016); setLocation(new Location(-32.7, 33.5));
    }};

    public static final Meteorite METEORITE_7 = new Meteorite("Adipiscing", 7) {{
        setMass(94168); setYear(2005); setLocation(new Location(73.6, 20.4));
    }};

    public static final Meteorite METEORITE_8 = new Meteorite("Elit", 8) {{
        setMass(7333); setYear(1974); setLocation(new Location(-90.0, -83.5));
    }};

    public static final Meteorite METEORITE_9 = new Meteorite("Suspendisse", 9) {{
        setMass(55555); setYear(1969); setLocation(new Location(90.0, -32.1));
    }};

    // Additional meteorite test objects, duplicate names and/or ID's.

    public static final Meteorite METEORITE_10 = new Meteorite("Lorem", 10) {{
        setMass(7333); setYear(1901); setLocation(new Location(26.4, 137.5));
    }};

    public static final Meteorite METEORITE_11 = new Meteorite("Volutpat", 2) {{
        setMass(654); setYear(1866); setLocation(new Location(55.0, 112.0));
    }};

    public static final Meteorite METEORITE_12 = new Meteorite("Dolor", 30) {{
        setMass(645); setYear(1866); setLocation(new Location(49.4, 90.2));
    }};

    public static final Meteorite METEORITE_13 = new Meteorite("Turpis", 4) {{
        setMass(6308); setYear(1922); setLocation(new Location(-77.5, -77.0));
    }};

    public static final Meteorite METEORITE_14 = new Meteorite("Amet", 50) {{
        setMass(7353); setYear(1855); setLocation(new Location(76.8, 57.4));
    }};

    public static final Meteorite METEORITE_15 = new Meteorite("Adipiscing", 6) {{
        setMass(9502); setYear(1900); setLocation(new Location(47.8, 58.1));
    }};

    public static final Meteorite METEORITE_16 = new Meteorite("Fringilla", 70) {{
        setMass(2049); setYear(1919); setLocation(new Location(60.4, -103.8));
    }};

    public static final Meteorite METEORITE_17 = new Meteorite("Suspendisse", 8) {{
        setMass(9117); setYear(1995); setLocation(new Location(66.9, -123.3));
    }};

    public static final Meteorite METEORITE_18 = new Meteorite("Faucibus", 90) {{
        setMass(4721); setYear(1866); setLocation(new Location(58.5, -144.4));
    }};

    // Test meteorite data structures. BSTs sort by year to make order testing easier.

    public static final BST<Meteorite> TEST_METEORITE_BST_FULL = new BST<Meteorite>() {{
        add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
        add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
        add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
    }};

    public static final BST<Meteorite> TEST_METEORITE_BST_HALF = new BST<Meteorite>() {{
        add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5);
        add(METEORITE_6); add(METEORITE_7); add(METEORITE_8); add(METEORITE_9);
    }};

    public static final MeteoriteData TEST_METEORITE_DATA = new MeteoriteData() {{
        add(METEORITE_1); add(METEORITE_2); add(METEORITE_3); add(METEORITE_4); add(METEORITE_5); add(METEORITE_6);
        add(METEORITE_7); add(METEORITE_8); add(METEORITE_9); add(METEORITE_10); add(METEORITE_11); add(METEORITE_12);
        add(METEORITE_13); add(METEORITE_14); add(METEORITE_15); add(METEORITE_16); add(METEORITE_17); add(METEORITE_18);
    }};

}