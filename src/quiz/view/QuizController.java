package quiz.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import quiz.model.QuizQs;

import java.io.IOException;
import java.util.Random;

public class QuizController {
    // JavaFX elements defined in FXML
    @FXML
    public Label question;
    @FXML
    public Button option1, option2, option3, option4;

    // Variable to track question number, correct and wrong answers, and status
    public int qnNo = 0; // Variable to track question number
    public static int correct = 0; // Variable to track correct answers
    public static int wrong = 0; // Variable to track wrong answers
    public static String status = "NOT ATTEMPTED"; // Variable to track user's status

    // Reference to the main stage
    private Stage theMainStage;

    // instance of quiz object
    static QuizQs quiz = new QuizQs();

    // Set the main stage
    public void setStage(Stage theStage){
        this.theMainStage = theStage;
    }

    @FXML
    // Initialize method, called after FXML elements are injected
    private void initialize() {
        quiz = new QuizQs(); // Instantiate the QuizQs object
        loadQuestions(); //load questions
    }

    // Method to increment x
    private int incrementX(int x) {
        x++;
        if(x > 3) x = 0;
        return x;
    }

    // Method to load questions and their options
    private void loadQuestions() {
        question.setText(quiz.Qs.get(qnNo).question);
        Random rand = new Random();
        int x = rand.nextInt(3);
        option1.setText(quiz.Qs.get(qnNo).options[x]);
        x = incrementX(x);
        option2.setText(quiz.Qs.get(qnNo).options[x]);
        x = incrementX(x);
        option3.setText(quiz.Qs.get(qnNo).options[x]);
        x = incrementX(x);
        option4.setText(quiz.Qs.get(qnNo).options[x]);
        x = incrementX(x);
    }

    // Method to process user's choice
    private void processChoice(String answer) throws IOException {
        UserData ud = new UserData();
        if (quiz.Qs.get(qnNo).evaluateResponse(answer)) {
            correct++; //if evaluateResponse returns true, increments correct
        } else {
            wrong++; //else, increments wrong
        }
        qnNo++; //increments question number
        if (qnNo >= quiz.Qs.size()) { //after the quiz reaches the last question
            int total = correct + wrong;
            if (correct * 1.0 / total < 0.4) {//if user answers 3 or less than 3 questions, user fails the test
                status = "FAIL";
            } else { //else, the user passes the test
                status = "PASS";
            }
            // Set user's score and status
            ud.setUserScore(String.valueOf(correct));
            ud.setUserStatus(status);
            try {
                // Load score page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("score.fxml"));
                Scene scene = new Scene(loader.load());

                ScoreController scoreC = loader.getController();
                scoreC.setStage(theMainStage); //sets the stage

                theMainStage.setScene(scene); //sets the scene
                theMainStage.setResizable(false); //User cannot resize window
                theMainStage.show(); //displays the scene
            } catch (Exception e) { //handles any exception that may occur
                e.printStackTrace();
            }
        } else {
            // Load next question
            loadQuestions();
        }
    }

    // Methods for processing of user's choices
    @FXML
    public void optOne(ActionEvent actionEvent) throws IOException {
        processChoice(option1.getText().toString());
    }

    @FXML
    public void optTwo(ActionEvent actionEvent) throws IOException {
        processChoice(option2.getText().toString());
    }

    @FXML
    public void optThree(ActionEvent actionEvent) throws IOException {
        processChoice(option3.getText().toString());
    }

    @FXML
    public void optFour(ActionEvent actionEvent) throws IOException {
        processChoice(option4.getText().toString());
    }
}
