package ife.mp.lk;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class FxmlConst {
    private static Stage stage;

    public static void setStage(Stage stage) {
        FxmlConst.stage = stage;
    }

    private static Parent loadFxml(String fxml) throws IOException {
        return new FXMLLoader(FxmlConst.class.getResource(fxml)).load();
    }

    public static void showStage(String filePath, ResourceBundle resourceBundle) {
        try {
            stage.setScene(new Scene(
                    new FXMLLoader(FxmlConst.class.getResource(filePath), resourceBundle).load()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.sizeToScene();
        stage.show();
    }

    public static void buildStage(Stage stage, String filePath, String title) throws IOException {
        setStage(stage);
        stage.setScene(new Scene(loadFxml(filePath)));
        stage.setTitle(title);
        stage.sizeToScene();
        stage.show();
    }
}