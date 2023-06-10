package ife.mp.lk;

import ife.mp.lk.Level;
import ife.mp.lk.SudokuBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SudokuGameController {

    @FXML
    private Button backButton;

    @FXML
    private void switchToMainMenu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-manu.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private GridPane sudokuBoardGrid;

    private final MessageBox messageBox = new MessageBox();
    private final BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
    private final SudokuBoard sudokuBoard = new SudokuBoard(solver);
    private SudokuBoard sudokuBoardCopy;

    @FXML
    public void initialize() throws CloneNotSupportedException {
        sudokuBoard.solve();
        sudokuBoardCopy = (SudokuBoard) sudokuBoard.clone();
        sudokuBoard.removeFieldsByDifficultyLevel(MainManuController.getLevel());
        fillGrid();
    }

    private void fillGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setMinSize(50, 50);
                textField.setFont(Font.font(18));
                if (sudokuBoard.get(i, j) != 0) {
                    textField.setDisable(true);
                    textField.setText(String.valueOf(sudokuBoard.get(i, j)));
                }
                sudokuBoardGrid.add(textField, i, j);
            }
        }
    }

    @FXML
    public void onActionButtonCheck(ActionEvent actionEvent) {
        // check if everything is filled
        for (Node node: sudokuBoardGrid.getChildren()) {
            if (node instanceof TextField && !node.isDisabled()) {
                if (((TextField) node).getText().isEmpty()) {
                    messageBox.messageBox("", "Fill all fields", Alert.AlertType.ERROR);
                    return;
                }
                int x = GridPane.getColumnIndex(node);
                int y = GridPane.getRowIndex(node);


                sudokuBoard.set(x, y, Integer.parseInt(((TextField) node).getText()));
            }
        }

        if (sudokuBoard.equals(sudokuBoardCopy)) {
            messageBox.messageBox("", "You WON", Alert.AlertType.INFORMATION);
        } else {
            messageBox.messageBox("", "You LOST", Alert.AlertType.INFORMATION);
        }
    }

}