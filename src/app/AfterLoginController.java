package app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfterLoginController implements Initializable {
    public ComboBox<String> patientsCombo;
    public Button showBttn;
    public TextField nameField;
    public TextField lastNameField;
    public Button logoutBttn;
    public TextField emsoField;
    public TextField addressField;
    public TextField placeField;
    public TextField mobileField;
    public TextArea healthArea;
    public Button saveBttn;
    public MenuItem saveCB;
    public MenuItem logoutCB;
    public MenuItem exitCB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //patientsCombo.getItems().addAll();
    }

    public void prikaziKartotekoCB(ActionEvent actionEvent) {
        KAplikacija controller = new KAplikacija();
        controller.dostopDoKartoteke(patientsCombo.getSelectionModel().getSelectedItem());
    }

    public void logoutCB(ActionEvent actionEvent) throws IOException {
        Main m = new Main();
        try {
            m.changeScene("loginUI.fxml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void vnosTerapijeZOdpustnico(ActionEvent actionEvent) {
    }

    public void exitCB(ActionEvent actionEvent) {
        System.exit(0);
    }
}
