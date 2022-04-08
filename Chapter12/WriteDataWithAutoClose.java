package Chapter12;

import java.io.File;
import java.io.PrintWriter;

public class WriteDataWithAutoClose {
    public static void main(String[] args) throws Exception{
        java.io.File file = new File("WriteDataWithAutoClose.txt");
        if(file.exists()){
            System.out.println("File already exists");
            System.exit(0);
        }
        /*
        * try(声明和创建资源){
        * 使用资源来处理文件;//这是try-with-resources 自动关闭资源
        * }
        *
        * */


        try(
            //Create a file
            java.io.PrintWriter output=new java.io.PrintWriter("scores.txt");
        )
        {
            output.print("hhhhhhhh");
            output.print("\n");
            output.print("你是猪");
        //这里可以不写close 因为try块结束后自动调用
        }

    }
}
