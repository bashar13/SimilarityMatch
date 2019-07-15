package com.company.bashar;

import java.util.List;

public class CenterOfMass {

    public static int calculate (List<Integer> list) {

        int sumAxis = 0;
        for (int listItem : list) {
            sumAxis += listItem;
        }

        int centerofAxis = sumAxis / list.size();

        return centerofAxis;

    }
}
