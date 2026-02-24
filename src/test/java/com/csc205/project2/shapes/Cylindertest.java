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
public class Cylindertest {

    // Standard Cylinder reused across tests
    private Cylinder cylinder;

    /**
     * Runs before each test — fresh Cylinder(radius=3, height=5).
     */
    @BeforeEach
    void setUp() {
        cylinder = new Cylinder("Red", 3.0, 5.0);
    }

    // =========================================================================
    // 1. BASIC FUNCTIONALITY — Constructors, Getters, Setters
    // =========================================================================

    @Test
    @DisplayName("Parameterized constructor sets all fields correctly")
    void testParameterizedConstructor() {
        assertEquals("Cylinder", cylinder.getName());
        assertEquals("Red",      cylinder.getColor());
        assertEquals(3.0,        cylinder.getRadius(), 0.0001);
        assertEquals(5.0,        cylinder.getHeight(), 0.0001);
    }

    @Test
    @DisplayName("Default constructor sets default values")
    void testDefaultConstructor() {
        Cylinder defaultCylinder = new Cylinder();
        assertEquals("cylinder", defaultCylinder.getName());
        assertEquals("none",     defaultCylinder.getColor());
        assertEquals(0.0,        defaultCylinder.getRadius(), 0.0001);
        assertEquals(0.0,        defaultCylinder.getHeight(), 0.0001);
    }

    @Test
    @DisplayName("getRadius returns correct radius")
    void testGetRadius() {
        assertEquals(3.0, cylinder.getRadius(), 0.0001);
    }

    @Test
    @DisplayName("getHeight returns correct height")
    void testGetHeight() {
        assertEquals(5.0, cylinder.getHeight(), 0.0001);
    }

    @Test
    @DisplayName("setRadius updates radius correctly")
    void testSetRadius() {
        cylinder.setRadius(7.0);
        assertEquals(7.0, cylinder.getRadius(), 0.0001);
    }

    @Test
    @DisplayName("setHeight updates height correctly")
    void testSetHeight() {
        cylinder.setHeight(10.0);
        assertEquals(10.0, cylinder.getHeight(), 0.0001);
    }

    @Test
    @DisplayName("setColor updates color correctly")
    void testSetColor() {
        cylinder.setColor("Blue");
        assertEquals("Blue", cylinder.getColor());
    }

    // =========================================================================
    // 2. CALCULATION ACCURACY — Volume and Surface Area with known values
    // =========================================================================

    @Test
    @DisplayName("Volume of cylinder with radius 3 and height 5 should be approx 141.372")
    void testVolumeCalculation() {
        // V = π * r^2 * h = π * 9 * 5 = 141.3716...
        double expected = Math.PI * Math.pow(3.0, 2) * 5.0;
        assertEquals(expected, cylinder.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of cylinder with radius 3 and height 5 should be approx 150.796")
    void testSurfaceAreaCalculation() {
        // SA = 2πr^2 + 2πrh = 2π(9) + 2π(3)(5) = 56.548 + 94.247 = 150.796...
        double expected = 2 * Math.PI * Math.pow(3.0, 2) + 2 * Math.PI * 3.0 * 5.0;
        assertEquals(expected, cylinder.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("getVolume() delegates to calculateVolume() correctly")
    void testGetVolumeDelegatesToCalculateVolume() {
        assertEquals(cylinder.calculateVolume(), cylinder.getVolume(), 0.0001);
    }

    @Test
    @DisplayName("getSurfaceArea() delegates to calculateSurfaceArea() correctly")
    void testGetSurfaceAreaDelegatesToCalculateSurfaceArea() {
        assertEquals(cylinder.calculateSurfaceArea(), cylinder.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume of cylinder with radius 1 and height 1 should be π ≈ 3.14159")
    void testVolumeRadiusOneHeightOne() {
        // V = π * 1^2 * 1 = π
        Cylinder unit = new Cylinder("Blue", 1.0, 1.0);
        assertEquals(Math.PI, unit.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of cylinder with radius 1 and height 1 should be 4π ≈ 12.566")
    void testSurfaceAreaRadiusOneHeightOne() {
        // SA = 2π(1)^2 + 2π(1)(1) = 2π + 2π = 4π
        Cylinder unit = new Cylinder("Blue", 1.0, 1.0);
        assertEquals(4 * Math.PI, unit.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume recalculates correctly after setRadius and setHeight")
    void testVolumeAfterSetters() {
        cylinder.setRadius(2.0);
        cylinder.setHeight(4.0);
        // V = π * 2^2 * 4 = 16π = 50.265...
        assertEquals(Math.PI * 4.0 * 4.0, cylinder.calculateVolume(), 0.0001);
    }

    // =========================================================================
    // 3. BOUNDARY TESTING — Zero, very small, very large numbers
    // =========================================================================

    @Test
    @DisplayName("Zero radius alone should throw IllegalArgumentException")
    void testZeroRadiusThrows() {
        // Decision: radius of 0 makes no physical sense — reject it even if height is valid
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("Red", 0.0, 5.0));
    }

    @Test
    @DisplayName("Zero height alone should throw IllegalArgumentException")
    void testZeroHeightThrows() {
        // Decision: height of 0 makes no physical sense — reject it even if radius is valid
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("Red", 3.0, 0.0));
    }

    @Test
    @DisplayName("Both radius and height zero should throw IllegalArgumentException")
    void testBothZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("Red", 0.0, 0.0));
    }

    @Test
    @DisplayName("Very small radius and height should still calculate correctly")
    void testVerySmallDimensions() {
        Cylinder tiny = new Cylinder("Red", 0.0001, 0.0001);
        double expectedVolume = Math.PI * Math.pow(0.0001, 2) * 0.0001;
        assertEquals(expectedVolume, tiny.calculateVolume(), 1e-15);
    }

    @Test
    @DisplayName("Very large radius and height should still calculate correctly")
    void testVeryLargeDimensions() {
        Cylinder huge = new Cylinder("Red", 1_000_000.0, 1_000_000.0);
        double expectedVolume = Math.PI * Math.pow(1_000_000.0, 2) * 1_000_000.0;
        assertEquals(expectedVolume, huge.calculateVolume(), 1e10);
    }

    @Test
    @DisplayName("setRadius to zero should throw IllegalArgumentException")
    void testSetRadiusZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(0.0));
    }

    @Test
    @DisplayName("setHeight to zero should throw IllegalArgumentException")
    void testSetHeightZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(0.0));
    }

    // =========================================================================
    // 4. INPUT VALIDATION — Negative values, null inputs
    // =========================================================================

    @Test
    @DisplayName("Negative radius alone in constructor should throw IllegalArgumentException")
    void testNegativeRadiusAloneThrows() {
        // With || fix — a negative radius is enough to throw even if height is fine
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("Red", -3.0, 5.0));
    }

    @Test
    @DisplayName("Negative height alone in constructor should throw IllegalArgumentException")
    void testNegativeHeightAloneThrows() {
        // With || fix — a negative height is enough to throw even if radius is fine
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("Red", 3.0, -5.0));
    }

