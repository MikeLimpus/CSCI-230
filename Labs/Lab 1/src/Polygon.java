/*
* Define a Polygon interface that has methods area() and perimeter().
* Then implement classes for Triangle, Quadrilateral, Pentagon, Hexagon,
* and Octagon, which implement this interface, with the obvious meanings 
* for the area() and perimeter() methods. Also implement classes,
* IsoscelesTriangle, EquilateralTriangle, Rectangle, and Square, which
* have the appropriate inheritance relationships. Finally, write a simple 
* user interface, which allows users to create polygons of the various
* types, input their geometric dimensions, and then output their area and perimeter.
*/

public class Polygon {   
    public Polygon() {}
    public Polygon(int numSides) {
        numSides = sides;
    }                        
    public int sides = 0;                       //Each instance should have its own count of sides 
    public static void main(String args[]){
        System.out.println("Polygons");
    }
}
class Triangle extends Polygon {
    super.sides = 3;
}   

class IsoscelesTriangle extends Triangle {

}

class EquilateralTriangle extends Triangle   {

}

class Quadrilateral extends Polygon {

}

class Square extends Quadrilateral {

}

class Rectangle extends Quadrilateral {

}

class Pentagon extends Polygon {

}

class Hexagon extends Polygon {

}

class Octagon extends Polygon {

}