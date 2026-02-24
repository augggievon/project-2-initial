package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TriangularPrismTest.java
 * JUnit 5 test class for the TriangularPrism shape.
 * Tests cover:
 *   - Basic functionality (constructors, getters, setters)
 *   - Calculation accuracy (volume and surface area)
 *   - Boundary conditions (zero, very small, very large)
 *   - Input validation (negatives, null)
 *   - Inheritance / polymorphic behavior
 *
 * Test shape dimensions used:
 *   base=6, prismLength=10, triangleHeight=4, sideA=5, sideC=5
 *
 * Volume:       1/2 * base * prismLength * triangleHeight
 *             = 1/2 * 6 * 10 * 4 = 120.0
 *
 * Surface Area: (base * triangleHeight) + prismLength * (sideC + base + sideA)
 *             = (6 * 4) + 10 * (5 + 6 + 5)
 *             = 24 + 160 = 184.0
 */
public class Triangularprismtest {

    // Standard TriangularPrism reused across tests
    private TriangularPrism prism;

    /**
     * Runs before each test — fresh TriangularPrism with known dimensions.
     */
    @BeforeEach
    void setUp() {
        prism = new TriangularPrism("Red", 6.0, 10.0, 4.0, 5.0, 5.0);
    }

    // =========================================================================
    // 1. BASIC FUNCTIONALITY — Constructors, Getters, Setters
    // =========================================================================

    @Test
    @DisplayName("Parameterized constructor sets all fields correctly")
    void testParameterizedConstructor() {
        assertEquals("triangular prism", prism.getName());
        assertEquals("Red",              prism.getColor());
        assertEquals(6.0,                prism.getBase(),           0.0001);
        assertEquals(10.0,               prism.getPrismLength(),    0.0001);
        assertEquals(4.0,                prism.getTriangleHeight(), 0.0001);
        assertEquals(5.0,                prism.getSideA(),          0.0001);
        assertEquals(5.0,                prism.getSideC(),          0.0001);
    }

    @Test
    @DisplayName("Default constructor sets all fields to defaults")
    void testDefaultConstructor() {
        TriangularPrism defaultPrism = new TriangularPrism();
        assertEquals("triangular prism", defaultPrism.getName());
        assertEquals("none",             defaultPrism.getColor());
        assertEquals(0.0,                defaultPrism.getBase(),           0.0001);
        assertEquals(0.0,                defaultPrism.getPrismLength(),    0.0001);
        assertEquals(0.0,                defaultPrism.getTriangleHeight(), 0.0001);
        assertEquals(0.0,                defaultPrism.getSideA(),          0.0001);
        assertEquals(0.0,                defaultPrism.getSideC(),          0.0001);
    }

    @Test
    @DisplayName("getBase returns correct value")
    void testGetBase() {
        assertEquals(6.0, prism.getBase(), 0.0001);
    }

    @Test
    @DisplayName("getPrismLength returns correct value")
    void testGetPrismLength() {
        assertEquals(10.0, prism.getPrismLength(), 0.0001);
    }

    @Test
    @DisplayName("getTriangleHeight returns correct value")
    void testGetTriangleHeight() {
        assertEquals(4.0, prism.getTriangleHeight(), 0.0001);
    }

    @Test
    @DisplayName("getSideA returns correct value")
    void testGetSideA() {
        assertEquals(5.0, prism.getSideA(), 0.0001);
    }

    @Test
    @DisplayName("getSideC returns correct value")
    void testGetSideC() {
        assertEquals(5.0, prism.getSideC(), 0.0001);
    }

    @Test
    @DisplayName("setBase updates correctly")
    void testSetBase() {
        prism.setBase(8.0);
        assertEquals(8.0, prism.getBase(), 0.0001);
    }

    @Test
    @DisplayName("setPrismLength updates correctly")
    void testSetPrismLength() {
        prism.setPrismLength(12.0);
        assertEquals(12.0, prism.getPrismLength(), 0.0001);
    }

    @Test
    @DisplayName("setTriangleHeight updates correctly")
    void testSetTriangleHeight() {
        prism.setTriangleHeight(6.0);
        assertEquals(6.0, prism.getTriangleHeight(), 0.0001);
    }

