package at.vca.model.helper;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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
    static File file=new File("key");


    static {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Initializing PasswordManagement...");

        if(!file.exists()){
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

        }
            //key einlesen
        else{
            try {
                System.out.println(loadKey());
                secKey=loadKey();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            try {
                cipher = Cipher.getInstance("AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                e.printStackTrace();
            }

        System.out.println("[Log] Finished initializing PasswordManagement!");
        System.out.println("--------------------------------------------------");
    }


    /**
     * <h1><b>encrypt</b></h1>
     * <p>method that return the encrypted password</p>
     * @param data  String parameter that should get encrypted
     * @return encrypted String
     */
    public   static  byte[] encrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Encrypting string \""+data+"\"...");

        cipher.init(Cipher.ENCRYPT_MODE, secKey);

        System.out.println("[Log] Finished encrypting string \""+data+"\"!");
        System.out.println("--------------------------------------------------");
        return cipher.doFinal(data.getBytes());

    }

    /**
     * <h1><b>decrypt</b></h1>
     * <p>method that return the decrypted password</p>
     * @param dataEncrypt byte-array paramater that should get decrypted
     * @return decrypted byte-array
     */
    public static  String decrypt(byte[] dataEncrypt) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Decrypting string...");

        cipher.init(Cipher.DECRYPT_MODE, secKey);

        System.out.println("[Log] Finished decrypting string!");
        System.out.println("--------------------------------------------------");
        return new String(cipher.doFinal(dataEncrypt));

    }

    /**
     * <h1><b>saveKey</b></h1>
     * <p>method that saves the key to a file</p>
     * @param secKey SecretKey parameter that should get saved
     */
    private static void saveKey(SecretKey secKey) throws IOException {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Saving key...");

        FileOutputStream fos = new FileOutputStream("key");

        fos.write(secKey.getEncoded());
        fos.flush();
        fos.close();

        System.out.println("[Log] Finished saving key!");
        System.out.println("--------------------------------------------------");
    }

    private static  SecretKey loadKey() throws IOException {
        System.out.println("--------------------------------------------------");
        System.out.println("[Log] Loading key...");

        SecretKeySpec sks = new SecretKeySpec(Files.readAllBytes(file.toPath()),"AES");

        System.out.println("[Log] Finished loading key!");
        System.out.println("--------------------------------------------------");
        return sks;
    }
}

