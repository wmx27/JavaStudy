package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class DisplayClock extends Application {
    @Override
    public void start(Stage primaryStage){
        ClockPane clock=new ClockPane();
        String timeString=clock.getHour()+":"+clock.getMinute()+":"+clock.getSecond();
        Label lblCurrentTime=new Label(timeString);
        BorderPane pane=new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime,Pos.TOP_CENTER);

        Scene scene=new Scene(pane,600,600);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}

