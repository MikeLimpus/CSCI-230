// Jonathan Limpus 
// Problem Set 1, Problem 2
package psets;
// Imports
import java.util.Scanner;

import java.util.*;
public class Postfix {
    // Instance Variables 
    // Define all operators as special characters 
    static String add = "+", diff = "-", prod = "*", div = "/";
    static Scanner in = new Scanner(System.in);


    private Double postfixSolve(String equation) {
        Double result = 0.0;
        // Seperate the input string into substrings for each operator/operand
        String[] sepEquation = equation.split(" ");
        //Deque<String> operStack = new ArrayDeque<String>;
        List<String> operList = new ArrayList<String>(Arrays.asList(sepEquation));
        System.out.println(operList.toString());
        /*for (int i = 0; i < sepEquation.length; i++) {
            // Fill a stack with all operators and operands
            operStack.push(sepEquation[i]);
        }
        System.out.println(operStack);*/
        while(operList.size() > 0)
            for (int i = 0; i < operList.size(); i++) {
                switch (operList.get(i)) {
                    case "+":   
                        Double temp1 = Double.parseDouble(operList.get(i - 1));
                        Double temp2 = Double.parseDouble(operList.get(i - 2));
                
                        result += (temp1 + temp2);
                        // Remove the elements that have been operated on and resize the list
                        operList.remove(i);
                        operList.remove(i - 1);
                        operList.remove(i - 2);
                        operList.trimToSize();
                        break;
                    case "-":
                    Double temp1 = Double.parseDouble(operList.get(i - 1));
                    Double temp2 = Double.parseDouble(operList.get(i - 2));

                        result -= (temp1 - temp2);
                        // Remove the elements that have been operated on and resize the list
                        operList.remove(i);
                        operList.remove(i - 1);
                        operList.remove(i - 2);
                        operList.trimToSize();
                        break;
                    case "*":
                    Double temp1 = Double.parseDouble(operList.get(i - 1));
                    Double temp2 = Double.parseDouble(operList.get(i - 2));

                        result *= (temp1 * temp2);
                        // Remove the elements that have been operated on and resize the list
                        operList.remove(i);
                        operList.remove(i - 1);
                        operList.remove(i - 2);
                        operList.trimToSize();
                    case "/":
                    Double temp1 = Double.parseDouble(operList.get(i - 1));
                    Double temp2 = Double.parseDouble(operList.get(i - 2));

                        result /= (temp1 / temp2);
                        // Remove the elements that have been operated on and resize the list
                        operList.remove(i);
                        operList.remove(i - 1);
                        operList.remove(i - 2);
                        operList.trimToSize();                        
                    default:
                        break;
                }
            }
        return result;
    }


    public static void main(String args[]) {
        System.out.println("Please enter an equation in postfix notation (i.e. 5 2 3 * + 18 3 / +) with spaces");
        String equation = in.nextLine();
        result = postfixSolve(equation);
        System.out.println("The answer is: " + result);

    }



}
