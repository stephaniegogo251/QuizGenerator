package quiz.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import quiz.QuizGen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

public class ScoreBoardController implements Initializable {

    // JavaFX ListView elements defined in FXML
    @FXML
    private ListView myListView1;

    @FXML
    private ListView myListView2;

    @FXML
    private ListView myListView3;

    @FXML
    public Button exitBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Reads user data from file
            BufferedReader reader = new BufferedReader(new FileReader("D:/Stephanie Year 1 files/CST1150 - Introduction to Programming/Workspace/JavaProject/src/quiz/view/userdata.txt"));
            String line;

            //Defines 3 vectors to store user's name, status and score
            Vector<String> status = new Vector<>();
            Vector<String> name = new Vector<>();
            Vector<String> score = new Vector<>();

            // Checks user data and adds name, status and score to their respective vectors
            while ((line = reader.readLine()) != null) {
                if ((line.equals("PASS")) || (line.equals("FAIL"))) {
                    status.add(line);
                } else if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4") || line.equals("5") || line.equals("6") || line.equals("7") || line.equals("8") || line.equals("9") || line.equals("10") || line.equals("0")){
                    score.add(line);
                } else {
                    name.add(line);
                }
            }
            reader.close(); //closes reader file to not lose any data

            // Sorts user data by score
            int index = 0;
            for (int j = 0; j < score.size() - 1; j++){
                for (int i = 0; i < score.size() - 1; i++){
                    if (Integer.parseInt(score.get(i)) > Integer.parseInt(score.get(i+1))) {
                        index=i;
                    }
                    else {
                        index=i+1;
                    }
                    // Swap name to maintain sorted order
                    String replaceName = name.get(i);
                    name.set(i,name.get(index));
                    name.set(index,replaceName);

                    // Swap status to maintain sorted oder
                    String replaceStatus = status.get(i);
                    status.set(i,status.get(index));
                    status.set(index,replaceStatus);

                    // Swap score to maintain sorted order
                    String replaceScore = score.get(i);
                    score.set(i,score.get(index));
                    score.set(index,replaceScore);

                }
            }
            // Displays sorted user data in each list view
            myListView1.getItems().addAll(name);
            myListView2.getItems().addAll(status);
            myListView3.getItems().addAll(score);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    // Action when exit button is clicked
    public void setExitButton(ActionEvent actionEvent) {
        try {
            // Close the current stage
            Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}