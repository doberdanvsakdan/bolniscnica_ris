package app;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

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
    public TextArea drugsArea;
    public Button odpustiBttn;
    public TextField idField;
    public Label statusLabel;
    private Terapija terapija;
    private OpisPacienta pacient;
    private KAplikacija controller;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new KAplikacija();

        for (int i = 0; i < controller.opisPacientov.size(); i++) {
            OpisPacienta pacient = controller.opisPacientov.get(i);
            patientsCombo.getItems().add(pacient.getName() + " " + pacient.getPriimek());
        }
    }


    public void prikaziKartotekoCB(ActionEvent actionEvent) throws Exception {
        if (patientsCombo.getSelectionModel().getSelectedItem() != null) {
            String priimek = patientsCombo.getSelectionModel().getSelectedItem().split(" ")[1];
            Object[] arr = controller.dostopDoKartoteke(priimek);
            try {
                pacient = (OpisPacienta) arr[0];

                nameField.setText(pacient.getName());
                nameField.setEditable(true);
                lastNameField.setText(pacient.getPriimek());
                lastNameField.setEditable(true);
                emsoField.setText(String.valueOf(pacient.getEmso()));
                emsoField.setEditable(true);
                String[] naslov = pacient.getNaslov().split(",");
                addressField.setText(naslov[0].strip());
                addressField.setEditable(true);
                placeField.setText(naslov[1].strip());
                placeField.setEditable(true);
                mobileField.setText(String.valueOf(pacient.getTel()));
                mobileField.setEditable(true);

                terapija = (Terapija) arr[1];

                healthArea.setText(terapija.getOpisTezave());
                drugsArea.setText(terapija.getPredpisanoZdravljenje());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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

    public void vnosTerapijeZOdpustnicoCB(ActionEvent actionEvent) throws Exception {
        saveCB(new ActionEvent());

        if(idField.getText().equals("")) {
            statusLabel.setTextFill(Color.web("#ff0000"));
            statusLabel.setText("Vpiši ID specialista");
            return;
        }
        int stikalo = controller.vnosTerapijeZOdpustnico(pacient, Integer.parseInt(idField.getText()));
        switch (stikalo) {
            case 2 -> statusLabel.setText("Napaka v naročilu čiščenja");
            case 1 -> statusLabel.setText("Napaka v izdaji računa");
            case 0 -> {
                statusLabel.setTextFill(Color.web("#4ec1b5"));
                statusLabel.setText("Račun izdan");
            }
        }

    }

    public void exitCB(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void saveCB(ActionEvent actionEvent) throws Exception {
        try {
            pacient.setName(nameField.getText());
            pacient.setPriimek(lastNameField.getText());
            pacient.setEmso(emsoField.getText());
            pacient.setTel(mobileField.getText());
            pacient.setNaslov(addressField.getText(), placeField.getText());

            terapija.setOpisTezave(healthArea.getText());
            terapija.setPredpisanoZdravljenje(drugsArea.getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void helpCB(ActionEvent actionEvent) {
        statusLabel.setTextFill(Color.web("#4ec1b5"));
        statusLabel.setText("Ni jim pomoči");
    }
}
