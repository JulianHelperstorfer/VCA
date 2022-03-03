package at.vca.model;

import at.vca.model.helper.FileManagement;
import at.vca.model.helper.PasswordManagement;
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
import java.util.LinkedList;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PasswordManagement.writeUserData("weg", "ghswort");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/homepage.fxml")));
        primaryStage.setTitle("VCA");
        primaryStage.setScene(new Scene(root, 630, 340));
        primaryStage.show();
    }


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        User user1 = new User("Leon", "Jukic", "Leon69", "kldsjofosj343", "leon@htl-wels.at");
        User user2 = new User("Julian", "Helperstorfer", "Juli565", "werffsdfsf434342", "julian@htl-wels.at");
        User user3 = new User("Baran", "Imre", "Lelelele1", "opskfp93238dsfoh", "imre@htl-wels.ar");

        LinkedList<User> userList = new LinkedList<>();


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        File file1 = new File("userData");

        FileManagement.write(userList, file1);




        launch(args);
    }

}
