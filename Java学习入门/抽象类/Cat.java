package Java学习入门.抽象类;

public class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void show() {
        super.show();
    }
}
