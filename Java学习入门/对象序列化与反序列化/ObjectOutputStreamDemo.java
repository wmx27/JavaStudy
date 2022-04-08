package Java学习入门.对象序列化与反序列化;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
    对象序列化流
        构造方法
        ObjectOutputStream(ObjectStream out) 创建一个写入指定的OutputStream的ObjectOutputStream

        序列化对象的方法
        void writeObject(Object obj) 将指定的对象写入ObjectOutputStream


    NotSerializableException:抛出一个实例需要一个Serializable接口 序列化运行时或实例的类可能会抛出异常
    序列化的类需要实现Serializable接口 此接口是一个标记接口 实现该接口 不需要重写任何方法


 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\Java\\项目\\src\\Java学习入门\\对象序列化与反序列化\\oos.txt"));
        Student02 s1=new Student02("wmx",30);
        oos.writeObject(s1);
        //�� sr 9Java学习入门.对象序列化与反序列化.Student02��R��Uْ I ageL namet Ljava/lang/String;xp   t wmx
        oos.close();
    }
}
/*
    当序列化一个对象之后 我们修改了这个对象所属类文件 会出现一些问题
    serialVersionUID是用来区别的 当修改后serialVersionUID会产生变化
    所以在类文件里面可以声明一个static  final long serialVersionUID=42L; 来解决这个问题

    当不想其中的一部分序列化 使用transient来限定成员变量
 */