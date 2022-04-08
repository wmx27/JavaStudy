package GUI;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    private TextField tfAnnualInterstRate =new TextField();
    private TextField tfNumberOfYears =new TextField();
    private TextField tfLoanAmount =new TextField();
    private TextField tfTotalPayment =new TextField();
    private Button vtCalculate =new Button("Calculate");

    @Override
    public void start(Stage primaryStage){

    }
}
