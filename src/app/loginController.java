package app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    public TextField userNameField;
    public PasswordField passwordField;
    public Button loginButton;
    public Button izhodButton;
    public Label passwordStatusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        passwordStatusLabel.setText("");
    }

    public void loginCB(ActionEvent actionEvent) {
        Main m = new Main();
        KAplikacija controller = new KAplikacija();

        try {
            if (controller.prijavaVSistem(userNameField.getText(), passwordField.getText()) == 1) {
                m.changeScene("afterLogin.fxml");
            } else
                passwordStatusLabel.setText("Uporabniško ime ali geslo je napačno.");
        } catch (Exception e) {
            passwordStatusLabel.setText("Napaka v sistemu");
            System.out.println(e.getMessage());
        }

    }

    public void izhodCB(ActionEvent actionEvent) {
        System.exit(0);
    }
}
