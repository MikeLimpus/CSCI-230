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
import java.util.ArrayDeque;
import java.util.Deque;                             // The Deque class will be used to implement a stack      

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
        Boolean switcher = false;

        // These stacks will hold the operators and operands, respectively
        Deque<Character> operStack = new ArrayDeque<Character>();
        Deque<Double> numberStack = new ArrayDeque<Double>();

        // Create a string array full of subtrings for easier handling
        String seperatedInput[] = userInput.split(" ");
        // Create a simple char array for syntax checking
        char inputArray[] = userInput.toCharArray();

        if 
        // Seperate the numbers and characters
        for(int i = 0; i < seperatedInput.length; i++) {
            switcher = !switcher;                                       // Starts as true
            // This will only execute every other iteration, in order to seperate numbers from operators
            if (switcher) {                                             
                Double temp = 0.0;                                      // Placeholder needed due to parseDouble method
                Double stackValue = temp.parseDouble(seperatedInput[i]);// Convert string to Double
                numberStack.push(stackValue);                           // Add Double value to stack
            }
        }
        switcher = true;                                                // Set the toggle switch to off to read the other half of the array

        // Add the operators to the operStack
        for(int i = 0; i < seperatedInput.length; i++) {
            switcher = !switcher;                                       // Starts as false
            
            if (switcher) {
                // Push characters to operStack
                Character stackChar = seperatedInput[i].charAt(0);      // operators should be strings of length 1, and always at the index after operands
                operStack.push(stackChar);
            }
        }

 
        System.out.println(numberStack);
        System.out.println(operStack);

        // Count left and right parenthesis
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
            }
        }

        // Check if there are the same amount of open and close parenthesis
        if (parCount1 != parCount2)
            syntaxError = true;
        if (syntaxError == true)
            System.out.println("Syntax Error");

        System.out.println("parCount1 " + parCount1);
        System.out.println("parCount2 " + parCount2);
        // Third Pass: Finish Calculations
        for (int i = 0; i < inputArray.length, i++) {
            switch(operStack.pop()) {
                case: '+'
                    result += Arithmetic.addition(numberStack.pop(), numberStack.pop());
                    break;
                case: '-'
                    result -= Arithmetic.subtraction(numberStack.pop(), numberStack.pop());
                    break;
                case '*':
                    result *= Arithmetic.multiplication(numberStack.pop(), numberStack.pop());
                    break;
                case '/':
                    result /= Arithmetic.division(numberStack.pop(), numberStack.pop());
                    break;
                case '^':
                    result = Arithmetic.exponentiation(numberStack.pop(), numberStack.pop());   //TODO Fix this
            }
        }
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