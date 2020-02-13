/**
 * Jonathan Limpus
 * Project 1: Parsing Strings/Calculator
 * CSCI-230
 * 
 * Class: CalculatorInterface
 * This class handles user I/0 and performs the neccesary calculations
 */

package projects.calculator;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
  
public class CalculatorInterface {

    // Instance variables
    static Scanner input = new Scanner(System.in);  // We should only need a single instace of this

    // Methods 

    // Default constructor
    CalculatorInterface() {}

    /**
     * interface: void method that handles input and output of main program
     * @return void 
     */
    public static void userInterface() {
        String userInput;
        // Scan system.in to get an input string
        userInput = input.nextLine();
        System.out.println(userInput + " = " + parser(userInput));
    }

    /**
     * parser: This method handles the parenthesis in the input while using the mathOperations method to handle 
     * calculations. The method creates an array list operList which mathOperations uses. The parenthesis are parsed in 
     * a for loop which:
     * - checks for a string "("
     * - adds everything between the parenthesis into a new array list
     * - invokes mathOperations on this new array list
     * - replaces the parenthesized operators/operands into operList with the result of that calculation
     * mathOperations is then used on operList to complete the calculation
     * @param userInput
     * @return Double
     */
    private static Double parser(String userInput) {
        // Initialize return variable
        Double result = 0.0;
        
        /*
         * Covert userInput into an arrayList, seperated by spaces. 
         * This operList will be our main data structure that will be operated on. 
         */
        ArrayList<String> operList = new ArrayList<String>(Arrays.asList(userInput.split(" ")));
        ArrayList<String> parenList = new ArrayList<String>();

        // These array lists will be used as references for array list methods that will be invoked
        String paren[] = "( )".split(" ");
        ArrayList<String> parenthesis = new ArrayList<String>(Arrays.asList(paren));

        // Check for syntax errors
        if(!syntaxError(operList)) {
            // This loop will iterate through the operator list
            for (int i = 0; i < operList.size(); i++) {
                if(operList.get(i).contains("(") && !operList.get(i).contains("sqrt")) {
                    // add things between parenthesis to a new list 
                    // note that the second parameter is "exclusive", so it must be offset by 1
                    parenList.addAll(operList.subList(operList.indexOf("("), (operList.indexOf(")")) + 1 ));

                    // Remove all paranthesis from sublist
                    parenList.removeAll(parenthesis);

                    // Perform operations on new sublist
                    Double newElement = mathOperations(parenList);

                    // Remove the sublist elements from the original insert the result in its place
                    operList.subList(operList.indexOf("("), operList.indexOf(")") + 1).clear();
                    operList.add(i, newElement.toString());
                }
            }
            result = mathOperations(operList);
        }

        else {
            System.out.println("Syntax error detected\nAborting...");
        }
          
            return result;    
        }
    /**
     * mathOperation: In order to implement the correct order of operations, or 'PEMDAS', the input will
     * be iterated through 3 times. As the parenthesis were handled in the function parser, we begin with
     * exponentiation (including the square root n^(1/2)). Then, the simple operations of multiplication, division 
     * and modulus, and finally addition/subtraction. This will be accomplished using 3 for-loops, each containing a 
     * switch statement for each operation that will handle calculations. These loops will be housed in a larger while 
     * loop that continue so long as the list still has calculations to perform or a syntax error has been found
     * @param operList
     * @return
     */
    private static Double mathOperations(ArrayList<String> operList) {
        // Local Variables
        Double result = 0.0;
        final String sqrt = "sqrt(";

        if (operList.size() > 1) {
            /*
            * Now, resolve all square roots and exponents. Due to the nature of the sqrt() function, a switch is not 
            * used. Rather, two seperate if statements are used with different local variables and calculations
            */
            for (int i = 0; i < operList.size(); i++) {
                // If the index contains a sqrt() function
                if (operList.get(i).contains(sqrt)) {
                    // Create a string that contains the elements inside the paranthesis
                    String sqrString = 
                        operList.get(i).substring(operList.get(i).indexOf("(")+1, operList.get(i).indexOf(")"));
                    // parse a double from the string type and invoke Math.sqrt() to perform the calculation
                    Double squareRoot = Math.sqrt(Double.parseDouble(sqrString));
                    // Replace squareRoot into the array list in the same spot as the sqrt() function
                    operList.set(i, squareRoot.toString());
                }
                if ("^".contains(operList.get(i))) {
                        // Create two temporary doubles based on the index on either side of the operator
                        Double operand1 = Double.parseDouble(operList.get(i - 1));
                        Double operand2 = Double.parseDouble(operList.get(i + 1));

                        result = Math.pow(operand1, operand2);
                        
                        // Place back into array list
                        replace(operList, i, result);
                        i--;
                    }
            }
                // Multiplication/Division/Modulus
            for(int i = 0; i < operList.size(); i++) { 
                // Enter this if an operator is found
                if ("*/%".contains(operList.get(i))) {
                    // Create two temporary doubles based on the index on either side of the operator
                    Double operand1 = Double.parseDouble(operList.get(i - 1));
                    Double operand2 = Double.parseDouble(operList.get(i + 1));
                    result = operand1;
                    switch (operList.get(i)) {
                        case "*":
                            result *= operand2;
                            break;
                        case "/":
                            result /= operand2;
                            break;
                        case "%":
                            result = result % operand2;
                            break;
                        default:
                            break;
                        }
                    replace(operList, i, result);
                    i--;
                }
            }
            // Addition/Subtraction
            for(int i = 0; i < operList.size(); i++) { 
            // Enter this switch if an operator is found
            if ("+-".contains(operList.get(i))) {
                // Create two temporary doubles based on the index on either side of the operator
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
                        default:
                            break;
                        }
                    replace(operList, i, result);
                    i--;
                }                  
            }
            
        } 
        // Handles use case when a single sqrt() is desired
        else if (operList.size() == 1 && operList.get(0).contains(sqrt)) {
                // Create a string that contains the elements inside the paranthesis
                String sqrString = 
                    operList.get(0).substring(operList.get(0).indexOf("(")+1,operList.get(0).indexOf(")"));
                result = Math.sqrt(Double.parseDouble(sqrString));
            }
        
