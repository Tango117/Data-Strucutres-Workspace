package project4;

/**
 * This class represents a List using the List interface.
 *
 * @author Brendan Tang
 * @version 10/29/2020
 */

public class Converter{



  public int binToDec(String s){
    if(s.length < 2 && s.substring(0, 2) != "0b")
      return 0;
    return binToDec(s.substring(2, s.length), 0);

  }

  private int binToDec(String s, int i){
    if(s.length == 0)
      return

    return 0;

  }

  public int hexToDec(String s){
    return 0;
  }

  public String decToBin(int x){
    return null;
  }

  public String binToHex(String s){
    return null;
  }

  public String hexToBin(String s){
    return null;
  }

  public int ConvertStringToInt(String s) throws NumberFormatException {

    int num = 0;

    for(int i = 0; i < s.length(); i++){
        if( ((int) s.charAt(i) >= 48) && ((int) s.charAt(i) <= 57)) {
            num = num * 10 + ((int) s.charAt(i) - 48);
        }
        else{
            throw new NumberFormatException();
        }

    }

    return num;
  }

}
