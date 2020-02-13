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
import java.util.ArrayList;
import java.util.Arrays;
  
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
       // System.out.println("\tsqrt(n) [without spaces] for square root, where n is a non-negative real number");
        System.out.println("Please seperate operators and operands by a space\n");

        userInput = input.nextLine();
        System.out.println("The answer is: " + parser(userInput));
        System.out.println(userInput.length());

    }

    private static Double parser(String userInput) {
        // Local variables
        Double result = 0.0;
        Integer parCount1 = 0, parCount2 = 0;           // Used to check for syntax errors
        Boolean syntaxError = false; 
       
        // Covert userInput into an arrayList, seperated by spaces. This operList will be our main data structure that will be operated on.
        ArrayList<String> operList = new ArrayList<String>(Arrays.asList(userInput.split(" ")));

        /*
         * Main algorithm: In order to implement the correct order of operations, or 'PEMDAS', the input will be
         * iterated through 4 times. First, to resolve paranthesis, then exponentiation (including the square root n^(1/2)).
         * Then, the simple operations of multiplication/division/modulus and finally addition/subtraction. This will be accomplished using 
         * 4 for-loops, each containing a switch statement for each operation that will handle calculations
         */
        while (syntaxError == false && operList.size() > 1) {
            // First, resolve paranthesis by moving each element to the front
            for (int i = 0; i < operList.size(); i++) {
                // If the current element is an open paranthesis
                if("(".contains(operList.get(i))) {
                    if (operList.contains(")")) {
                        for(int j = 0; j < operList.size(); j++) {
                            if (operList.get(i + j) == ")")
                                break;
                            else
                                operList.set(j, operList.get(i + j));
                        }
                    }
                    else {
                        System.out.println("Syntax Error: Mismatched Parenthesis");
                        syntaxError = true;
                        break;
                    } 
                }
                


            }

            // Now, resolve all square roots and exponents
            for (int i = 0; i < operList.size(); i++) {
                if (operList.get(i).contains(sqrt)) {
                    String sqrString = operList.get(i).substring(operList.get(i).indexOf("(")+1,operList.get(i).indexOf(")"));
                    Double squareRoot = Math.sqrt(Double.parseDouble(sqrString));
                    operList.set(i, squareRoot.toString());
                }
            }
                // Main function loop - continue so long as there are elements in the list
            //while(operList.size() > 0) 
                //Double operand1 = 0.0, operand2 = 0.0;
                for(int i = 0; i < operList.size(); i++) {
                //do { 
                    //int i = 0;   
                    // Enter this switch if an operator is found
                    if ("+-*/^()".contains(operList.get(i))) {
                        Double operand1 = Double.parseDouble(operList.get(i - 1));
                        Double operand2 = Double.parseDouble(operList.get(i + 1));
                        result = operand1;
                        switch (operList.get(i)) {
                            case "+":
                                result += operand2;
                                break;
                            case "-":
                                result -= operand2;
                                break;
                            case "*":
                                result *= operand2;
                                break;
                            case "/":
                                result /= operand2;
                                break;
                            case "^":
                                result = Math.pow(result, operand2);
                                break;
                            case "(":
                                parCount1++;
                                break;
                            case ")":
                                parCount2++;
                                break;
                        // case "sqrt":
                                
                            default:
                                break;
                        }
                        moveToFront(operList, i, result);
                        i--;
                    }
                    if (operList.get(i).contains(sqrt)) {
                        String sqrString = operList.get(i).substring(operList.get(i).indexOf("(")+1,operList.get(i).indexOf(")"));
                        Double sqrOperand = Double.parseDouble(sqrString);
                        result = Math.sqrt(sqrOperand);
                    }
                    
                    System.out.println(operList + " At -> " + operList.get(i) + " Or index:" + i);
                    System.out.println(result);
                    
                } //while(operList.size() > 2);
            }
        
/*         // Check if there are the same amount of open and close parenthesis
        if (parCount1 != parCount2)
            syntaxError = true;
        if (syntaxError == true)
            System.out.println("Syntax Error");

        //System.out.println("parCount1 " + parCount1);
        //System.out.println("parCount2 " + parCount2);
         */
        return result;
    }
    
    private static void moveToFront(ArrayList<String> inputList, int i, Double value) {
        int index = i;
        inputList.remove(index);
        inputList.add(index, value.toString());
        inputList.remove(index + 1);
        inputList.remove(index - 1);
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