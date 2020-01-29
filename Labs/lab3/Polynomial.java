/**
 * Jonathan Limpus
 * Lab 3, Part 2 (generics)
 * 
 * Design and implement class Polynomial<T,n> which can be used 
 * to represent an n-degree polynomial.
 * This class should facilitate the addition, subtraction, 
 * multiplication, and derivative operations and contain 
 * the appropriate constructors, getters, and setters.
 */



package lab3;
public class Polynomial { 
    // Instance variables 
    private int degree;
    private int poly[] = new int[degree];
    private double coefficient[] = new double[degree];

    // Constructors
    Polynomial(){                           // Default constructor
        degree = 0;
    }
    Polynomial(int degree, int poly[]) {    // Parameterized constructor
        degree = this.degree;
        poly = this.poly;
    }

    // Mutators
    public void setDegree(int degree) {
        degree = this.degree;
    }

    public void setPoly(int poly[]) {
        poly = this.poly;   
    }

    public void setCoef(double coefficient[]) {
        coefficient = this.coefficient;
    }
    // Accessors
    public int getDegree() {
        return degree;
    }

    public int[] getPoly(){
        return poly;
    }
    // Methods

    public double[] addition(double secondPoly[]) {
        // Addition: add the values of a second array into our coefficient array 
        for(int i = 0; i < coefficient.length; i++) 
            coefficient[i] += secondPoly[i];
        return coefficient;
    }

    public double[] subtraction(double secondPoly[]) {
        // Subtraction: essentially our addition function, but with a switched operator
        for(int i = 0; i < coefficient.length; i++) 
            coefficient[i] -= secondPoly[i];
        return coefficient;
    }

    public double[] derivative() {
        /* 
         * Find d/dx of our "Polynomial"
         * We will use the power rule f^1(x) = nx^(n-1)
         */
        for(int i = 0; i < coefficient.length; i++)
            coefficient[i] *= i; 
        return coefficient;
    }

}