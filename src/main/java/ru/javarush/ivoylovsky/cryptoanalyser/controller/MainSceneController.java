package ru.javarush.ivoylovsky.cryptoanalyser.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import ru.javarush.ivoylovsky.cryptoanalyser.action.BruteForce;
import ru.javarush.ivoylovsky.cryptoanalyser.action.Decrypt;
import ru.javarush.ivoylovsky.cryptoanalyser.action.Encrypt;

import java.io.File;


public class MainSceneController {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField keyField;
    @FXML
    private TextField pathToFileEncrypt;
    @FXML
    private TextField pathToFileDecrypt;

    private final FileChooser fileChooser = new FileChooser();
    private File fileEncrypt;
    private File fileDecrypt;

    @FXML
    public void clickEncrypt() {
        String encryptedResult
                = Encrypt.encryptString(textArea.getText(), getKey());
        textArea.setText(encryptedResult);
    }

    @FXML
    public void clickDecrypt() {
        String decryptedResult =
                Decrypt.decryptString(textArea.getText(), getKey());
        textArea.setText(decryptedResult);
    }

    @FXML
    public void upKey() {
        keyField.setText(String.valueOf(getKey() + 1));
    }

    @FXML
    public void downKey() {
        int key = getKey() - 1;
        if (key < 0) {
            keyField.setText("0");
            new Alert(Alert.AlertType.WARNING, "Значение ключа не может быть отрицательным").showAndWait();
        } else {
            keyField.setText(String.valueOf(key));
        }
    }

    @FXML
    public void selectPathToFileEncrypt() {
        fileChooser.setTitle("Выберите файл для шифровки");
        fileChooser.setInitialFileName("*.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text", "*.txt"));
        fileEncrypt = fileChooser.showOpenDialog(textArea.getScene().getWindow());

        if (fileEncrypt != null) {
            pathToFileEncrypt.setText(fileEncrypt.getPath());
        }
    }

    @FXML
    public void selectPathToFileDecrypt() {
        fileChooser.setTitle("Выберите файл для расшифровки");
        fileChooser.setInitialFileName("*.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text", "*.txt"));
        fileDecrypt = fileChooser.showOpenDialog(textArea.getScene().getWindow());

        if (fileDecrypt != null) {
            pathToFileDecrypt.setText(fileDecrypt.getPath());
        }
    }

    @FXML
    public void encryptFile() {
        Encrypt.encryptFile(fileEncrypt, getKey());
        new Alert(
                Alert.AlertType.INFORMATION,
                "Файл зашифрован, сохраните ключ для дальнейшей расшифровки. Файл: " + fileEncrypt.getParent() + "\\encrypted.txt").showAndWait();
    }

    @FXML
    public void decryptFile() {
        Decrypt.decryptFile(fileDecrypt, getKey());
        new Alert(
                Alert.AlertType.INFORMATION,
                "Файл расшифрован. Файл: " + fileDecrypt.getParent() + "\\decrypted.txt").showAndWait();
    }

    @FXML
    public void clickBruteforce() {
        String decrypt = BruteForce.decrypt(textArea.getText());
        textArea.setText(decrypt);
    }

    public int getKey() {
        try {
            return Integer.parseInt(keyField.getText());
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Введите валидное значение ключа").showAndWait();
        }
        return 0;
    }
}
