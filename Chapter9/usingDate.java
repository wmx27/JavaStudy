package Chapter9;
import java.util.*;
public class usingDate {
    public static void main(String[] args) {
        Date date1=new Date();
        date1.setTime(10000);
        System.out.println(date1.toString());
        date1.setTime(100000);
        System.out.println(date1.toString());
        date1.setTime(1000000);
        System.out.println(date1.toString());
        date1.setTime(10000000);
        System.out.println(date1.toString());
        date1.setTime(100000000);
        System.out.println(date1.toString());
        date1.setTime(1000000000);
        System.out.println(date1.toString());
    }
}
