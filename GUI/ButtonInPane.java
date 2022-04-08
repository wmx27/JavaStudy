package GUI;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
public class ButtonInPane extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane pane=new StackPane();
        pane.getChildren().add(new Button("OK"));
        Scene scene=new Scene(pane,200,250);
        primaryStage.setTitle("Button in Pane");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
