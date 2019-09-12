//
//  CenterOfMassCalculator.java
//
//  Created by Khairul Bashar on 25/6/19.
//

package com.company.bashar;

import java.math.BigInteger;
import java.util.List;

class CenterOfMassCalculator {

    /*calculate center of mass for a list of values
    Parameter: list- a list of BigInteger
    Return: a double value, center of mass of 'list'
     */

    static double calculateCenterOfAxis (List<BigInteger> list) {

        BigInteger sumAxisPoints = new BigInteger("0");
        for (BigInteger listItem : list) {
            sumAxisPoints = sumAxisPoints.add(listItem);
        }

        String total = sumAxisPoints.toString(10);

        return Double.parseDouble(total) / list.size();

    }
}
