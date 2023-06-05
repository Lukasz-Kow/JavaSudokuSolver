package ife_mp_lk.viewproject;

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
            Button button = (Button) event.getSource();
            String buttonText = button.getText();

            String fxmlPath = "";
            if (buttonText.equals("Easy")) {
                fxmlPath = "easy-view.fxml";
            } else if (buttonText.equals("Medium")) {
                fxmlPath = "medium-view.fxml";
            } else if (buttonText.equals("Hard")) {
                fxmlPath = "hard-view.fxml";
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

            difficultyLevel.setText(buttonText);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button backButton;

    @FXML
    private void initialize() {
        if (backButton != null) {
            backButton.setOnAction(this::switchToMainMenu);
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

}