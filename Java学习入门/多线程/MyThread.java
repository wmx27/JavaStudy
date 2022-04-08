package Java学习入门.多线程;
/*

 */
public class MyThread extends Thread{
    @Override
    public void run(){
        Math.pow(2,2);
        for(int i=0;i<=1000;i++){
            System.out.println(MyThread.currentThread().getName()+":"+i);
        }
    }
}
