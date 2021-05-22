package app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
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
    private ArrayList<OpisPacienta> pacienti = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lastNameField.setText("");
        emsoField.setText("");
        addressField.setText("");
        placeField.setText("");
        mobileField.setText("");

        for (int i = 0; i < controller.opisPacientov.size(); i++) {
            OpisPacienta pacient = controller.opisPacientov.get(i);
            patientsCombo.getItems().add(pacient.getName() + " " + pacient.getPriimek());
        }


    }

    public void prikaziKartotekoCB(ActionEvent actionEvent) throws Exception {

        try {

            String priimek = patientsCombo.getSelectionModel().getSelectedItem().split(" ")[1];
            OpisPacienta pacient = controller.getPacient(priimek);

            nameField.setText(pacient.getName());
            lastNameField.setText(pacient.getPriimek());
            emsoField.setText(String.valueOf(pacient.getEmso()));
            String[] naslov = pacient.getNaslov().split(",");
            addressField.setText(naslov[0].strip());
            placeField.setText(naslov[1].strip());
            mobileField.setText(String.valueOf(pacient.getTel()));

            System.out.println(controller.opisPacientov.get(0).getPriimek());


            healthArea.setText("test");

            System.out.println(pacient.getIdPacienta());
        } catch (Exception e){
            System.out.println(e);
        }
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
