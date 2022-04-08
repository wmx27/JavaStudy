package Chapter15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.event.EventHandler;

public class HandleEvent extends Application {
    @Override
    public void start(Stage primaryStage){
        HBox hBox=new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btOK=new Button("OK");
        Button bkCancel=new Button("Cancel");
        OKHandlerClass handler1=new OKHandlerClass();
        CancelHandlerClass hander2=new CancelHandlerClass();
        btOK.setOnAction(handler1);
        bkCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override//使用了匿名类来作事件的处理器
            public void handle(ActionEvent event) {
                primaryStage.setTitle("sss");
            }
        });
        hBox.getChildren().addAll(bkCancel,btOK);
        Scene scene=new Scene(hBox,100,50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class OKHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("OK button clicked");
    }

}
class CancelHandlerClass implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        System.out.println("Cancel button clicked");
    }
}
