package Chapter8;
import java.util.Scanner;
public class Diussion {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the size for the matrix:");
        int number= input.nextInt();
        int[][] arr=inputMatrix(number);
        for(int i=1;i<=number;i++)
            if(isSameLine(i-1,arr,number))
                System.out.println("All "+arr[i-1][0]+"s"+" on line"+i);
        for(int i=1;i<=number;i++)
            if(isSamerow(i-1,arr,number))
                System.out.println("All "+arr[i-1][0]+"s"+" on row"+i);
        if(isSameDuijiao(arr,number)==1)
            {
                System.out.println("All "+arr[0][0]+"s"+" on major diagonal");
                System.out.println("no same numbers on the sub-diagonal");
            }
        else if(isSameDuijiao(arr,number)==-1)
        {
            System.out.println("no same numbers on the major diagonal");
            System.out.println("All "+arr[0][number-1]+"s"+" on sub-diagonal");
        }
        else if(isSameDuijiao(arr,number)==-2)
        {
            System.out.println("no same numbers on the major diagonal");
            System.out.println("no same numbers on the sub-diagonal");
        }
        else
        {
            System.out.println("All "+arr[0][0]+"s"+" on major diagonal");
            System.out.println("All "+arr[0][number-1]+"s"+" on sub-diagonal");
        }
    }

    public static int[][] inputMatrix(int number)
    {
        Scanner input=new Scanner(System.in);
        int[][] arr=new int[number][number];
        for(int i=0;i<number;i++)
            for(int j=0;j<number;j++)
                arr[i][j]=input.nextInt();
            return arr;
    }
    public static boolean isSameLine(int i,int[][] arr,int number)
    {
        int flag=1;
        int temp=arr[i][0];
        for(int j=0;j<number;j++)
        {
            if(arr[i][j]!=temp)
            {
                flag = 0;
                break;
            }
        }
            if(flag==0)return false;
            else return true;
        }

    public static boolean isSamerow(int j,int[][] arr,int number)
    {
        int flag=1;
        int temp=arr[0][j];
        for(int i=0;i<number;i++)
        {
            if(arr[i][j]!=temp)
            {
                flag = 0;
                break;
            }
        }
        if(flag==0)return false;
        else return true;
    }
    public static int isSameDuijiao(int[][] arr,int number)
    {
        int flag1=1,flag2=1;
        int temp=arr[0][0];
        for(int i=0,j=0;i<number;i++,j++)
        {
            if(arr[i][j]!=temp)
            {
                flag1 = 0;
                break;
            }
        }
        temp=arr[0][number-1];
        for(int i=0,j=number-1;i<number;i++,j--)
        {
            if(arr[i][j]!=temp)
            {
                flag2 = 0;
                break;
            }
        }
        if(flag1==0&&flag2==0)return -2;
        else if(flag1==1&&flag2==1) return 2;
        else if(flag1==1&&flag2!=1) return 1;
        else return -1;
    }
}

