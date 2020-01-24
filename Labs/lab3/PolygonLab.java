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
package lab3;
public class PolygonLab {   
    public static void main(String args[]){
        System.out.println("Polygons");
    }
}




class IsoscelesTriangle implements Triangle  {

}

class EquilateralTriangle implements Triangle   {

}

class Quadrilateral implements Polygon {

}

class Square implements Quadrilateral {

}

class Rectangle implements Quadrilateral {

}

class Pentagon implements Polygon {

}

class Hexagon implements Polygon {

}

