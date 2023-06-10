package ife.mp.lk;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class SudokuGameApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FxmlSetup.buildStage(stage, "hello-view.fxml", "Sudoku Game");
    }

    public static void main(String[] args) {
        launch();
    }
}