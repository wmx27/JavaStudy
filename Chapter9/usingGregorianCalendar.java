package Chapter9;
import java.util.*;
public class usingGregorianCalendar {
    public static void main(String[] args) {
        GregorianCalendar g1=new GregorianCalendar();
        System.out.println(g1.get(GregorianCalendar.YEAR)+"."+g1.get(GregorianCalendar.MONTH)+"."+g1.get(GregorianCalendar.DAY_OF_MONTH));
        g1.setTimeInMillis(1234567898765L);
        System.out.println(g1.get(GregorianCalendar.YEAR)+"."+g1.get(GregorianCalendar.MONTH)+"."+g1.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
