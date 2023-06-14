package ife.mp.lk;

import ife.mp.lk.Level;
import ife.mp.lk.SudokuBoard;
import javafx.beans.binding.Bindings;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
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
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class SudokuGameController {

    @FXML
    private Button backButton;

    public SudokuGameController() throws CloneNotSupportedException {
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) {
        FxmlConst.showStage("main-manu.fxml", ResourceBundle.getBundle("ife.mp.lk.language"));
    }


    @FXML
    private GridPane sudokuBoardGrid;

    private SudokuBoardsCache sudokuBoardsCache = new SudokuBoardsCache();
    private final SudokuBoard sudokuBoard = sudokuBoardsCache.get("Solved Sudoku Board");

    private SudokuBoard sudokuBoardCopy = sudokuBoard.clone();

    @FXML
    public void initialize() throws CloneNotSupportedException, NoSuchMethodException {
        sudokuBoard.removeFieldsByDifficultyLevel(MainManuController.getLevel());
        fillGrid();
    }

    private void fillGrid() throws NoSuchMethodException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setMinSize(50, 50);
                textField.setFont(Font.font(18));
                if (sudokuBoard.get(i, j) != 0) {
                    textField.setDisable(true);
                }

                CustomStringConverter stringConverter = new CustomStringConverter();

                UnaryOperator<TextFormatter.Change> textFilter = c -> {
                    if (c.getText().matches("[1-9]")) {
                        c.setRange(0, textField.getText().length());
                        return c;
                    } else {
                        if (c.getText().isEmpty()) {
                            return c;
                        }
                    }
                    return null;
                };

                TextFormatter<Integer> textFormatter = new TextFormatter<Integer>(stringConverter, 0, textFilter);

                textField.setTextFormatter(textFormatter);

                JavaBeanIntegerProperty integerProperty =
                        JavaBeanIntegerPropertyBuilder
                                .create()
                                .bean(sudokuBoard.getField(i, j))
                                .name("value")
                                .getter("getFieldValue")
                                .setter("setValue")
                                .build();

                textField.setText(String.valueOf(sudokuBoard.get(i,j)));
                Bindings.bindBidirectional(textField.textProperty(), integerProperty, new NumberStringConverter());
                sudokuBoardGrid.add(textField, j, i);
            }
        }
    }

    @FXML
    public void saveSudoku(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Sudoku");
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                try (FileSudokuBoardDao<SudokuBoard> fileSudokuBoardDao =
                             new FileSudokuBoardDao<>(file.getAbsolutePath())) {
                    fileSudokuBoardDao.write(sudokuBoardCopy);
                }
            }
            System.out.println("Sudoku saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadSudoku(ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Sudoku");
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                try (FileSudokuBoardDao<SudokuBoard> fileSudokuBoardDao =
                             new FileSudokuBoardDao<>(file.getAbsolutePath())) {
                    sudokuBoardCopy = fileSudokuBoardDao.read();
                    updateBoard();
                }
            }
            System.out.println("Sudoku loaded");
        } catch (IOException e) {
            System.out.println("Couldn't load file from board");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("SudokuBoard file is invalid");
            e.printStackTrace();
        }

    }

    private void updateBoard() {
        int counter = 0;
        for (Node node : sudokuBoardGrid.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;
                textField.setText(String.valueOf(sudokuBoardCopy.get(counter / 9, counter % 9)));
                counter++;
            }
        }
    }

}