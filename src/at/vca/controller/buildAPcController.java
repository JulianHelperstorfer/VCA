package at.vca.controller;

import at.vca.model.helper.ComponentManagement;
import at.vca.model.parts.Component;
import javafx.collections.FXCollections;
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
    private ChoiceBox<Component> cbb_case;

    @FXML
    private ChoiceBox<Component> cbb_mainboard;

    @FXML
    private ChoiceBox<Component> cbb_cpu;

    @FXML
    private ChoiceBox<Component> cbb_cpucooler;

    @FXML
    private ChoiceBox<Component> cbb_gpu;

    @FXML
    private ChoiceBox<Component> cbb_ram;

    @FXML
    private ChoiceBox<Component> cbb_storage;

    @FXML
    private ChoiceBox<Component> cbb_psupply;

    @FXML
    private ChoiceBox<Component> cbb_fan;

    @FXML
    void onCancelButtonClick(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/homepage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Homepage");
            stage.setScene(new Scene(root, 630, 380));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onContinueButtonClick() {

    }

    @FXML public void initialize(){
        System.out.println("Initializing choice boxes...");

        //cases
        System.out.println("Loading cases...");
        cbb_case.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCases()));
        System.out.println("Finished loading cases!");

        //mainboards
        System.out.println("Loading mainboards...");
        cbb_mainboard.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getMotherboards()));
        System.out.println("Finished loading mainboards!");

        //cpus
        System.out.println("Loading CPUs...");
        cbb_cpu.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCpus()));
        System.out.println("Finished loading CPUs!");

        //cpu coolers
        System.out.println("Loading CPU-coolers...");
        cbb_cpucooler.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCpuCoolers()));
        System.out.println("Finished loading CPU-coolers!");

        //ram
        System.out.println("Loading RAM...");
        cbb_ram.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getRams()));
        System.out.println("Finished loading RAMs!");

        //gpu
        System.out.println("Loading GPUs...");
        cbb_gpu.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getGpus()));
        System.out.println("Finished loading GPUs!");

        //storage
        System.out.println("Loading storages...");
        cbb_storage.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getStorages()));
        System.out.println("Finished loading storages!");

        //case fans
        System.out.println("Loading case fans...");
        cbb_fan.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCaseFans()));
        System.out.println("Finished loading case fans!");

        //power supply
        System.out.println("Loading power supplies...");
        cbb_psupply.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getPowerSupplies()));
        System.out.println("Finished loading power supplies!");

        System.out.println("Finished initializing choice boxes!");
    }

}
