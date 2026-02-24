package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [Claude sonnet4.6]
 * Generation Date: [feb 19]
 *
 * Original Prompt:
 * "[I did'nt use a prompt
 *  * I remembered from the last prompt what to code
 *  * and i used the last skeleton of code in the Sphere
 *  * class to make this new class]"
 *
 * Follow-up Prompts (if any):
 * 1. "[na]"
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
public class Cylinder extends Shape3D {

    private double radius;
    private double height;

    public Cylinder(){
        super("cylinder","none");
        this.radius=0.0;
        this.height = 0.0;
    }

    public Cylinder(String color, double radius, double height) {
        // validation to verify that user is inputting a correct color
        super("Cylinder", (color == null || color.trim().isEmpty()) ? "Unknown Color" : color);
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("radius length and height must be greater than zero. Received: " + height+" "+radius);
            // validation is needed so as not to setup
            //an invalid sphere
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateVolume() {


        return Math.PI * Math.pow(radius,2)*height;
    }

    @Override
    public double calculateSurfaceArea() {
        return 2* Math.PI*Math.pow(radius,2)+2*Math.PI*radius*height;
    }

    public double getHeight(){
        return height;
    }
    public double getRadius(){
        return radius;
    }

    public void setHeight(double height){
        if (height <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+height);


        }
        this.height = height;
    }
    public void setRadius(double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+radius);


        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\n*#Volume-Of-Cylinder:    " +calculateVolume(),
                        "Surface area of Cylinder:      "+calculateSurfaceArea());
    }






}
