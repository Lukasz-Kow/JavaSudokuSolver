package ife.mp.lk;

import javafx.beans.binding.Bindings;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
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

    private SudokuBoard sudokuBoard = sudokuBoardsCache.get("Solved Sudoku Board");

    private SudokuBoardWithProgress sudokuBoardDecorated;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("language");

    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);


    @FXML
    public void initialize() throws CloneNotSupportedException, NoSuchMethodException {
        sudokuBoard.removeFieldsByDifficultyLevel(MainManuController.getLevel());
        sudokuBoardDecorated = new SudokuBoardWithProgress(sudokuBoard);
        fillGrid();
    }

    private void fillGrid() throws NoSuchMethodException {
        sudokuBoardDecorated.printBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setMinSize(50, 50);
                textField.setFont(Font.font(18));

                if (sudokuBoardDecorated.getAccess(i, j)) {
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
                                .bean(sudokuBoardDecorated.getField(i, j))
                                .name("value")
                                .getter("getFieldValue")
                                .setter("setValue")
                                .build();

                textField.setText(String.valueOf(sudokuBoardDecorated.get(i,j)));
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
                sudokuBoardDecorated.printBoard();
                try (FileSudokuBoardDao<SudokuBoardWithProgress> fileSudokuBoardDao =
                             new FileSudokuBoardDao<>(file.getAbsolutePath())) {
                    fileSudokuBoardDao.write(sudokuBoardDecorated);
                }
            }
            logger.info(resourceBundle.getString("SudokuSaved"));
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
                try (FileSudokuBoardDao<SudokuBoardWithProgress> fileSudokuBoardDao =
                             new FileSudokuBoardDao<>(file.getAbsolutePath())) {
                    sudokuBoardDecorated = fileSudokuBoardDao.read();
                    sudokuBoardDecorated.printBoard();
                    updateBoard();
                }
            }
            logger.info(resourceBundle.getString("SudokuLoaded"));
        } catch (IOException e) {
            logger.error("Error: ", e);
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            logger.error("Error: ", ex);
            ex.printStackTrace();
        }

    }

    private void updateBoard() {
        int counter = 0;
        for (Node node : sudokuBoardGrid.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;
                textField.setText(String.valueOf(sudokuBoardDecorated.get(counter / 9, counter % 9)));
                if (sudokuBoardDecorated.get(counter / 9, counter % 9) == 0) {
                    textField.setText("");
                }
                if (sudokuBoardDecorated.getAccess(counter / 9, counter % 9)) {
                    textField.setDisable(true);
                } else {
                    textField.setDisable(false);
                }
                counter++;
            }
        }
    }

}