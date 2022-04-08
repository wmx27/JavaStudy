package Java学习入门.基础;

public class Phone
{
    //类的定义步骤
    /*
     * 类名：Phone
     * 成员变量：品牌（brand）  价格（price）
     * 成员方法：打电话（call） 发短信（sendMessage）
     * */
    String brand;
    int price;
    public static void call()
    {
        System.out.println("打电话");
    }
    public void sendMessage()
    {
        System.out.println("发短信");
    }
}
