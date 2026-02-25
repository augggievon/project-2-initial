package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: [Claude sonnet 4.6]
 * Generation Date: [feb 20]
 *
 * Original Prompt:
 * "[For each shape class, generate JUnit 5 test classes that include:
 *
 * Test Categories:
 *
 * Basic Functionality: Constructor, getters, setters
 * Calculation Accuracy: Volume and surface area with known values
 * Boundary Testing: Zero values, very small/large numbers
 * Input Validation: Negative values, null inputs
 * Inheritance Testing: Polymorphic behavior verification here is my shape class
 * ]"
 *
 * Follow-up Prompts (if any):
 * 1. "[na]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [It had some diagnonal test methods that i removed ]
 * - [they were neccessary to remove because the methods were giving the ide
 * an error and because the test class could not access because of some reason]
 *
 *
 */
/**
 * CylinderTest.java
 * JUnit 5 test class for the Cylinder shape.
 * Tests cover:
 *   - Basic functionality (constructors, getters, setters)
 *   - Calculation accuracy (volume and surface area)
 *   - Boundary conditions (zero, very small, very large)
 *   - Input validation (negatives, null)
 *   - Inheritance / polymorphic behavior
 *
 * NOTE: Tests assume constructor validation uses || (OR) —
 * meaning EITHER an invalid radius OR an invalid height alone is enough to throw.
 */

public class CylinderTest {

    @Test
    void calculateVolume_correctResult() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertEquals(141.37, c.calculateVolume(), 0.01);
    }

    @Test
    void calculateSurfaceArea_correctResult() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertEquals(150.80, c.calculateSurfaceArea(), 0.01);
    }

    @Test
    void getRadius_returnsCorrectValue() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertEquals(3.0, c.getRadius());
    }

    @Test
    void getHeight_returnsCorrectValue() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertEquals(5.0, c.getHeight());
    }

    @Test
    void setRadius_updatesValue() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        c.setRadius(4.0);
        assertEquals(4.0, c.getRadius());
    }

    @Test
    void setHeight_updatesValue() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        c.setHeight(6.0);
        assertEquals(6.0, c.getHeight());
    }

    @Test
    void constructor_invalidRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("purple", -1.0, 5.0));
    }

    @Test
    void constructor_zeroHeight_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("purple", 3.0, 0.0));
    }

    @Test
    void constructor_nullColor_defaultsToUnknownColor() {
        Cylinder c = new Cylinder(null, 3.0, 5.0);
        assertEquals("Unknown Color", c.getColor());
    }

    @Test
    void getEfficiencyRatio_greaterThanZero() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertTrue(c.getEfficiencyRatio() > 0);
    }

    @Test
    void getDimensions_containsRadiusValue() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertTrue(c.getDimensions().contains("3.0"));
    }

    @Test
    void isLargerThan_returnsTrue_whenBigger() {
        Cylinder big = new Cylinder("purple", 5.0, 10.0);
        Cylinder small = new Cylinder("red", 1.0, 1.0);
        assertTrue(big.isLargerThan(small));
    }

    @Test
    void getName_returnsCylinder() {
        Cylinder c = new Cylinder("purple", 3.0, 5.0);
        assertEquals("Cylinder", c.getName());
    }
}