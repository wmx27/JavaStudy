package GUI;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import javax.swing.text.LabelView;


public class ShowHBoxVBox extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane pane=new BorderPane();

        pane.setTop(getHBox());
        pane.setLeft(getVBox());

        Scene scene=new Scene(pane);
        primaryStage.setTitle("ShowHBoxVBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private HBox getHBox(){
        HBox hBox=new HBox(15);
        hBox.setPadding(new Insets(15,15,15,15));
        hBox.setStyle("-fx-background-color:gold");
        hBox.getChildren().add(new Button("Computer Science"));
        hBox.getChildren().add(new Button("Chemistry"));
        Image image=new Image("src/图片.jpeg");
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        hBox.getChildren().add(imageView);
        return hBox;
    }
    private VBox getVBox(){
        VBox vBox=new VBox(15);
        vBox.setStyle("-fx-backGround-color:red");
        vBox.setPadding(new Insets(15,5,5,5));
        vBox.getChildren().add(new Label("Course"));
        Label[] courses={
                new Label("CSCI 1301"),
                new Label("CSCI 1302"),
                new Label("CSCI 2410"),
                new Label("CSCI 3720")
        };
        for(Label s:courses){
            VBox.setMargin(s,new Insets(0,0,0,15));
            vBox.getChildren().add(s);
        }
        return vBox;
    }
}
