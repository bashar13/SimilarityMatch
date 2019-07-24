package com.company.bashar;

import java.math.BigInteger;
import java.util.List;

class CenterOfMassCalculator {

    //calculate center of mass for x axis or y axis

    static double calculateCenterOfAxis (List<BigInteger> list) {

        BigInteger sumAxisPoints = new BigInteger("0");
        for (BigInteger listItem : list) {
            sumAxisPoints = sumAxisPoints.add(listItem);
        }

        String total = sumAxisPoints.toString(10);

        return Double.parseDouble(total) / list.size();

    }
}
