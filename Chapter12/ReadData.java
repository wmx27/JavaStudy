package Chapter12;

import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) throws Exception {
        java.io.File file=new java.io.File("filetext.txt");
        Scanner input=new Scanner(file);

        while(input.hasNext()){//hasNext是用来判断是否有更多数据可以读取的
            String firstname=input.next();
            String mi= input.next();
            String lastname= input.next();
            int score=input.nextInt();
            System.out.println(firstname+" "+mi+" "+lastname+" "+score);
        }
    }
}
