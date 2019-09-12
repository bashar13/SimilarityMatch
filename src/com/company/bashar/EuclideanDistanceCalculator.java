//
//  EuclideanDistanceCalculator.java
//
//  Created by Khairul Bashar on 25/6/19.
//

package com.company.bashar;

class EuclideanDistanceCalculator {

    /*
    Calculates euclidean distance between two points
    Parameter: takes two SpanningTreeDataModel objects as points
    Return: returns a double value, the euclidean distance of two given points
     */

    static double calculate(SpanningTreeDataModel point1, SpanningTreeDataModel point2) {

        double sum = Math.pow((point1.getXCoordinate() - point2.getXCoordinate()), 2)
                + Math.pow((point1.getYCoordinate() - point2.getYCoordinate()), 2);

        return Math.sqrt(sum);
    }

}
