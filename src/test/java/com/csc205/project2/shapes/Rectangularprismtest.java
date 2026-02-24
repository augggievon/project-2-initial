package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
public class Rectangularprismtest {

    // Standard RectangularPrism reused across tests
    private RectangularPrism prism;

    /**
     * Runs before each test — fresh RectangularPrism(length=4, height=3, width=5).
     */
    @BeforeEach
    void setUp() {
        prism = new RectangularPrism("Red", 4.0, 3.0, 5.0);
    }

    // =========================================================================
    // 1. BASIC FUNCTIONALITY — Constructors, Getters, Setters
    // =========================================================================

    @Test
    @DisplayName("Parameterized constructor sets all fields correctly")
    void testParameterizedConstructor() {
        assertEquals("retangularprism", prism.getName()); // Note: super() uses "Cylinder" as name
        assertEquals("Red",      prism.getColor());
        assertEquals(4.0,        prism.getLength(), 0.0001);
        assertEquals(3.0,        prism.getHeight(), 0.0001);
        assertEquals(5.0,        prism.getWidth(),  0.0001);
    }

    @Test
    @DisplayName("Default constructor sets default values")
    void testDefaultConstructor() {
        RectangularPrism defaultPrism = new RectangularPrism();
        assertEquals("retangularprism", defaultPrism.getName());
        assertEquals("none",     defaultPrism.getColor());
        assertEquals(0.0,        defaultPrism.getLength(), 0.0001);
        assertEquals(0.0,        defaultPrism.getHeight(), 0.0001);
        assertEquals(0.0,        defaultPrism.getWidth(),  0.0001);
    }

    @Test
    @DisplayName("getLength returns correct value")
    void testGetLength() {
        assertEquals(4.0, prism.getLength(), 0.0001);
    }

    @Test
    @DisplayName("getHeight returns correct value")
    void testGetHeight() {
        assertEquals(3.0, prism.getHeight(), 0.0001);
    }

    @Test
    @DisplayName("getWidth returns correct value")
    void testGetWidth() {
        assertEquals(5.0, prism.getWidth(), 0.0001);
    }

    @Test
    @DisplayName("setLength updates correctly")
    void testSetLength() {
        prism.setLength(10.0);
        assertEquals(10.0, prism.getLength(), 0.0001);
    }

    @Test
    @DisplayName("setHeight updates correctly")
    void testSetHeight() {
        prism.setHeight(8.0);
        assertEquals(8.0, prism.getHeight(), 0.0001);
    }

    @Test
    @DisplayName("setWidth updates correctly")
    void testSetWidth() {
        prism.setWidth(6.0);
        assertEquals(6.0, prism.getWidth(), 0.0001);
    }

    @Test
    @DisplayName("setColor updates correctly")
    void testSetColor() {
        prism.setColor("Blue");
        assertEquals("Blue", prism.getColor());
    }

    // =========================================================================
    // 2. CALCULATION ACCURACY — Volume and Surface Area with known values
    // =========================================================================

    @Test
    @DisplayName("Volume of prism with length=4, height=3, width=5 should be 60.0")
    void testVolumeCalculation() {
        // V = length * width * height = 4 * 5 * 3 = 60.0
        assertEquals(60.0, prism.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of prism with length=4, height=3, width=5 should be 94.0")
    void testSurfaceAreaCalculation() {
        // SA = 2 * (lw + lh + wh) = 2 * (20 + 12 + 15) = 2 * 47 = 94.0
        assertEquals(94.0, prism.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("getVolume() delegates to calculateVolume() correctly")
    void testGetVolumeDelegatesToCalculateVolume() {
        assertEquals(prism.calculateVolume(), prism.getVolume(), 0.0001);
    }

    @Test
    @DisplayName("getSurfaceArea() delegates to calculateSurfaceArea() correctly")
    void testGetSurfaceAreaDelegatesToCalculateSurfaceArea() {
        assertEquals(prism.calculateSurfaceArea(), prism.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume of a cube-like prism with all sides=2 should be 8.0")
    void testVolumeAllSidesEqual() {
        // V = 2 * 2 * 2 = 8.0
        RectangularPrism cube = new RectangularPrism("Blue", 2.0, 2.0, 2.0);
        assertEquals(8.0, cube.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of a cube-like prism with all sides=2 should be 24.0")
    void testSurfaceAreaAllSidesEqual() {
        // SA = 2 * (4 + 4 + 4) = 24.0
        RectangularPrism cube = new RectangularPrism("Blue", 2.0, 2.0, 2.0);
        assertEquals(24.0, cube.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume recalculates correctly after all three setters")
    void testVolumeAfterSetters() {
        prism.setLength(2.0);
        prism.setHeight(2.0);
        prism.setWidth(2.0);
        // V = 2 * 2 * 2 = 8.0
        assertEquals(8.0, prism.calculateVolume(), 0.0001);
    }

    // =========================================================================
    // 3. BOUNDARY TESTING — Zero, very small, very large numbers
    // =========================================================================

    @Test
    @DisplayName("Zero length alone should throw IllegalArgumentException")
    void testZeroLengthThrows() {
        // With || fix — zero length alone is enough to throw
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", 0.0, 3.0, 5.0));
    }

    @Test
    @DisplayName("Zero height alone should throw IllegalArgumentException")
    void testZeroHeightThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", 4.0, 0.0, 5.0));
    }

    @Test
    @DisplayName("Zero width alone should throw IllegalArgumentException")
    void testZeroWidthThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", 4.0, 3.0, 0.0));
    }

    @Test
    @DisplayName("All three dimensions zero should throw IllegalArgumentException")
    void testAllZeroThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", 0.0, 0.0, 0.0));
    }

    @Test
    @DisplayName("Very small dimensions should still calculate correctly")
    void testVerySmallDimensions() {
        RectangularPrism tiny = new RectangularPrism("Red", 0.0001, 0.0001, 0.0001);
        // V = 0.0001^3 = 1e-12
        assertEquals(1e-12, tiny.calculateVolume(), 1e-15);
    }

    @Test
    @DisplayName("Very large dimensions should still calculate correctly")
    void testVeryLargeDimensions() {
        RectangularPrism huge = new RectangularPrism("Red", 1_000_000.0, 1_000_000.0, 1_000_000.0);
        // V = 1e6^3 = 1e18
        assertEquals(1e18, huge.calculateVolume(), 1e10);
    }

    @Test
    @DisplayName("setLength to zero should throw IllegalArgumentException")
    void testSetLengthZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setLength(0.0));
    }

    @Test
    @DisplayName("setHeight to zero should throw IllegalArgumentException")
    void testSetHeightZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setHeight(0.0));
    }

    @Test
    @DisplayName("setWidth to zero should throw IllegalArgumentException")
    void testSetWidthZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setWidth(0.0));
    }

    // =========================================================================
    // 4. INPUT VALIDATION — Negative values, null inputs
    // =========================================================================

    @Test
    @DisplayName("Negative length alone in constructor should throw IllegalArgumentException")
    void testNegativeLengthAloneThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", -4.0, 3.0, 5.0));
    }

