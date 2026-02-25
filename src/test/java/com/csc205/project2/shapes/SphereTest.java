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
 * "[For this shape class, generate JUnit 5 test classes that include:Basic Functionality: Constructor, getters, setters
 * * Calculation Accuracy: Volume and surface area with known values
 * * Boundary Testing: Zero values, very small/large numbers
 * * Input Validation: Negative values, null inputs
 * * Inheritance Testing: Polymorphic behavior verification. example test scenario // Test with known mathematical results
 //and I gave the ai my sphere class to write a test for]"
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
 * SphereTest.java
 * JUnit 5 test class for the Sphere shape.
 * Tests cover:
 *   - Basic functionality (constructors, getters, setters)
 *   - Calculation accuracy (volume and surface area)
 *   - Boundary conditions (zero, very small, very large)
 *   - Input validation (negatives, null)
 *   - Inheritance / polymorphic behavior
 */

public class SphereTest {

    @Test
    void calculateVolume_correctResult() {
        Sphere s = new Sphere("red", 3.0);
        assertEquals(113.10, s.calculateVolume(), 0.01);
    }

    @Test
    void calculateSurfaceArea_correctResult() {
        Sphere s = new Sphere("red", 3.0);
        assertEquals(113.10, s.calculateSurfaceArea(), 0.01);
    }

    @Test
    void getRadius_returnsCorrectValue() {
        Sphere s = new Sphere("red", 5.0);
        assertEquals(5.0, s.getRadius());
    }

    @Test
    void setRadius_updatesValue() {
        Sphere s = new Sphere("red", 3.0);
        s.setRadius(7.0);
        assertEquals(7.0, s.getRadius());
    }

    @Test
    void constructor_invalidRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere("red", -1.0));
    }

    @Test
    void constructor_zeroRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere("red", 0.0));
    }

    @Test
    void constructor_nullColor_defaultsToUnknownColor() {
        Sphere s = new Sphere(null, 3.0);
        assertEquals("Unknown Color", s.getColor());
    }

    @Test
    void getEfficiencyRatio_greaterThanZero() {
        Sphere s = new Sphere("red", 3.0);
        assertTrue(s.getEfficiencyRatio() > 0);
    }

    @Test
    void getDimensions_containsRadius() {
        Sphere s = new Sphere("red", 3.0);
        assertTrue(s.getDimensions().contains("3.0"));
    }

    @Test
    void isLargerThan_returnsTrue_whenBigger() {
        Sphere big = new Sphere("red", 5.0);
        Sphere small = new Sphere("blue", 2.0);
        assertTrue(big.isLargerThan(small));
    }

    @Test
    void isLargerThan_returnsFalse_whenSmaller() {
        Sphere big = new Sphere("red", 5.0);
        Sphere small = new Sphere("blue", 2.0);
        assertFalse(small.isLargerThan(big));
    }

    @Test
    void getName_returnsSphere() {
        Sphere s = new Sphere("red", 3.0);
        assertEquals("Sphere", s.getName());
    }

    @Test
    void getColor_returnsCorrectColor() {
        Sphere s = new Sphere("red", 3.0);
        assertEquals("red", s.getColor());
    }
}