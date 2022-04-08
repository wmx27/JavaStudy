package Chapter15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class work15point6 extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane pane=new StackPane();
        Text text=new Text("Java is fun");
        pane.getChildren().add(text);
        pane.setOnMouseClicked(e -> {
            if (text.getText().equals("Java is fun")) {
                text.setText("Java is powerful");
            }
            else {
                text.setText("Java is fun");
            }
        });
        Scene scene=new Scene(pane,500,100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
