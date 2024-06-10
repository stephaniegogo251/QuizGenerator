package quiz.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import quiz.QuizGen;

import java.io.*;

public class SignUpController {

    // JavaFX elements defined in FXML
    @FXML
    public PasswordField password;

    @FXML
    public TextField username;

    @FXML
    public Button signUp;

    @FXML
    public Label alert;

    // Reference to the primary stage
    private Stage stage;

    // Set the primary stage
    public void setStage(Stage primaryStage){
        this.stage = primaryStage;
    }

    // File to store login credentials
    File loginFile = new File("src/quiz/view/loginFile.txt");

    // Method to handle sign-up button click
    public void setSignUp() {
        try {
            // Open the file in append mode to add new user credentials
            FileWriter file = new FileWriter(loginFile, true);
            BufferedReader reader = new BufferedReader(new FileReader(loginFile));
            String line;
            boolean exist = false;
            // Check if username already exists
            while ((line = reader.readLine()) != null){
                if (line.equals(username.getText())){
                    exist=true;
                    break;
                }
            }
            reader.close(); //closes reader to not lose data

            // Display alert if username already exists
            if (exist){
                alert.setText("Username already exists");
                return;
            }

            // Write new user credentials to the file
            file.write(username.getText() + "\n");
            file.flush();
            file.write(password.getText() + "\n");
            file.flush();
            file.close();
            // Redirect to login page after successful sign-up
            goToLogin();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to navigate to login page
    private void goToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(QuizGen.class.getResource("view/LoginPage.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);

            LoginPageController loginPageController = loader.getController();
            loginPageController.setStage(stage); //sets stage

            stage.setScene(scene); //sets scene
            stage.setTitle("Quiz Generator"); //sets title of window
            stage.setResizable(false); //User cannot resize window
            stage.show(); //displays the stage
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
