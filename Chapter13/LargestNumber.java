package Chapter13;
//抽象的Number类 是数值包装类及BigInteger和BigDecimal类的抽象父类
//包含 byteValue() shortValue() doubleValue() longValue() intValue() 以这个形式的值返回 这些方法中 int long float double
//注意没有compareTo()方法
//是抽象方法
import java.util.ArrayList;
import java.math.*;
public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<Number> list=new ArrayList<>();
        list.add(45);
        list.add(3445.53);
        list.add(new BigInteger("344465464646465464654"));
        list.add(new BigDecimal("2.055545654654654654"));
        System.out.println("The largest number is "+getLargestNumber(list));

        //实验  ClassCastException  因为Number不是Double的子类
//        Number n=new Integer(45);
//        Double d=(Double) n;

    }
    public static Number getLargestNumber(ArrayList<Number> list){
        if(list==null||list.size()==0)
            return null;
        Number number=list.get(0);
        for(int i=0;i< list.size();i++)
            if(number.doubleValue()<list.get(i).doubleValue())
                number=list.get(i);
        return number;
    }
}
