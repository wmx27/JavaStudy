package Chapter10;
import java.math.BigInteger;
public class MersenneDemo {
    public static void main(String[] args) {
        BigInteger[]  number= new BigInteger[105];
        System.out.println("p\t2^p-1");
        for(int i=1;i<=100;i++)
        {long num=2;
            for(int j=1;j<i;j++)
                num*=2;
            if(isPrimeNumber(num-1))
                System.out.println(i+"   "+(num-1));
        }
    }
    public static boolean isPrimeNumber(double num){
        if(num<=1)
            return false;
        for (int i = 2 ; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
