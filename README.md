# Information to know -
1) This is a java application built using Gradle
2) Install latest version of gradle in IDE of your choice (IntellIJ is preferred)


# Steps to run the project -
1) Open project in IDE and let the IDE resolve gradle dependencies
2) Build the project to ensure dependencies are resolved
3) If you encounter any errors with related to dependencies, install dependencies that are suggested to be downloaded by the IDE
4) Repeat Step #2
5) Your Main class is Billing.java and run the class
6) You might receive a prompt to setup JDK version for this project. Recommend setting JDK version 1.8 or higher.
7) Repeat Step #5
8) Enter Input file name containing order details (Sample test files have been located in project directory. Please ensure to locate any additional test files in same directory or enter the complete path for Input file to avoid exceptions)
9) On 'Enter', the application validates input and generates response accordingly.
10) Output.csv and Error.txt files will be generated for positive and failed cases respectively. These files will be located in project directory.


# Design Patterns Used -
### 1) Builder :
To convert data from CSV to Java Objects, I utilized the Builder Design Pattern. This creational design pattern helped me to construct complex objects step by step. Additionally, the Builder pattern allowed me to produce different types and representations of an object using the same construction code - I have used the construction code that I used to build Card Data for building Order.
<img width="675" alt="image" src="https://user-images.githubusercontent.com/75163512/167275933-740a04e4-1c57-40d1-ac93-1400adb94bed.png">


### 2) Singleton :
The constraints on this project is to limit users from purchasing items belonging to multiple categories. Singleton creational design pattern helped me to construct instance of the category limit only at the start of the application. This limit on different categories will not be reset but always the updated limit is fetched to the user on request of the object instance.

<img width="675" alt="image" src="https://user-images.githubusercontent.com/75163512/167275956-2c4bb3dc-d27d-4337-9b5d-ed9cf7e676a8.png">


### 3) Factory :
The final creational design pattern I have used is Factory. I have noticed that the categories - Essential/Luxury/Misc all have the same construction code and instead of duplicating the construction code in each of these classes, I have used the Factory design pattern to redirect the object creation based on the category type on demand.

<img width="675" alt="image" src="https://user-images.githubusercontent.com/75163512/167275957-666a45a4-5125-4d95-bd3c-2c94519b96ed.png">


### 4) Chain of Responsibility :
Upon validation of the input order, I have to either print the receipt or generate an error text file. I have identified these responsibilities to be handled by the COR Design Pattern. The responsibility has been handed over to print a receipt on a valid input order and to print error if an invalid input order is encountered.

<img width="675" alt="image" src="https://user-images.githubusercontent.com/75163512/167279390-9204bf9a-ee79-4f5b-9d4a-41d82c62187a.png">


# Class Diagram -
<img width="1634" alt="image" src="https://user-images.githubusercontent.com/75163512/167287218-91b0276a-b876-4af2-80b0-fc87070af34e.png">


