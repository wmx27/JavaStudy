package Java学习入门.基础;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String hex = input.nextLine();

        System.out.println(hexToDecimal(hex.toUpperCase()));
    }

    public static int hexToDecimal(String hex)
    {
        char[] arr=hex.toCharArray();
        int num=0;
        for(int i=0;i<hex.length();i++)
        {
            if(arr[i]<='F'&&arr[i]>='A')
                num+=arr[i]-'A'+10;
            else if(arr[i]<='9'&&arr[i]>='0')
                num+=arr[i]-'0';
            num*=16;
        }

        return num;
    }
}