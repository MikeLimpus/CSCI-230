/**
 * Jonathan Limpus
 * CSCI-230
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
     public static void main(String args[]) {
          // Explain the rules to the user
          System.out.println("Calculator\n Valid operators are:\n\t+ for addition\n\t- for subtraction");
          System.out.println("\t* for multiplication\n\t/ for division\n\t% for modulo\n\t^ for exponentiation");
          System.out.println("\tsqrt(n) [without spaces] for square root, where n is a non-negative real number");
          System.out.println("Please seperate parenthesis, operators and operands by a space\n");
          CalculatorInterface.userInterface();

          // Test Cases: see attached output.txt for results
          System.out.println("Case 1 : Simple addition");
          CalculatorInterface.userInterface();

          System.out.println("Case 2 : Every operation used");
          CalculatorInterface.userInterface();

          System.out.println("Case 3 : Parenthesis used");
          CalculatorInterface.userInterface();

          System.out.println("Case 4: Parenthesis used in conjunction with exponents");
          CalculatorInterface.userInterface();

          System.out.println("Case 5: Square Root of a negative number");
          CalculatorInterface.userInterface();

          System.out.println("Case 6: Syntax errors");
          CalculatorInterface.userInterface();
     


     }

}