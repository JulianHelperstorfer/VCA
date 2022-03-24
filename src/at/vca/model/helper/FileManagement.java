package at.vca.model.helper;

import at.vca.model.User;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/****
 <p>Author: Julian Helperstorfer</p>
 <p>Date: 27/01/2022 | 09:13</p>
 <p>Description: Class to manage file-input and output</p>
 ****/

public class FileManagement {
    static File userData;

    static {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Initializing FileManagement...");

        userData = new File("userData");
        //System.out.println(file.exists());
        if(!userData.exists()){
            FileManagement.write(new ArrayList<User>(), userData);
            //System.out.println("erstellt");
        }
        System.out.println("[Log] Finished initializing FileManagement!");
        System.out.println("--------------------------------------------------");
    }

    /**
     * <h1><b>write</b></h1>
     * <p>Method to write a collection of objects into a file using object streams</p>
     * @param users
     * @param file
     */
    public static void write(Collection<User> users, File file){
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Writing collection into file \""+file.getName()+"\"...");

        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));) {

            //writing objects
            oos.writeObject(users);

            System.out.println("[Log] Finished writing into file!");
            System.out.println("--------------------------------------------------");
            //Error-handling
        } catch (IOException e) {
            System.out.println("[Log] Error while writing into file! (destination-file not found)");
            System.out.println("--------------------------------------------------");
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
    public static Collection<User> read(File file){
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Reading collection from file \""+file.getName()+"\"...");

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){

            //reading objects
            System.out.println("[Log] Finished reading collection from file!");
            System.out.println("--------------------------------------------------");
            return (Collection<User>) ois.readObject();

            //Error-handling
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[Log] Error while reading collection from file!");
            System.out.println("--------------------------------------------------");
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
