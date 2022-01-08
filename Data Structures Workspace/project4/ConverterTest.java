package project4;

import static org.junit.Assert.*;
import org.junit.Test;

/*

To compile this code execute:  

javac -cp .:/usr/share/java/junit-4.12.jar project4/ConverterTest.java  

To run this code execute: 

java -cp .:/usr/share/java/junit-4.12.jar:/usr/share/java/hamcrest-core.jar org.junit.runner.JUnitCore project4.ConverterTest  

*/

public class ConverterTest {

    //Add tests for your own method here. 

    //Work with your group and your section leader to make sure you are a set of complete tests and 
    // that you thought of all possibilities and edge cases. 
    //Group members: Jonason Wu, Ali Boukind, Pragya Parthasarathy

    /*
    IllegalArgumentException - if the parameter is null
    NumberFormatException - if the hexadecimal string passed to the function is invalid
    ArithmeticException - when the hexadecimal string parameter is greater than 0x7FFFFFFF (the largest value that can be represented as an int)
    */

//    @Test
//    public void hexToDecimal_IllegalArgumentException(){
//        try {
//            String hex = null;
//            Converter.hexToDecimal(hex);
//            fail("No exception thrown for null parameter");         
//        }
//        catch (IllegalArgumentException ex) {
//            //passes
//        }
//        catch (Exception ex){
//            fail("Unknown exception thrown.");
//        }
//    }
//
//
//    @Test
//    public void hexToDecimal_NumberFormatException (){
//        try{
//            String value2 = "#234j234"; // cant start w #
//            Converter.hexToDecimal(value2);
//            fail("can't start with #.");
//            
//        } catch (NumberFormatException e) {
//            // pass 
//        } catch (Exception e) {
//            fail("invalid exception thrown.");
//        }
//    }
//
//    @Test
//    public void hexToDecimal_NumberFormatException2 (){
//        try{
//            //String value2 = "#234j234765jghgj8768"; // too long
//            String value2 = "0x234234765"; // too long
//            Converter.hexToDecimal(value2);
//            fail("too long.");
//            
//        } catch (NumberFormatException e) {
//            // pass 
//        } catch (Exception e) {
//            fail("invalid exception thrown.");
//        }
//    }
//
//
//    
//    @Test
//    public void hexToDecimal_ArithmeticException1(){
//        try{
//            String hex2 = "0xFFFFFFFF"; 
//            Converter.hexToDecimal(hex2);
//            fail("No exception thrown for paramater greater than 0x7FFFFFFF");
//        }
//        catch (ArithmeticException ex) {
//            //desired behavior, test passed
//        }
//        catch (Exception ex) {
//            fail("Invalid exception thrown.");
//        } 
//    }
//
//    @Test
//    public void hexToDecimal_ArithmeticException(){
//        try{
//            String hex1 = "0x80000000";
//            Converter.hexToDecimal(hex1);
//            fail("No exception thrown for paramater greater than 0x7FFFFFFF");
//        }
//        catch (ArithmeticException ex) {
//            //desired behavior, test passed
//        }
//        catch (Exception ex) {
//            fail("Invalid exception thrown.");
//        }
//        
//    }
//
//    @Test
//    public void hexToDecimal_normalCase(){
//        try{
//            String hex = "0x000000"; 
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is unsuccessfully converted to decimal", 0, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//    }
//
//    @Test
//    public void hexToDecimal_normalCase1(){
//        try{
//            String hex = "0x000001";
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is incorrectly converted to decimal", 1, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//    }
//
//    @Test
//    public void hexToDecimal_normalCase2(){
//        try{
//            String hex = "0x7FFFFFFF";
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is incorrectly converted to decimal", 2147483647, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//    }
//    @Test
//    public void hexToDecimal_normalCase3(){
//        try{
//            String hex = "0x1";
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is incorrectly converted to decimal", 1, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//    }
//
//    @Test
//    public void hexToDecimal_normalCase4(){
//        try{
//            String hex = "0x11";
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is incorrectly converted to decimal", 17, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//    }
//
//    @Test
//    public void hexToDecimal_normalCase5(){
//        try{
//            String hex = "0x0";
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is incorrectly converted to decimal", 0, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//    }
//    @Test
//    public void hexToDecimal_normalCase6(){
//        try{
//            String hex = "0x1F";
//            int tmp;
//            tmp = Converter.hexToDecimal(hex);
//            assertEquals("The hex is incorrectly converted to decimal", 31, tmp);
//        }
//        catch (Exception ex){
//            fail("This should have passed");
//        }
//
//        
//    }
    
    public static void main(String[] args) {
    	System.out.println(Converter.binaryToDecimal("0b1111111111111111111111111111111"));
    }
    
}