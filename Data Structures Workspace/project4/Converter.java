package project4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This Converter class converts binary, hexadecimal, and decimal numbers.
 *
 * @author Brendan Tang
 * @version 11/14/2020
 */

public class Converter {
	
	private static final String HEX_VALUE = "0123456789ABCDEF";
	private static final String BIN_VALUE = " 0000 0001 0010 0011 0100 0101 0110 0111 1000 1001 1010 1011 1100 1101 1110 1111";
	
	
	
/**
 * Converts binary strings to decimal numbers.
 * More specifically given a valid string representing a binary number,
 * returns a non-negative decimal integer with the same value.
 * @param binary - the binary string to be converted
 * @return the decimal number equal in value to the binary string passed as the parameter
 * @throws IllegalArgumentException - if the parameter is null
 * @throws NumberFormatException - if the binary string passed to the function is invalid
 */
	public static int binaryToDecimal(String binary) throws IllegalArgumentException, NumberFormatException {
		
		if (binary == null)
			throw new IllegalArgumentException("Null Parameter");
		
		Pattern p = Pattern.compile("0b[01]{1,31}");
		Matcher m = p.matcher(binary);
		
		if (!m.matches())
			throw new NumberFormatException("Invalid Binary Format");
		
		int ans = binToDec(binary.substring(2, binary.length()), 1);
		
		return ans;

	}

	private static int binToDec(String bin, int pow) {
		if (bin.length() == 0)
			return 0;
		
		int value = toInt(bin.substring(bin.length() - 1));
		
		value *= pow;
		
		pow *= 2;
		
		return value + binToDec(bin.substring(0, bin.length() - 1), pow);

	}

	
/**
 * Converts hexadecimal strings to decimal numbers.
 * More specifically given a valid string representing a hexadecimal number,
 * returns a non-negative decimal integer with the same value.
 * @param hex - hexadecimal string to be converted
 * @return the decimal number equal in value to the hexadecimal string passed as the parameter
 * @throws IllegalArgumentException - if the parameter is null
 * @throws NumberFormatException - if the hexadecimal string passed to the function is invalid
 * @throws ArithmeticException - when the hexadecimal string parameter is greater than 0x7FFFFFFF (the largest value that can be represented as an int)
 */
	public static int hexToDecimal(String hex) throws IllegalArgumentException, NumberFormatException, ArithmeticException {
		
		if (hex == null)
			throw new IllegalArgumentException("Null Parameter");
		
		Pattern p = Pattern.compile("0x[0-9ABCDEF]{1,8}");
		Matcher m = p.matcher(hex);
		
		if (!m.matches())
			throw new NumberFormatException("Invalid Hex Format");
		
		return hexToDec(hex.substring(2), 1);
		
	}
	
	private static int hexToDec(String hex, int pow) throws ArithmeticException{
		
		if (hex.isEmpty())
			return 0;
		
		char c = hex.charAt(hex.length() - 1);
		int d = HEX_VALUE.indexOf(c);
		int val = d * pow;
		
		if(val < 0)
			throw new ArithmeticException("Hex value too big");
		
		pow *= 16;
		
		return val + hexToDec(hex.substring(0, hex.length() - 1), pow);

	}
	
	
	
/**
 * Converts decimal numbers to binary strings.
 * More specifically given a non-negative decimal integer,
 * returns the string representing the binary number with the same value.
 * @param decimal - the decimal number to be converted
 * @return the binary string equal in value to the decimal number passed as the parameter 
 * or null if the decimal is negative
 */
	public static String decimalToBinary(int decimal) {
		
		if(decimal < 0)
			return null;
		
		if(decimal == 0)
			return "0b0";
			
		return "0b" + decToBin(decimal);
		
	}
	
	private static String decToBin(int dec) {
		
		if(dec == 1)
			return "1";
		int rem = dec % 2;
		dec /= 2;
		
		return decToBin(dec) + rem;
		
	}
	
	
	
/**
 * Converts decimal numbers to hexadecimal strings.
 * More specifically given a non-negative decimal integer,
 * returns the string representing the hexadecimal number with the same value.
 * @param decimal - the decimal number to be converted
 * @return the hexadecimal string equal in value to the decimal number passed as the parameter 
 * or null if the decimal is negative
 */
	public static String decimalToHex(int decimal) {
		
		if(decimal < 0)
			return null;
		
		if(decimal == 0)
			return "0x0";
		
		return "0x" + decToHex(decimal);
		
	}
	
	private static String decToHex(int dec) {
		
		if(dec < 16)
			return Character.toString(HEX_VALUE.charAt(dec));
		
		int rem = dec % 16;
		dec /= 16;
		
		return decToHex(dec) + Character.toString(HEX_VALUE.charAt(rem));
	
	}
	
	
	
/**
 * Converts binary strings to hexadecimal strings.
 * More specifically given a valid string representing a binary number,
 * returns the string representing the hexadecimal number with the same value.
 * @param binary - the binary string to be converted
 * @return the hexadecimal string equal in value to the binary string passed as the parameter
 * @throws IllegalArgumentException - if the parameter is null
 * @throws NumberFormatException - if the binary string passed to the function is invalid
 */
	public static String binaryToHex(String binary) throws IllegalArgumentException, NumberFormatException {
		
		if (binary == null)
			throw new IllegalArgumentException();
		
		Pattern p = Pattern.compile("0b[01]{1,31}");
		Matcher m = p.matcher(binary);
		
		if (!m.matches())
			throw new NumberFormatException();
		
		String bin = binary.substring(2);
		
		if(bin.length() % 4 ==0)
			return "0x" + binToHex(bin);
		
		return binaryToHex("0b0" + bin);
		
	}
	
	private static String binToHex(String bin) {

		if(bin.isEmpty())
			return bin;
		
		int i = BIN_VALUE.indexOf(bin.substring(bin.length() - 4));
		i = (i - 1) / 5;

		return binToHex(bin.substring(0, bin.length() - 4)) + Character.toString(HEX_VALUE.charAt(i));
	
	}
	
	
	
/**
 * Converts hexadecimal strings to binary strings.
 * More specifically given a valid string representing a hexadecimal number,
 * returns the string representing the binary number with the same value.
 * @param hex - the hexadecimal string to be converted
 * @return the binary string equal in value to the hexadecimal string passed as the parameter
 * @throws IllegalArgumentException - if the parameter is null
 * @throws NumberFormatException - if the hexadecimal string passed to the function is invalid
 */
	public static String hexToBinary(String hex) throws IllegalArgumentException, NumberFormatException {
		
		if (hex == null)
			throw new IllegalArgumentException();
		
		Pattern p = Pattern.compile("0x[0-9ABCDEF]{1,8}");
		Matcher m = p.matcher(hex);
		
		if (!m.matches())
			throw new NumberFormatException();
		
		String ans = hexToBin(hex.substring(2));
		
		return "0b" + ans;
		
	}
	
	private static String hexToBin(String hex) {
		
		char c = hex.charAt(hex.length() - 1);
		int d = HEX_VALUE.indexOf(c);
		d = d * 5 + 1;
		String val = BIN_VALUE.substring(d, d + 4);
		
		if(hex.length() == 1)
			return String.valueOf(toInt(val));
		
		return hexToBin(hex.substring(0, hex.length() - 1)) + val;
		
	}
	
	
	
	private static int toInt(String s) throws NumberFormatException {

		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			
			if (((int) s.charAt(i) >= 48) && ((int) s.charAt(i) <= 57)) {
				num = num * 10 + ((int) s.charAt(i) - 48);
			} else {
				throw new NumberFormatException();
			}

		}

		return num;
	
	}

}