    @Test
    @DisplayName("Negative height alone in constructor should throw IllegalArgumentException")
    void testNegativeHeightAloneThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", 4.0, -3.0, 5.0));
    }

    @Test
    @DisplayName("Negative width alone in constructor should throw IllegalArgumentException")
    void testNegativeWidthAloneThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", 4.0, 3.0, -5.0));
    }

    @Test
    @DisplayName("All three negative in constructor should throw IllegalArgumentException")
    void testAllNegativeThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new RectangularPrism("Red", -4.0, -3.0, -5.0));
    }

    @Test
    @DisplayName("setLength to negative should throw IllegalArgumentException")
    void testSetLengthNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setLength(-1.0));
    }

    @Test
    @DisplayName("setHeight to negative should throw IllegalArgumentException")
    void testSetHeightNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setHeight(-1.0));
    }

    @Test
    @DisplayName("setWidth to negative should throw IllegalArgumentException")
    void testSetWidthNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setWidth(-1.0));
    }

    @Test
    @DisplayName("Null color in constructor should default to 'Unknown Color'")
    void testNullColorDefaultsToUnknown() {
        RectangularPrism nullColor = new RectangularPrism(null, 4.0, 3.0, 5.0);
        assertEquals("Unknown Color", nullColor.getColor());
    }

    @Test
    @DisplayName("Empty string color in constructor should default to 'Unknown Color'")
    void testEmptyColorDefaultsToUnknown() {
        RectangularPrism emptyColor = new RectangularPrism("   ", 4.0, 3.0, 5.0);
        assertEquals("Unknown Color", emptyColor.getColor());
    }

    // =========================================================================
    // 5. INHERITANCE TESTING — Polymorphic behavior
    // =========================================================================

    @Test
    @DisplayName("RectangularPrism is an instance of Shape3D (inheritance check)")
    void testRectangularPrismIsInstanceOfShape3D() {
        assertTrue(prism instanceof Shape3D);
    }

    @Test
    @DisplayName("RectangularPrism works correctly when referenced as a Shape3D")
    void testRectangularPrismAsShape3D() {
        // Polymorphism — store RectangularPrism in a Shape3D reference
        Shape3D shape = new RectangularPrism("Blue", 4.0, 3.0, 5.0);

        // V = 4 * 5 * 3 = 60.0
        assertEquals(60.0, shape.getVolume(), 0.0001);

        // SA = 2 * (4*5 + 4*3 + 5*3) = 2 * 47 = 94.0
        assertEquals(94.0, shape.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("toString contains expected prism information")
    void testToString() {
        String result = prism.toString();
        assertTrue(result.contains("Red"));
        assertTrue(result.contains("60"));  // volume
        assertTrue(result.contains("94"));  // surface area
    }

    @Test
    @DisplayName("Recalculation is correct after all three setters are updated")
    void testRecalculationAfterAllSetters() {
        prism.setLength(3.0);
        prism.setHeight(3.0);
        prism.setWidth(3.0);
        // V = 3 * 3 * 3 = 27.0
        assertEquals(27.0, prism.calculateVolume(), 0.0001);
        // SA = 2 * (9 + 9 + 9) = 54.0
        assertEquals(54.0, prism.calculateSurfaceArea(), 0.0001);
    }
}
