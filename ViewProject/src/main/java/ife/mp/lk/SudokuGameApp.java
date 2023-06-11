package ife.mp.lk;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;


public class SudokuGameApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(new Locale("en"));

        FxmlConst.setStage(stage);
        FxmlConst.showStage("main-manu.fxml", resourceBundle);    }

    public static void main(String[] args) {
        launch();
    }

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("ife.mp.lk.language");
    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }


}