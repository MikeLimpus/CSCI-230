/**
 * Jonathan Limpus
 * Project 1: Parsing Strings/Calculator
 * CSCI-230
 * 
 * Class: CalculatorInterface
 * Implements a user interface for the arithmetic methods in class Arithmetic
 */

package projects.calculator;

import java.util.Scanner;           

public class CalculatorInterface {

    // Instance variables
    static Scanner input = new Scanner(System.in);  // We should only need a single instace of this

    // Define operators 
    //public static char plus = '+',  minus = '-', times = '*', divide = '/', mod = '%', power = '^', sqrt2 = ')';
    //public static String sqrt = "sqrt(";
    public enum Operators {
        PLUS, MINUS, TIMES, DIVIDE, MOD, POWER, SQRT, SQRT2;
        public static char plus = '+',  minus = '-', times = '*', divide = '/', mod = '%', power = '^', sqrt2 = ')';
        public static String sqrt = "sqrt(";
    }
    


    // Methods 

    // Default constructor
    CalculatorInterface() {}

    /**
     * interface: void method that handles input and output of main program
     * @return void 
     */
    public static void userInterface() {
        // Local variables
        String userInput;

        // Explain the rules to the user
        System.out.println("Calculator\n Valid operators are:\n\t+ for addition\n\t- for subtraction");
        System.out.println("\t* for multiplication\n\t/ for division\n\t% for modulo\n\t^ for exponentiation");
        System.out.println("\tsqrt(n) for square root, where n is a non-negative real number");
        System.out.println("Please seperate operators and operands by a space\n");

        userInput = input.nextLine();

        System.out.println(userInput);

    }

    public Double parser(String userInput) {
        // Local variables
        Double result = 0.0;
        Integer parCount1 = 0, parCount2 = 0;    // Used to check for syntax errors

        // First pass: Check for syntax errors
        for(int i = 0; i < userInput.length(); i++) {
            /*
             * Iterate through the input to check if the number of open 
             * and close parentheseis is equal, if not, syntax error
             */
            switch (userInput.charAt(i)) {
                case '(':
                    parCount1++;
                    break;
                case ')':
                    parCount2++;
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                default:
                    break;
            }

            /*if (userInput.charAt(i) == '(')
                parCount1++;
            else if(userInput.charAt(i) == ')')
                parCount2++;
            else
                continue;*/

        }
        for(int i = 0; i < userInput.length(); i++) {
            // Second Pass: Check and resolve parenthesis
            
        }
        // Third Pass: Finish Calculations
        return result;
    }

    public static void main(String args[]) {
        // TODO delete this
        userInterface();
    }
}