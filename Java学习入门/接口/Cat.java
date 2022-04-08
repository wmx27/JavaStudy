package Java学习入门.接口;
//使用implements（实现）
public class Cat implements Jumpping{
    //不用extends会产生No interface expected here错误

    @Override
    public void jump() {
        System.out.println("猫可以跳高了");
    }
}
