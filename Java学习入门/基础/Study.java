package Java学习入门.基础;
//java中的重要东西
/*FirstClass包含主要的Java介绍 JVM JRE JDK JVM 常见DOS命令 关键字 标识符 数据类型 类型转换 算术运算 逻辑运算 数据输入、
学习日期:2021.8.30日 学习者:WMX
*/

/*.1
跨平台原理:在不同的操作系统上运行java程序   通过JVM的不同调用
*/

/*.2
JRE(Java Runtime Environment):是java程序的运行时环境 包含JVM和运行时所需要的核心类库
JDK(Java Development Kit):是java程序开发工具包 包含JRE和开发人员使用的工具
    其中的开发工具:编译工具:javac.exe 运行工具:java.exe
JDK JRE JVM的关系
JDK包含JRE和开发工具  JRE包含JVM和核心类库
*/
/*.3
常见的DOS命令
1.1打开命令提示符窗口
（1）按下win+R （2）输入cmd （3）按下回车键
1.2常用命令
（1）盘符切换             盘符名称:
（2）查看当前路径下的内容   dir
（3）进入单级目录          cd 目录
（4）返回上一级目录        cd..
（5）退回到盘符目录        cd\
（6）清屏                cls
（7）退出命令提示符窗口     exit
（8）进入多级目录          cd 目录1\目录2\目录3
*/
/*
Java程序中的最基本的组成单位是类
类的定义格式：
   public class 类名{
      //这是main方法  main方法是程序的入口方法 代码的执行是从main方法开始的
      public static void main(String[] args)
      {
      System.out.println("hello world!");
      }
   }
*/
/*
Java关键字
    Java关键字的字母全为小写
    常用的代码编辑器 针对关键字有特殊的颜色标记 非常直观
Java变量使用的注意事项
    名字不能重复
    变量未赋值，不能使用
    long类型的变量定义的时候 为了防止整数过大 后面要加L（当选用整数的时候 默认为整数类型）
Java标识符定义规则
    由数字 字母 下划线 和美元符$组成  不能以数字 不能是关键字 区分大小写
Java类型转换分类
    自动类型转换
    强制类型转换
Java的运算
    + - * / %
    字符“+”操作 对应底层的连续运算  i+e  A+B
    （在进行操作的时候 包含多个类型 整个算数表达式的类型会自动的进行提升 short和char会转换到int）
    字符串的“+”操作 当“+”操作出现在字符串的时候 这个+是字符串连接符 而不是算术运算
    （从左到右运算+ 当出现字符串的时候+号变为字符串连接符）
Java的逻辑运算
    &逻辑与 !逻辑非 ^逻辑异或 |逻辑或
    &&短路与（具有短路效果 左端为false右端不执行） ||短路或（具有短路效果 左端为true右端不执行）
Java的数据输入
    Scanner使用的基本步骤
    （1）导包   import Java.util.Scanner;
    （2）创建对象 Scanner sc = new Scanner(System.in);
    （3）接受数据 int i = sc.nextInt();
*/
//关于class有如下几点规则：
//1.文件的名字必须和class的名字一致（public级别的class名字）。
//2.文件必须只包含一个public访问基本的class（可以包含多个非public级别的class）。
//3.package名字必须和目录一致。

/*SecondClass包含Idea的常用快捷键
学习日期:2021.8.31 学习者:WMX
*/
/*.1
    idea快捷键
快速创建主方法             psvm
快速生成输出语句           sout
内容辅助键         Ctrl+Alt+space（内容提示 代码补全）
注释      单行：选中代码 Ctrl+/ 再来一次取消注释        多行：选中代码Ctrl+shirt+/ 再来一次取消注释
格式化 Ctrl+Alt+L
*/

/*.2
Idea中的模块操作   新建模块 删除模块 导入模块
*/

/*.3
数组定义格式
数据类型[] 变量名  定义了一个（数据类型）的数组 数组名为（数组名）
数据类型 变量名[]  定义了一个（数据类型）的变量 变量名为（数组名）数组
*/

/*.4
数组初始化
数组初始化之动态初始化：在初始化的时候只指定数组长度 由系统分配初始值
int[] arr=new int[3];
数组初始化之静态初始化：初始化时指定每个数组元素的初始值 由系统确定数组长度
int[] arr=new int[]{数据1，数据2，数据3，数据4，。。。。};
简化格式：int[] arr={数据1，数据2，数据3，数据4，。。。。};

数组中常见问题
（1）索引越界
（2）空指针异常
*/

/*.5
数组元素访问
数组元素访问方式 格式：数组名
数组内部保存的数据的访问方式 格式：数组名[索引]
索引是什么？  c语言的下标
*/

/*.6
栈内存去寻找堆内存中的数据（通过地址的方式）
Java中的内存分配 堆内存（
    存储new出来的内容（实体，对象）每一个new出来的东西都有一个地址值 使用完毕 会在垃圾回收器空闲时被回收）
c语言中的内存分配 栈内存（
    存储局部变量）定义在方法中的变量使用完毕立即消失

    当多个数组指向相同内存时 两个修改时改变的是堆内存中的数值 都会改变
    （发现数组这个内存管理方式有点像指针）
*/

/*.7
Java中数组常见操作
遍历   用循环
获取数组元素数量  格式：数组名.length
*/

import java.util.Arrays;

/*.8
Java方法概述
类似与c语言的函数为了封装代码集
方法定义和调用
方法定义格式：  public static void 方法名(){ //方法体}
方法调用：     方法名();
eg
public static void isEvenNumber()
{  //方法体
}
isEvenNumber();
*/
public class Study {
    public static void main(String[] args) {
        //Java程序由package + class组成，package对应目录的相对路径，class对应文件
        int[] list1={11,2,4,7,10};
        int[] list2={2,4,7,7,7,10};
        Arrays.sort(list1);
        for (int i:list1)
        {
            System.out.print(i+" ");
        }
        System.out.println();

        Arrays.fill(list1,5);
        Arrays.fill(list2,0,3,8);
        for(int i=0;i<list1.length;i++)
        {
            System.out.print(list1[i]+" ");
        }
        System.out.println();
        for(int i=0;i<list2.length;i++)
        {
            System.out.print(list2[i]+" ");
        }
    }
}
