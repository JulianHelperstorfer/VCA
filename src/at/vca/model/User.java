package at.vca.model;

import at.vca.model.helper.PasswordManagement;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.util.Arrays;

/****
 Author: Bertal Imre
 Date: 27/01/2022 | 09:08
 Description: Just a simple user class.
 ****/

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private byte[] userName;
    private byte[] password;
    private String eMail;


    //Constructor, that's used when a User is beeing created.
    public User(String firstName, String lastName, String userName, String password, String eMail) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        //Sets the
        this.firstName = firstName;
        this.lastName = lastName;
        //Encrypts the Username and Password, übergibt diese dann an die 2 Attribute in dieser Klasse.
        this.userName = PasswordManagement.encrypt(userName);
        this.password = PasswordManagement.encrypt(password);
        this.eMail = eMail;
    }


    //Getter and Setter für this Classes Variables.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getUserName() {
        return userName;
    }

    public void setUserName(byte[] userName) {
        this.userName = userName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public boolean equals(Object o) {   //Compares 2 Users and checks, if they have the same Email or Username.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Arrays.equals(userName, user.userName) || eMail.equals(user.eMail);
    }
}