    @Test
    @DisplayName("Both negative radius and height should throw IllegalArgumentException")
    void testBothNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder("Red", -3.0, -5.0));
    }

    @Test
    @DisplayName("setRadius to negative should throw IllegalArgumentException")
    void testSetRadiusNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(-1.0));
    }

    @Test
    @DisplayName("setHeight to negative should throw IllegalArgumentException")
    void testSetHeightNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(-1.0));
    }

    @Test
    @DisplayName("Null color in constructor should default to 'Unknown Color'")
    void testNullColorDefaultsToUnknown() {
        Cylinder nullColor = new Cylinder(null, 3.0, 5.0);
        assertEquals("Unknown Color", nullColor.getColor());
    }

    @Test
    @DisplayName("Empty string color in constructor should default to 'Unknown Color'")
    void testEmptyColorDefaultsToUnknown() {
        Cylinder emptyColor = new Cylinder("   ", 3.0, 5.0);
        assertEquals("Unknown Color", emptyColor.getColor());
    }

    // =========================================================================
    // 5. INHERITANCE TESTING — Polymorphic behavior
    // =========================================================================

    @Test
    @DisplayName("Cylinder is an instance of Shape3D (inheritance check)")
    void testCylinderIsInstanceOfShape3D() {
        assertTrue(cylinder instanceof Shape3D);
    }

    @Test
    @DisplayName("Cylinder works correctly when referenced as a Shape3D")
    void testCylinderAsShape3D() {
        // Polymorphism — store Cylinder in a Shape3D reference
        Shape3D shape = new Cylinder("Blue", 3.0, 5.0);

        // V = π * 3^2 * 5 = 141.3716...
        double expectedVolume = Math.PI * Math.pow(3.0, 2) * 5.0;
        assertEquals(expectedVolume, shape.getVolume(), 0.0001);

        // SA = 2π(3)^2 + 2π(3)(5) = 150.796...
        double expectedSA = 2 * Math.PI * Math.pow(3.0, 2) + 2 * Math.PI * 3.0 * 5.0;
        assertEquals(expectedSA, shape.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("toString contains expected cylinder information")
    void testToString() {
        String result = cylinder.toString();
        assertTrue(result.contains("Cylinder"));
        assertTrue(result.contains("Red"));
    }

    @Test
    @DisplayName("Recalculation is correct after both setRadius and setHeight")
    void testRecalculationAfterBothSetters() {
        cylinder.setRadius(4.0);
        cylinder.setHeight(6.0);
        // V = π * 4^2 * 6 = 96π = 301.592...
        double expectedVolume = Math.PI * Math.pow(4.0, 2) * 6.0;
        assertEquals(expectedVolume, cylinder.calculateVolume(), 0.0001);

        // SA = 2π(4)^2 + 2π(4)(6) = 32π + 48π = 80π = 251.327...
        double expectedSA = 2 * Math.PI * Math.pow(4.0, 2) + 2 * Math.PI * 4.0 * 6.0;
        assertEquals(expectedSA, cylinder.calculateSurfaceArea(), 0.0001);
    }
}