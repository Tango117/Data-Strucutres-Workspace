package project5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test runs of the complete FallenStars program.
 *
 * Because each implementation of the program is slightly different, these tests do not test whether or not the run
 * completed correctly, that is up to you to test yourself given the output of the program and the expected output.
 *
 * These tests will only fail if an exception is thrown during the run or something else goes catastrophically wrong.
 * NOTE: If you use System.exit(...) to exit the program in any place, some of these tests may fail unexpectedly.
 *
 * These runs are adapted from the run descriptions for the Project 2 runs in Gradescope.
 *
 * @author Harrison Douglass
 * @version 1.0
 */
public class FallenStarsRuns {

    // CHANGE THE LOCATION OF THE INPUT FILE FOR THE RUNS TO GO CORRECTLY.
    private static final String INPUT_FILE = "/Users/brendantang/Downloads/nyu-cs102-project-tests-main/project5/Meteorite_Landings.csv";

    /**
     * Test to make sure that the input file exists.
     */
    @Test
    public void testInputFileValidity() {
        File input = new File(INPUT_FILE);
        assertTrue(input.exists());
    }

    private InputStream systemIn;
    private ByteArrayInputStream testIn;

    /**
     * Before each test, sets systemIn to the value of System.in to preserve it.
     */
    @Before
    public void preserveInput() {
        systemIn = System.in;
    }

    /**
     * After each test, restores System.in() to its former value.
     */
    @After
    public void restoreInput() {
        testIn = null;
        System.setIn(systemIn);
    }

    /**
     * Helper method to provide the command line input for a given test.
     * @param data The input that the program should process (as a String)
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * Run that does not specify the input file as a command-line argument.
     *
     * Expected: Program should print an error to an error stream and terminate.
     */
    @Test
    public void run1() {
        FallenStars.main(new String[]{});
    }

    /**
     * Run that specifies an input file, but that file does not exist.
     *
     * Expected: Program should print an error to an error stream and terminate.
     */
    @Test
    public void run2() {
        FallenStars.main(new String[]{"random_directory/nonexistent_file.csv"});
    }

    /**
     * Run where the command line argument is valid but an invalid query is sent.
     *
     * Provided input: 'name Dhofar', 'quit'
     * Expected: Program should print an error for invalid query and continue to run.
     */
    @Test
    public void run3() {
        provideInput("name Dhofar\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument is valid but an invalid "location" query is sent.
     *
     * Provided input: 'location 90.1 180.1', 'quit'
     * Expected: Program should print an error for invalid query and continue to run.
     */
    @Test
    public void run4() {
        provideInput("location 90.1 180.1\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument specified and valid.
     * A valid "location" query is sent, and there is a result.
     *
     * Provided input: 'location 33.45 -111.51667', 'quit'
     * Expected: The program should print results for the query, then terminate.
     */
    @Test
    public void run5() {
        try {
            provideInput("location 3.45 -11.567\nquit");
            FallenStars.main(new String[]{INPUT_FILE});
        } catch (StackOverflowError e) {
            System.err.println("This failure means you got a StackOverflowError.\nThis happened on my machine when I ran all the tests at once.\nRun this test individually, and see if the error persists.");
        }
    }

    /**
     * Run where the command line argument specified and valid.
     * A valid "year" query is sent, and there are results.
     *
     * Provided input: 'year 1920', 'quit'
     * Expected: The program should print results for the query, then terminate.
     */
    @Test
    public void run6() {
        provideInput("year 1920\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument specified and valid.
     * A valid "mass" query is sent, and there are results.
     *
     * Provided input: 'mass 7000', 'quit'
     * Expected: The program should print results for the query, then terminate.
     */
    @Test
    public void run7() {
        provideInput("mass 7000\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument specified and valid.
     * A valid "mass" query is sent, but there are no results.
     *
     * Provided input: 'mass 12345', 'quit'
     * Expected: Program should print a message for no matches found and continue to run.
     */
    @Test
    public void run8() {
        provideInput("mass 12345\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument specified and valid.
     * A valid "year" query is sent, but there are no results.
     *
     * Provided input: 'year 2021', 'quit'
     * Expected: Expected: Program should print a message for no matches found and continue to run.
     */
    @Test
    public void run9() {
        provideInput("year 2021\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument specified and valid.
     * Multiple queries are entered. The first two are valid and should produce results, the last is invalid.
     *
     * Provided input: 'location 0.0 0.0', 'mass 5', 'mast 25000', 'quit'
     * Expected: Program should produce results for the first two queries and an error for the last, then terminate when 'quit' is entered.
     */
    @Test
    public void run10() {
        provideInput("location 0.0 0.0\nmass 5\nmast 25000\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

    /**
     * Run where the command line argument specified and valid.
     * Multiple queries are entered. All three queries are valid and should produce results.
     *
     * Provided input: 'location 0.0 37.66667', 'year 2003', 'mass 6580', 'quit'
     * Expected: Program should produce results for all three queries and then terminate when 'quit' is entered.
     */
    @Test
    public void run11() {
        provideInput("location 0.0 37.66667\nyear 2003\nmass 6580\nquit");
        FallenStars.main(new String[]{INPUT_FILE});
    }

}