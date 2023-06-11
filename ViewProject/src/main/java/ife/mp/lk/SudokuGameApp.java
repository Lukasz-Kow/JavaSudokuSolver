package ife.mp.lk;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;


public class SudokuGameApp extends Application {

    private static ResourceBundle resourceBundle;

    @Override
    public void start(Stage stage) throws IOException {

        Locale.setDefault(Locale.ENGLISH);

        resourceBundle = ResourceBundle.getBundle("ife.mp.lk.language");

        FxmlConst.setStage(stage);
        FxmlConst.showStage("main-manu.fxml", resourceBundle);
    }

    public static void main(String[] args) {
        launch();
    }

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }


}