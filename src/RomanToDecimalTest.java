import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RomanToDecimalTest is a JUnit test class that tests the RomanToDecimal
 * class's method called romanToDecimal with 18 different inputs, some using
 * assertEquals and some using assertNotEquals
 * @version 10/6/20
 * @author 22ridley
 */
public class RomanToDecimalTest {

    @Test
    /**This method runs the assertEquals and assertNotEquals tests to
     * see if the romanToDecimal method of the RomanToDecimal class
     * works correctly for a vairety of valid, invalid, and illogical
     * inputs
     */
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XIV"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("LXV"), 65);
        assertEquals(RomanToDecimal.romanToDecimal("CXXXIV"), 134);
        assertEquals(RomanToDecimal.romanToDecimal("MCMLIX"), 1959);
        assertEquals(RomanToDecimal.romanToDecimal("MMMDCCXXIV"), 3724);
        assertEquals(RomanToDecimal.romanToDecimal("DXCVII"), 597);
        assertEquals(RomanToDecimal.romanToDecimal("MXL"), 1040);
        assertEquals(RomanToDecimal.romanToDecimal("MMMCDI"), 3401);
        assertEquals(RomanToDecimal.romanToDecimal("CCLIII"), 253);
        assertEquals(RomanToDecimal.romanToDecimal("MMMMCMXXVII"), 4927);

        assertEquals(RomanToDecimal.romanToDecimal("HAHAHA"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("HELLO123"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("HAPPY"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("HALLOWEEN"), -1);

        /*
        These 'actuals' aren't what my program would actually return,
        just this RomanToDecimal method, because I check with my
        decimalToRoman method to make sure that the roman numerals
        inputted are valid Roman Numerals
         */
        assertEquals(RomanToDecimal.romanToDecimal("DM"), 1500);
        assertEquals(RomanToDecimal.romanToDecimal("LCMIII"), 953);
        assertEquals(RomanToDecimal.romanToDecimal("VIVI"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("IC"), 101);

        assertNotEquals(RomanToDecimal.romanToDecimal("CDLIX"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("XXXI"), 41);
    }
}