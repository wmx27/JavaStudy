package JavaFX学习课;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class kindOfStage extends Application {
    @Override
    public void start(Stage primaryStage){
        //五种基本模式
        Stage s1=new Stage();
        s1.setTitle("s1");
        s1.initStyle(StageStyle.DECORATED);//默认
        s1.show();

        Stage s2=new Stage();
        s2.setTitle("s2");
        s2.initStyle(StageStyle.TRANSPARENT);//透明
        s2.show();

        Stage s3=new Stage();
        s3.setTitle("s3");
        s3.initStyle(StageStyle.UNIFIED);//与默认相似
        s3.show();

        Stage s4=new Stage();
        s4.setTitle("s4");
        s4.initStyle(StageStyle.UNDECORATED);//透明白色
        s4.show();

        Stage s5=new Stage();
        s5.initStyle(StageStyle.UTILITY);//只有关闭按钮 其余没有
        s5.setTitle("s5");
        s5.show();

        Platform.exit();
    }
}
