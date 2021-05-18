import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
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
        userNameField.getText();
        passwordField.getText();
    }

    public void izhodCB(ActionEvent actionEvent) {
        System.exit(0);
    }
}
