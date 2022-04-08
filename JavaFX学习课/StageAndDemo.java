package JavaFX学习课;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;//监听里面需要的的包
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javax.swing.border.Border;


public class StageAndDemo extends Application {
    @Override
    public void start(Stage primaryStage){
//        primaryStage.getIcons().add(new Image("图片2.jpg"));修改程序图标
//        primaryStage.setFullScreen(true);//设置全屏

//        primaryStage.setIconified(true);设置最小化
//        primaryStage.setMaximized(true);设置最大化
//        primaryStage.close();设置关闭

        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
//        primaryStage.setResizable(false);设置不可变窗口大小false

//        primaryStage.setMaxWidth(1000);//设置最大的宽度和高度
//        primaryStage.setMaxHeight(1000);

//        primaryStage.setMinWidth(500);//设置最小的宽度和高度
//        primaryStage.setMinHeight(500);

//        System.out.println("宽度 = "+primaryStage.getWidth());
//        System.out.println("高度 = "+primaryStage.getHeight());
        //在不设置宽度和高度的情况下 宽度 = NaN 高度 = NaN  要是想获得 在show方法后获取


        //监听窗口的宽度 和 高度
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("当前高度 "+newValue.doubleValue());
            }
        });
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("当前宽度 "+newValue.doubleValue());
            }
        });

//        primaryStage.setFullScreen(true);//单一使用没效果 需设置下一个
//        primaryStage.setScene(new Scene(new BorderPane()));

        primaryStage.setX(100);//设置出生时的坐标 但是设置后屏幕大小的默认值会消失 需自己设置
        primaryStage.setY(100);

        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("X:"+newValue.doubleValue());
            }
        });

        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Y:"+newValue.doubleValue());
            }
        });

        primaryStage.setOpacity(0.5);//设置透明度 从 0 到 1 （1为不透明）
//        primaryStage.setAlwaysOnTop(true);//设置窗口始终在最上层





        primaryStage.show();
//        System.out.println("宽度 = "+primaryStage.getWidth());
//        System.out.println("高度 = "+primaryStage.getHeight());

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
