import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    // Add VM options "--module-path /Users/teo/Documents/FRI/2_letnik/UV/javafx-sdk-16/lib --add-modules javafx.controls,javafx.fxml,javafx.web"

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginUI.fxml"));
        primaryStage.setTitle("Bolnišnica");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
