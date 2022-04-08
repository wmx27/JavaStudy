package Chapter12;
import java.io.*;
import java.util.*;
public class work12point22 {
    public static void main(String[] args) throws Exception{
        if(args.length!=3){
            System.out.println("Usage path oldStr newStr");
            System.exit(0);
        }
        File file = new File(args[0]);
        File[] files = file.listFiles();
        if (!file.exists()) {
            System.out.println(args[0] + " isn't exist");
            System.exit(2);
        }
        for (int i = 0; i < files.length; i++) {
            Scanner input = new Scanner(files[i]);
            StringBuffer sb = new StringBuffer();
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[1], args[2]);
                sb.append(s2 + "\r\n");
            }
            input.close();
            PrintWriter output = new PrintWriter(files[i]);
            output.println(sb);
            output.close();


        }
    }
}
