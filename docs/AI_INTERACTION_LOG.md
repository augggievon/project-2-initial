# AI Interaction Log

This document serves as a log of interactions with AI systems, capturing prompts, responses, and reflections on the outcomes. It is intended to help users track their engagements with AI and improve future interactions.

## Driver
Write a Java program that demonstrates polymorphism and object-oriented design using 3D geometric shapes.

Create classes representing several shapes — including Sphere, Cube, Cylinder, RectangularPrism, and TriangularPrism — each implementing methods to calculate surface area and volume.

In the ShapeDriver class, instantiate one object of each shape with unique dimensions and colors, call their calculateVolume() and calculateSurfaceArea() methods, and display their descriptive information to the console using System.out.println().

Example output should show each shape’s name, color, volume, and surface area.
## Class 1
Create a Java class named Cube that extends a base abstract class Shape3D.

The Cube class should include:

A private field to store the length of one side.

A constructor that accepts the cube’s color and side length, performing input validation to ensure the side is greater than zero and the color string is not null or empty.

Implementations of the abstract methods calculateSurfaceArea() and calculateVolume() using the mathematical formulas:

Surface Area =
6
×
side
2
6×side
2


Volume =
side
3
side
3


Include getter and setter methods for the side length with validation, and override toString() to display the cube’s name, color, volume, and surface area in a formatted output.

Test the class within ShapeDriver by creating a Cube object with sample values (e.g., color "titanium white" and side 4.0) and displaying its computed properties.
## Class 2
Create a Java class named Cylinder that extends the abstract base class Shape3D.

The Cylinder class should:

Store the radius of the base and the height of the cylinder as private double fields.

Provide a no-argument constructor that sets a default name "Cylinder", a default color (e.g., "none"), and initializes radius and height to 0.0.

Provide a constructor that accepts the cylinder’s color, radius, and height, validating that:

The color is not null or empty (otherwise use a fallback such as "Unknown Color").

Radius and height are greater than zero; if not, throw an IllegalArgumentException with a helpful message.

Implement the abstract methods calculateSurfaceArea() and calculateVolume() using the standard formulas for a right circular cylinder:




Include getter and setter methods for radius and height with validation to prevent non-positive values.

Override toString() to return a formatted String that includes the shape’s name, color, radius, height, volume, and surface area.
Finally, test the Cylinder class in ShapeDriver by creating at least one Cylinder object (for example, color "sap green", radius 5.5, height 6.0), calling its calculateVolume() and calculateSurfaceArea() methods, and printing the object to the console.