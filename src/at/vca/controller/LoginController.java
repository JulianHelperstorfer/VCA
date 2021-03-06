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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.LinkedList;

/****
 <p>Author: Baran Imre</p>
 <p>Date: 27/01/2022 | 09:23</p>
 <p>Description: Controller-class for the login view</p>
 ****/
public class LoginController {

    private Node node;
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    //defines the FXML Variables.
    @FXML
    private TextField username_txt;

    @FXML private TextField password_txt;

    @FXML private PasswordField password_pwf;

    @FXML private Button signIn_btn;

    @FXML private ImageView eyeIcon;

    @FXML private Button createAcc_btn;

    @FXML private Button showPassw_btn;

    private int counter = 1;

    /**
     * <h1><b>initialize</b></h1>
     * <p>Method to set up bindings as soon as the controller gets initialized</p>
     */
    @FXML public void initialize(){
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Initializing login page...");

        //BooleanBinding to check, if the username and password have been entered.
        BooleanBinding textFieldEntered =
                username_txt.textProperty().isNotEmpty().and(password_pwf.textProperty().isNotEmpty());

        //Binds the SignIn-Button Property to the BooleanBinding
        //As long as the BooleanBinding isnt true, it will be deactivated.
        signIn_btn.disableProperty().bind(textFieldEntered.not());

        LinkedList<User> users = new LinkedList<>();
        users = (LinkedList<User>) FileManagement.read(FileManagement.getUserDataFile());

        showPassw(new ActionEvent());

        System.out.println("[Log] Finished initializing login page...");
        System.out.println("--------------------------------------------------");
    }

    /**
     * <h1><b>loginButtonPressed</b></h1>
     * <p>method that checks if the user already exists when the login button is pressed</p>
     * @param event ActionEvent parameter for the button
     */
    public void loginButtonPressed(ActionEvent event) {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Logging in user...");

        try {
            User user = new User(" "," ",username_txt.getText(),password_pwf.getText(),username_txt.getText());



            if (!UserManagement.hasSameData(user)){
                System.out.println("[Log] Failed to log in user! (username or password is wrong)");
                System.out.println("--------------------------------------------------");
                alert("Username or password is wrong");
            }else{
                //Anderes Fenster erscheint
                //alert("User signed in");
                try {
                    node = (Node) event.getSource();
                    stage = (Stage) node.getScene().getWindow();
                    stage.setWidth(420);
                    stage.setHeight(530);
                    scene = stage.getScene();
                    fxmlLoader = new FXMLLoader(getClass().getResource("../view/buildAPc.fxml"));
                    root = (Parent) fxmlLoader.load();
                    scene.setRoot(root);
                    System.out.println("[Log] Successfully logged in user!");
                    System.out.println("--------------------------------------------------");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

    }

    /**
     * <h1><b>alert</b></h1>
     * <p>method that shows an alert</p>
     * @param text String parameter that gets shown in the alert
     */
    public void alert(String text){ //Method, to show an Alert.
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(text);
        a.show();
    }

    /**
     * <h1><b>onCreateAccount</b></h1>
     * <p>method that changes the view to the createUser view when the create Account button is pressed</p>
     * @param event ActionEvent parameter for the button
     */
    public void onCreateAccount(ActionEvent event){
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Switching to create account page...");
        try {
            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            scene = stage.getScene();
            fxmlLoader = new FXMLLoader(getClass().getResource("../view/createUser.fxml"));
            root = (Parent) fxmlLoader.load();
            scene.setRoot(root);
            System.out.println("[Log] Finished switching to create account page!");
            System.out.println("--------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * <h1><b>onShowPassw</b></h1>
     * <p>method that shows or hides the password when the showPassWord-button is pressed</p>
     * @param event ActionEvent parameter for the button
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

        }else {
            this.eyeIcon.setImage(eyeIcon);
            counter--;
            password_pwf.setText(password_txt.getText());
            password_pwf.setVisible(true);
            password_txt.setVisible(false);

        }

    }
}
