package Java学习入门.基础;

public class Study2
{
    public static void main(String[] args)
    {
        //创建对象
        /*
        * 格式：类名 对象名 = new 类名();
        * */
        //使用对象
        /*
        1.使用成员变量
        格式：对象名.变量名
        2.使用成员方法
        格式：对象名.方法名（）
        * */
        //
        Phone p=new Phone();
        System.out.println("p.price"+p.price);
        System.out.println("p.brand"+p.brand);
        p.brand="XiaoMi";
        p.price=1999;
        p.call();//也可以通过创建对象访问static方法
        Phone.call();//可以通过访问类名直接访问static方法
        p.sendMessage();

        Integer i =new Integer("15");
        System.out.println(i);
        System.out.println(Integer.toString(011,10));

    }
}
