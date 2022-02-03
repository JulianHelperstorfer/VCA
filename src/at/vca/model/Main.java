package at.vca.model;

import at.vca.model.helper.FileManagement;
import at.vca.model.helper.PasswordManagement;
import at.vca.model.helper.UserManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PasswordManagement.writeUserData("weg", "ghswort");
        Parent root = FXMLLoader.load(getClass().getResource("../view/createUser.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 630, 340));
        primaryStage.show();
    }


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        /*PasswordManagement.writeUserData("sadfser", "passwort");
        User user1 = new User("Leon", "Jukic", "Leon69", "kldsjofosj343", "leon@htl-wels.at");
        User user2 = new User("Julian", "Helperstorfer", "Juli565", "werffsdfsf434342", "julian@htl-wels.at");
        User user3 = new User("Baran", "Imre", "Lelelele", "opskfp93238dsfoh", "imre@htl-wels.ar");

        ArrayList<User> userList = new ArrayList<>();
        ArrayList<User> userList2 = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        File file1 = new File("userData");

        FileManagement.write(userList, file1);

        System.out.println("Parameter stimmt mit File Daten überein: " + UserManagement.hasSameData(user3));
        userList2 = (ArrayList<User>) FileManagement.read(file1);*/


        launch(args);
    }
}
