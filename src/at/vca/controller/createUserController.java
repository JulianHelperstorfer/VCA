package at.vca.controller;
//Baran Imre 27.01.2022

import at.vca.model.User;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

public class createUserController {

    @FXML private TextField firstName_txt;

    @FXML private TextField lastName_txt;

    @FXML private TextField username_txt;

    @FXML private TextField email_txt;

    @FXML private TextField password_txt;

    @FXML private TextField confirmPassword_txt;

    @FXML private Button createAcc_btn;

    @FXML private Button signIn_btn;

    @FXML public void initialize(){

        BooleanBinding textFieldEntered =
                firstName_txt.textProperty().isNotEmpty().
                        and(lastName_txt.textProperty().isNotEmpty())
                        .and(username_txt.textProperty().isNotEmpty())
                        .and(email_txt.textProperty().isNotEmpty())
                        .and(password_txt.textProperty().isNotEmpty())
                        .and(confirmPassword_txt.textProperty().isEqualTo(password_txt.textProperty()));

        createAcc_btn.disableProperty().bind(textFieldEntered.not());

    }

    public void saveUser() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
       // User newUser = new User(firstName_txt.get)
    }
}
