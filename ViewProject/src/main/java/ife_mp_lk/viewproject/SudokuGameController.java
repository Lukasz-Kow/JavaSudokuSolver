package ife_mp_lk.viewproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SudokuGameController {

    @FXML
    private Label difficultyLevel;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void difficultyLevelClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        // Perform action based on the pressed button
        if (buttonText.equals("Easy")) {
            welcomeText.setText("ez");
            switchToGameView(event);
        } else if (buttonText.equals("Medium")) {
            welcomeText.setText("med");
            switchToGameView(event);
        } else if (buttonText.equals("Hard")) {
            welcomeText.setText("hard");
            switchToGameView(event);
        }
    }

    @FXML
    public void switchToGameView(ActionEvent event) {
        try {
            // Load scene2.fxml
            Parent scene2Root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-view.fxml")));

            // Create a new scene with scene2Root
            Scene scene2 = new Scene(scene2Root);

            // Get the current stage (window)
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Set the new scene on the current stage
            currentStage.setScene(scene2);
            currentStage.show();

            difficultyLevel.setText("Dupcia");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}