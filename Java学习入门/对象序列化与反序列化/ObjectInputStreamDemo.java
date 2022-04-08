package Java学习入门.对象序列化与反序列化;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
    构造方法
        objectInputStream (InputStream in) 创建一个对象输入流读取从指定的输入流。
    反序列化方法
        Object readObject()  从对象输入流对象。
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\Java\\项目\\src\\Java学习入门\\对象序列化与反序列化\\oos.txt"));

        Object obj=ois.readObject();// ClassNotFoundException
        Student02 s2=(Student02) obj;
        System.out.println(s2.getName()+":"+s2.getAge());
    }
}
