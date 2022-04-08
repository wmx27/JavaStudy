package Chapter13;
import java.util.*;
public class work13point13 implements Cloneable {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.println("Ignoring nonalphanumeric characters, \n is " + s + " a palindrome? " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String s1 = filter(s);
        String s2 = reverse(s1);
        return s2.equals(s1);
    }

    public static String filter(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    @Override
    public Object clone() {
        Object o1 = null;
        try {
            o1 = (work13Point8) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return o1;
    }
}
