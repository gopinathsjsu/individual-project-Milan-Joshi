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
8) Enter Input file name containing order details (Input.csv for valid order and ErrorInput.csv for invalid order)
9) On 'Enter', the application validates input and generates response accordingly.
10) Output.csv and Error.txt files will be generated for positive and failed cases respectively. These files will be located in project directory.


# Design Patterns Used -
### 1) Builder :
To convert data from CSV to Java Objects, I utilized the Builder Design Pattern. This creational design pattern helped me to construct complex objects step by step. Additionally, the Builder pattern allowed me to produce different types and representations of an object using the same construction code - I have used the construction code that I used to build Card Data for building Order.
<img width="757" alt="image" src="https://user-images.githubusercontent.com/60649973/167502064-e5d9aa60-321f-4e9f-8d63-40fb0b7ba326.png">




### 2) Singleton :
The constraints on this project is to limit users from purchasing items belonging to multiple categories. Singleton creational design pattern helped me to construct instance of the category limit only at the start of the application. This limit on different categories will not be reset but always the updated limit is fetched to the user on request of the object instance.

<img width="392" alt="image" src="https://user-images.githubusercontent.com/60649973/167502854-11ee0508-70e2-45d0-956e-1cc01bbdc263.png">




### 3) Factory :
I've observed that the categories - Essential/Luxury/Misc all have the same construction code and instead of duplicating the construction code in each of these classes, I have used the Factory design pattern to redirect the object creation based on the category type on demand.

<img width="1188" alt="image" src="https://user-images.githubusercontent.com/60649973/167507024-52c16d99-edcd-4572-acf7-282ab9973779.png">






### 4) Chain of Responsibility :
I have to either print the receipt or produce an error text file when the input order is validated. I have identified these responsibilities to be handled by the COR Design Pattern. The responsibility has been handed over to print a receipt on a valid input order and to print error if an invalid input order is encountered.
<img width="1067" alt="image" src="https://user-images.githubusercontent.com/60649973/167503640-768c2b56-9588-419a-8ba6-7e6ba0e1a37d.png">







# Class Diagram -
<img width="1093" alt="image" src="https://user-images.githubusercontent.com/60649973/167506456-f46c5395-eb76-4fdd-a50a-00611548c5f7.png">






