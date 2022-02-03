package at.vca.controller;
//Baran Imre 27.01.2022

import at.vca.model.User;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private TextField username_txt;

    @FXML private TextField password_txt;

    @FXML private Button signIn_btn;

    @FXML private Button createAcc_btn;

    @FXML private Button showPassw_btn;

    @FXML public void initialize(){

        BooleanBinding textFieldEntered =
                username_txt.textProperty().isNotEmpty().and(password_txt.textProperty().isNotEmpty());

        signIn_btn.disableProperty().bind(textFieldEntered.not());

    }

}
