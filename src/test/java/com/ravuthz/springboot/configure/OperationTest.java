package com.ravuthz.springboot.configure;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/2017, 11:54 AM
 * Email : ravuthz@gmail.com
 */

public class OperationTest {
    @Test
    public void operationEnum() throws Exception {

    }

    @Test
    public void calculate() throws Exception {
        Assert.assertEquals(12L, Operation.PLUS.calculate(10,2));
        Assert.assertEquals(12L, Operation.MINUS.calculate(24, 12));
        Assert.assertEquals(12L, Operation.TIMES.calculate(3, 4));
        Assert.assertEquals(12L, Operation.DIVIDE.calculate(12, 1));
    }

}