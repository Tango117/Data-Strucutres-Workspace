package project5;

import java.io.*;
import java.util.*;

/**
 * This class is the program performing Meteorite search. The program is
 * interactive. When the program is executed the name of the input CSV file
 * containing the list of all the Meteorites and it's data as the program's
 * single command line argument. The data in this CSV file serves as a database
 * of all the Meteorites.
 *
 * In the interactive part: - if the user enters location LATITUDE LONGITUDE,
 * The program responds by printing the nearest Meteorite. - if the user enters
 * year YEAR, The program responds by printing a list of Meteorites with that
 * year. - if the user enters mass MASS, The program responds by printing a list
 * of Meteorites with that mass +/-10.
 *
 * @author Brendan Tang
 * @version 10/7/2020
 */
public class FallenStars {

	/**
	 * Splits the given line of a CSV file according to commas and double quotes
	 * (double quotes are used to surround multi-word entries so that they may
	 * contain commas)
	 * 
	 * @author Joanna Klukowska
	 * @param textLine
	 *            a line of text from a CSV file to be parsed
	 * @return an ArrayList object containing all individual entries found on
	 *         that line; any missing entries are indicated as empty strings;
	 *         null is returned if the textline passed to this function is null
	 *         itself.
	 */

	public static ArrayList<String> splitCSVLine(String textLine) {

		if (textLine == null)
			return null;

		ArrayList<String> entries = new ArrayList<String>();
		int lineLength = textLine.length();
		StringBuffer nextWord = new StringBuffer();
		char nextChar;
		boolean insideQuotes = false;
		boolean insideEntry = false;

		// iterate over all characters in the textLine
		for (int i = 0; i < lineLength; i++) {
			nextChar = textLine.charAt(i);

			// handle smart quotes as well as regular quotes
			if (nextChar == '"' || nextChar == '\u201C' || nextChar == '\u201D') {

				// change insideQuotes flag when nextChar is a quote
				if (insideQuotes) {
					insideQuotes = false;
					insideEntry = false;
				} else {
					insideQuotes = true;
					insideEntry = true;
				}
			} else if (Character.isWhitespace(nextChar)) {
				if (insideQuotes || insideEntry) {
					// add it to the current entry
					nextWord.append(nextChar);
				} else { // skip all spaces between entries
					continue;
				}
			} else if (nextChar == ',') {
				if (insideQuotes) { // comma inside an entry
					nextWord.append(nextChar);
				} else { // end of entry found
					insideEntry = false;
					entries.add(nextWord.toString());
					nextWord = new StringBuffer();
				}
			} else {
				// add all other characters to the nextWord
				nextWord.append(nextChar);
				insideEntry = true;
			}

		}
		// add the last word ( assuming not empty )
		// trim the white space before adding to the list
		if (!nextWord.toString().equals("")) {
			entries.add(nextWord.toString().trim());
		}

		return entries;
	}

