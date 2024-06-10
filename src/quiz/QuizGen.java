package quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quiz.view.LoginPageController;

public class QuizGen extends Application {

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    // Start method called when the application is launched
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(QuizGen.class.getResource("view/LoginPage.fxml")); // Load the FXML file for the login page
            Scene scene = new Scene(loader.load()); // Create a new scene with the loaded FXML file

            LoginPageController loginPageController = loader.getController(); // Get the controller associated with the loaded FXML file
            loginPageController.setStage(primaryStage); // Set the primary stage for the controller

            primaryStage.setScene(scene); // Set the scene for the primary stage
            primaryStage.setTitle("Quiz Generator"); // Set the title for the primary stage
            primaryStage.setResizable(false); // User cannot resize window
            primaryStage.show(); // Display the primary stage
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
