import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * BaseConverter is a class that reads input of a file with several
 * numbers with different bases and prints and writes output of the
 * conversion of the original number to the new supplied base.
 * @version 11/19/20
 * @author 22ridley
 */

public class BaseConverter {
    String hex;
    /**
     * Constructor for class.
     */
    public BaseConverter() {
        hex = "0123456789ABCDEF";
    }

    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num, a String representing the original value
     * @param fromBase, a String representing the original base
     * @return a base-10 int representation of num fromBase
     */
    public int strToInt(String num, String fromBase) {
        String s;
        int sum = 0, digit = 0;
        for(int i = 0; i < num.length(); i++) {
            s = num.substring(i, i + 1);
            for(int j = 0; j < hex.length(); j++) {
                if(s.equals(hex.substring(j, j+1))) {
                    digit = j;
                    break;
                }
            }
            sum += digit * Math.pow(Integer.parseInt(fromBase), num.length() - i - 1);
        }
        return sum;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     * @param num A base-10 integer representation of the original value
     * @param toBase  An integer representation of the base to be converted to
     * @return A string representation of the new number in the correct base
     */
    public String intToStr(int num, int toBase) {
        int top = 0;
        while(num > Math.pow(toBase, top)) {
            top++;
        }
        String newDigit = "", newNum = "";
        for(int i = top - 1; i >= 0; i--) {
            newDigit = "" + (int) (num / Math.pow(toBase, i));
            num -= Math.pow(toBase, i) * Integer.parseInt(newDigit);
            newDigit = hex.substring(Integer.parseInt(newDigit), Integer.parseInt(newDigit) +1);
            newNum += newDigit;
        }
        return newNum.equals("") ? "0" : newNum;
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner in = null;
        PrintWriter pw = null;
        int baseTen = 0;
        final JFileChooser fc = new JFileChooser();
        // I got the JFileChooser code above and below from Oracle's java tutorials:
        // https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
        try {
            int returnVal = fc.showOpenDialog(null);
            File file = fc.getSelectedFile();
            in = new Scanner(new File("" + file));
            pw = new PrintWriter(new FileWriter("datafiles/converted.dat"));
            String[] line;
            String newNum;
            while (in.hasNext()) {
                line = in.nextLine().split("\t");
                if(Integer.parseInt(line[1]) < 2 || Integer.parseInt(line[1]) > 16)
                    System.out.println("Invalid input base " + line[1]);
                else if(Integer.parseInt(line[2]) < 2 || Integer.parseInt(line[2]) > 16)
                    System.out.println("Invalid output base " + line[2]);
                else {
                    baseTen = strToInt(line[0], line[1]);
                    newNum = intToStr(baseTen, Integer.parseInt(line[2]));
                    System.out.println(line[0] + " base " + line[1] + " = " + newNum + " base " + line[2]);
                    pw.println(line[0] + "\t" + line[1] + "\t" + newNum + "\t" + line[2]);
                }
            }
            in.close();
            pw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Main method for class BaseConverter
     * @param args Command line arguments, if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
