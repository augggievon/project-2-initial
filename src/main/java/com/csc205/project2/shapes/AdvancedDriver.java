package com.csc205.project2.shapes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * ShapeDriver.java
 * Advanced driver class for the 3D Shape Analysis System.
 * Demonstrates:
 *   - Polymorphism: List of Shape3D references holding different shape types
 *   - Comparative Analysis: Largest volume, surface area, efficiency
 *   - Interactive Features: User can create custom shapes
 *   - Performance Timing: Measures calculation speeds in nanoseconds
 *   - Formatted Output: Professional presentation of all results
 */
public class AdvancedDriver {

    // -------------------------------------------------------------------------
    // Formatting constants
    // -------------------------------------------------------------------------
    private static final String DIVIDER     = "=".repeat(55);
    private static final String SUB_DIVIDER = "-".repeat(55);

    public static void main(String[] args) {

        System.out.println(DIVIDER);
        System.out.println("       3D SHAPE ANALYSIS SYSTEM");
        System.out.println(DIVIDER);

        // ---------------------------------------------------------------------
        // STEP 1 — Build a polymorphic list of Shape3D references
        // Each variable is typed as Shape3D but holds a different concrete shape
        // ---------------------------------------------------------------------
        List<Shape3D> shapes = new ArrayList<>();

        shapes.add(new Sphere("Red",          5.0));
        shapes.add(new Cube("Blue",            4.0));
        shapes.add(new Cylinder("Green",       3.0, 7.0));
        shapes.add(new RectangularPrism("Purple", 6.0, 4.0, 5.0));
        shapes.add(new TriangularPrism("Orange",  6.0, 10.0, 4.0, 5.0, 5.0));

        // ---------------------------------------------------------------------
        // STEP 2 — Display all shapes with performance timing
        // ---------------------------------------------------------------------
        System.out.println("\nCreated Shapes:");
        System.out.println(SUB_DIVIDER);

        List<Long> volumeTimes      = new ArrayList<>();
        List<Long> surfaceAreaTimes = new ArrayList<>();

        for (int i = 0; i < shapes.size(); i++) {
            Shape3D shape = shapes.get(i);

            // Time the volume calculation
            long startVolume = System.nanoTime();
            double volume = shape.getVolume();
            long endVolume = System.nanoTime();
            long volumeTime = endVolume - startVolume;
            volumeTimes.add(volumeTime);

            // Time the surface area calculation
            long startSA = System.nanoTime();
            double surfaceArea = shape.getSurfaceArea();
            long endSA = System.nanoTime();
            long saTime = endSA - startSA;
            surfaceAreaTimes.add(saTime);

            // Print formatted shape info
            System.out.printf("%n%d. %s (Color: %s)%n",
                    i + 1,
                    shape.getName(),
                    shape.getColor());
            System.out.printf("   Volume:       %10.2f cubic units%n",  volume);
            System.out.printf("   Surface Area: %10.2f square units%n", surfaceArea);
            System.out.printf("   Efficiency (Vol/SA): %.4f%n",         volume / surfaceArea);
            System.out.printf("   [Timing] Volume calc:       %,d ns%n", volumeTime);
            System.out.printf("   [Timing] Surface area calc: %,d ns%n", saTime);
        }

        // ---------------------------------------------------------------------
        // STEP 3 — Comparative Analysis
        // ---------------------------------------------------------------------
        System.out.println("\n" + DIVIDER);
        System.out.println("              ANALYSIS RESULTS");
        System.out.println(DIVIDER);

        // Largest volume
        Shape3D largestVolume = shapes.stream()
                .max(Comparator.comparingDouble(Shape3D::getVolume))
                .orElse(null);

        // Largest surface area
        Shape3D largestSA = shapes.stream()
                .max(Comparator.comparingDouble(Shape3D::getSurfaceArea))
                .orElse(null);

        // Most efficient: highest volume-to-surface-area ratio
        Shape3D mostEfficient = shapes.stream()
                .max(Comparator.comparingDouble(s -> s.getVolume() / s.getSurfaceArea()))
                .orElse(null);

        // Smallest volume
        Shape3D smallestVolume = shapes.stream()
                .min(Comparator.comparingDouble(Shape3D::getVolume))
                .orElse(null);

        System.out.printf("%n  Largest Volume:       %-20s (%.2f cubic units)%n",
                largestVolume  != null ? largestVolume.getName()  : "N/A",
                largestVolume  != null ? largestVolume.getVolume() : 0.0);

        System.out.printf("  Largest Surface Area: %-20s (%.2f square units)%n",
                largestSA      != null ? largestSA.getName()         : "N/A",
                largestSA      != null ? largestSA.getSurfaceArea()  : 0.0);

        System.out.printf("  Most Efficient:       %-20s (ratio: %.4f)%n",
                mostEfficient  != null ? mostEfficient.getName()                                    : "N/A",
                mostEfficient  != null ? mostEfficient.getVolume() / mostEfficient.getSurfaceArea() : 0.0);

        System.out.printf("  Smallest Volume:      %-20s (%.2f cubic units)%n",
                smallestVolume != null ? smallestVolume.getName()  : "N/A",
                smallestVolume != null ? smallestVolume.getVolume() : 0.0);

        // ---------------------------------------------------------------------
        // STEP 4 — Performance Summary
        // ---------------------------------------------------------------------
        System.out.println("\n" + DIVIDER);
        System.out.println("            PERFORMANCE SUMMARY");
        System.out.println(DIVIDER);

        long totalVolumeTime = volumeTimes.stream().mapToLong(Long::longValue).sum();
        long totalSATime     = surfaceAreaTimes.stream().mapToLong(Long::longValue).sum();
        long fastestVolume   = volumeTimes.stream().mapToLong(Long::longValue).min().orElse(0);
        long slowestVolume   = volumeTimes.stream().mapToLong(Long::longValue).max().orElse(0);

        System.out.printf("%n  Total volume calc time:       %,d ns%n",  totalVolumeTime);
        System.out.printf("  Total surface area calc time: %,d ns%n",    totalSATime);
        System.out.printf("  Fastest volume calculation:   %,d ns%n",    fastestVolume);
        System.out.printf("  Slowest volume calculation:   %,d ns%n",    slowestVolume);
        System.out.printf("  Average volume calc time:     %,.1f ns%n",
                (double) totalVolumeTime / shapes.size());

        // ---------------------------------------------------------------------
        // STEP 5 — Interactive: Let the user create a custom shape
        // ---------------------------------------------------------------------
        System.out.println("\n" + DIVIDER);
        System.out.println("         CREATE YOUR OWN SHAPE");
        System.out.println(DIVIDER);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose a shape to create:");
            System.out.println("  1. Sphere");
            System.out.println("  2. Cube");
            System.out.println("  3. Cylinder");
            System.out.println("  4. Rectangular Prism");
            System.out.println("  5. Triangular Prism");
            System.out.println("  6. Exit");
            System.out.print("\nEnter choice (1-6): ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Please enter a number 1-6.");
                continue;
            }

