package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [Claude Sonnet 4.6]
 * Generation Date: [Feb 19]
 *
 * Original Prompt:
 * "[I did'nt use a prompt
 * I remembered from the last prompt what to code
 * and i used the last skeleton of code in the Sphere
 * class to make this new class]"
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [na]
 * - [Explain why changes were necessary]
 *
 * Formula Verification:
 * - Volume formula verified against: [NIST (National Institute of Standards and Technology)]
 * - Surface area formula verified against: [Khan Academy]
 */
public class Cube extends Shape3D{


    private double side;

    public Cube(){
        super("Cube","none");
        this.side=0.0;
    }
    public Cube(String color, double side) {
        // validation to verify that user is inputting a correct color
        super("Cube", (color == null || color.trim().isEmpty()) ? "Unknown Color" : color);
        if (side <= 0) {
            throw new IllegalArgumentException("side length must be greater than zero. Received: " + side);
            // validation is needed so as not to setup
            //an invalid sphere
        }
        this.side = side;
    }

    @Override
    public double calculateSurfaceArea() {


        return 6*Math.pow(side,2);
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side,3);
    }

    public double getSideLength(){
        return side;
    }

    public void setSideLength(double side){
        if (side <= 0){
            throw new IllegalArgumentException("Side must be greater than zero. Received: "+side);

        }
        this.side = side;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\n*#Volume-Of-Cube:    " +calculateVolume(),
                        "Surface area of Cube:      "+calculateSurfaceArea());
    }
}
