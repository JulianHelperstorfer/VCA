package at.vca.controller;

import at.vca.model.helper.ComponentManagement;
import at.vca.model.parts.Component;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
    private Button btn_continue;

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
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Initializing choice boxes...");

        //cases
        System.out.println("[Log] Loading cases...");
        cbb_case.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCases()));
        System.out.println("[Log] Finished loading cases!");

        //mainboards
        System.out.println("[Log] Loading mainboards...");
        cbb_mainboard.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getMotherboards()));
        System.out.println("[Log] Finished loading mainboards!");

        //cpus
        System.out.println("[Log] Loading CPUs...");
        cbb_cpu.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCpus()));
        System.out.println("[Log] Finished loading CPUs!");

        //cpu coolers
        System.out.println("[Log] Loading CPU-coolers...");
        cbb_cpucooler.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCpuCoolers()));
        System.out.println("[Log] Finished loading CPU-coolers!");

        //ram
        System.out.println("[Log] Loading RAM...");
        cbb_ram.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getRams()));
        System.out.println("[Log] Finished loading RAMs!");

        //gpu
        System.out.println("[Log] Loading GPUs...");
        cbb_gpu.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getGpus()));
        System.out.println("[Log] Finished loading GPUs!");

        //storage
        System.out.println("[Log] Loading storages...");
        cbb_storage.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getStorages()));
        System.out.println("[Log] Finished loading storages!");

        //case fans
        System.out.println("[Log] Loading case fans...");
        cbb_fan.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getCaseFans()));
        System.out.println("[Log] Finished loading case fans!");

        //power supply
        System.out.println("[Log] Loading power supplies...");
        cbb_psupply.getItems().addAll(FXCollections.observableArrayList(ComponentManagement.getPowerSupplies()));
        System.out.println("[Log] Finished loading power supplies!");

        System.out.println("[Log] Initializing bindings...");
        BooleanBinding disablePSupplyBox =
                cbb_mainboard.valueProperty().isNotNull()
                        .and(cbb_cpu.valueProperty().isNotNull())
                        .and(cbb_cpucooler.valueProperty().isNotNull())
                        .and(cbb_gpu.valueProperty().isNotNull())
                        .and(cbb_ram.valueProperty().isNotNull())
                        .and(cbb_storage.valueProperty().isNotNull())
                        .and(cbb_fan.valueProperty().isNotNull());
        cbb_mainboard.disableProperty().bind(cbb_case.valueProperty().isNull());
        cbb_cpu.disableProperty().bind(cbb_mainboard.valueProperty().isNull());
        cbb_cpucooler.disableProperty().bind(cbb_cpu.valueProperty().isNull());
        cbb_gpu.disableProperty().bind(cbb_mainboard.valueProperty().isNull());
        cbb_ram.disableProperty().bind(cbb_mainboard.valueProperty().isNull());
        cbb_storage.disableProperty().bind(cbb_mainboard.valueProperty().isNull());
        cbb_fan.disableProperty().bind(cbb_mainboard.valueProperty().isNull());
// you can choose the power supply, if all the other boxes have a value
        cbb_psupply.disableProperty().bind(disablePSupplyBox.not());
        btn_continue.disableProperty().bind(cbb_psupply.valueProperty().isNull());
        System.out.println("[Log] Finished initializing bindings!");

        System.out.println("[Log] Finished initializing choice boxes!");
        System.out.println("--------------------------------------------------");
    }
}
