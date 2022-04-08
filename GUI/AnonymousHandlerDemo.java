package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class AnonymousHandlerDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Text text=new Text(40,40,"Programming is fun");
        Pane pane=new Pane(text);

        Button b1=new Button("Up");
        Button b2=new Button("Down");
        Button b3=new Button("Left");
        Button b4=new Button("Right");
        HBox hBox=new HBox(b1,b2,b3,b4);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane=new BorderPane(pane);
        borderPane.setBottom(hBox);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setY(text.getY()>10?text.getX()-5:10);
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setY(text.getY()<pane.getHeight()? text.getY()+5 :pane.getHeight() );
            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setX(text.getX()>0? text.getX()-5 :0 );
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setX(text.getX()<pane.getWidth()-100? text.getX()+5 : pane.getWidth()-100);

            }
        });
        Scene scene=new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
