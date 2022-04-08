package Chapter12;
import java.io.*;
import java.util.*;
public class ReplaceText {
    public static void main(String[] args) throws Exception{
        if(args.length!=4){
            System.out.println("Usage java ReplaceText sourceFile targeFile oldStr newStr");
            System.exit(0);
        }
        File sourceFile=new File(args[0]);
        if(!sourceFile.exists()){
            System.out.println("Source File "+args[0]+" does not exists");
            System.exit(2);
        }
        File targeFile=new File(args[1]);
        if(!targeFile.exists()){
            System.out.println("Source File "+args[1]+" already exists");
            System.exit(3);
        }
        try(
                Scanner input=new Scanner(sourceFile);
                PrintWriter output=new PrintWriter(targeFile);
                ){
            while(input.hasNext()){
                String s1=input.nextLine();
                String s2=s1.replaceAll(args[2],args[3]);
                output.println(s2);
            }

        }
    }
}
