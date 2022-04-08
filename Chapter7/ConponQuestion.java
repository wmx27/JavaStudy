package Chapter7;

import java.util.Random;
public class ConponQuestion {
    public static void main(String[] args) {
        Random R=new Random();
        int[] arr=new int[52];
        int num=0,temp,time=0,i,j;
        String[] color={"Spadens","Clubs","Diamonds","Hearts"};
        int[] colorTable=new int[4];
        for(i=0;i<4;i++)
            colorTable[i]=1;
        for(i=0;i<52;i++)
            arr[i]=1;

        while(num<4)
        {
            temp=R.nextInt(52);
            i=temp/4;
            j=temp%4;
            if(arr[temp]==0||colorTable[j]==0)
            {
                time++;
            }
            else
            {
                arr[temp]=0;
                colorTable[j]=0;
                num++;time++;
                System.out.println(i+1+" of "+color[j]);
            }
        }
        System.out.println("number of picks:"+time);
    }
}
