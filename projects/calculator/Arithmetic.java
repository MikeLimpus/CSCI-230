/**
 * @author Jonathan Limpus
 * Project 1: Parsing Strings/Calculator
 * CSCI-230
 * 
 * Class: Arithmetic
 * Implements all of the basic arithmetic functions required for 
 * the calculator including : Addition, Subtraction, Multiplication, 
 * Modulus, Exponentiation, and Square Root
 */
package projects.calculator;

public final class Arithmetic<T extends Number>{

    // Methods

    /**
     * addition: Accepts 2 variables of numeric type and
     * adds them together, returning number value
     * @param operand1
     * @param operand2
     * @return T sum
     */
    public T addition(T operand1, T operand2){
        Double sum = 0.0;
        try {
            sum = (Double)operand1 + (Double)operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in addition: Input not a number");
        } 
        return (T)sum;
    }

    /**
     * subtraction: Accepts 2 variables of numeric type and
     * subtracts the first from the second, returning number value
     * @param operand1
     * @param operand2
     * @return T difference
     */
    public T subtraction(T operand1, T operand2){
        Double difference = 0.0;
        try {
            difference = (Double)operand1 + (Double)operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in subtraction: Input not a number");
        } 
        return (T)difference;
    }

     /**
     * multiplication: Accepts 2 variables of numeric type and
     * multiplies the first and the second, returning number value
     * @param operand1
     * @param operand2
     * @return T product
     */

    public T multiplication(T operand1, T operand2) {
        Double product = 0.0;
        try {
            product = (Double)operand1 * (Double)operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in multiplication: Input not a number");
        }
        return (T)product;
    }

    /**
     * division: Accepts 2 variables of numeric type and
     * divides the first and the second, returning number value
     * @param operand1
     * @param operand2
     * @return T quotient
     */

    public T division(T operand1, T operand2) {
        Double quotient = 0.0;
        try {
            quotient = (Double)operand1 / (Double)operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in division: Input not a number");
        }
        return (T)quotient;
    }

    /**
     * modulo: Accepts 2 variables of numeric type and
     * mods the first and the second, returning number value
     * @param operand1
     * @param operand2
     * @return T modulus
     */
    
    public T modulo(T operand1, T operand2) {
        Double modulus = 0.0;
        try {
            modulus = (Double)operand1 % (Double)operand2;
        } catch (NumberFormatException e) {
            System.out.println("Error in modulo: Input not a number");
        }
        return (T)modulus;
    }

    /**
     * exponentiation: Accepts 2 variables of numeric type and
     * raised the value of the first to the power of the value of the 
     * second, returning number value
     * @param operand1
     * @param operand2
     * @return T product
     */
    
    public T exponentiation(T operand1, T operand2) {
        Double product = 0.0;
        try {
            product = Math.pow((Double)operand1, (Double)operand2);
        } catch (NumberFormatException e) {
            System.out.println("Error in exponentiation: Input not a number");
        }
        return (T)product;
    }

    /**
     * Accepts a single variable to calculate its square root 
     * @param operand1
     * @return T root
     */
    
    public T squareRoot(T operand) {
        Double root = 0.0;
        try {
            root = Math.sqrt((Double)operand);
        } catch (NumberFormatException e) {
            System.out.println("Error in square root: Input not a number");
        }
        return (T)root;
    }

    public static void main(String args[]) {
        // TODO Delete this
        System.out.println("I work");
    }

}