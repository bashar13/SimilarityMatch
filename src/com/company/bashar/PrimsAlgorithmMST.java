//
//  PrimsAlgorithmMST.java
//  Calculates minimum spanning tree for a given adjacency matrix graph[][] input
//  Returns the graph[][] by updating the values to represent minimum spanning tree
//  value 1 represents an edge of the spanning tree, while any other values are considered ignored
//
//  Created by Khairul Bashar on 25/6/19.
//

package com.company.bashar;

import java.util.*;
import java.lang.*;
import java.io.*;

class PrimsAlgorithmMST {
    // Number of vertices in the graph
    private static final int V = 6;

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(double key[], Boolean mstSet[]) {
        // Initialize min value
        double min = Double.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], double graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            graph[parent[i]][i] = 1;
        }
    }

    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    void primMST(double graph[][]) {
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        double key[] = new double[V];

        // To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Double.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, graph);

//        for (int i = 1; i < V; i++) {
//            //System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
//            System.out.println(graph[parent[i]][i]);
//        }
    }
}
