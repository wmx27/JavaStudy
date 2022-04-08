package Chapter15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;

public class work15point1 extends Application {
    @Override
    public void start(Stage primaryStage){
        Button bt=new Button("Refresh");
        BorderPane borderPane=new BorderPane();
        borderPane.setBottom(bt);
        BorderPane.setAlignment(bt,Pos.CENTER);
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //
                int[] num=new int[4];
                Image[] images=new Image[4];
                HBox hBox=new HBox();
                for(int i=0;i<4;i++)
                num[i]=(int)(Math.random()*52+1);

                for(int i=0;i<4;i++) {
                    images[i] = new Image("imageCard//" + num[i] + ".png");
                    ImageView imageView=new ImageView(images[i]);
                    hBox.getChildren().add(imageView);
                }
                borderPane.setCenter(hBox);
                BorderPane.setAlignment(hBox,Pos.CENTER);
            }
        });
        Scene scene=new Scene(borderPane,72*4,150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
