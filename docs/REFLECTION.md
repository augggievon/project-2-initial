# Reflections Log

This document serves as a log of reflections on various topics, capturing insights, lessons learned, and personal growth. It is intended to help users track their thoughts and experiences over time.

NIST (National Institute of Standards and Technology) src for volume of cube
Surface area formula verified against: [Khan Academy] for cube

Volume formula verified against: [Rice University (OpenStax)] --sphere
* - Surface area formula verified against: [Rice University (OpenStax)] --sphere

Volume formula verified against: [NIST (National Institute of Standards and Technology)] --triangular prism
* - Surface area formula verified against: [Khan Academy] --triangular prism

Volume formula verified against: [NIST (National Institute of Standards and Technology)] --rectangular prism
* - Surface area formula verified against: [Khan Academy] --rectangular prism

Volume formula verified against: [NIST (National Institute of Standards and Technology)] --cylinder
* - Surface area formula verified against: [Khan Academy] --cylinder

sphere calculations verified:
*given radius of 5.5 desmos calculator yields surface area as 380.13 and volume = 696.909
* output of code with ShapeDriver was 696.91 = volume and surface area = 380.13

cylinder calculations verified:
given a radius of 5.5 and a height of 6 the desmos calculator has surface area = 397.41 and volume= 570.20
output of the code yields the same values of the desmos calculations

cube calcs verified:
given a side of 4 the desmos calculations surface area = 96.0 and volume = 64.0
output in the code yields the same vaules as the desmos caclulations

triangular prism calcs verified:
given a base of 5.5 , a prism length of 4.8, a triangle heights of 6.9, sideA of 7 and a sideC of 3.3
desmos gives surface area = 113.79 and volume = 91.08

rectangular prism calculations verified:
given length = 5.6, height = 7.7 and width = 9.8 desmos gave volume = 422.58 and surface area = 346.92
output of code gives the same values.

Verified all formulas by cross referencing legible sources and by using calculators like desmos to
determine if the output of the code was correct given the same input values passed into the constructor in the driver class.


AI Effectiveness: Where did AI tools excel? Where did they struggle?
Overall, I thought that the AI I used or Claude was particular useful when it comes to self documentation and explaining itself
when it makes a particular code decision. I thought that the AI sometimes struggled with context.

Code Quality Comparison: How does AI-generated code compare to manual coding?
AI generated code is best for making the rough draft so to speak or boilerplate. Enabling the
developer to address the parts of the code requiring human attention and oversight.
Learning Experience: What did you learn about inheritance AND AI-assisted development?
I learned that inheritance is nice when we want to make classes that reuse the methods in an abstract class
which requires overriding. It is nice if we have lots of classes that are similar in nature to the parent.
AI-assisted development is powerful because it can be used to streamline projects by mainly generating boilerplate code
and using it to generate test classes.
Validation Process: How did you ensure the AI-generated code was correct?
I made sure the AI generated code was correct by running it first and either modifying it myself or if there
is something I did'nt understand have AI fix the problem and explain it back to me.
Future Applications: How will you use AI tools in future programming projects?
I plan to use AI in future projects as a way to generate boilerplate code and as a way to test my code.