        else {
            // Handles rare case of input of only one element being passed in
            result = Double.parseDouble(operList.get(0));
        }           
        
        return result;
    }

    
    /**
     * replace: Take a list and replace a single element in the place of 3: the one on the left of the 
     * i, one on the right of i, and the one in the place of i. 
     * @param inputList
     * @param i
     * @param value
     * @return void
     */
    private static void replace(ArrayList<String> inputList, int i, Double value) {
        int index = i;
        inputList.remove(index);
        inputList.add(index, value.toString());
        inputList.remove(index + 1);
        inputList.remove(index - 1);
        
    }
    /**
     * syntaxError: checks operList for various syntax errors
     * @param operList
     * @return Boolean
     */
    private static Boolean syntaxError (ArrayList<String> operList){
        String operators = "+-*/^%";
        Integer parCount1 = 0, parCount2 = 0;
        for(int i = 0; i < operList.size(); i++) {
            // Check if there are two operators in a row
            if (operators.contains(operList.get(i)) && operators.contains(operList.get(i + 1))) {
                System.out.println("Error = MULTIPLE OPERATORS");
                return true;
            }

            // Count left and right parenthesis for mismatch
            switch (operList.get(i)) {
                case "(":
                    parCount1++;
                    break;
                case ")":
                    parCount2++;
                    break;
                default:
                    break;
            }
        }
        if (parCount1 != parCount2) {
            System.out.println("Error = MISMATCHED PARENTHESIS");
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        userInterface();
    }
}