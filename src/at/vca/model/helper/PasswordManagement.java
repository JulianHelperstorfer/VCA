package at.vca.model.helper;


import javax.crypto.*;

import java.io.File;



import java.io.FileOutputStream;

import java.io.IOException;

import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;



import java.util.logging.Level;

import java.util.logging.Logger;



public class PasswordManagement {

    static KeyGenerator kg;

    static SecretKey secKey;

    static Cipher cipher;



    static {
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
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }





    //test kann man spaeter Löschen

    public static void writeUserData(String username,String password) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {



        byte[] sUserEncrypt = encrypt(username);

        byte[] sPassEncrypt = encrypt(password);



        System.out.println("user: "+ new String(sUserEncrypt));

        System.out.println("pass: "+ new String(sPassEncrypt));





        byte[] sUserDecrypt = decrypt(sUserEncrypt);

        byte[] sPassDecrypt = decrypt(sPassEncrypt);



        System.out.println("user: "+new String(sUserDecrypt));

        System.out.println("pass: "+new String(sPassDecrypt));







    }



    public   static  byte[] encrypt(String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        cipher.init(Cipher.ENCRYPT_MODE, secKey);

        return cipher.doFinal(data.getBytes());

    }



    public static  byte[] decrypt(byte[] dataEncypt) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        cipher.init(Cipher.DECRYPT_MODE, secKey);

        return cipher.doFinal(dataEncypt);

    }





    private static void saveKey(SecretKey secKey) throws IOException {

        FileOutputStream fos = new FileOutputStream(new File("key"));


        fos.write(secKey.getEncoded());
        fos.flush();
        fos.close();
    }

}

