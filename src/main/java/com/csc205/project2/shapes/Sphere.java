package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [Claude, Sonnet4.6]
 * Generation Date: [Feb 19]
 *
 * Original Prompt:
 * "[Now i need the same class to have a child this time
 * square that will overide the abstract methods to get the vlome and surface area of the sqre]"
 *
 * Follow-up Prompts (if any):
 * 1. "[hey it also needs this Extends Shape3D (which implements ThreeDimensionalShape)
 * * Implement the abstract methods from ThreeDimensionalShape
 * * Include proper constructors with validation
 * * Override toString() with shape-specific formatting
 * * Add any shape-specific methods if needed]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [I changed the methods and constructor params to take a radius
 * since to find volume and surface area of sphere a radius is needed]
 * - [The change was neccesary because without it the code would
 * make no sense calculating a sphere volume with side which is what
 * a square would need]
 *
 * Formula Verification:
 * - Volume formula verified against: [Rice University (OpenStax)]
 * - Surface area formula verified against: [Rice University (OpenStax)]
 */

public class Sphere extends Shape3D{

    private double radius;

// default constructor sets default values
    public Sphere(){
        super("Sphere","none");
        this.radius =0.0;
    }

    @Override
    public String getDimensions() {
        return String.format("radius: "+radius);
    }

    public Sphere(String color, double radius) {
        // validation to verify that user is inputting a correct color
        super("Sphere", (color == null || color.trim().isEmpty()) ? "Unknown Color" : color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius length must be greater than zero. Received: " + radius);
            // validation is needed so as not to setup
            //an invalid sphere
        }
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        double calc1 = 4.0/3.0 * Math.PI;
        return Math.pow(radius, 3)*calc1;
    }

    @Override
    public double calculateSurfaceArea() {
        return 4.0* Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculates the space diagonal of the cube —
     * the longest straight line you can draw inside it, corner to corner.
     * Formula: d = side * sqrt(3)
     *
     * @return the space diagonal length
     */


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius length must be greater than zero. Received: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\n Effieciency Ratio: "+getEfficiencyRatio());
    }








}
