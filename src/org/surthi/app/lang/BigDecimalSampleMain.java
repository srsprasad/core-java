package org.surthi.app.lang;

import java.math.BigDecimal;

public class BigDecimalSampleMain {
  public static final void main(String... args) {
    BigDecimal numberOne = new BigDecimal("0.1547326626064");
    BigDecimal numberTwo = new BigDecimal("0.1547574972232");
    System.out.println(BigDecimal
        .valueOf(
            (BigDecimal.valueOf(1d).doubleValue() / numberOne.subtract(numberTwo).doubleValue()))
        .abs());
  }
}
