package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
public class ShowBorderPane extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane pane=new BorderPane();
        pane.setTop(new CustomPane("Top"));
        pane.setRight(new CustomPane("Right"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setLeft(new CustomPane("Left"));
        pane.setCenter(new CustomPane("Center"));

        Scene scene=new Scene(pane,300,300);
        primaryStage.setTitle("ShowBorderPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
class CustomPane extends StackPane{
    public CustomPane(String s)
    {
        getChildren().add(new Label(s));
        setStyle("-fx-border-color:red");
        setPadding(new Insets(11.5,12.5,13.5,14.5));

    }
}
