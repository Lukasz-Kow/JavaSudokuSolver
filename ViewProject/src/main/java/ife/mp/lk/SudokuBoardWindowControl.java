package ife.mp.lk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SudokuBoardWindowControl {
    @FXML
    private GridPane sudokuBoardGrid;

    private final MessageBoxWindow messageBoxWindow = new MessageBoxWindow();
    private SudokuBoardsCache cache = new SudokuBoardsCache();

    private SudokuBoard sudokuBoard = cache.get("Solved Sudoku Board");
    private SudokuBoard sudokuBoardCopy;

    @FXML
    public void initialize() throws CloneNotSupportedException {
        sudokuBoardCopy = (SudokuBoard) sudokuBoard.clone();
        sudokuBoard.removeFieldsByDifficultyLevel(SudokuGameController.getLevel());
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
                    messageBoxWindow.messageBox("", "Fill all fields", Alert.AlertType.ERROR);
                    return;
                }
                int x = GridPane.getColumnIndex(node);
                int y = GridPane.getRowIndex(node);


                sudokuBoard.set(x, y, Integer.parseInt(((TextField) node).getText()));
            }
        }

        if (sudokuBoard.equals(sudokuBoardCopy)) {
            messageBoxWindow.messageBox("", "You WON", Alert.AlertType.INFORMATION);
        } else {
            messageBoxWindow.messageBox("", "You LOST", Alert.AlertType.INFORMATION);
        }
    }

}