            if (choice == 6) {
                running = false;
                System.out.println("\nExiting shape creator. Peace out!");
                continue;
            }

            System.out.print("Enter color: ");
            String color = scanner.nextLine().trim();

            try {
                Shape3D customShape = null;

                switch (choice) {

                    case 1: // Sphere
                        System.out.print("Enter radius: ");
                        double radius = Double.parseDouble(scanner.nextLine().trim());

                        long s1 = System.nanoTime();
                        customShape = new Sphere(color, radius);
                        long e1 = System.nanoTime();
                        System.out.printf("  [Timing] Shape created in: %,d ns%n", e1 - s1);
                        break;

                    case 2: // Cube
                        System.out.print("Enter side length: ");
                        double side = Double.parseDouble(scanner.nextLine().trim());

                        long s2 = System.nanoTime();
                        customShape = new Cube(color, side);
                        long e2 = System.nanoTime();
                        System.out.printf("  [Timing] Shape created in: %,d ns%n", e2 - s2);
                        break;

                    case 3: // Cylinder
                        System.out.print("Enter radius: ");
                        double cylRadius = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter height: ");
                        double cylHeight = Double.parseDouble(scanner.nextLine().trim());

                        long s3 = System.nanoTime();
                        customShape = new Cylinder(color, cylRadius, cylHeight);
                        long e3 = System.nanoTime();
                        System.out.printf("  [Timing] Shape created in: %,d ns%n", e3 - s3);
                        break;

                    case 4: // Rectangular Prism
                        System.out.print("Enter length: ");
                        double rpLength = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter height: ");
                        double rpHeight = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter width: ");
                        double rpWidth  = Double.parseDouble(scanner.nextLine().trim());

                        long s4 = System.nanoTime();
                        customShape = new RectangularPrism(color, rpLength, rpHeight, rpWidth);
                        long e4 = System.nanoTime();
                        System.out.printf("  [Timing] Shape created in: %,d ns%n", e4 - s4);
                        break;

                    case 5: // Triangular Prism
                        System.out.print("Enter base: ");
                        double tpBase   = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter prism length: ");
                        double tpLength = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter triangle height: ");
                        double tpHeight = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter side A: ");
                        double tpSideA  = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter side C: ");
                        double tpSideC  = Double.parseDouble(scanner.nextLine().trim());

                        long s5 = System.nanoTime();
                        customShape = new TriangularPrism(color, tpBase, tpLength, tpHeight, tpSideA, tpSideC);
                        long e5 = System.nanoTime();
                        System.out.printf("  [Timing] Shape created in: %,d ns%n", e5 - s5);
                        break;

                    default:
                        System.out.println("  Invalid choice. Please enter 1-6.");
                        continue;
                }

                // Display the custom shape results
                if (customShape != null) {
                    System.out.println("\n" + SUB_DIVIDER);
                    System.out.println("  Your Custom Shape Results:");
                    System.out.println(SUB_DIVIDER);

                    long vStart = System.nanoTime();
                    double vol = customShape.getVolume();
                    long vEnd   = System.nanoTime();

                    long saStart = System.nanoTime();
                    double sa   = customShape.getSurfaceArea();
                    long saEnd   = System.nanoTime();

                    System.out.printf("  Shape:        %s%n",               customShape.getName());
                    System.out.printf("  Color:        %s%n",               customShape.getColor());
                    System.out.printf("  Volume:       %.2f cubic units%n",  vol);
                    System.out.printf("  Surface Area: %.2f square units%n", sa);
                    System.out.printf("  Efficiency:   %.4f%n",             vol / sa);
                    System.out.printf("  [Timing] Volume calc:       %,d ns%n", vEnd   - vStart);
                    System.out.printf("  [Timing] Surface area calc: %,d ns%n", saEnd  - saStart);
                    System.out.println(SUB_DIVIDER);

                    // Add to the main list and show updated analysis
                    shapes.add(customShape);
                    System.out.println("\n  Updated largest volume across all shapes:");

                    Shape3D newLargest = shapes.stream()
                            .max(Comparator.comparingDouble(Shape3D::getVolume))
                            .orElse(null);

                    System.out.printf("  -> %s with %.2f cubic units%n",
                            newLargest != null ? newLargest.getName()  : "N/A",
                            newLargest != null ? newLargest.getVolume() : 0.0);
                }

            } catch (NumberFormatException e) {
                System.out.println("  Invalid number entered. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("  Error creating shape: " + e.getMessage());
            }
        }

        System.out.println("\n" + DIVIDER);
        System.out.printf("  Total shapes created this session: %d%n", shapes.size());
        System.out.println(DIVIDER);
        scanner.close();
    }
}
