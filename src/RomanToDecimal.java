
/**
 * RomanToDecimal is a class that takes user input of a Roman numeral
 * and outputs that value in decimal form, while also handling invalid
 * character input
 * @version 8/6/20
 * @author 22ridley
 */

public class RomanToDecimal {
    //no private data, only helper methods

    /**
     * This method converts roman numeral String into decimal output (base-10 value)
     * @param roman Must be an uppercase string
     * @return Decimal value of roman input
     */
    public static int romanToDecimal (String roman) {
        int sum = 0;
        //declare your variables outside of for loops
        String letter;
        for(int i = 0; i < roman.length(); i++) {
            letter = roman.substring(i, i+1);
            if (letter.equals("I"))
                sum += 1;
            else if (letter.equals("V"))
                sum += 5;
            else if (letter.equals("X"))
                sum += 10;
            else if (letter.equals("L"))
                sum += 50;
            else if (letter.equals("C"))
                sum += 100;
            else if (letter.equals("D"))
                sum += 500;
            else if (letter.equals("M"))
                sum += 1000;
            else    // user supplies a bad character
                return -1;
        }
        // handling invariant cases
        // if this substring isn't in the string, it will return an index of -1, showing that the index doesn't exist
        if(roman.indexOf("IV") != -1 || roman.indexOf("IX") != -1)
            sum -= 2;
        if(roman.indexOf("XL") != -1 || roman.indexOf("XC") != -1)
            sum -= 20;
        if(roman.indexOf("CD") != -1 || roman.indexOf("CM") != -1)
            sum -= 200;

        return sum;
    }

    /**
     * This method converts decimal integers into a Roman Numeral output
     * @param decimal A positive integer to be made into a Roman Numeral
     * @return Roman value of decimal input
     */
    public static String decimalToRoman (int decimal) {
        String romanOutput = "";

        while (decimal >= 1000) {
            romanOutput += "M";
            decimal -= 1000;
        }
        while (decimal >= 900) {
            romanOutput += "CM";
            decimal -= 900;
        }
        while (decimal >= 500) {
            romanOutput += "D";
            decimal -= 500;
        }
        while (decimal >= 400) {
            romanOutput += "CD";
            decimal -= 400;
        }
        while (decimal >= 100) {
            romanOutput += "C";
            decimal -= 100;
        }
        while (decimal >= 90) {
            romanOutput += "XC";
            decimal -= 90;
        }
        while (decimal >= 50) {
            romanOutput += "L";
            decimal -= 50;
        }
        while (decimal >= 40) {
            romanOutput += "XL";
            decimal -= 40;
        }
        while (decimal >= 10) {
            romanOutput += "X";
            decimal -= 10;
        }
        while (decimal >= 9) {
            romanOutput += "IX";
            decimal -= 9;
        }
        while (decimal >= 5) {
            romanOutput += "V";
            decimal -= 5;
        }
        while (decimal >= 4) {
            romanOutput += "IV";
            decimal -= 4;
        }
        while (decimal >= 1) {
            romanOutput += "I";
            decimal -= 1;
        }
        return romanOutput;
    }

    /**
     * Main method for class RomanToDecimal
     * @param args Command line arguments if necessary
     */
    public static void main(String[] args) {
        for (String roman : args) {
            int decimal = romanToDecimal(roman.toUpperCase());
            System.out.print("Input: " + roman + " => output: ");
            if (decimal == -1)
                System.out.println("invalid");
            else {
                if (roman.equals(decimalToRoman(decimal)))
                    System.out.println(decimal);
                else
                    System.out.println("invalid Roman Numeral");
            }
        }
    }
}
