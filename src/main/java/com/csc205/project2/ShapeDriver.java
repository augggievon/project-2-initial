package com.csc205.project2;

import com.csc205.project2.shapes.*;

public class ShapeDriver {

    public static void main(String[] args) {
        // TODO: Create instances of your shape classes and test their methods here.
        Sphere thing = new Sphere("phthalo blue",5.5);

        Cube thing2 = new Cube("titanium white",4);

        Cylinder thing3 = new Cylinder("sap green", 5.5,6);

        RectangularPrism thing4 = new RectangularPrism("van dyke brown", 5.6,7.7,9.8);

        TriangularPrism thing5 = new TriangularPrism("midnight black", 5.5, 4.8,6.9,7.0,3.3);
        thing.calculateVolume();
        thing.calculateSurfaceArea();
        System.out.println(thing);

        System.out.println();

        thing2.calculateSurfaceArea();
        thing2.calculateVolume();
        System.out.println(thing2);

        System.out.println();

        thing3.calculateVolume();
        thing3.calculateSurfaceArea();
        System.out.println(thing3);
        System.out.println();

        thing4.calculateVolume();
        thing4.calculateSurfaceArea();
        System.out.println(thing4);
        System.out.println();

        thing5.calculateSurfaceArea();
        thing5.calculateVolume();
        System.out.println(thing5);

    }
}
