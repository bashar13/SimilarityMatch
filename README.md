# SimilarityMatch
Idea: Center of mass calculation approach
- Steps:
1. Pick a random number of transactions from the data source.
2. Calculate center of mass for the picked set of transactions
    - For each transaction in the list, create a hash value using MdFiveHashFunction
    - Represent the hash value as a (x,y) point 
    - Calculate the center of mass for the set of points
    
3. For a different set of transactions, we do the same process to calculate the center of mass.

4. Now, to determine the similarity between two set of transactions, we compute the euclidean distance between two center of mass points.

- Observation:
1. The actual result is not similar to our expectation.
    - Expectation: The euclidean distance between two set of transactions will gradually increase with the number of different transactions between two sets.
    - Actual result: The euclidean distances doesn't show any similarity with the number of different transaction between two sets.

- Class descriptions:
1. Main.java - Launcher class. All the step by step logics are written in this class.
2. OpenCSVReader.java - Read the .csv file in the data DataSource folder.
3. MdFiveHashFunction.java - Generates unique hash value for a given input string
4. CenterOfMassCalculator.java - Calculates center of mass for a given list of (x,y) points
5. EuclideanDistanceCalculator.java - Calculates euclidean distance between to given (x,y) points
6. TransactionDataModel.java - A data model class to create transaction objects and populate an array list of transaction data model.
7. CenterOfMassDataModel.java - A data model class to create an object from the result of CenterOfMassCalculator.java.
- The output.txt file shows the euclidean distance between the set of transaction considered as the main model and a new set of transaction with different value of 'K', where 'K' is the number of different transactions between two models. 

- Hor to run:
- JDK 1.8
- Java language version 8

1. The program is developed in IntelliJ Idea IDE. If you have IntelliJ Idea installed in your PC, simply open the project in the IDE.
2. The Ant build script (antBuild.xml) is provided with the project. You can also use the Ant build to run the project, if you have the environemnt for that.


