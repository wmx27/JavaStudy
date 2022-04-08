package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class EventDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Button b1=new Button("Button1");
        b1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //获取鼠标点击点的坐标
                System.out.println("event.getX()"+event.getX());
                System.out.println("event.getY()"+event.getY());
                //不知道是啥返回 但是存在
                System.out.println("event.getZ()"+event.getZ());
                //返回鼠标点击点在scene中的坐标
                System.out.println("event.getSceneX()"+event.getSceneX());
                System.out.println("event.getSceneY()"+event.getSceneY());
                //返回鼠标在屏幕坐标的位置
                System.out.println("event.getScreenX()"+event.getScreenX());
                System.out.println("event.getScreenY()"+event.getScreenY());
                //
                System.out.println(event.toString());
                /*
                MouseEvent [source = Button@65966bb7[styleClass=button]'Button1',
                target = Button@65966bb7[styleClass=button]'Button1',
                eventType = MOUSE_PRESSED, consumed = false,
                x = 91.0, y = 25.0, z = 0.0,
                button = PRIMARY, primaryButtonDown,
                pickResult = PickResult [node = Button@65966bb7[styleClass=button]'Button1',
                point = Point3D [x = 91.0, y = 25.0, z = 0.0], distance = 74.64101615137756]
                 */
                System.out.println("event.getButton()"+event.getButton());
                System.out.println("event.getEventType()"+event.getEventType());
                System.out.println("event.getSource()"+event.getSource());
                System.out.println("event.getTarget()"+event.getTarget());
                System.out.println("event.getClass()"+event.getClass());

            }
        });
        Button b2=new Button("Button2");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("event.getEventType()"+event.getEventType());
            }
        });

        FlowPane pane=new FlowPane();

        pane.getChildren().add(b1);
        pane.getChildren().add(b2);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5,10,5,10));
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