	/**
	 * The main() method of this program.
	 * 
	 * @param args
	 *            array of Strings provided on the command line when the program
	 *            is started; the first string should be the name of the input
	 *            csv file containing the list of Meteorites.
	 */
	public static void main(String[] args) {

		// Checks if command line argument is used
		if (args.length == 0) {
			System.err.println("Usage Error: the program expects file name as an argument.");
			System.exit(1);
		}

		// Checks if file exists
		File MeteoriteFile = new File(args[0]);
		if (!MeteoriteFile.exists()) {
			System.err.println("Error: the file does not exist.");
			System.exit(1);
		}

		// Checks if file can be opened
		if (!MeteoriteFile.canRead()) {
			System.err.println("Error: the file meteorites.csv cannot be opened.");
			System.exit(1);
		}

		Scanner in = null;

		// Open file for reading
		try {
			in = new Scanner(MeteoriteFile);
		}

		catch (FileNotFoundException e) {
			System.err.println("Error: the file meteorites.csv cannot be opened.");
			System.exit(1);
		}

		// Skip Catagory Line
		String line = in.nextLine();

		MeteoriteData data = new MeteoriteData();

		// Adds Meteorites to MeteoriteData
		while (in.hasNextLine()) {
			line = in.nextLine();

			// Splits line into individual entries
			ArrayList<String> ln = splitCSVLine(line);

			try {
				Meteorite m = new Meteorite(ln.get(0), Integer.parseInt(ln.get(1)));

				// Skips nonIntegers and sets mass
				if (!(ln.get(4).isEmpty()) && Double.parseDouble(ln.get(4)) == (int) Double.parseDouble(ln.get(4))) {
					m.setMass(Integer.parseInt(ln.get(4)));
				}

				// Sets Year
				if (!ln.get(6).isEmpty())
					m.setYear(Integer.parseInt(ln.get(6).substring(6, 10)));

				// Sets Location
				if (!(ln.get(7).isEmpty()) && !(ln.get(8).isEmpty())) {
					Location l = new Location(Double.parseDouble(ln.get(7)), Double.parseDouble(ln.get(8)));
					m.setLocation(l);
				}

				data.add(m);

			} catch (IllegalArgumentException ex) {

				continue;
			}
		}

		// Interactive Mode
		
		Scanner userInput = new Scanner(System.in);
		String userValue = "";

		// String instructions = "Search the database by using one of the
		// following queries."
		// + " To search for meteorite nearest to a given goe-location, enter"
		// + " location LATITUDE LONGITUDE"
		// + " To search for meteorites that fell in a given year, enter"
		// + " year YEAR"
		// + " To search for meteorites with weights MASS +/- 10 grams, enter"
		// + " mass MASS"
		// + " To finish the program, enter"
		// + " quit";
		System.out.println("\nSearch the database by using one of the following queries.\n"
				+ "	  To search for meteorite nearest to a given goe-location, enter\n"
				+ "	        location LATITUDE LONGITUDE\n"
				+ "	  To search for meteorites that fell in a given year, enter\n" + "	        year YEAR\n"
				+ "	  To search for meteorites with weights MASS +/- 10 grams, enter\n" + "	        mass MASS\n"
				+ "	  To finish the program, enter\n" + "	        quit\n\n");

		do {
			System.out.println("Enter your search query:\n");
			userValue = userInput.nextLine();
			String output = "";

			if (!userValue.equalsIgnoreCase("quit")) {

				try {
					String[] part = userValue.split(" ");

					// User enters: location LATITUDE LONGITUDE
					if (part[0].equals("location") && part.length == 3) {
						Location loc = new Location(Double.parseDouble(part[1]), Double.parseDouble(part[2]));
						Meteorite res = data.getByLocation(loc);
						output = res.toString();
					}

					// User enters: year YEAR
					else if (part[0].equals("year") && part.length == 2) {
						MeteoriteData result = data.getByYear(Integer.parseInt(part[1]));
						output = result.toString();
					}

					// User enters: mass MASS
					else if (part[0].equals("mass") && part.length == 2) {
						MeteoriteData result = data.getByMass(Integer.parseInt(part[1]), 10);
						output = result.toString();
					}

					// User enters anything else
					else {
						// Purposely cause ArrayIndexOutOfBoundsException Error
						// if no location, year, or mass argument
						output = part[part.length];
					}
				}
				
				// Catches if user input is invalid
				catch (IllegalArgumentException ex) {
					System.out.println("Illegal Error: This is not a valid query. Try again.\n");
					continue;
				}

				// Catches if user input format is invalid
				catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Error: This is not a valid query. Try again.\n");
					continue;
				}

				// Catches if null is returned
				catch (NullPointerException ex) {
					System.out.println("Error: No matches found. Try again.\n");
					continue;
				}

				// Prints output
				System.out.println(output + "\n");
			}

		} while (!userValue.equalsIgnoreCase("quit"));

		userInput.close();

	}

}
