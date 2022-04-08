package Chapter7;

import java.util.Scanner;

public class shiyan {
    public static void main(String[] args) {
        // 声明一个数组
        int[] lst0 = new int[10];
        // 读取数据并传入数组
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 numbers: ");
        int input_number = 0, count = 0;
        for (int x = 0 ; x < 10 ; x++)
        {
            boolean bool = false;
            input_number = input.nextInt();
            for (int y = 0 ; y < x ; y++)
            {
                if (lst0[y] == input_number)
                {
                    bool = true;
                }
            }
            if ( !bool )
            {
                count++;
                lst0[count-1] = input_number;
            }
        }

        // 输出结果
        System.out.println("The number of distinct numbers is " + count);
        System.out.print("The distinct numbers are: ");
        for (int i = 0 ; i < count ; i++){
            System.out.print(lst0[i] + " ");
        }
    }
}
