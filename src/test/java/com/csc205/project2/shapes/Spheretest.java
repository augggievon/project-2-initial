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
public class Spheretest {

    // Standard Sphere reused across tests
    private Sphere sphere;

    /**
     * Runs before each test — fresh Sphere with radius=3.
     */
    @BeforeEach
    void setUp() {
        sphere = new Sphere("Red", 3.0);
    }

    // =========================================================================
    // 1. BASIC FUNCTIONALITY — Constructors, Getters, Setters
    // =========================================================================

    @Test
    @DisplayName("Parameterized constructor sets all fields correctly")
    void testParameterizedConstructor() {
        assertEquals("Sphere", sphere.getName());
        assertEquals("Red",    sphere.getColor());
        assertEquals(3.0,      sphere.getRadius(), 0.0001);
    }

    @Test
    @DisplayName("Default constructor sets default values")
    void testDefaultConstructor() {
        Sphere defaultSphere = new Sphere();
        assertEquals("Sphere", defaultSphere.getName());
        assertEquals("none",   defaultSphere.getColor());
        assertEquals(0.0,      defaultSphere.getRadius(), 0.0001);
    }

    @Test
    @DisplayName("getRadius returns correct radius")
    void testGetRadius() {
        assertEquals(3.0, sphere.getRadius(), 0.0001);
    }

    @Test
    @DisplayName("setRadius updates radius correctly")
    void testSetRadius() {
        sphere.setRadius(7.0);
        assertEquals(7.0, sphere.getRadius(), 0.0001);
    }

    @Test
    @DisplayName("setColor updates color correctly")
    void testSetColor() {
        sphere.setColor("Blue");
        assertEquals("Blue", sphere.getColor());
    }

    // =========================================================================
    // 2. CALCULATION ACCURACY — Volume and Surface Area with known values
    // =========================================================================

