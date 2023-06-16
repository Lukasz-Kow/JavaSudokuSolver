package ife.mp.lk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Locale;
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
    protected void difficultyLevelClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        ResourceBundle targetBundle = SudokuGameApp.getResourceBundle();

        String key = getBundleKey(targetBundle, buttonText);

        //System.out.println("Key: " + key);
        chosenBundle.getString("Easy");

        // Perform action based on the pressed button
        if (key != null) {
            switch (key) {
                case "Medium" -> {
                    level = Level.MEDIUM;
                    switchToGameView(event);
                }
                case "Hard" -> {
                    level = Level.HARD;
                    switchToGameView(event);
                }
                default -> {
                    level = Level.EASY;
                    switchToGameView(event);
                }
            }
        } else {
            // If an error occurs set default difficulty level Easy
            level = Level.EASY;
            switchToGameView(event);
        }
    }

    private static String getBundleKey(ResourceBundle bundle, String translatedText) {
        Enumeration<String> keys = bundle.getKeys();

        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = bundle.getString(key);

            if (value.equals(translatedText)) {
                return key;
            }
        }

        return null;
    }

    @FXML
    public void switchToGameView(ActionEvent event) {

            Button button = (Button) event.getSource();
            String buttonText = button.getText();

            String fxmlPath = "board_view.fxml";

            FxmlConst.showStage(fxmlPath, chosenBundle);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chosenBundle = resourceBundle;

        language.getItems().addAll(chosenBundle.getString("English"), chosenBundle.getString("Polish"));

        ListResourceBundle authorBundle = (ListResourceBundle) ResourceBundle.getBundle("ife.mp.lk.AuthorsSet",
                Locale.getDefault());
        author.setText(authorBundle.toString());
    }

    @FXML void getChosenLanguage() {
        Locale locale = null;
        String choice = language.getValue();

        switch (choice) {
            case "English", "Angielski" -> locale = Locale.ENGLISH;
            case "Polish", "Polski" -> locale = Locale.of("pl", "PL");
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
