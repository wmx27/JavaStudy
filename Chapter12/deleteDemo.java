package Chapter12;
import java.io.*;
import java.util.Scanner;

public class deleteDemo {
    public static void main(String[] args) throws Exception{
        File file=new File("deleteDemo.txt");
        if(file.exists()) {
            Scanner input=new Scanner(file);
            //找到文件并且重写
            PrintWriter output = new PrintWriter(file);
            output.print("hhhh###wwww###jjjjj###");
            output.close();
            //删除含有###的所以字符串
            String s="";
            //设置分隔符
            input.useDelimiter("###");
            while(input.hasNext()){
                s+=input.next();
            }
            //将读到的字符串重写到文件中
            PrintWriter output1 = new PrintWriter(file);
            output1.print(s);
            output1.close();
        }
    }
}
