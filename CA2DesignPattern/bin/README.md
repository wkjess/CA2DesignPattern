# Object Orientation Design Pattern - CA2 Assignment 16 May 2020

# Objective

� Bullet list Determine which design pattern should be used and how design patterns can be tailored for custom use.
 
� Bullet list Understand how design patterns are used in industry code to aid the design process on larger projects.
 
� Bullet list Utilise their knowledge of design patterns to assess the limitations of an existing application. 

# Specification Functionality

The design pattern acquires the application able to simulate and retrieving data from collection object.
It uses the component class interface to interact with objects in the composition structure.
If recipient is the leaf then request will be handled directly.
If recipient is a composite, then it usually forwards the request to its child for performing the additional operations.

## Specific Requirements 

I have chose structural of bridge and facade design patterns.
The bridge design simply just implement the define method in the interface's package for both instance of Company and Investor,
where as it uses the component class interface to interact with objects in the composition structure. If recipient is the leaf then request will be handled directly,
therefore it hides the complexities of the subsystem from the object.

Additional to the simulation program, the behaviour uses of the 
terminology of command design patterns where
the command interface which implemented by the concrete class would be able to take change of the responsibility to be simulated in the trading market. 

# Steps to Run

Step: select option 5 and follow by 6 at the beginning to simulate the both company and investor

Step 2: select option 7 to simulate the stock market trading program

Step 3: run through from option 1 to 4 to observe their selling and buying a share activity reports.
