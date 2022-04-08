package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class MultipleStageDemo extends Application{
    @Override
    public void start(Stage PrimaryStage)
    {
        Scene scene = new Scene(new Button("OK"),200,250);
        PrimaryStage.setTitle("MultipleStage");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();

        Stage stage=new Stage();
        stage.setTitle("Second Stage");
        stage.setScene(new Scene(new Button("确认"),200,250));
        stage.show();

    }

}
