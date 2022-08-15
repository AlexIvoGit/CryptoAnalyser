import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("scene/MainScene.fxml")));
            Parent root = loader.load();
            stage.setTitle("CryptoAnalyser");
            Scene scene = new Scene(root, 1024, 768);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Ошибка при загрузке главного окна: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}