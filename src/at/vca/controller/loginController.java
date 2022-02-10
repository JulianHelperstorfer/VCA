package at.vca.controller;
//Baran Imre 27.01.2022

import at.vca.model.User;
import at.vca.model.helper.FileManagement;
import at.vca.model.helper.UserManagement;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;

public class loginController {

    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    private String password;
    boolean passwordHidden;

    //defines the FXML Variables.
    @FXML
    private TextField username_txt;

    @FXML private PasswordField password_txt;

    @FXML private Button signIn_btn;

    @FXML private Button createAcc_btn;

    @FXML private Button showPassw_btn;

    @FXML public void initialize(){ //Initialize Methode, when this Programm starts, it runs through this Code.

        //BooleanBinding to check, if the username and password have been entered.
        BooleanBinding textFieldEntered =
                username_txt.textProperty().isNotEmpty().and(password_txt.textProperty().isNotEmpty());

        //Binds the SignIn-Button Property to the BooleanBinding
        //As long as the BooleanBinding isnt true, it will be deactivated.
        signIn_btn.disableProperty().bind(textFieldEntered.not());
    }

    public void loginButtonPressed(ActionEvent event) {
        System.out.println("test");

        try {
            User user = new User(" "," ",username_txt.getText(),password_txt.getText(),username_txt.getText());

            if (!UserManagement.hasSameUsernameOrEmail(user)){
                alert("Username oder Passwort sind falsch");
            }else{
                //Anderes Fenster erscheint
            }
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

    public void alert(String text){ //Method, to show an Alert.
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(text);
        a.show();
    }

    public void onCreateAccount(ActionEvent event){
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



    public void onShowPassword(){
        /*if(passwordHidden){
            password = "";
            password = password_txt.getText();
            password_txt.clear();
            System.out.println(password);
            password_txt.setPromptText(password);
            passwordHidden = false;
        }else{
            password_txt.setPromptText("Password");
            System.out.println(password);
            password_txt.setText(password);
            passwordHidden = true;
        }*/
        //not working correctly
    }

}
