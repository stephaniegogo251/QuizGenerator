package quiz.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartController {
    // Variables to store user name and reference to JavaFX elements
    public String userName;

    @FXML
    private TextField name;

    @FXML
    private Button checkScoreBtn;

    @FXML
    private Button startButton;

    @FXML
    private Button scoreBoard;

    // Reference to the main stage
    private Stage theMainStage;

    // Set the main stage
    public void setStage(Stage theStage){
        this.theMainStage = theStage;
    }

    @FXML
    // Initialize method, called after FXML elements are injected
    private void initialize() {
        // Action when start button is clicked
        startButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // Load quiz questions page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("quizQns.fxml"));
                    Scene scene = new Scene(loader.load());

                    QuizController quizController = loader.getController();
                    quizController.setStage(theMainStage); //sets stage

                    UserData ud = new UserData(); //creates instance of UserData class
                    userName = name.getText(); //stores name entered by user
                    ud.setUserName(userName); //sets UserName

                    theMainStage.setTitle("Quiz Generator"); //sets the title of the window
                    theMainStage.setScene(scene); //sets the scene
                    theMainStage.setResizable(false); //User cannot resize window
                    theMainStage.show(); //displays the stage
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @FXML
    // Action when check score button is clicked
    public void setCheckScoreBtn() {
        checkScoreBtn.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // Close current stage
                    Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    currentStage.close();

                    // Load result page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
                    Parent root = loader.load();

                    UserData userData = new UserData(); //creates instance of UserData
                    userData.setStage(theMainStage); //sets stage

                    Scene scene = new Scene(root); //creates scene
                    theMainStage.setScene(scene); //sets scene
                    theMainStage.setResizable(false); //User cannot resize the window
                    theMainStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    @FXML
    // Action when score board button is clicked
    public void goToScoreBoard() {
        scoreBoard.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // Close current stage
                    Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    currentStage.close();

                    // Load score board page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));
                    Parent root = loader.load();

                    Stage stage = new Stage(); //creates stage
                    Scene scene = new Scene(root); //creates scene
                    stage.setResizable(false); //User cannot resize window
                    stage.setTitle("Quiz Generator"); //sets title of window
                    stage.setScene(scene); //sets scene
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
