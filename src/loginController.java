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

        /*
        try {
            if (Ldap.zahtevaZaAvtentikacijo(userNameField.getText(), passwordField.getText()) == 1) {
                //TODO: Implement
                m.changeScene("afterLogin.fmxl");
            } else
                passwordStatusLabel.setText("Uporabniško ime ali geslo je napačno.");
        } catch (Exception e) {
            passwordStatusLabel.setText("Napaka v sistemu");
        }
        */
        passwordStatusLabel.setText("Uporabniško ime ali geslo je napačno.");

    }

    public void izhodCB(ActionEvent actionEvent) {
        System.exit(0);
    }
}
