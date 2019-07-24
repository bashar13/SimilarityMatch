package com.company.bashar;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EuclideanDistanceCalculatorTest {

    @Test
    public void calculate() {

        CenterOfMassDataModel dataModel1 = new CenterOfMassDataModel(10.2434, 12.1212);
        CenterOfMassDataModel dataModel2 = new CenterOfMassDataModel(500.243, 30.281);

        double result = EuclideanDistanceCalculator.calculate(dataModel1, dataModel2);

        Assert.assertEquals(result, 490.335993310913287, .0000001);
    }
}