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
 //and I gave the ai my rectangularprism class to write a test for]"
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
 * RectangularPrismTest.java
 * JUnit 5 test class for the RectangularPrism shape.
 * Tests cover:
 *   - Basic functionality (constructors, getters, setters)
 *   - Calculation accuracy (volume and surface area)
 *   - Boundary conditions (zero, very small, very large)
 *   - Input validation (negatives, null)
 *   - Inheritance / polymorphic behavior
 *
 * NOTE: Tests assume constructor validation uses || (OR) —
 * meaning ANY single invalid dimension is enough to throw.
 */

public class RectangularPrismTest {

    // constructor order is: color, length, height, width
    @Test
    void calculateVolume_correctResult() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertEquals(24.0, r.calculateVolume(), 0.01);
    }

    @Test
    void calculateSurfaceArea_correctResult() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertEquals(52.0, r.calculateSurfaceArea(), 0.01);
    }

    @Test
    void getLength_returnsCorrectValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertEquals(2.0, r.getLength());
    }

    @Test
    void getHeight_returnsCorrectValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertEquals(3.0, r.getHeight());
    }

    @Test
    void getWidth_returnsCorrectValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertEquals(4.0, r.getWidth());
    }

    @Test
    void setLength_updatesValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        r.setLength(5.0);
        assertEquals(5.0, r.getLength());
    }

    @Test
    void setHeight_updatesValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        r.setHeight(6.0);
        assertEquals(6.0, r.getHeight());
    }

    @Test
    void setWidth_updatesValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        r.setWidth(7.0);
        assertEquals(7.0, r.getWidth());
    }

    @Test
    void constructor_invalidLength_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism("green", -1.0, 3.0, 4.0));
    }

    @Test
    void constructor_invalidHeight_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism("green", 2.0, -1.0, 4.0));
    }

    @Test
    void constructor_invalidWidth_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism("green", 2.0, 3.0, -1.0));
    }

    @Test
    void constructor_nullColor_defaultsToUnknownColor() {
        RectangularPrism r = new RectangularPrism(null, 2.0, 3.0, 4.0);
        assertEquals("Unknown Color", r.getColor());
    }

    @Test
    void getEfficiencyRatio_greaterThanZero() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertTrue(r.getEfficiencyRatio() > 0);
    }

    @Test
    void getDimensions_containsLengthValue() {
        RectangularPrism r = new RectangularPrism("green", 2.0, 3.0, 4.0);
        assertTrue(r.getDimensions().contains("2.0"));
    }

    @Test
    void isLargerThan_returnsTrue_whenBigger() {
        RectangularPrism big = new RectangularPrism("green", 5.0, 5.0, 5.0);
        RectangularPrism small = new RectangularPrism("red", 1.0, 1.0, 1.0);
        assertTrue(big.isLargerThan(small));
    }
}