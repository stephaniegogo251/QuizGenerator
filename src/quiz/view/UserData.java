package quiz.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class UserData {
    // JavaFX elements defined in FXML
    @FXML
    public Button exitButton;

    @FXML
    public Button goBtn;

    @FXML
    public Button backBtn;

    @FXML
    private TextField Name;

    @FXML
    private Label UserName;

    @FXML
    private Label UserStatus;

    @FXML
    private Label UserScore;

    // Vectors to store user data
    public Vector<String> nameList = new Vector<>();
    public Vector<String> statusList = new Vector<>();
    public Vector<String> scoreList = new Vector<>();

    // FileWriter to write data to file
    public FileWriter file = new FileWriter("D:/Stephanie Year 1 files/CST1150 - Introduction to Programming/Workspace/JavaProject/src/quiz/view/userdata.txt", true);

    //defines file
    public File ud;

    // Reference to the stage
    private Stage stage;

    // Default Constructor
    public UserData() throws IOException {

    }

    // Set the stage
    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    // Method to check user's result
    private void checkResult() throws IOException {
        file.close();
        //assigns file to a specific file in the specified filepath
        ud = new File("D:/Stephanie Year 1 files/CST1150 - Introduction to Programming/Workspace/JavaProject/src/quiz/view/userdata.txt");
        if (ud.exists()) {
            try {
                int i = 0;
                int index = 0;
                boolean found = false; //to check if user is found (set to false by default)
                Scanner scan = new Scanner(ud);
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    if (line.equalsIgnoreCase(Name.getText())) {
                        found=true; // user is found
                        index = i;
                        i++; //iterates over each line of file (if name found, increments i)
                        UserName.setText(line); //sets name of user
                        nameList.add(UserName.getText()); //adds name to vector
                        if (scan.hasNextLine()) {
                            UserStatus.setText(scan.nextLine()+"/10");//if user has attempted quiz more than once, most recent score is displayed
                            statusList.add(UserStatus.getText()); //adds status to vector
                        }
                        if (scan.hasNextLine()) {
                            UserScore.setText(scan.nextLine()); //if user has attempted quiz more than once, most recent status is displayed
                            scoreList.add(UserScore.getText()); //adds score to vector
                        }
                        break;
                    }
                    if (!found) {
                        //if user has not attempted the quiz, it shows the following data
                        UserName.setText("User Not Found");
                        UserStatus.setText("N/A");
                        UserScore.setText("N/A");
                    }

                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to write user's name to the file
    public void setUserName(String name) throws IOException {
        file.write(name + "\n");
        file.flush();
    }

    // Method to write user's status to the file
    public void setUserStatus(String status) throws IOException {
        file.write(status+"\n");
        file.flush();
    }

    // Method to write user's score to the file
    public void setUserScore(String score) throws IOException {
        file.write(score+"\n");
        file.flush();
    }

    @FXML
    // Method to exit the application
    public void exitApp() {
        exitButton.setOnAction(actionEvent -> {
            try {
                Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                currentStage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
