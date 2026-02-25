package com.csc205.project2.shapes;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [Claude Sonnet 4.6]
 * Generation Date: [Feb 19]
 *
 * Original Prompt:
 * "[Hey my instructor told me to have you write a Shape3D.java with these requirements Must Include:Implements the ThreeDimensionalShape interfaceConcrete implementations of getVolume() and getSurfaceArea() that call the abstract methodsCommon properties: name (String), color (String) (Properties in Java are typically private fields
 * with public getters and setters)Constructor(s) for initializationtoString() method that formats output consistentlyGetter/setter methods as appropriate keep in mind this is a classic inheritance project]"
 *
 * Follow-up Prompts (if any):
 * 1. "[na]"
 * 2. "[na ]"
 *
 * Manual Modifications:
 * - [the ai had @overide for the abstract methods removed them]
 * - [the change was neccesary because abstract methods are supposed to be
 * overridden in the children classes thats why the ide gave an error]
 *
 * Formula Verification:
 * - Volume formula verified against: [na because the methods will
 * be overridden in the child classes that need different formulas
 * because they are different shapes]
 * - Surface area formula verified against: [same as the first]
 */
/**
 * Shape3D.java
 * Abstract class that implements the ThreeDimensionalShape interface.
 * Serves as the base class for all concrete 3D shapes in the hierarchy.
 */
public abstract class Shape3D implements ThreeDimensionalShape {

    // -------------------------------------------------------------------------
    // Fields (private — accessed only through getters/setters)
    // -------------------------------------------------------------------------
    private String name;
    private String color;

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Default constructor — sets default name and color.
     */
    public Shape3D() {
        this.name  = "Unknown Shape";
        this.color = "Unknown Color";
    }

    /**
     * Parameterized constructor.
     *
     * @param name  the name of the shape (e.g. "Sphere", "Cube")
     * @param color the color of the shape (e.g. "Red", "Blue")
     */
    public Shape3D(String name, String color) {
        this.name  = name;
        this.color = color;
    }

    // -------------------------------------------------------------------------
    // Abstract methods — subclasses MUST override these
    // (declared in ThreeDimensionalShape interface and left abstract here so
    //  each concrete shape provides its own formula)
    // -------------------------------------------------------------------------

    /**
     * Returns a string describing the shape's dimensions (e.g. "radius = 5.00").
     * Each subclass defines what its relevant dimensions are.
     *
     * @return formatted dimension string
     */
    public abstract String getDimensions();

    public double getEfficiencyRatio() {
        double vol = getVolume();
        if (vol == 0) return 0;

        double ratio = getSurfaceArea() / vol;
        return Math.round(ratio * 100.0) / 100.0;  // 2 decimal places
    }

    public boolean isLargerThan(Shape3D other) {
        return this.getVolume() > other.getVolume();
    }





    /**
     * Calculates and returns the volume of the shape.
     * Each concrete subclass provides its own implementation.
     *
     * @return the volume of the shape
     */

    public abstract double calculateVolume();

    /**
     * Calculates and returns the surface area of the shape.
     * Each concrete subclass provides its own implementation.
     *
     * @return the surface area of the shape
     */

    public abstract double calculateSurfaceArea();

    // -------------------------------------------------------------------------
    // Concrete implementations of getVolume() / getSurfaceArea()
    // These satisfy the interface contract by delegating to the abstract methods.
    // -------------------------------------------------------------------------

    /**
     * Returns the volume by calling the abstract calculateVolume() method.
     * Subclasses do NOT need to override this method.
     *
     * @return the volume of the shape
     */
    public double getVolume() {
        return calculateVolume();
    }

    /**
     * Returns the surface area by calling the abstract calculateSurfaceArea() method.
     * Subclasses do NOT need to override this method.
     *
     * @return the surface area of the shape
     */
    public double getSurfaceArea() {
        return calculateSurfaceArea();
    }

    // -------------------------------------------------------------------------
    // Getters and Setters
    // -------------------------------------------------------------------------

    /**
     * Returns the name of the shape.
     *
     * @return shape name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the shape.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the color of the shape.
     *
     * @return shape color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the shape.
     *
     * @param color the new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    /**
     * Returns a formatted string representation of the shape.
     * Subclasses can call super.toString() and append their own fields.
     *
     * @return formatted shape details
     */
    @Override
    public String toString() {
        return String.format(
                "Shape:        %s%n" +
                        "Color:        %s%n" +
                        "Volume:       %.2f%n" +
                        "Surface Area: %.2f"+
                        "\nDimensions: %s",
                name,
                color,
                getVolume(),
                getSurfaceArea(),
                getDimensions()
        );
    }
}
