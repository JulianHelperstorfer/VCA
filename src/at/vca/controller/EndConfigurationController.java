package at.vca.controller;

import at.vca.model.parts.Component;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EndConfigurationController {

    @FXML
    private Label lbl_caseName;

    @FXML
    private Label lbl_mbName;

    @FXML
    private Label lbl_cpuName;

    @FXML
    private Label lbl_cpuCoolerName;

    @FXML
    private Label lbl_gpuName;

    @FXML
    private Label lbl_ramName;

    @FXML
    private Label lbl_ramPrice;

    @FXML
    private Label lbl_storageName;

    @FXML
    private Label lbl_psName;

    @FXML
    private Label lbl_fanName;

    @FXML
    private Label lbl_casePrice;

    @FXML
    private Label lbl_mbPrice;

    @FXML
    private Label lbl_cpuPrice;

    @FXML
    private Label lbl_cpuCoolerPrice;

    @FXML
    private Label lbl_gpuPrice;

    @FXML
    private Label lbl_storagePrice;

    @FXML
    private Label lbl_psPrice;

    @FXML
    private Label lbl_fanPrice;

    @FXML
    private Label lbl_totalPrice;

    ArrayList<Component> pc  = new ArrayList<>();

    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;


    @FXML public void initialize(){
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Initializing end configuration controller...");

        pc.addAll(BuildAPcController.builtPC);
        lbl_caseName.setText(pc.get(0).getName());
        lbl_casePrice.setText(pc.get(0).getPrice() +" €");
        lbl_mbName.setText(pc.get(1).getName());
        lbl_mbPrice.setText(pc.get(1).getPrice() +" €");
        lbl_cpuName.setText(pc.get(2).getName());
        lbl_cpuPrice.setText(pc.get(2).getPrice() +" €");
        lbl_cpuCoolerName.setText(pc.get(3).getName());
        lbl_cpuCoolerPrice.setText(pc.get(3).getPrice() +" €");
        lbl_gpuName.setText(pc.get(4).getName());
        lbl_gpuPrice.setText(pc.get(4).getPrice() +" €");
        lbl_ramName.setText(pc.get(5).getName());
        lbl_ramPrice.setText(pc.get(5).getPrice() +" €");
        lbl_storageName.setText(pc.get(6).getName());
        lbl_storagePrice.setText(pc.get(6).getPrice() +" €");
        lbl_psName.setText(pc.get(7).getName());
        lbl_psPrice.setText(pc.get(7).getPrice() +" €");
        lbl_fanName.setText(pc.get(8).getName());
        lbl_fanPrice.setText(pc.get(8).getPrice() +" €");

        double sum = 0;
        for (Component c: pc) {
            sum += c.getPrice();
        }

        sum =Math.round((sum*100.0)/100.0);

        lbl_totalPrice.setText(String.valueOf(sum + " €"));

        System.out.println("[Log] Finished initializing end configuration controller!");
        System.out.println("--------------------------------------------------");
    }


    @FXML
    void onBackButtonClick(ActionEvent event) {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Switching back to configuration window...");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/buildAPc.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Build A PC");
            stage.setScene(new Scene(root, 420, 520));
            stage.setResizable(false);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            System.out.println("[Log] Finished switching back to configuration window!");
            System.out.println("--------------------------------------------------");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}