    @Test
    @DisplayName("setSideA updates correctly")
    void testSetSideA() {
        prism.setSideA(7.0);
        assertEquals(7.0, prism.getSideA(), 0.0001);
    }

    @Test
    @DisplayName("setSideC updates correctly")
    void testSetSideC() {
        prism.setSideC(7.0);
        assertEquals(7.0, prism.getSideC(), 0.0001);
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
    @DisplayName("Volume with base=6, prismLength=10, triangleHeight=4 should be 120.0")
    void testVolumeCalculation() {
        // V = 1/2 * base * prismLength * triangleHeight
        //   = 1/2 * 6 * 10 * 4 = 120.0
        assertEquals(120.0, prism.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area with all dimensions set should be 184.0")
    void testSurfaceAreaCalculation() {
        // SA = (base * triangleHeight) + prismLength * (sideC + base + sideA)
        //    = (6 * 4) + 10 * (5 + 6 + 5)
        //    = 24 + 160 = 184.0
        assertEquals(184.0, prism.calculateSurfaceArea(), 0.0001);
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
    @DisplayName("Volume recalculates correctly after setters are called")
    void testVolumeAfterSetters() {
        prism.setBase(4.0);
        prism.setPrismLength(5.0);
        prism.setTriangleHeight(2.0);
        // V = 1/2 * 4 * 5 * 2 = 20.0
        assertEquals(20.0, prism.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area recalculates correctly after setters are called")
    void testSurfaceAreaAfterSetters() {
        prism.setBase(3.0);
        prism.setPrismLength(8.0);
        prism.setTriangleHeight(2.0);
        prism.setSideA(4.0);
        prism.setSideC(4.0);
        // SA = (3 * 2) + 8 * (4 + 3 + 4)
        //    = 6 + 8 * 11 = 6 + 88 = 94.0
        assertEquals(94.0, prism.calculateSurfaceArea(), 0.0001);
    }

    // =========================================================================
    // 3. BOUNDARY TESTING — Zero, very small, very large numbers
    // =========================================================================

    @Test
    @DisplayName("Zero base alone should throw IllegalArgumentException")
    void testZeroBaseThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 0.0, 10.0, 4.0, 5.0, 5.0));
    }

    @Test
    @DisplayName("Zero prismLength alone should throw IllegalArgumentException")
    void testZeroPrismLengthThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 0.0, 4.0, 5.0, 5.0));
    }

