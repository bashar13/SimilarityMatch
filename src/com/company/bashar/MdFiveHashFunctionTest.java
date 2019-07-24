package com.company.bashar;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MdFiveHashFunctionTest {

    @Test
    public void getMd5() {

        String str = "22748POPPY'SPLAYHOUSEKITCHEN62012-01-108:342.1";
        String hashValue = MdFiveHashFunction.getMd5(str);

        Assert.assertEquals(hashValue, "a30a5bd66152703a9fbea1e581900e63");
    }
}