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
public class RectangularPrism extends Shape3D{

    private double height, length,width;

    public RectangularPrism(){
        super("retangularprism","none");
        this.height = 0.0;
        this.length = 0.0;
        this.width = 0.0;
    }



    public RectangularPrism(String color, double length, double height,double width) {
        // validation to verify that user is inputting a correct color
        super("retangularprism", (color == null || color.trim().isEmpty()) ? "Unknown Color" : color);
        if (length <= 0 || height <= 0 || width <= 0) {
            throw new IllegalArgumentException("width, length and height must be greater " +
                    "than zero. Received: " + height+" "+length+" "+width);
            // validation is needed so as not to setup
            //an invalid sphere
        }
        this.length = length;
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateVolume() {


        return length*width*height;
    }
    @Override
    public String getDimensions() {
        return String.format("length: "+length+" width: "+width+" height: "+height);
    }

    @Override
    public double calculateSurfaceArea() {
        double calc1 = length * width+length*height+width*height;
        return 2* calc1;
    }

    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
    public double getHeight(){
        return height;
    }

    public void setWidth(double width){
        if (width <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+width);


        }
        this.width = width;
    }
    public void setLength(double length){
        if (length <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+length);


        }
        this.length = length;
    }
    public void setHeight(double height){
        if (height <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+height);


        }
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\nEfficiency Ratio: "+getEfficiencyRatio());
    }



}
