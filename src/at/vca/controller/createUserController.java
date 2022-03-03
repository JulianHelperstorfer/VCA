package at.vca.controller;

import at.vca.model.User;
import at.vca.model.helper.FileManagement;
import at.vca.model.helper.UserManagement;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.LinkedList;
import java.util.regex.Pattern;

/****
 <p>Author: Baran Imre</p>
 <p>Date: 27/01/2022 | 09:19</p>
 <p>Description: Controller-class for the create user view</p>
 ****/
public class createUserController {

    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    //defining the Variables here.
    @FXML private TextField firstName_txt;

    @FXML private TextField lastName_txt;

    @FXML private TextField username_txt;

    @FXML private TextField email_txt;

    @FXML private TextField password_txt;

    @FXML private PasswordField password_pwf;

    @FXML private TextField confirmPassword_txt;

    @FXML private PasswordField confirmPassword_pwf;

    @FXML private Button createAcc_btn;

    @FXML private Button signIn_btn;

    @FXML private ImageView eyeIcon;

    private int counter=0;

    Format format;

    @FXML public void initialize(){ //Initialize Methode, wo bei start des Programmes dieser Code ausgeführt wird.

            //BooleanBinding for, when you want to create a User, to check if all TextFields are not empty and the Password equals the ConfirmPassword.
        BooleanBinding textFieldEntered =
                firstName_txt.textProperty().isNotEmpty().
                        and(lastName_txt.textProperty().isNotEmpty())
                        .and(username_txt.textProperty().isNotEmpty())
                        .and(email_txt.textProperty().isNotEmpty())
                        .and(password_txt.textProperty().isNotEmpty())
                        .and(confirmPassword_txt.textProperty().isEqualTo(password_txt.textProperty()));

        //Binds the Property of the createAccount-Button to the Booleanbinding.
        //Means, that as long as not all criterias are fullfilled, it will be disabled.
        createAcc_btn.disableProperty().bind(textFieldEntered.not());

    }

    /**
     * <h1><b>saveUser</b></h1>
     * <p>Method saves the user if it doesn't yet exist when the create account button is pressed</p>
     * @param event ActionEvent parameter from the button
     */
    public void saveUser(ActionEvent event) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, FileNotFoundException {
        // User newUser = new User(firstName_txt.get)
        LinkedList<User> users = new LinkedList<>();
        LinkedList<User> testArray = new LinkedList<>();
        String userFirstName, userLastName, username, password, mail, confirmPassword;

        //creates Variables, that get the GUI Datas.
        userFirstName = firstName_txt.getText();
        userLastName = lastName_txt.getText();
        username = username_txt.getText();
        password = password_txt.getText();
        mail = email_txt.getText();
        confirmPassword = confirmPassword_txt.getText();

        //Creates a new User with the Data.
        User newUser = new User(userFirstName, userLastName, username, password, mail);

        if (password.equals(confirmPassword)){  //Checks, if the typed in Password equals the Confirmation Password.

            //Befüllt die users LinkedList, mit den Usern aus der File.
            users = (LinkedList<User>) FileManagement.read(FileManagement.getUserDataFile());

            // checks if the E-Mail or username is already taken
            if (!UserManagement.hasSameUsernameOrEmail(newUser)){
                //if not, it adds the new User to the LinkedList and writes it into the file again.
                users.add(newUser);
                FileManagement.write(users, FileManagement.getUserDataFile());
            }else{
                //Shows Alert.
                Alert newAlert = new Alert(Alert.AlertType.ERROR, "User already exists", ButtonType.CLOSE);
            }
        }else{
            //Shows Alert.
            Alert newAlert = new Alert(Alert.AlertType.ERROR, "Password not correct!", ButtonType.CLOSE);
        }

        //Output for verification.
        testArray = (LinkedList<User>) FileManagement.read(FileManagement.getUserDataFile());

        for (User user: testArray) {
            System.out.println(user.toString());
        }*/
        onSignIn(event);
    }

    /**
     * <h1><b>onSignIn</b></h1>
     * <p>Method that switches to the sign in view when the sign in button is pressed</p>
     * @param event ActionEvent parameter from the button
     */
    public void onSignIn(ActionEvent event){    //If the Button is pressed, it switches the FXML so you can switch between views.
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

    /**
     * <h1><b>showPassw</b></h1>
     * <p>Method that shows the password when the show password button is pressed</p>
     * @param event ActionEvent parameter from the button
     */
    @FXML
    void showPassw(ActionEvent event) {
        Image eyeIcon = new Image("at/vca/view/EyeIcon.png");
        Image eyeIcon2 = new Image("at/vca/view/EyeIcon2.jpg");

        if (counter==0){
            this.eyeIcon.setImage(eyeIcon2);
            counter++;
            password_txt.setText(password_pwf.getText());
            password_txt.setVisible(true);
            password_pwf.setVisible(false);

            confirmPassword_txt.setText(confirmPassword_pwf.getText());
            confirmPassword_txt.setVisible(true);
            confirmPassword_pwf.setVisible(false);
        }else {
            this.eyeIcon.setImage(eyeIcon);
            counter--;
            password_pwf.setText(password_txt.getText());
            password_pwf.setVisible(true);
            password_txt.setVisible(false);

            confirmPassword_pwf.setText(confirmPassword_txt.getText());
            confirmPassword_pwf.setVisible(true);
            confirmPassword_txt.setVisible(false);
        }

    }
}
