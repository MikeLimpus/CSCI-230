/*
 * Jonathan Limpus 
 * CSCI-230 Lab 2
 * 01/21/20
 * 
 *  A string a is an encoding of a string b if each character in 
 *  a can be "mapped" to a unique letter in 
 *  b . For example, "matata" is an encoding of "banana" since all f(b)=m, 
 *  f(a)=a and f(n)=t. Given two strings, determine if these strings are an 
 *  encoding of one another. Find a brute-force solution first, and then if you have
 *  time, find a O(n) solution.
 */
public class StringEncode {
    //Instance variables 
    static int SIZE = 26;                                      //size of the alphabet
    public static void main(String args[]) {

    } 
    static boolean isEncoding(String foo, String bar) { 
        foo = args[0];                                  //Program will read from the command line
        bar = args[1];
        char[] cipher = new char[SIZE];                   //create an array to use 
        for (int i = 0; i < SIZE; i++) {                  //Alphabetically fill the area with all the characters of the alphabet
            cipher[i] = 'a' + i;
        } 
        for (int i = 0; i < SIZE; i++ ) {
            System.out.print(cipher[i] + " ");
        }
        // Main program loop
        for (char c : args[0].charAt(c)) {

        }
        

    }
}