package JavaFX学习课;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageStudy extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        //模态
        Stage s1=new Stage();
        s1.setTitle("s1");
        s1.initModality(Modality.WINDOW_MODAL);//当设置这个模态时


        Stage s2=new Stage();
        s2.setTitle("s2");
        s1.initOwner(s1);
//        s2.initModality(Modality.NONE);
        ;

//        Stage s3=new Stage();
//        s3.setTitle("s3");
//        s3.initModality(Modality.APPLICATION_MODAL);
//        //注意这个模态设置的窗口打开时，只能操作1本窗口 其他的窗口无法操作


        s2.show();  s1.show();
//        s3.show();
    }
}
