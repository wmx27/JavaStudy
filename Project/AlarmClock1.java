package Project;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
//获取现在时间
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
//事件相关
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
//动画相关
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
public class AlarmClock1 extends Application{
    private AlarmClockPane nowTime=new AlarmClockPane();
    private ArrayList<AlarmClockPane> eventTime=new ArrayList<>();//最多创建100个规定时间
    private int Hour;
    private int Minute;
    private int Second;
    private int num=0;//代办事件的个数
    private int lineNum=2;
    @Override
    public void start(Stage primaryStage){
        HBox hBox=new HBox(10);
        ComboBox hour=new ComboBox();
        hour.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        hour.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Hour=(int)newValue;
            }
        });
        ComboBox minute=new ComboBox();
        minute.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59);
        minute.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Minute=(int)newValue;
            }
        });
        ComboBox second=new ComboBox();
        second.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59);
        second.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Second=(int)newValue;
            }
        });
        hBox.getChildren().addAll(hour,new Label("时"),minute,new Label("分"),second,new Label("秒"));
        hBox.setAlignment(Pos.CENTER);

        HBox hBox1=new HBox(10);
        TextField event=new TextField();
        Label label=new Label("待办事件");
        hBox1.getChildren().addAll(label,event);
        hBox1.setAlignment(Pos.CENTER);

        Button btAdd=new Button("添加");

        GridPane pane=new GridPane();
        pane.addRow(0,hBox);
        pane.addRow(1,hBox1,btAdd);
        pane.setAlignment(Pos.TOP_CENTER);

        Scene scene=new Scene(nowTime,500,400);
        primaryStage.setScene(scene);


        btAdd.setOnAction(e->{
                eventTime.add(new AlarmClockPane(Hour, Minute, Second, event.getText()));
                HBox temp = new HBox();
                temp.setPrefWidth(100);
                Label l=new Label(Hour + ":" + Minute + ":" + Second + " " + event.getText());
                l.setFont(new Font(30));
                temp.getChildren().add(l);
                temp.setAlignment(Pos.CENTER_LEFT);
                pane.addRow(lineNum, temp);
                lineNum++;
        });

        nowTime.setCenter(pane);



        //设置闹钟循环处理器
        EventHandler<ActionEvent> eventHandler=e -> {

            //每次更新时间
            nowTime.setCurrentTime();
            int remove=0;
            for(int i=eventTime.size()-1;i>=0;i--)
                if(eventTime.get(i).getHour()==nowTime.getHour()&&eventTime.get(i).getMinute()==nowTime.getMinute()&&eventTime.get(i).getSecond()==nowTime.getSecond())
                {
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.titleProperty().set("闹钟响了！！！！");

                    alert.headerTextProperty().set(eventTime.get(i).getHour()+":"+eventTime.get(i).getMinute()+":"+eventTime.get(i).getSecond()+" "+event.getText()+"到时间了");
                    alert.show();
                    System.out.println("闹钟"+eventTime.get(i).getHour()+":"+eventTime.get(i).getMinute()+":"+eventTime.get(i).getSecond()+" "+event.getText()+"到时间了");
                    pane.getChildren().remove(i+3);
                    eventTime.remove(i);

                }

            //重写输出的时间字符串和Label
            String timeString1=nowTime.getHour()+":"+nowTime.getMinute()+":"+nowTime.getSecond();
            Label label1=new Label(timeString1);
            label1.setFont(Font.font(50));
            nowTime.setTop(label1);
            BorderPane.setAlignment(label1, Pos.CENTER);
        };
        Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        primaryStage.show();

    }
}
class AlarmClockPane extends BorderPane {
    private int hour;
    private int minute;
    private int second;
    private String message;
    public AlarmClockPane(){
        //无参构造方法以当前时间来作为参数构建
        Calendar calendar=new GregorianCalendar();
        this.hour=calendar.get(Calendar.HOUR_OF_DAY);
        this.minute=calendar.get(Calendar.MINUTE);
        this.second=calendar.get(Calendar.SECOND);
    }

    public AlarmClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }
    public AlarmClockPane(int hour, int minute, int second,String message) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.message=message;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String getMessage() {
        return message;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    public void setCurrentTime(){
        Calendar calendar=new GregorianCalendar();
        this.hour=calendar.get(Calendar.HOUR_OF_DAY);
        this.minute=calendar.get(Calendar.MINUTE);
        this.second=calendar.get(Calendar.SECOND);
    }
}
