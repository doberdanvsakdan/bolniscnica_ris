package app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
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

    private final KAplikacija controller = new KAplikacija();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Iterator<OpisPacienta> iter = controller.getIteratorOpisPacienta();
        while (iter.hasNext()) {
            patientsCombo.getItems().add(iter.next().getName());
        }
        patientsCombo.getItems().addAll("Albert", "Bertoncelj", "Ciril");
    }

    public void prikaziKartotekoCB(ActionEvent actionEvent) {
        KartotekaPacienta kart = controller.dostopDoKartoteke(patientsCombo.getSelectionModel().getSelectedItem());
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
