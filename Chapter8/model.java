package Chapter8;
import java.util.Scanner;
public class model {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[][] arr=new int[6][7];
        System.out.println("Please enter the matrix");
        for(int i=0;i<6;i++)
            for(int j=0;j<7;j++)
                arr[i][j]= input.nextInt();
        int flag=0;
        for(int i=0;i<6;i++)
            for(int j=0;j<7;j++)
                if(isSame(arr,i,j))
                {flag=1;break;}
        if(flag==1)System.out.println("true");
        else System.out.println("false");
    }
     public static boolean isSame(int arr[][],int i,int j)
     {
         int flag=1;
         int temp=arr[i][j];
         for(int k=i;k<i+4&&i+3<6;k++)
             if(arr[k][j]!=temp)
             {
                 flag = 0;
                 break;
             }
         if(flag==1)return true;
         flag=1;
         for(int k=j;k<j+4&&j+3<7;k++)
             if(arr[i][k]!=temp)
             {
                 flag = 0;
                 break;
             }
         if(flag==1)return true;
         flag=1;
         for(int k=i,l=j;k<i+4&&i+3<6&&j+3<7;k++,l++)
             if(arr[k][l]!=temp)
             {
                 flag = 0;
                 break;
             }
         if(flag==1)return true;
         flag=1;
         for(int k=i,l=j;k<i+4&&l>j-4&&i-3>-1&&j-3>-1;k++,l--)
             if(arr[k][l]!=temp)
             {
                 flag = 0;
                 break;
             }
         if(flag==1)return true;
         else return false;
     }

}
