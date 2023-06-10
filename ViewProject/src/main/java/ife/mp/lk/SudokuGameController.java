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
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.util.Objects;
import java.util.function.UnaryOperator;

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

    private SudokuBoardsCache sudokuBoardsCache = new SudokuBoardsCache();
    private final SudokuBoard sudokuBoard = sudokuBoardsCache.get("Solved Sudoku Board");

    @FXML
    public void initialize() throws CloneNotSupportedException, NoSuchMethodException {
        System.out.println(MainManuController.getLevel());
        sudokuBoard.removeFieldsByDifficultyLevel(MainManuController.getLevel());
        sudokuBoard.printBoard();
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

}