package at.vca.model.helper;

import at.vca.model.User;
import javafx.scene.control.Alert;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/****
 Author: Julian Helperstorfer
 Date: 27/01/2022 | 09:13
 Description: Class to manage file-input and output
 ****/

public class FileManagement {
    static File userData;

    static {
        userData = new File("userData");
        //System.out.println(file.exists());
        if(!userData.exists()){
            FileManagement.write(new ArrayList<User>(), userData);
            //System.out.println("erstellt");
        }
    }

    /**
     * <h1><b>write</b></h1>
     * <p>Method to write a collection of objects into a file using object streams</p>
     * @param users
     * @param file
     */
    //writing into a file
    public static void write(Collection<User> users, File file){

        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));) {

            //writing objects
            oos.writeObject(users);

            //Error-handling
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Destination-file not found!");
            alert.showAndWait();
        }
    }

    /**
     * <h1><b>read</b></h1>
     * <p>Method to read objects from a file into a collection using an object stream</p>
     * @param file
     * @return
     */
    //reading a file
    public static Collection<User> read(File file){

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){

            //reading objects
            return (Collection<User>) ois.readObject();

            //Error-handling
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error while reading source-file!");
            alert.showAndWait();
            return null;
        }
    }

    public static File getUserDataFile(){
        return userData;
    }

}
