package at.vca.model;

import at.vca.model.helper.ComponentManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
