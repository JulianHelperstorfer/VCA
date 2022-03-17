package at.vca.model.helper;

import at.vca.model.User;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.util.*;

/****
 <p>Author: Bertal Imre</p>
 <p>Date: 27/01/2022 | 10:32</p>
 <p>Description: Class that provides methods for user management</p>
 ****/
public class UserManagement {

    /**
     * <h1><b>hasSameUsernameOrEmail</b></h1>
     * <p>method for checking if the User already exist</p>
     * @param inputUser User parameter for the user that's beeing checked
     * @return boolean variable hasSameData (true = user already exists)
     */
    public static boolean hasSameUsernameOrEmail(User inputUser) {
        boolean hasSameUsernameOrEmail = false;
        Collection<User> userList = FileManagement.read(FileManagement.getUserDataFile());


        // compare the data from the inputUser with the data from the userList, from the userData file,  for login
        if (userList != null) {

            hasSameUsernameOrEmail = userList.contains(inputUser);

        } else {
            System.out.println("UserList is null/empty");
        }

        return hasSameUsernameOrEmail;
    }

    /**
     * <h1><b>hasSameUsernameAndPassword</b></h1>
     * <p>method for checking if the user's username and password are already used</p>
     * @param inputUser User parameter for the user that's beeing checked
     * @return boolean variable hasSameData (true = user already exists)
     */
    // returns true if the inputUsers username and password are correct
    public static boolean hasSameData(User inputUser) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        boolean hasSameData = false;
        LinkedList<User> userList = (LinkedList<User>) FileManagement.read(FileManagement.getUserDataFile());

        if (hasSameUsernameOrEmail(inputUser)) {
                  //if (Arrays.equals(userList.get(userList.indexOf(inputUser)).getPassword(), inputUser.getPassword()))
                  //  hasSameData = true;

            System.out.println("Username/E-Mail richtig");
                if(PasswordManagement.decrypt(userList.get(userList.indexOf(inputUser)).getPassword()).equals(PasswordManagement.decrypt(inputUser.getPassword()))){
                    hasSameData = true;
                    System.out.println("Passwort richtig");
                }
            }

        return hasSameData;
    }
}