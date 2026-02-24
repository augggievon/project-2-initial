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
public class TriangularPrism extends Shape3D{
    private double base,prismLength,triangleHeight,sideA,sideC;

    public TriangularPrism(){
        super("triangular prism","none");
        this.base = 0.0;
        this.prismLength = 0.0;
        this.triangleHeight= 0.0;
        this.sideA = 0.0;
        this.sideC = 0.0;

    }

    public TriangularPrism(String color, double base, double prismLength,double triangleHeight
    , double sideA, double sideC) {
        // validation to verify that user is inputting a correct color
        super("triangular prism", (color == null || color.trim().isEmpty()) ? "Unknown Color" : color);
        if (sideA <= 0 ||sideC <= 0 || prismLength <= 0 || triangleHeight <=0 || base <=0) {
            throw new IllegalArgumentException("width, length and height must be greater " +
                    "than zero. Received: " + sideA+" "+sideC+" "+prismLength+" "+triangleHeight+" " +
                    " "+ base);
            // validation is needed so as not to setup
            //an invalid sphere
        }
        this.base = base;
        this.sideA = sideA;
        this.sideC = sideC;
        this.prismLength = prismLength;
        this.triangleHeight = triangleHeight;
    }

    @Override
    public double calculateVolume() {

        double calc1 = 1.0/2.0 * base*prismLength*triangleHeight;


        return calc1;
    }

    @Override
    public double calculateSurfaceArea() {
        double calc1 = base*triangleHeight;
        double calc2 = sideC + base + sideA;
        double calc3 = prismLength * calc2;

        return calc1+calc3;
    }

    public double getPrismLength(){
        return prismLength;
    }
    public double getBase(){
        return base;
    }
    public double getTriangleHeight(){
        return triangleHeight;
    }
    public double getSideA(){
        return sideA;
    }
    public double getSideC(){
        return sideC;
    }

    public void setPrismLength(double prismLength){
        if (prismLength <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+prismLength);


        }
        this.prismLength = prismLength;
    }
    public void setBase(double base){
        if (base <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+base);


        }
        this.base = base;
    }
    public void setTriangleHeight(double triangleHeight){
        if (triangleHeight <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+triangleHeight);


        }
        this.triangleHeight = triangleHeight;
    }
    public void setSideA(double sideA){
        if (sideA <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+sideA);


        }
        this.sideA = sideA;
    }
    public void setSideC(double sideC){
        if (sideC <= 0){
            throw new IllegalArgumentException("must have a radius greater than 0 and cannot be less " +
                    "than 0 Received: "+sideC);


        }
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("\n*#Volume-Of-TriangularPrism:    " +calculateVolume(),
                        "Surface area of Triangular Prism:      "+calculateSurfaceArea());
    }




}
