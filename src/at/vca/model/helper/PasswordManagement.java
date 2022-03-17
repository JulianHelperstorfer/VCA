package at.vca.model.helper;

import javax.crypto.*;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.util.logging.Level;
import java.util.logging.Logger;

/****
 <p>Author: Marko Jezidzic</p>
 <p>Date: 27/01/2022 | 09:47</p>
 <p>Description: Class to encrypt and decrypt Strings (mainly for passwords)</p>
 ****/

public class PasswordManagement {

    //defining the Variables.
    static KeyGenerator kg;
    static SecretKey secKey;
    static Cipher cipher;


    static {
        if(!(new File("key").length() >=0)) {
            // Key generator with encrypt code
            try {
                kg = KeyGenerator.getInstance("AES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            // Initializing keysizee
            kg.init(128);
            // Creating a secret key
            secKey = kg.generateKey();

            // Save key for Reuse
            try {
                saveKey(secKey);
            } catch (IOException ex) {
                Logger.getLogger(PasswordManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //key einlesen
        }
            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                e.printStackTrace();
            }

    }


    /**
     * <h1><b>encrypt</b></h1>
     * <p>method that return the encrypted password</p>
     * @param data  String parameter that should get encrypted
     * @return encrypted String
     */
    public   static  byte[] encrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        cipher.init(Cipher.ENCRYPT_MODE, secKey);
        return cipher.doFinal(data.getBytes());

    }

    /**
     * <h1><b>decrypt</b></h1>
     * <p>method that return the decrypted password</p>
     * @param dataEncrypt byte-array paramater that should get decrypted
     * @return decrypted byte-array
     */
    public static  String decrypt(byte[] dataEncrypt) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        cipher.init(Cipher.DECRYPT_MODE, secKey);
        return new String(cipher.doFinal(dataEncrypt));

    }

    /**
     * <h1><b>saveKey</b></h1>
     * <p>method that saves the key to a file</p>
     * @param secKey SecretKey parameter that should get saved
     */
    private static void saveKey(SecretKey secKey) throws IOException {

        FileOutputStream fos = new FileOutputStream(new File("key"));

        fos.write(secKey.getEncoded());
        fos.flush();
        fos.close();
    }

}

