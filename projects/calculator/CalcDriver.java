/**
 * Jonathan Limpus
 * Programming Project 1: Parsing Strings/Calculator
 * 
 * Write a Java program that can simulate a simple calculator, 
 * using the Java console as the exclusive input and output device. 
 * That is, each input to the calculator, be it a number, like 12.34 
 * or 1034, or an operator, like + or =, can be done on a separate 
 * line. After each such input, you should output to the Java console 
 * what would be displayed on your calculator. Implement at least the 
 * following operations: Addition, Subtraction, Multiplication, Modulus,
 * Exponentiation and Square Root and the use of parentheses for grouping. 
 * Your program should thrown an exception if the expression is invalid. 
 */
package projects.calculator;
public class CalcDriver {
     // TODO Write a driver program
     public static void main(String args[]) {
        // Explain the rules to the user
        System.out.println("Calculator\n Valid operators are:\n\t+ for addition\n\t- for subtraction");
        System.out.println("\t* for multiplication\n\t/ for division\n\t% for modulo\n\t^ for exponentiation");
        System.out.println("\tsqrt(n) [without spaces] for square root, where n is a non-negative real number");
        System.out.println("Please seperate operators and operands by a space\n");
     }

}