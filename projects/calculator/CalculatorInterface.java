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
        Boolean switcher = false;

        // These stacks will hold the operators and operands, respectively
        // Deque<Character> operStack = new ArrayDeque<Character>();
        // Deque<Double> numberStack = new ArrayDeque<Double>();

        // Create a string array full of subtrings for easier handling
        String seperatedInput[] = userInput.split(" ");
        // Covert into an arrayList
        ArrayList<String> operList = new ArrayList<String>(Arrays.asList(seperatedInput));
        Integer initialSize = operList.size();          // Initial size will be referenced in multiplication to prevent * 0

        // Move parenthesis to front of list
        /*for(int i = 0; i < operList.size(); i++) {
            if (operList.get(i) == "(") {
                do {
                    int newIndex = 0;
                    int currentIndex = i;
                    operList.add(newIndex, operList.get(currentIndex));
                    i++;
                    operList.remove(currentIndex + 1);
                    operList.trimToSize();
                } while(operList.get(i) != ")");
            }
            System.out.println("operList: " + operList);
        }*/

        // Main function loop - continue so long as there are elements in the list
        //while(operList.size() > 0) {
            //Double operand1 = 0.0, operand2 = 0.0;
            for(int i = 0; i < operList.size(); i++) {
                
                // Enter this switch if an operator is found
                if ("+-*/^()".contains(operList.get(i))) {
                    Double operand1 = Double.parseDouble(operList.get(i - 1));
                    Double operand2 = Double.parseDouble(operList.get(i + 1));

                    switch (operList.get(i)) {
                        case "+":
                            result += (operand1 + operand2);
                            break;
                        case "-":
                            result += (operand1 - operand2);
                            break;
                        case "*":
                            result += (operand1 * operand2);
                            break;
                        case "/":
                            result += (operand1 / operand2);
                            break;
                        case "^":
                        result += Math.pow(operand1, operand2);
                        default:
                            break;
                    } 
                }
                if (operList.get(i).contains(sqrt)) {
                    String sqrString = operList.get(i).substring(operList.get(i).indexOf("(")+1,operList.get(i).indexOf(")"));
                    Double sqrOperand = Double.parseDouble(sqrString);
                    result += Math.sqrt(sqrOperand);
                    //Double sqrtOperand = Double.parseDouble(operList.get(i));
                }
            }

        
        // Check if there are the same amount of open and close parenthesis
        if (parCount1 != parCount2)
            syntaxError = true;
        if (syntaxError == true)
            System.out.println("Syntax Error");

        System.out.println("parCount1 " + parCount1);
        System.out.println("parCount2 " + parCount2);
        
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