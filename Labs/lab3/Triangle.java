/**
 * Jonathan Limpus
 * Implements Polygon with Triangle specific methods 
 * 
 */
package lab3; 
import java.util.Scanner;

public class Triangle implements Polygon {
    // Instance variables
    int sides;
    //double side1 = 0.0, side2 = 0.0, side3 = 0.0;                   //Triangles have 3 sides 
    float HALF = 0.5; 
    double sideValues[] = new double[sides];
    Scanner in = new Scanner(System.in);                              //Input stream
    // Methods
    public double numOfSides(int n){
        n = sides; 
        for (int i = 0; i < sideValues.length; i++) {
            sideValues[n] = in.nextDouble();
        } 
    }

    public double calculateArea(){
        double area = 0.0, base = 0.0, height = 0.0; 
        area = HALF * base * height;
        return area;
    }  
    public double calculatePerimeter() { 
        double perimeter = 0.0;
        for(int i: )
    }

}   