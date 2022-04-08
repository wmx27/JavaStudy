package Chapter15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class work15point33 extends Application {
    private double paneWidth = 300;
    private double paneHeight = 250;
    private double shift = paneWidth / 2;
    private int[] slots = new int[9];
    private int numberOfBallsDropped = 0;
    private int moveCount = 0;
    private int position = 0;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new BorderPane(new BeanMachine()), paneWidth, paneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class BeanMachine extends Group {




        final static int LENGTH_OF_OPENNING = 15;

        final static int RED_BALL_START_Y =45;
        private int yRed = 50-5;
        private Circle currentBall;
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(500), e -> move()));
        private double y_for_bottom_line;
        public BeanMachine() {
            dropABall();
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
            double y =50;
            double centerX = paneWidth / 2;
            for (double i = 0; i <7; i++) {
                y += 20;
                for (double k = 0; k <= i; k++) {
                    Circle c = new Circle(centerX - i * 20 / 2 + k * 20, y, 5);
                    c.setFill(Color.GREEN);
                    getChildren().add(c);
                }
            }
            y = y +5;
            for (double i = 0; i < 9; i++) {
                double x = centerX - (7 - 1) * 20 / 2 + (i - 1) * 20;
                getChildren().add(new Line(x, y, x, y + 50));
            }

            y_for_bottom_line = y + 50;
            getChildren().add(new Line(centerX - (7 - 1) * 20 / 2 - 20,
                    y + 50, centerX - (7 - 1) * 20 / 2 + 7 *20,
                    y +50));
            getChildren().add(new Line(centerX + 20 / 2, 50 +5,
                    centerX - (7 - 1) * 20 / 2 + 7 * 20, y));
            getChildren().add(new Line(centerX - 20 / 2, 50 + 5,
                    centerX - (7 - 1) * 20 / 2 - 20, y));
            getChildren().add(new Line(centerX - 20 / 2, 50 + 5,
                    centerX - 20 / 2, 50 - LENGTH_OF_OPENNING));
            getChildren().add(new Line(centerX + 20/ 2, 50 + 5,
                    centerX + 20 / 2, 50 - LENGTH_OF_OPENNING));
        }
        public void dropABall() {
            shift = paneWidth / 2;
            moveCount = 0;
            position = 0;
            yRed = RED_BALL_START_Y;
            currentBall = new Circle(shift, yRed, 5);
            currentBall.setFill(Color.RED);
            getChildren().add(currentBall);
        }
        public void moveRedBallLeft() {
            shift -=20 / 2;
            yRed += 20;
            currentBall.setCenterX(shift);
            currentBall.setCenterY(yRed);
        }
        public void moveRedBallRight() {
            shift += 20 / 2;
            yRed += 20;
            currentBall.setCenterX(shift);
            currentBall.setCenterY(yRed);
        }

        public void moveRedBallDown() {
            currentBall.setCenterY(y_for_bottom_line - slots[position] * 2 * 5 + 5);
        }

        public void move() {
            moveCount++;
            if (moveCount <= 7) {
                if (Math.random() < 0.5) {
                    moveRedBallLeft();
                } else {
                    moveRedBallRight();
                    position++;
                }
            } else {
                slots[position]++;
                moveRedBallDown();
                numberOfBallsDropped++;

                if (numberOfBallsDropped == 10) {
                    animation.stop();
                } else {
                    dropABall();
                }
            }
        }
    }
}
