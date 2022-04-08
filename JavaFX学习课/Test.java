package JavaFX学习课;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test implements comparable<Integer>{
    @Override
    public int comp(Integer x){
        return 1;
    }
    public static void main(String[] args)  {
        Calendar a=new GregorianCalendar(1778,0,4);
        System.out.println(a.get(Calendar.YEAR));
        InterfaceName arr;
        ArrayList<Integer>[] ar=new ArrayList[6];
        ar[0].add(3);
        ArrayList<Integer>[] numbers=new ArrayList[100];
        numbers[0].add(6);
        System.out.println((numbers[0]).size());
    }
}
abstract interface InterfaceName{
    int a=0;
    void p();
}
interface comparable<a>{
    public int comp(a x);

    public static int um(){
        return 1;
    }
}