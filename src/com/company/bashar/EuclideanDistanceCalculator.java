package com.company.bashar;

import com.android.aapt.Resources;

class EuclideanDistanceCalculator {

    static double calculate(SpanningTreeDataModel point1, SpanningTreeDataModel point2) {

        double sum = Math.pow((point1.getXCoordinate() - point2.getXCoordinate()), 2)
                + Math.pow((point1.getYCoordinate() - point2.getYCoordinate()), 2);

        return Math.sqrt(sum);
    }

}
