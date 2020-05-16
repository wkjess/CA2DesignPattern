# Object Orientation Design Pattern - CA2 Assignment 16 May 2020

BSc in Computer IT at College Computing Training CCT Dublin.
Student name Kim Jang Wong
Project title Stock Market Trading Simulation Program

# Objective

The aims to this project requirement to design and implement a simulator of a simplified model of a stock market.
The program will simulate both companies and investors to try to sell and buy a share according to their share and budget availibilities.
Once the simulation has been completed, the program  must present to the user a menu with the list of possible reports for them to see the result.
The program  should use of  at least three design patterns implementation and at least two of them must be from structural or behavioural patterns.

 # Specification Functionality

## Specific Requirements 

Singleton Patterns: used to get a instance of the class MenuActivity, creating a global field for the class

Bridge Patterns: The CompanyInterface and InvestorInterface to be used for a class signature and should be implemented by its concrete class.

Builder Patterns: The Company and Investor classes are use to create the instance of the class.

Command Patterns: used to execute methods to start, to stop simulation  at  the class TradingMarket

Additional to the simulation program, the behaviour uses of the 
terminology of command design patterns where
the displayUpdate method which implemented by the concrete class would be able to take change of the responsibility to be simulated in the trading market. 

## Compile and Running
Step 1: select option 5 and follow by 6 at the beginning to simulate the both company and investor

Step 2: select option 7 to simulate the stock market trading program

Step 3: run through from option 1 to 4 to observe their selling and buying a share activity reports.

### Thank you for reading and playing it!
