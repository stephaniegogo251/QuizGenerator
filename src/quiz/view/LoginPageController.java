package quiz.view;

import javafx.event.ActionEvent;
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

public class LoginPageController {
    @FXML
    public Button loginButton;

    @FXML
    public Button signUp;

    @FXML
    public Label alert;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private AnchorPane anchorPane;

    // File to store login credentials
    public File loginFile = new File("src/quiz/view/loginFile.txt");

    private Stage stage;

    // Set the primary stage
    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }


    @FXML
    // Action when login button is clicked
    public void setLoginButton(ActionEvent actionEvent) {
        try {
            // Read from the login file
            BufferedReader reader = new BufferedReader(new FileReader(loginFile));
            String line;
            boolean name = false;
            boolean pass = false;
            while ((line = reader.readLine()) != null) {
                String savedUsername = line;
                String savedPassword = reader.readLine();

                // Checks if entered username and password match with saved ones
                if (username.getText().equals(savedUsername) && password.getText().equals(savedPassword)) {
                    name = true;
                    pass = true;
                    break;
                }
            }

            // Display alert if username or password is invalid
            if (!(name && pass)) {
                alert.setText("Username or password entered is invalid");
            } else {
                alert.setText("");
                // Navigate to start page upon successful login
                goToStart();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Navigate to start page
    private void goToStart() {
        try {
            FXMLLoader loader = new FXMLLoader(QuizGen.class.getResource("view/start.fxml"));
            AnchorPane root = loader.load();
            Scene scene =  new Scene(root);

            StartController startController = loader.getController();
            startController.setStage(stage); //sets the stage

            stage.setScene(scene); //sets the scene
            stage.setResizable(false); // User cannot resize the window
            stage.setTitle("Quiz Generator"); //sets the title of the window
            stage.show(); //displays the stage
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    // Action when sign-up button is clicked
    public void setSignUp(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);

            SignUpController signUpController = loader.getController();
            signUpController.setStage(stage);

            stage.setScene(scene);
            stage.setTitle("Quiz Generator");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
