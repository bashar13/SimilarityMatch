# SimilarityMatch
## Idea: Minimum Spanning Tree Traversal approach
- Steps:
1. Pick a random number of transactions from the data source (e.g. a set of 500 random transactions).
2. Represent each transaction in the set as an (x,y) point
- For each transaction in the list, generate a hash value using MdFiveHashFunction
- Represent the hash value as an (x,y) point (each point stores in a list as a SpanningTreeDataModel object)
- Calculate the label for each point to represent the point
3. Sort the list of points in ascending order by the value of x (so that we can keep track of the starting point)
4. Calculate an adjacency matrix graph by connecting each of the points with each other with an edge having a distance value equal to the euclidean distance between two points.
5. Calculate the minimum spanning tree from the graph of the previous step by applying the prim's algorithm
6. Do a post-order traversal on the MST and store the sequence of the vertices/points traversed.
7. Represent the points by the label and output a string containing the sequence of labels

### To compare two sets of transactions
8. Modify the previous set of transactions by removing or/and adding one or multiple transactions from the list
9. Apply steps 1 to 7 to the new set of transactions and output a string containing the sequence of labels

10. Now, to determine the similarity between the two sets of transactions, we apply the edit distance technique on the output strings (To-Do).

## Observation:
1. The result after applying the edit distance technique will tell us how similar the two set of transactions.

## Class descriptions:
1. Main.java - Launcher class. All the step by step logic is written in this class.
2. OpenCSVReader.java - Read the .csv file in the data DataSource folder.
3. MdFiveHashFunction.java - Generates unique hash value for a given input string
4. EuclideanDistanceCalculator.java - Calculates euclidean distance between to given (x,y) points
5. TransactionDataModel.java - A data model class, the blueprint of an object that represents a transaction in the set of transactions.
6. SpanningTreeDataModel.java - A data model class, the blueprint of an object that represents a point in XY plane.
7. PrimsAlgorithmMST.java - implementation of Prim's algorithm to calculate the minimum-spanning tree of a given graph

## The output.txt sample
1. output string for the main set of transactions
- 21586.0, 51705.0, 38096.0, 22761.0, 10478.0, 7070.0
2. output string for the main set of transactions modified by 1 transaction
- 21586.0, 38096.0, 34544.0, 22761.0, 10478.0, 7070.0


## Hor to run:
- JDK 1.8
- Java language version 8
- libraries: opencsv-4.6.jar, commons-lang3-3.9.jar

1. The program is developed in IntelliJ Idea IDE. If you have IntelliJ Idea installed in your PC, simply open the project in the IDE.
2. The Ant build script (antBuild.xml) is provided with the project. You can also use the Ant build to run the project if you have the environment for that.

## Important Tags:
1. idea1: final implementation of center of mass idea


