package ife.mp.lk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainManuController implements Initializable {

    BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
    SudokuBoard sudokuBoard = new SudokuBoard(solver);

    @FXML
    private ComboBox<String> language;
    private ResourceBundle chosenBundle;

    @FXML
    private Label author = new Label();

    private static Level level;

    public static Level getLevel() {
        return level;
    }

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
            switchToGameView(event);
        } else if (buttonText.equals("Medium")) {
            switchToGameView(event);
        } else if (buttonText.equals("Hard")) {
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
                level = Level.EASY;
                fxmlPath = "board_view.fxml";
            } else if (buttonText.equals("Medium")) {
                level = Level.MEDIUM;
                fxmlPath = "board_view.fxml";
            } else if (buttonText.equals("Hard")) {
                level = Level.HARD;
                fxmlPath = "board_view.fxml";
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chosenBundle = resourceBundle;

        language.getItems().addAll(chosenBundle.getString("English"), chosenBundle.getString("Polish"));

        ListResourceBundle authorBundle = (ListResourceBundle) ResourceBundle.getBundle("ife.mp.lk.AuthorsSet");
        author.setText(authorBundle.toString());
    }

    @FXML void getChosenLanguage() {
        Locale locale = new Locale("en");
        String choice = language.getValue();

        switch (choice) {
            case "English", "Angielski" -> locale = new Locale("en");
            case "Polish", "Polski" -> locale = new Locale("pl");
            default -> { }
        }
        Locale.setDefault(locale);
        chosenBundle = ResourceBundle.getBundle("ife.mp.lk.language");

        ListResourceBundle authorBundle = (ListResourceBundle) ResourceBundle
                .getBundle("ife.mp.lk.AuthorsSet", locale);

        FxmlConst.showStage("main-manu.fxml", chosenBundle);
        author.setText(authorBundle.toString());
    }

}
