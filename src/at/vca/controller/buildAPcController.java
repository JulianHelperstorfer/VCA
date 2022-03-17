package at.vca.controller;

import at.vca.model.parts.Case;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Baran Imre 17.03.2022
 * onCancelButtonClick
 * Startseite Scene wird geöffnet
 * buildAPc Scene wird geschlossen
 */

public class buildAPcController {

    @FXML
    private ChoiceBox<?> cbb_case;

    @FXML
    private ChoiceBox<?> cbb_mainboard;

    @FXML
    private ChoiceBox<?> cbb_cpu;

    @FXML
    private ChoiceBox<?> cbb_cpucooler;

    @FXML
    private ChoiceBox<?> cbb_gpu;

    @FXML
    private ChoiceBox<?> cbb_ram;

    @FXML
    private ChoiceBox<?> cbb_storage;

    @FXML
    private ChoiceBox<?> cbb_psupply;

    @FXML
    private ChoiceBox<?> cbb_fan;

    @FXML
    void onCancelButtonClick(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/homepage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Homepage");
            stage.setScene(new Scene(root, 630, 380));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onSaveButtonClick() {

    }

    @FXML public void initialize(){
    }

}
