package at.vca.model;

import at.vca.model.helper.ComponentManagement;
import at.vca.model.helper.FileManagement;
import at.vca.model.helper.PasswordManagement;
import at.vca.model.parts.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/homepage.fxml")));
        primaryStage.setTitle("VCA - Virtual Computer Assembler");
        primaryStage.setScene(new Scene(root, 630, 340));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* String user = "asd";
        byte[] test = PasswordManagement.encrypt(user);
        System.out.println(new String(PasswordManagement.decrypt(test)));*/

        ComponentManagement.initializeStandardComponents();
        ComponentManagement.loadAllComponents();

        launch(args);
    }

}
