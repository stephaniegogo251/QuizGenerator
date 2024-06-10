package quiz.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ScoreController {
    // JavaFX elements defined in FXML
    @FXML
    private Button goBack;

    @FXML
    public Label finalStatus, correctAns, wrongAns;

    // Reference to the main stage
    private Stage theMainStage;

    // Set the main stage
    public void setStage(Stage theStage){
        this.theMainStage = theStage;
    }

    @FXML
    // Initialize method, called after FXML elements are injected
    private void initialize()
    {
        // Set final status, correct and wrong answers
        finalStatus.setText(finalStatus.getText() + "\n" + QuizController.status);
        correctAns.setText(correctAns.getText() + "\n" + String.valueOf(QuizController.correct));
        wrongAns.setText(wrongAns.getText() + "\n" + String.valueOf(QuizController.wrong));
    }

    @FXML
    // Action when "Go Back" button is clicked
    public void backToStart() {
        goBack.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // Load start page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
                    Scene scene = new Scene(loader.load());

                    StartController startController = loader.getController();
                    startController.setStage(theMainStage); //sets the stage

                    theMainStage.setTitle("Quiz Generator"); //sets the title of stage
                    theMainStage.setScene(scene); //sets the scene
                    theMainStage.setResizable(false); //User cannot resize window size
                    theMainStage.show(); //displays the stage
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
