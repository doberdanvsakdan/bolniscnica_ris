package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    // Add VM options "--module-path /Users/teo/Documents/FRI/2_letnik/RIS/bolniscnica_ris/src/data/javafx-sdk-16/lib --add-modules javafx.controls,javafx.fxml,javafx.web"
    private static Stage stg;
    private static Scene loginScn, afterLoginScn;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        stg.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginUI.fxml")));
        stg.setTitle("Bolnišnica Boleče nogice");
        stg.setScene(new Scene(root, 600, 480));
        stg.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
        stg.setTitle("Bolnišnica Boleče nogice");
        stg.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
