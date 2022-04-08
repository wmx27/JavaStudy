package Chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class game {
    public static void main(String[] args) throws Exception {
        //文件的读取
        int num = 0;
        File file = new File("hangman.txt");
        ArrayList<String> list = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            num++;//记录单词数
            list.add(input.next());
        }
        //开始猜词


        int timesGuess = 0;
        boolean game = true;
        while (game) {
            int i = (int) (Math.random() * num);//确定是那一个词
            int length = list.get(i).length();
            String str = list.get(i);
            timesGuess = guess(str);
            System.out.println("The word is " + str + ". You missed " + timesGuess + " times");
            System.out.print("Do you want to guess another word? Enter y or n>");
            Scanner input1 = new Scanner(System.in);
            char c = input1.next().charAt(0);
            if (c == 'n') {
                game = false;
            }
        }

    }
    private static int guess(String str) {
        //11. 自定义方法guess： 获取输入str（String对象）长度为length_str
        int length_str = str.length();
        //12. 自定义方法guess： 声明一个长度为length的char型数组str_char
        char[] str_char = new char[length_str];
        //13. 自定义方法guess： 将str中的每个字符传递值给char数组
        for (int i = 0 ; i < length_str ; i++){
            str_char[i] = str.charAt(i);
        }
        //14. 自定义方法guess： 再声明一个boolean型数组，char数组的下标对应int型下标，全部采用初始值为false，表示未猜出
        boolean[] bool_char = new boolean[length_str];
        //15. 自定义方法guess： 创建一个int型记猜错次数初始0，一个boolean对象bool初始为true（当单词全部猜出时设置为false）
        int count = 0;
        boolean bool = true;
        //16. 自定义方法guess： 循环体头，判断条件为bool
        while (bool){
            //17. 自定义方法guess： 输出guess语句（boolean数组元素为false的输出*，下标为true的输出对应的char元素字符）并接收用户输入的字符
            Scanner input = new Scanner(System.in);
            System.out.print("(Guess) Enter a letter in word ");
            for (int i = 0 ; i < length_str ; i++){
                if ( !bool_char[i] ){
                    System.out.print("*");
                }else {
                    System.out.print(str_char[i]);
                }
            }
            System.out.println(" > ");
            //18. 自定义方法guess： 对用户输入字符进行接收
            String temp = input.next();
            char ch_guess = temp.charAt(0);
            //19. 自定义方法guess： 与char型元素比较，有匹配的则将对应的boolean数组值改为true，没匹配则计数变量+1
            boolean bool_temp = false;
            for (int i = 0 ; i <length_str ; i++){
                if (ch_guess == str_char[i]){
                    bool_char[i] = true;
                    bool_temp = true;
                }
            }
            if ( !bool_temp ){
                ++count;
            }
            //20. 自定义方法guess： 判断boolean数组是否全为true，如果是则将判断条件的bool改为false
            if (isAllTrue(bool_char)){
                bool = false;
            }
        }
        //22. 自定义方法guess： 返回计数变量
        return count;
    }
    //自定义方法：看传入的boolean数组是不是全为true
    public static boolean isAllTrue(boolean[] bool){
        int length = bool.length;
        boolean sym = true;
        for (int i = 0 ; i <length ; i++){
            if ( !bool[i] ){
                sym = false;
                break;
            }
        }
        return sym;
    }
}

