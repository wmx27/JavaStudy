package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//注意 javaFX的设计始终要继承自Application
public class MyJavaFX extends Application{
    @Override
    public void start(Stage primaryStage){
        Button bkOk=new Button("OK");//创建一个button类型的按钮
        Scene scene=new Scene(bkOk,200,250);//创建一个Scene类型的界面 并且将Button类型的放在这个界面中

        primaryStage.setTitle("MyJavaFX");//设置这个总舞台的标题
        primaryStage.setScene(scene);//将界面嵌入到舞台当中
        primaryStage.show();//展示

    }
    //实际上 对于主模块可以不用 但是如果存在 必须用Application的静态方法启动JavaFX程序才行
    public static void main(String[] args) {
        Application.launch(args);
    }
}
