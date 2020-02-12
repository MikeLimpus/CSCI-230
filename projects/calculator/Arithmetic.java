/**
 * Jonathan Limpus
 * Project 1: Parsing Strings/Calculator
 * CSCI-230
 * 
 * Class: Arithmetic
 * Implements all of the basic arithmetic functions required for 
 * the calculator including : Addition, Subtraction, Multiplication, 
 * Modulus, Exponentiation, and Square Root
 */
package projects.calculator;

public final class Arithmetic{

    // Methods

    /**
     * addition: Accepts 2 variables of numeric type and
     * adds them together, returning number value
     * @param operand1
     * @param operand2
     * @return Double sum
     */
    public static Double addition(Double operand1, Double operand2){
        Double sum = 0.0;
        try {
            sum = operand1 + operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in addition: Input not a number");
        } 
        return sum;
    }

    /**
     * subtraction: Accepts 2 variables of numeric type and
     * subtracts the first from the second, returning number value
     * @param operand1
     * @param operand2
     * @return Double difference
     */
    public static Double subtraction(Double operand1, Double operand2){
        Double difference = 0.0;
        try {
            difference = operand1 + operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in subtraction: Input not a number");
        } 
        return difference;
    }

     /**
     * multiplication: Accepts 2 variables of numeric type and
     * multiplies the first and the second, returning number value
     * @param operand1
     * @param operand2
     * @return T product
     */

    public static Double multiplication(Double operand1, Double operand2) {
        Double product = 0.0;
        try {
            product = operand1 * operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in multiplication: Input not a number");
        }
        return product;
    }

    /**
     * division: Accepts 2 variables of numeric type and
     * divides the first and the second, returning number value
     * @param operand1
     * @param operand2
     * @return Double quotient
     */

    public static Double division(Double operand1, Double operand2) {
        Double quotient = 0.0;
        try {
            quotient = operand1 / operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in division: Input not a number");
        }
        return quotient;
    }

    /**
     * modulo: Accepts 2 variables of numeric type and
     * mods the first and the second, returning number value
     * @param operand1
     * @param operand2
     * @return Double modulus
     */
    
    public static Double modulo(Double operand1, Double operand2) {
        Double modulus = 0.0;
        try {
            modulus = operand1 % operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in modulo: Input not a number");
        }
        return modulus;
    }

    /**
     * exponentiation: Accepts 2 variables of numeric type and
     * raised the value of the first to the power of the value of the 
     * second, returning number value
     * @param operand1
     * @param operand2
     * @return Double product
     */
    
    public static Double exponentiation(Double operand1, Double operand2) {
        Double product = 0.0;
        try {
            product = Math.pow(operand1, operand2);
        } catch (NumberFormatException e) {
            System.out.println("Error in exponentiation: Input not a number");
        }
        return product;
    }

    /**
     * Accepts a single variable to calculate its square root 
     * @param operand1
     * @return Double root
     */
    
    public static Double squareRoot(Double operand) {
        Double root = 0.0;
        if (root > 0) {
            try {
                root = Math.sqrt(operand);
            } catch (NumberFormatException e) {
                System.out.println("Error in square root: Input not a number");
            }
        }
        else {
            System.out.println("Operand must be greater than 0");
        }
        return root;
    }

    public static void main(String args[]) {
        // TODO Delete this
        System.out.println("I work");
    }

}