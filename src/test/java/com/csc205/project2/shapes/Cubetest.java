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
public class Cubetest {

    // A standard Cube instance reused across tests
    private Cube cube;

    /**
     * Runs before each test — gives us a fresh Cube(side=3) to work with.
     */
    @BeforeEach
    void setUp() {
        cube = new Cube("Red", 3.0);
    }

    // =========================================================================
    // 1. BASIC FUNCTIONALITY — Constructors, Getters, Setters
    // =========================================================================

    @Test
    @DisplayName("Parameterized constructor sets all fields correctly")
    void testParameterizedConstructor() {
        assertEquals("Cube",  cube.getName());
        assertEquals("Red",   cube.getColor());
        assertEquals(3.0,     cube.getSideLength(), 0.0001);
    }

    @Test
    @DisplayName("Default constructor sets default values")
    void testDefaultConstructor() {
        Cube defaultCube = new Cube();
        assertEquals("Cube",          defaultCube.getName());
        assertEquals("Unknown Color", defaultCube.getColor());
        assertEquals(1.0,             defaultCube.getSideLength(), 0.0001);
    }

    @Test
    @DisplayName("getSideLength returns the correct side length")
    void testGetSideLength() {
        assertEquals(3.0, cube.getSideLength(), 0.0001);
    }

    @Test
    @DisplayName("setSideLength updates the side length correctly")
    void testSetSideLength() {
        cube.setSideLength(5.0);
        assertEquals(5.0, cube.getSideLength(), 0.0001);
    }

    @Test
    @DisplayName("setColor updates the color correctly")
    void testSetColor() {
        cube.setColor("Blue");
        assertEquals("Blue", cube.getColor());
    }

    // =========================================================================
    // 2. CALCULATION ACCURACY — Volume and Surface Area with known values
    // =========================================================================

    @Test
    @DisplayName("Volume of cube with side 3 should be 27.0")
    void testVolumeCalculation() {
        // V = sideLength^3 = 3^3 = 27.0
        assertEquals(27.0, cube.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of cube with side 3 should be 54.0")
    void testSurfaceAreaCalculation() {
        // SA = 6 * sideLength^2 = 6 * 9 = 54.0
        assertEquals(54.0, cube.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("getVolume() delegates to calculateVolume() correctly")
    void testGetVolumeDelegatesToCalculateVolume() {
        // getVolume() in Shape3D calls calculateVolume() — results must match
        assertEquals(cube.calculateVolume(), cube.getVolume(), 0.0001);
    }

    @Test
    @DisplayName("getSurfaceArea() delegates to calculateSurfaceArea() correctly")
    void testGetSurfaceAreaDelegatesToCalculateSurfaceArea() {
        // getSurfaceArea() in Shape3D calls calculateSurfaceArea() — results must match
        assertEquals(cube.calculateSurfaceArea(), cube.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume of cube with side 5 should be 125.0")
    void testVolumeWithSideFive() {
        Cube bigCube = new Cube("Green", 5.0);
        assertEquals(125.0, bigCube.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of cube with side 5 should be 150.0")
    void testSurfaceAreaWithSideFive() {
        Cube bigCube = new Cube("Green", 5.0);
        assertEquals(150.0, bigCube.calculateSurfaceArea(), 0.0001);
    }



    // =========================================================================
    // 3. BOUNDARY TESTING — Zero, very small, very large numbers
    // =========================================================================

    @Test
    @DisplayName("Zero side length should throw IllegalArgumentException")
    void testZeroSideLength() {
        // Decision: A cube with side 0 has no physical meaning — reject it.
        assertThrows(IllegalArgumentException.class, () -> new Cube("Red", 0.0));
    }

    @Test
    @DisplayName("Very small side length (0.0001) should still calculate correctly")
    void testVerySmallSideLength() {
        Cube tinyCube = new Cube("Red", 0.0001);
        // V = 0.0001^3 = 1e-12
        assertEquals(1e-12, tinyCube.calculateVolume(), 1e-15);
        // SA = 6 * 0.0001^2 = 6e-8
        assertEquals(6e-8,  tinyCube.calculateSurfaceArea(), 1e-11);
    }

    @Test
    @DisplayName("Very large side length (1,000,000) should still calculate correctly")
    void testVeryLargeSideLength() {
        Cube hugeCube = new Cube("Red", 1_000_000.0);
        // V = 1e6^3 = 1e18
        assertEquals(1e18, hugeCube.calculateVolume(), 1e12);
        // SA = 6 * 1e6^2 = 6e12
        assertEquals(6e12, hugeCube.calculateSurfaceArea(), 1e6);
    }

    @Test
    @DisplayName("setSideLength to zero should throw IllegalArgumentException")
    void testSetSideLengthToZero() {
        assertThrows(IllegalArgumentException.class, () -> cube.setSideLength(0.0));
    }

    // =========================================================================
    // 4. INPUT VALIDATION — Negative values, null inputs
    // =========================================================================

    @Test
    @DisplayName("Negative side length in constructor should throw IllegalArgumentException")
    void testNegativeSideLengthConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Cube("Red", -5.0));
    }

    @Test
    @DisplayName("Negative side length in setter should throw IllegalArgumentException")
    void testNegativeSideLengthSetter() {
        assertThrows(IllegalArgumentException.class, () -> cube.setSideLength(-1.0));
    }

    @Test
    @DisplayName("Null color in constructor should default to 'Unknown Color'")
    void testNullColorDefaultsToUnknown() {
        // Decision: null color is handled gracefully rather than crashing.
        Cube nullColorCube = new Cube(null, 3.0);
        assertEquals("Unknown Color", nullColorCube.getColor());
    }

    @Test
    @DisplayName("Empty string color in constructor should default to 'Unknown Color'")
    void testEmptyColorDefaultsToUnknown() {
        Cube emptyColorCube = new Cube("   ", 3.0);
        assertEquals("Unknown Color", emptyColorCube.getColor());
    }

    // =========================================================================
    // 5. INHERITANCE TESTING — Polymorphic behavior
    // =========================================================================

    @Test
    @DisplayName("Cube is an instance of Shape3D (inheritance check)")
    void testCubeIsInstanceOfShape3D() {
        assertTrue(cube instanceof Shape3D);
    }

    @Test
    @DisplayName("Cube works correctly when referenced as a Shape3D")
    void testCubeAsShape3D() {
        // Polymorphism — store Cube in a Shape3D reference
        Shape3D shape = new Cube("Blue", 4.0);

        // Volume: 4^3 = 64.0
        assertEquals(64.0, shape.getVolume(), 0.0001);
        // Surface area: 6 * 4^2 = 96.0
        assertEquals(96.0, shape.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("toString contains expected cube information")
    void testToString() {
        String result = cube.toString();
        assertTrue(result.contains("Cube"));
        assertTrue(result.contains("Red"));
        assertTrue(result.contains("27.00"));  // volume
        assertTrue(result.contains("54.00"));  // surface area
        assertTrue(result.contains("4.00"));   // side length
    }

    @Test
    @DisplayName("Recalculation is correct after setSideLength update")
    void testRecalculationAfterSetSideLength() {
        cube.setSideLength(6.0);
        // V = 6^3 = 216
        assertEquals(216.0, cube.calculateVolume(), 0.0001);
        // SA = 6 * 6^2 = 216
        assertEquals(216.0, cube.calculateSurfaceArea(), 0.0001);
    }
}