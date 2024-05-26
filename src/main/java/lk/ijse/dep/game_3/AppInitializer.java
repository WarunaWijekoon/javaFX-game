package lk.ijse.dep.game_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/MainView.fxml")));

        Scene scene =new Scene(anchorPane);

        primaryStage.setTitle("Game - 3");
        primaryStage.centerOnScreen();

        primaryStage.setFullScreen(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
