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
    public static String sqrt = "sqrt(";

    


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
       // System.out.println("Calculator\n Valid operators are:\n\t+ for addition\n\t- for subtraction");
       // System.out.println("\t* for multiplication\n\t/ for division\n\t% for modulo\n\t^ for exponentiation");
       // System.out.println("\tsqrt(n) for square root, where n is a non-negative real number");
        System.out.println("Please seperate operators and operands by a space\n");

        userInput = input.nextLine();
        parser(userInput);
        System.out.println(userInput.length());

    }

    private static Double parser(String userInput) {
        // Local variables
        Double result = 0.0;
        Integer parCount1 = 0, parCount2 = 0;           // Used to check for syntax errors
        Boolean syntaxError = false; 
        char inputArray[] = userInput.toCharArray();    // Convert input to a char array
        // First pass: Check for syntax errors
        for(int i = 0; i < inputArray.length; i++) {
            /*
             * Iterate through the input to check if the number of open 
             * and close parentheseis is equal, if not, syntax error
             */
            switch (inputArray[i]) {
                case '(':
                    parCount1++;
                    break;
                case ')':
                    parCount2++;
                    break;
                // Check if there are two operators in a row
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    if(isAnOperator(inputArray, i ) == true)
                        syntaxError = true;
                    break;
                default:
                    break;
            }
        }
        if (parCount1 != parCount2)
            syntaxError = true;
        if(syntaxError == true)
            System.out.println("Syntax Error");
        for(int i = 0; i < userInput.length(); i++) {
            // Second Pass: Check and resolve parenthesis
            
        }
        System.out.println("parCount1 " + parCount1);
        System.out.println("parCount2 " + parCount2);
        // Third Pass: Finish Calculations
        return result;
    }

    /**
     * isAnOperator: checks an element of a char array to see if it is one of the defined 
     * operators {+, -, *, /, ^, )} by iterating through a defined list of operators, and 
     * comparing each element of operators against the single element of inputArray
     * @param inputArray
     * @param index
     * @return Boolean
     */
    private static Boolean isAnOperator(char inputArray[], int index) {
        char[] operators = {'+', '-', '*', '/', '^', ')'};
        for(int i = 0; i < operators.length; i++) {
            if (inputArray[index] == operators[i] )
                return true;
            }
        return false;
    }
    public static void main(String args[]) {
        // TODO delete this
        userInterface();
    }
}