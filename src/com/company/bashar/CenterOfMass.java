package com.company.bashar;

import java.math.BigInteger;
import java.util.List;

public class CenterOfMass {

    public static double calculate (List<BigInteger> list) {

        BigInteger sumAxis = new BigInteger("0");
        for (BigInteger listItem : list) {
            sumAxis = sumAxis.add(listItem);
        }

        String total = sumAxis.toString(10);

        double centerofAxis = Double.parseDouble(total) / list.size();

        return centerofAxis;

    }
}
