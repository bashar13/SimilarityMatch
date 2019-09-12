//
//  SpanningTreeDataModel.java
//  A data model class represents a point with it's label on a xy plane
//
//  Created by Khairul Bashar on 25/6/19.
//

package com.company.bashar;
import org.jetbrains.annotations.NotNull;

import java.lang.*;

public class SpanningTreeDataModel {

    private static int valueOfB = 8;

    private double xCoordinate;
    private double yCoordinate;
    private String pointLabel;

    SpanningTreeDataModel(double x, double y) {
        xCoordinate = x;
        yCoordinate = y;

        double temp = Math.floor((Math.pow(2, 64) - 1)/ Math.pow(2, valueOfB));
        //System.out.println("temp: " +temp);
        double i = Math.floor(xCoordinate/temp);
        //System.out.println("i: " + i);
        double j = Math.floor(yCoordinate/temp);
        //System.out.println("j: "+ j);

        double label = Math.pow(2, valueOfB) * i + j;
        //System.out.println("label: " + label);
        pointLabel = String.valueOf(label);

        //printObjectValues();

    }

    double getXCoordinate() {
        return xCoordinate;
    }

    double getYCoordinate() {
        return yCoordinate;
    }

    String getPointLabel() {
        return pointLabel;
    }

    private void printObjectValues() {

        System.out.println(xCoordinate);
        System.out.println(yCoordinate);
        System.out.println(pointLabel);
    }
}
