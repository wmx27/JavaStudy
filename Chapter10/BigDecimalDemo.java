package Chapter10;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1.0);
        BigDecimal b = new BigDecimal(3);
        // BigDecimal类在除的时如果不能终止运行 那么divide方法会抛出ArithmeticException异常
        // BigDecimal c = a.divide(b);  可以用重载方法 divide(BigDecimal d,int scale,int roundingMode)
        BigDecimal c = a.divide(b,20,BigDecimal.ROUND_UP);
        System.out.println(c);
    }
}
