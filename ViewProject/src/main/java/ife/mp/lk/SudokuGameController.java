package ife.mp.lk;

import ife.mp.lk.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private static Level level;

    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        if (backButton != null) {
            backButton.setOnAction(this::switchToMainMenu);
        }
    }

    @FXML
    private void chooseDifficultyLevel(ActionEvent event) {
        try {
            Button button = (Button) event.getSource();

            if (Objects.equals(button.getText(), "Easy")) {
                level = Level.EASY;
            } else if (Objects.equals(button.getText(), "Medium")) {
                level = Level.MEDIUM;
            } else if (Objects.equals(button.getText(), "Hard")) {
                level = Level.HARD;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Level getLevel() {
        return level;
    }

}