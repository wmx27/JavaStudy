package GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
public class ShowFlowPane extends Application{
    @Override
    public void start(Stage primaryStage){
        FlowPane pane=new FlowPane();
        pane.setPadding(new Insets(11,12,13,14));
        pane.setHgap(5);
        pane.setVgap(5);

        pane.getChildren().addAll(new Label("first name"),new TextField(),new Label("MI:"));
        TextField tfMi=new TextField();
        tfMi.setPrefColumnCount(1);
        pane.getChildren().addAll(tfMi,new Label("last Name"),new TextField());

        Scene scene=new Scene(pane,200,250);
        primaryStage.setTitle("ShowFlowPane");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
