package Chapter12;

import java.io.File;
import java.io.PrintWriter;

public class WriteData {
    public static void main(String[] args) throws java.io.IOException{
//        java.io.File file=new File("filetext.txt");
//        if(file.exists())
//        {
//            System.out.println("File already exists");
//            System.exit(1);
//        }
        java.io.PrintWriter output=new PrintWriter("filetext.txt");
        output.print("john T Smith ");
        output.println(90);
        output.print("Eric K jones ");
        output.println(85);
        //注意文件的关闭才能映射到文件实体
        output.close();

    }
}
