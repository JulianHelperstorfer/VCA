package at.vca.model.helper;

import at.vca.model.User;

import java.io.File;
import java.util.Arrays;

public class UserManagement {


    // provisorische checkUserData Methode
    // returns true if inputData == savedData
    // inputData: Username or emailAddress, password
    // Methodenname gehört verbessert
    public static boolean hasSameData(User inputUser){
        boolean hasSameData = false;



        // compare the data from the inputUser with the data from the userList, from the userData file,  for login
        for (User anyUser : FileManagement.read(new File("userData"))) {

            // falls nicht funktioniert, username und email als String verlgleichen, indem man sie encrypted
            // entweder hier encrypten oder direkt in user class
            hasSameData = inputUser.geteMail().equals(anyUser.geteMail())
                    || Arrays.equals(inputUser.getUserName(), anyUser.getUserName())
                    && Arrays.equals(inputUser.getPassword(), anyUser.getPassword())
            ;
            }


        return hasSameData;
    }
}
