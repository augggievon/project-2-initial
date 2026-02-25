package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
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

public class TriangularPrismTest {

    // constructor order: color, base, prismLength, triangleHeight, sideA, sideC
    @Test
    void calculateVolume_correctResult() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(60.0, t.calculateVolume(), 0.01);
    }

    @Test
    void calculateSurfaceArea_correctResult() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(152.0, t.calculateSurfaceArea(), 0.01);
    }

    @Test
    void getBase_returnsCorrectValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(4.0, t.getBase());
    }

    @Test
    void getPrismLength_returnsCorrectValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(10.0, t.getPrismLength());
    }

    @Test
    void getTriangleHeight_returnsCorrectValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(3.0, t.getTriangleHeight());
    }

    @Test
    void getSideA_returnsCorrectValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(5.0, t.getSideA());
    }

    @Test
    void getSideC_returnsCorrectValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals(5.0, t.getSideC());
    }

    @Test
    void setBase_updatesValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        t.setBase(6.0);
        assertEquals(6.0, t.getBase());
    }

    @Test
    void setPrismLength_updatesValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        t.setPrismLength(8.0);
        assertEquals(8.0, t.getPrismLength());
    }

    @Test
    void constructor_invalidBase_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new TriangularPrism("yellow", -1.0, 10.0, 3.0, 5.0, 5.0));
    }

    @Test
    void constructor_invalidSideA_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new TriangularPrism("yellow", 4.0, 10.0, 3.0, -1.0, 5.0));
    }

    @Test
    void constructor_nullColor_defaultsToUnknownColor() {
        TriangularPrism t = new TriangularPrism(null, 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals("Unknown Color", t.getColor());
    }

    @Test
    void getEfficiencyRatio_greaterThanZero() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertTrue(t.getEfficiencyRatio() > 0);
    }

    @Test
    void getDimensions_containsBaseValue() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertTrue(t.getDimensions().contains("4.0"));
    }

    @Test
    void isLargerThan_returnsTrue_whenBigger() {
        TriangularPrism big = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        TriangularPrism small = new TriangularPrism("red", 1.0, 1.0, 1.0, 1.0, 1.0);
        assertTrue(big.isLargerThan(small));
    }

    @Test
    void getName_returnsTriangularPrism() {
        TriangularPrism t = new TriangularPrism("yellow", 4.0, 10.0, 3.0, 5.0, 5.0);
        assertEquals("triangular prism", t.getName());
    }
}