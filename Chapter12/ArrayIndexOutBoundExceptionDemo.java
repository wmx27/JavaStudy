package Chapter12;

import java.util.Scanner;

public class ArrayIndexOutBoundExceptionDemo{
    public static void main(String[] args) {
        int[] arr=new int[100];
        for(int i=0;i<100;i++)
            arr[i]=(int)(Math.random()*1000);//一共100个随机数
        try{
            Scanner input=new Scanner(System.in);
            int num=input.nextInt();
            System.out.println(arr[num]);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("输入的下标越界Out of Bounds");
        }
    }
}
