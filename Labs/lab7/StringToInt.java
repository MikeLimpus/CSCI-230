/**
 * Describe a recursive algorithm for converting a string of 
 * digits into the integer it represents. For example, '13531'
 * represents the integer 13,531.
 */

public class StringToInt {
    public int stringToInt(String n, int index) {
        int finalAnswer = 0;
    // Base case - String is length 1
        if (n.length() == 1) {
            return n.charAt(0).parseInt();
        }
        else {
            stringToInt(n, index + 1);
            
        }
    }
}