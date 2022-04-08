package Chapter10;
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag=true;
        int i=0;
        Account[] arr=new Account[100];

        while(true)
        {
            System.out.print("Enter an id: ");
            int id=input.nextInt();
            arr[i].id=id;
            flag=true;
            while (flag)
            {
                System.out.print("Main menu\n1:check balance\n2:withdraw\n3:deposit\n4:exit");
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.printf("The balance is %.1f\n", arr[i].blance);
                }
                if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");

                    double withdraw = input.nextDouble();
                    arr[id].withdraw = withdraw;
                }
                if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    double deposit = input.nextDouble();
                    arr[id].deposit = deposit;
                }
                if (choice == 4) {
                    i++;
                    flag = false;
                }
            }
        }


    }
}

class Account{
    int id;
    double blance;
    double deposit;
    double withdraw;

}

