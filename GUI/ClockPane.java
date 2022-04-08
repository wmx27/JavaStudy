package GUI;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    public ClockPane(){
        setCurrentTime();
    }
    public ClockPane(int hour,int minute,int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    public int getHour(){
        return hour;
    }
    public void setHour(int hour){
        this.hour=hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        PaintClock();
    }
    public void setCurrentTime(){
        Calendar calendar=new GregorianCalendar();
        this.hour=calendar.get(Calendar.HOUR_OF_DAY);
        this.minute=calendar.get(Calendar.MINUTE);
        this.second=calendar.get(Calendar.SECOND);
    }
    public void PaintClock(){

        setCurrentTime();
        double clockRadius=Math.min(getWidth(),getHeight())*0.8*0.5;
        DoubleProperty centerX=new SimpleDoubleProperty();
        DoubleProperty centerY=new SimpleDoubleProperty();
        centerX.bind(this.widthProperty().divide(2));
        centerY.bind(this.heightProperty().divide(2));
        Circle circle=new Circle(centerX.doubleValue(),centerY.doubleValue(),clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Text t1=new Text(centerX.doubleValue()-5,centerY.doubleValue()-clockRadius+12,"12");
        Text t2=new Text(centerX.doubleValue()-clockRadius+3,centerY.doubleValue()+5,"9");
        Text t3=new Text(centerX.doubleValue()+clockRadius-10,centerY.doubleValue()+3,"3");
        Text t4=new Text(centerX.doubleValue()-3,centerY.doubleValue()+clockRadius-3,"6");

        double sLength=clockRadius*0.8;
        double secondX=centerX.doubleValue()+sLength*Math.sin(second*(2*Math.PI/60));
        double secondY=centerY.doubleValue()-sLength*Math.cos(second*(2*Math.PI/60));
        Line sLine=new Line(centerX.doubleValue(),centerY.doubleValue(),secondX,secondY);
        sLine.setStroke(Color.RED);

        double mLength=clockRadius*0.65;
        double XMinute=centerX.doubleValue()+mLength*Math.sin(minute*(2*Math.PI/60));
        double YMinute=centerY.doubleValue()-mLength*Math.cos(minute*(2*Math.PI/60));
        Line mLine=new Line(centerX.doubleValue(),centerY.doubleValue(),XMinute,YMinute);
        mLine.setStroke(Color.BLUE);

        double hLength=clockRadius*0.5;
        double hourX=centerX.doubleValue()+hLength*Math.sin((hour%12+minute/60.0)*(2*Math.PI/12));
        double hourY=centerX.doubleValue()-hLength*Math.cos((hour%12+minute/60.0)*(2*Math.PI/12));
        Line hLine=new Line(centerX.doubleValue(),centerY.doubleValue(),hourX,hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle,t1,t2,t3,t4,sLine,mLine,hLine);
    }
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        PaintClock();
    }
    public void setHeight(double height){
        super.setHeight(height);
        PaintClock();
    }
}
