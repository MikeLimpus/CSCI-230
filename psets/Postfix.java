// Jonathan Limpus 
// Problem Set 1, Problem 2
package psets;
// Imports
import java.util.Scanner;

import java.util.Arrays;
import java.util.ArrayList;

public class Postfix {
    // Instance Variables 
    // Define all operators as special characters 
    static String add = "+", diff = "-", prod = "*", div = "/";
    static Scanner in = new Scanner(System.in);


    private static Double postfixSolve(String equation) {
        Double result = 0.0;
        // Seperate the input string into substrings for each operator/operand
        String[] sepEquation = equation.split(" ");
        ArrayList<String> operList = new ArrayList<String>(Arrays.asList(sepEquation));
        Integer initialSize = operList.size();
        System.out.println(operList.toString());
        while(operList.size() > 0) {
            Double temp1 = 0.0;
            Double temp2 = 0.0;
            for (int i = 0; i < operList.size(); i++) {
                if ("+-*/".contains(operList.get(i))) {
                    temp1 = Double.parseDouble(operList.get(i - 1));
                    temp2 = Double.parseDouble(operList.get(i - 2));
                    
                    switch (operList.get(i)) {
                        case "+":   
                            result += (temp1 + temp2);
                            break;
                        case "-":
                            result -= (temp1 - temp2);
                            break;
                        case "*":
                            if (operList.size() == initialSize) 
                                result = 1.0; 
                            result *= (temp1 * temp2);
                            break;
                        case "/":
                            result /= (temp1 / temp2);
                            break;                        
                        default:
                            break;    
                    }
                    // Remove the elements that have been operated on and resize the list
                    operList.remove(i);
                    operList.remove(i - 1);
                    operList.remove(i - 2);
                    operList.trimToSize();
                }
                
                
            }
        }
        return result;
    }


    public static void main(String args[]) {
        System.out.println("Please enter an equation in postfix notation (i.e. 5 2 3 * + 18 3 / +) with spaces");
        String equation = in.nextLine();
        Double result = postfixSolve(equation);
        System.out.println("The answer is: " + result);

    }
}
