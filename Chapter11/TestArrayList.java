package Chapter11;
import java.util.ArrayList;
public class TestArrayList {
    public static void main(String[] args) {
        //创建一个ArrayList  这两种方法都可以实现 JDK7开始可以简写为第一种
        ArrayList<String> cityList=new ArrayList<>();
        ArrayList<String> cityList2=new ArrayList<String>();
        //注意 不能ArrayList<int> list=new ArrayList<>();因为list存放的必须是一个对象 不能是基础类型


        cityList.add("London");
        cityList.add("Denver");
        cityList.add("Paris");
        cityList.add("Miami");
        cityList.add("Seoul");
        cityList.add("Tokyo");

        System.out.println("List size? "+cityList.size());
        System.out.println("Is Miami in the list? "+cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? "+cityList.indexOf("Denver"));//从0开始的下标
        System.out.println("Is the list empty? "+cityList.isEmpty());

        cityList.add(2,"Xian");
        cityList.remove("Miami");
        cityList.remove(1);//这不是一个好的方法
        System.out.println(cityList.toString());


        for(int i=cityList.size()-1;i>=0;i--)
        {
            System.out.print(cityList.get(i)+" ");
        }
        System.out.println();
        cityList.clear();
        System.out.println(cityList.toString());
//        cityList.set(0);会报错 因为在list中无元素的时候 set（index） set(index,element)是不能使用的

        ArrayList<Circle> list=new ArrayList<>();
        list.add(new Circle(2));
        list.add(new Circle(3));
        System.out.println("The area of the circle? "+list.get(0).getArea());
    }
}
