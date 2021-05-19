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
        Ldap ldap = new Ldap();

        try {
            System.out.println(userNameField.getText() + "; " + passwordField.getText());
            if (ldap.zahtevaZaAvtentikacijo(userNameField.getText(), passwordField.getText()) == 1) {
                System.out.println("Prijava uspešna");
                m.changeScene("afterLogin.fmxl");
            } else
                passwordStatusLabel.setText("Uporabniško ime ali geslo je napačno.");
        } catch (Exception e) {
            passwordStatusLabel.setText("Napaka v sistemu");
        }

    }

    public void izhodCB(ActionEvent actionEvent) {
        System.exit(0);
    }
}
