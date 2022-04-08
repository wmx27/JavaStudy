package Chapter10;

import java.math.BigInteger;

public class BigIntegerDemo {
    //BigInteger类可以用于表示任意大小和精度的整数或者十进制整数  注意小数不行会报错
    public static void main(String[] args) {
        BigInteger a = new BigInteger("92223372005456464654512154");
        BigInteger c = new BigInteger("2222");
        System.out.println(a);
        //可以用 add subtract multiple divide 和 remainder来实现
        BigInteger b = a.add(c);
        BigInteger d = a.divide(c);
        System.out.println(b);
        System.out.println(d);
        System.out.println(a.multiply(c));
        System.out.println(c.subtract(c));
        System.out.println(a.remainder(c));

    }
}
