package at.vca.controller;

import at.vca.model.helper.ComponentManagement;
import at.vca.model.parts.Component;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
import java.util.Arrays;
import java.util.Collection;

public class BuildAPcController {

    public static ArrayList<Component> builtPC;
    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

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
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Cancelling configuration...");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/homepage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Homepage");
            stage.setScene(new Scene(root, 630, 380));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            System.out.println("[Log] Finished cancelling configuration!");
            System.out.println("--------------------------------------------------");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onContinueButtonClick(ActionEvent event) {
        Component pcCase = cbb_case.getValue();
        Component mainboard = cbb_mainboard.getValue();
        Component cpu = cbb_cpu.getValue();
        Component cpuCooler = cbb_cpucooler.getValue();
        Component gpu = cbb_gpu.getValue();
        Component ram = cbb_ram.getValue();
        Component storage = cbb_storage.getValue();
        Component pSupply = cbb_psupply.getValue();
        Component fan = cbb_fan.getValue();
        builtPC = new ArrayList<>(Arrays.asList(pcCase, mainboard, cpu, cpuCooler, gpu, ram, storage, pSupply, fan));
        try {
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            scene = stage.getScene();
            stage.setWidth(870);
            fxmlLoader = new FXMLLoader(getClass().getResource("../view/showPrice.fxml"));
            root = (Parent) fxmlLoader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
