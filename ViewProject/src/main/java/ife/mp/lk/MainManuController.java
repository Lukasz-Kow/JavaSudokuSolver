package ife.mp.lk;

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

public class MainManuController {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
    SudokuBoard sudokuBoard = new SudokuBoard(solver);
    private final MessageBox messageBox = new MessageBox();

    @FXML
    private Label difficultyLevel;
    @FXML
    private Label welcomeText;

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
                fxmlPath = "board_view.fxml";
                //sudokuBoard.removeFieldsByDifficultyLevel(Level.EASY);
            } else if (buttonText.equals("Medium")) {
                fxmlPath = "board_view.fxml";
                //sudokuBoard.removeFieldsByDifficultyLevel(Level.MEDIUM);
            } else if (buttonText.equals("Hard")) {
                fxmlPath = "board_view.fxml";
                //sudokuBoard.removeFieldsByDifficultyLevel(Level.HARD);
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



}