    @Test
    @DisplayName("Volume of sphere with radius 3 should be approx 113.097")
    void testVolumeCalculation() {
        // V = 4/3 * π * r^3 = 4/3 * π * 27 = 113.0973...
        double expected = (4.0 / 3.0) * Math.PI * Math.pow(3.0, 3);
        assertEquals(expected, sphere.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of sphere with radius 3 should be approx 113.097")
    void testSurfaceAreaCalculation() {
        // SA = 4 * π * r^2 = 4 * π * 9 = 113.0973...
        double expected = 4.0 * Math.PI * Math.pow(3.0, 2);
        assertEquals(expected, sphere.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("getVolume() delegates to calculateVolume() correctly")
    void testGetVolumeDelegatesToCalculateVolume() {
        assertEquals(sphere.calculateVolume(), sphere.getVolume(), 0.0001);
    }

    @Test
    @DisplayName("getSurfaceArea() delegates to calculateSurfaceArea() correctly")
    void testGetSurfaceAreaDelegatesToCalculateSurfaceArea() {
        assertEquals(sphere.calculateSurfaceArea(), sphere.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume of sphere with radius 1 should be 4/3 * π ≈ 4.189")
    void testVolumeRadiusOne() {
        // V = 4/3 * π * 1^3 = 4/3 * π = 4.1887...
        Sphere unit = new Sphere("Blue", 1.0);
        assertEquals((4.0 / 3.0) * Math.PI, unit.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Surface area of sphere with radius 1 should be 4π ≈ 12.566")
    void testSurfaceAreaRadiusOne() {
        // SA = 4 * π * 1^2 = 4π = 12.5663...
        Sphere unit = new Sphere("Blue", 1.0);
        assertEquals(4.0 * Math.PI, unit.calculateSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("Volume of sphere with radius 5 should be approx 523.599")
    void testVolumeRadiusFive() {
        // V = 4/3 * π * 5^3 = 4/3 * π * 125 = 523.5987...
        Sphere big = new Sphere("Green", 5.0);
        double expected = (4.0 / 3.0) * Math.PI * Math.pow(5.0, 3);
        assertEquals(expected, big.calculateVolume(), 0.0001);
    }

    @Test
    @DisplayName("Volume recalculates correctly after setRadius")
    void testVolumeAfterSetRadius() {
        sphere.setRadius(6.0);
        double expected = (4.0 / 3.0) * Math.PI * Math.pow(6.0, 3);
        assertEquals(expected, sphere.calculateVolume(), 0.0001);
    }

    // =========================================================================
    // 3. BOUNDARY TESTING — Zero, very small, very large numbers
    // =========================================================================

    @Test
    @DisplayName("Zero radius in constructor should throw IllegalArgumentException")
    void testZeroRadiusThrows() {
        // Decision: a sphere with radius 0 has no physical meaning — reject it
        assertThrows(IllegalArgumentException.class, () -> new Sphere("Red", 0.0));
    }

    @Test
    @DisplayName("Very small radius (0.0001) should still calculate correctly")
    void testVerySmallRadius() {
        Sphere tiny = new Sphere("Red", 0.0001);
        double expected = (4.0 / 3.0) * Math.PI * Math.pow(0.0001, 3);
        assertEquals(expected, tiny.calculateVolume(), 1e-15);
    }

    @Test
    @DisplayName("Very large radius (1,000,000) should still calculate correctly")
    void testVeryLargeRadius() {
        Sphere huge = new Sphere("Red", 1_000_000.0);
        double expected = (4.0 / 3.0) * Math.PI * Math.pow(1_000_000.0, 3);
        assertEquals(expected, huge.calculateVolume(), 1e10);
    }

    @Test
    @DisplayName("setRadius to zero should throw IllegalArgumentException")
    void testSetRadiusZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(0.0));
    }

    // =========================================================================
    // 4. INPUT VALIDATION — Negative values, null inputs
    // =========================================================================

    @Test
    @DisplayName("Negative radius in constructor should throw IllegalArgumentException")
    void testNegativeRadiusThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere("Red", -3.0));
    }

    @Test
    @DisplayName("setRadius to negative should throw IllegalArgumentException")
    void testSetRadiusNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(-1.0));
    }

    @Test
    @DisplayName("Null color in constructor should default to 'Unknown Color'")
    void testNullColorDefaultsToUnknown() {
        Sphere nullColor = new Sphere(null, 3.0);
        assertEquals("Unknown Color", nullColor.getColor());
    }

    @Test
    @DisplayName("Empty string color in constructor should default to 'Unknown Color'")
    void testEmptyColorDefaultsToUnknown() {
        Sphere emptyColor = new Sphere("   ", 3.0);
        assertEquals("Unknown Color", emptyColor.getColor());
    }

    // =========================================================================
    // 5. INHERITANCE TESTING — Polymorphic behavior
    // =========================================================================

    @Test
    @DisplayName("Sphere is an instance of Shape3D (inheritance check)")
    void testSphereIsInstanceOfShape3D() {
        assertTrue(sphere instanceof Shape3D);
    }

    @Test
    @DisplayName("Sphere works correctly when referenced as a Shape3D")
    void testSphereAsShape3D() {
        // Polymorphism — store Sphere in a Shape3D reference
        Shape3D shape = new Sphere("Blue", 3.0);

        // V = 4/3 * π * 3^3 = 113.097...
        double expectedVolume = (4.0 / 3.0) * Math.PI * Math.pow(3.0, 3);
        assertEquals(expectedVolume, shape.getVolume(), 0.0001);

        // SA = 4 * π * 3^2 = 113.097...
        double expectedSA = 4.0 * Math.PI * Math.pow(3.0, 2);
        assertEquals(expectedSA, shape.getSurfaceArea(), 0.0001);
    }

    @Test
    @DisplayName("toString contains expected sphere information")
    void testToString() {
        String result = sphere.toString();
        assertTrue(result.contains("Sphere"));
        assertTrue(result.contains("Red"));
    }

    @Test
    @DisplayName("Recalculation is correct after setRadius update")
    void testRecalculationAfterSetRadius() {
        sphere.setRadius(2.0);
        // V = 4/3 * π * 2^3 = 33.510...
        double expectedVolume = (4.0 / 3.0) * Math.PI * Math.pow(2.0, 3);
        assertEquals(expectedVolume, sphere.calculateVolume(), 0.0001);

        // SA = 4 * π * 2^2 = 50.265...
        double expectedSA = 4.0 * Math.PI * Math.pow(2.0, 2);
        assertEquals(expectedSA, sphere.calculateSurfaceArea(), 0.0001);
    }
}
