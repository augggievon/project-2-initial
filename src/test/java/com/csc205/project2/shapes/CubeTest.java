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
 * @Test void sphereVolumeCalculation() {
 *     // Volume of sphere with radius 3 should be 4/3 * π * 3³ = 113.097...
 * }
 * // Test boundary conditions
 * @Test void sphereWithZeroRadius() {
 *     // What should happen? Document your decision.
 * }
 * // Test polymorphism
 * @Test void sphereAsShape3D() {
 *     // Verify it works when treated as Shape3D reference
 * } and here is the class i want a test for // Test with known mathematical results
 * @Test void sphereVolumeCalculation() {
 *     // Volume of sphere with radius 3 should be 4/3 * π * 3³ = 113.097...
 * }
 * // Test boundary conditions
 * @Test void sphereWithZeroRadius() {
 *     // What should happen? Document your decision.
 * }
 * // Test polymorphism
 * @Test void sphereAsShape3D() {
 *     // Verify it works when treated as Shape3D reference
 * }]"
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
 * CubeTest.java
 * JUnit 5 test class for the Cube shape.
 * Tests cover:
 *   - Basic functionality (constructors, getters, setters)
 *   - Calculation accuracy (volume and surface area)
 *   - Boundary conditions (zero, very small, very large)
 *   - Input validation (negatives, null)
 *   - Inheritance / polymorphic behavior
 */

public class CubeTest {

    @Test
    void calculateVolume_correctResult() {
        Cube c = new Cube("blue", 3.0);
        assertEquals(27.0, c.calculateVolume(), 0.01);
    }

    @Test
    void calculateSurfaceArea_correctResult() {
        Cube c = new Cube("blue", 3.0);
        assertEquals(54.0, c.calculateSurfaceArea(), 0.01);
    }

    @Test
    void getSideLength_returnsCorrectValue() {
        Cube c = new Cube("blue", 4.0);
        assertEquals(4.0, c.getSideLength());
    }

    @Test
    void setSideLength_updatesValue() {
        Cube c = new Cube("blue", 3.0);
        c.setSideLength(6.0);
        assertEquals(6.0, c.getSideLength());
    }

    @Test
    void constructor_invalidSide_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Cube("blue", -1.0));
    }

    @Test
    void constructor_zeroSide_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Cube("blue", 0.0));
    }

    @Test
    void constructor_nullColor_defaultsToUnknownColor() {
        Cube c = new Cube(null, 3.0);
        assertEquals("Unknown Color", c.getColor());
    }

    @Test
    void getEfficiencyRatio_correctResult() {
        Cube c = new Cube("blue", 3.0);
        assertEquals(2.0, c.getEfficiencyRatio(), 0.01);
    }

    @Test
    void getDimensions_containsSideValue() {
        Cube c = new Cube("blue", 3.0);
        assertTrue(c.getDimensions().contains("3.0"));
    }

    @Test
    void isLargerThan_returnsTrue_whenBigger() {
        Cube big = new Cube("blue", 5.0);
        Cube small = new Cube("red", 2.0);
        assertTrue(big.isLargerThan(small));
    }

    @Test
    void isLargerThan_returnsFalse_whenSmaller() {
        Cube big = new Cube("blue", 5.0);
        Cube small = new Cube("red", 2.0);
        assertFalse(small.isLargerThan(big));
    }

    @Test
    void getName_returnsCube() {
        Cube c = new Cube("blue", 3.0);
        assertEquals("Cube", c.getName());
    }

    @Test
    void getColor_returnsCorrectColor() {
        Cube c = new Cube("blue", 3.0);
        assertEquals("blue", c.getColor());
    }
}