    @Test
    @DisplayName("Zero triangleHeight alone should throw IllegalArgumentException")
    void testZeroTriangleHeightThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 10.0, 0.0, 5.0, 5.0));
    }

    @Test
    @DisplayName("Zero sideA alone should throw IllegalArgumentException")
    void testZeroSideAThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 10.0, 4.0, 0.0, 5.0));
    }

    @Test
    @DisplayName("Zero sideC alone should throw IllegalArgumentException")
    void testZeroSideCThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 10.0, 4.0, 5.0, 0.0));
    }

    @Test
    @DisplayName("Very small dimensions should still calculate correctly")
    void testVerySmallDimensions() {
        TriangularPrism tiny = new TriangularPrism("Red", 0.001, 0.001, 0.001, 0.001, 0.001);
        // V = 1/2 * 0.001 * 0.001 * 0.001 = 5e-10
        assertEquals(5e-10, tiny.calculateVolume(), 1e-13);
    }

    @Test
    @DisplayName("Very large dimensions should still calculate correctly")
    void testVeryLargeDimensions() {
        TriangularPrism huge = new TriangularPrism("Red", 1000.0, 1000.0, 1000.0, 1000.0, 1000.0);
        // V = 1/2 * 1000 * 1000 * 1000 = 500,000,000.0
        assertEquals(500_000_000.0, huge.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("setBase to zero should throw IllegalArgumentException")
    void testSetBaseZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setBase(0.0));
    }

    @Test
    @DisplayName("setPrismLength to zero should throw IllegalArgumentException")
    void testSetPrismLengthZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setPrismLength(0.0));
    }

    @Test
    @DisplayName("setTriangleHeight to zero should throw IllegalArgumentException")
    void testSetTriangleHeightZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setTriangleHeight(0.0));
    }

    @Test
    @DisplayName("setSideA to zero should throw IllegalArgumentException")
    void testSetSideAZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setSideA(0.0));
    }

    @Test
    @DisplayName("setSideC to zero should throw IllegalArgumentException")
    void testSetSideCZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setSideC(0.0));
    }

    // =========================================================================
    // 4. INPUT VALIDATION — Negative values, null inputs
    // =========================================================================

    @Test
    @DisplayName("Negative base alone should throw IllegalArgumentException")
    void testNegativeBaseThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", -6.0, 10.0, 4.0, 5.0, 5.0));
    }

    @Test
    @DisplayName("Negative prismLength alone should throw IllegalArgumentException")
    void testNegativePrismLengthThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, -10.0, 4.0, 5.0, 5.0));
    }

    @Test
    @DisplayName("Negative triangleHeight alone should throw IllegalArgumentException")
    void testNegativeTriangleHeightThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 10.0, -4.0, 5.0, 5.0));
    }

    @Test
    @DisplayName("Negative sideA alone should throw IllegalArgumentException")
    void testNegativeSideAThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 10.0, 4.0, -5.0, 5.0));
    }

    @Test
    @DisplayName("Negative sideC alone should throw IllegalArgumentException")
    void testNegativeSideCThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> new TriangularPrism("Red", 6.0, 10.0, 4.0, 5.0, -5.0));
    }

    @Test
    @DisplayName("setBase to negative should throw IllegalArgumentException")
    void testSetBaseNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setBase(-1.0));
    }

    @Test
    @DisplayName("setPrismLength to negative should throw IllegalArgumentException")
    void testSetPrismLengthNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setPrismLength(-1.0));
    }

    @Test
    @DisplayName("setTriangleHeight to negative should throw IllegalArgumentException")
    void testSetTriangleHeightNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setTriangleHeight(-1.0));
    }

    @Test
    @DisplayName("setSideA to negative should throw IllegalArgumentException")
    void testSetSideANegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setSideA(-1.0));
    }

    @Test
    @DisplayName("setSideC to negative should throw IllegalArgumentException")
    void testSetSideCNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> prism.setSideC(-1.0));
    }

    @Test
    @DisplayName("Null color in constructor should default to 'Unknown Color'")
    void testNullColorDefaultsToUnknown() {
        TriangularPrism nullColor = new TriangularPrism(null, 6.0, 10.0, 4.0, 5.0, 5.0);
        assertEquals("Unknown Color", nullColor.getColor());
    }

    @Test
    @DisplayName("Empty string color in constructor should default to 'Unknown Color'")
    void testEmptyColorDefaultsToUnknown() {
        TriangularPrism emptyColor = new TriangularPrism("   ", 6.0, 10.0, 4.0, 5.0, 5.0);
        assertEquals("Unknown Color", emptyColor.getColor());
    }

    // =========================================================================
    // 5. INHERITANCE TESTING — Polymorphic behavior
    // =========================================================================

    @Test
    @DisplayName("TriangularPrism is an instance of Shape3D (inheritance check)")
    void testTriangularPrismIsInstanceOfShape3D() {
        assertTrue(prism instanceof Shape3D);
    }

    @Test
    @DisplayName("TriangularPrism works correctly when referenced as a Shape3D")
    void testTriangularPrismAsShape3D() {
        // Polymorphism — store TriangularPrism in a Shape3D reference
        Shape3D shape = new TriangularPrism("Blue", 6.0, 10.0, 4.0, 5.0, 5.0);

        // V = 1/2 * 6 * 10 * 4 = 120.0
        assertEquals(120.0, shape.getVolume(), 0.0001);

        // SA = (6 * 4) + 10 * (5 + 6 + 5) = 24 + 160 = 184.0
        assertEquals(184.0, shape.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("toString contains expected triangular prism information")
    void testToString() {
        String result = prism.toString();
        assertTrue(result.contains("triangular prism"));
        assertTrue(result.contains("Red"));
    }
}
