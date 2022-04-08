package Chapter15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControlCircleWithoutEventHandling extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane stackPane=new StackPane();
        Circle circle=new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        stackPane.getChildren().add(circle);

        HBox hBox=new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button button1=new Button("Enlarge");
//        button1.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent e){
//                    circle.setRadius(circle.getRadius()+2);
//            }
//        });
        button1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.setRadius(circle.getRadius()+2);
            }
        });
        Button button2=new Button("Shrink");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(circle.getRadius()-2>0)
                circle.setRadius(circle.getRadius()-2);
            }
        });
        hBox.getChildren().addAll(button1,button2);

        BorderPane borderPane=new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(stackPane);

        BorderPane.setAlignment(hBox,Pos.CENTER);

        Scene scene=new Scene(borderPane,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
