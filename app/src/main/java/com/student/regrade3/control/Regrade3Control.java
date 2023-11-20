package com.student.regrade3.control;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Regrade3Control {

    public static BigDecimal calcular(String c1, String c2, String c3) throws Exception {

        BigDecimal a = BigDecimal.valueOf(Double.parseDouble(c1));
        BigDecimal b = BigDecimal.valueOf(Double.parseDouble(c2));
        BigDecimal c = BigDecimal.valueOf(Double.parseDouble(c3));
        return (b.multiply(c)).divide(a, 2, RoundingMode.CEILING);

    }

}
