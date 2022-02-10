package at.vca.controller;
/**
 * Sample Skeleton for 'homepage.fxml' Controller Class
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class homepageController {

    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    //defining the Variables here.
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button_signIn"
    private Button button_signIn; // Value injected by FXMLLoader

    @FXML // fx:id="button_createAccount"
    private Button button_createAccount; // Value injected by FXMLLoader

    @FXML // fx:id="label_heading"
    private Label label_heading; // Value injected by FXMLLoader

    @FXML // fx:id="button_exit"
    private Button button_exit; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { //Initialize Methode, wo bei start des Programmes dieser Code ausgeführt wird.
        assert button_signIn != null : "fx:id=\"button_signIn\" was not injected: check your FXML file 'homepage.fxml'.";
        assert button_createAccount != null : "fx:id=\"button_createAccount\" was not injected: check your FXML file 'homepage.fxml'.";
        assert label_heading != null : "fx:id=\"label_heading\" was not injected: check your FXML file 'homepage.fxml'.";
        assert button_exit != null : "fx:id=\"button_exit\" was not injected: check your FXML file 'homepage.fxml'.";

    }

    public void onSignIn(ActionEvent event){    //If the Button is pressed, it switches to the  SignIn FXML, so you can switch between views.
        try {
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            scene = stage.getScene();
            fxmlLoader = new FXMLLoader(getClass().getResource("../view/login.fxml"));
            root = (Parent) fxmlLoader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreateAccount(ActionEvent event){ //If the Button is pressed, it switches to the CreateAccount FXML, so you can switch between views.
        try {
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            scene = stage.getScene();
            fxmlLoader = new FXMLLoader(getClass().getResource("../view/createUser.fxml"));
            root = (Parent) fxmlLoader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onExit(){
        System.exit(0);
    }
}
