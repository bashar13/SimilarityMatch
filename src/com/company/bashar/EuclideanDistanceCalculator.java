package com.company.bashar;

class EuclideanDistanceCalculator {

    static double calculate(CenterOfMassDataModel mainModel, CenterOfMassDataModel testModel) {

        double sum = Math.pow((mainModel.xPoint - testModel.xPoint), 2)
                + Math.pow((mainModel.yPoint - testModel.yPoint), 2);

        return Math.sqrt(sum);
    }

}
