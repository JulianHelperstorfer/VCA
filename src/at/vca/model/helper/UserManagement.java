package at.vca.model.helper;

import at.vca.model.User;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class UserManagement {


    // provisorische checkUserData Methode
    // returns true if inputData == savedData
    // inputData: Username or emailAddress, password
    // Methodenname gehört verbessert
    public static boolean hasSameData(User inputUser){
        boolean hasSameData = false;
        Collection<User> userList = FileManagement.read(FileManagement.getUserDataFile());


        // compare the data from the inputUser with the data from the userList, from the userData file,  for login
        if (userList != null) {

            hasSameData = userList.contains(inputUser);

        } else {
            System.out.println("UserList ist null");
        }

        return hasSameData;
    }

    // returns true if the inputUsers username and password are correct
    public static boolean hasSameUsernameAndPassword(User inputUser) {
        boolean hasSameData = false;
        LinkedList<User> userList = (LinkedList<User>) FileManagement.read(FileManagement.getUserDataFile());

        if (hasSameUsernameOrEmail(inputUser)) {
                  if (Arrays.equals(userList.get(userList.indexOf(inputUser)).getPassword(), inputUser.getPassword()))
                    hasSameData = true;
            }

        return hasSameData;
    }
}