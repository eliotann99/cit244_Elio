/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliot
 */
public class Md5Test {

    private static final String importantMessage = "Acceleration is nine point eight"
             + "meters per second per second on earth";
    public static void main(String[] args) {
        System.out.println("Input: ");
        
        try {
            // TODO code application logic here
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            digester.update(importantMessage.getBytes());
            byte[] hashValue= digester.digest();
            
            StringBuffer hexbuffer = new StringBuffer();
            for (int i = 0; i < hashValue.length; i++) {
                hexabuffer.append(Integer.toHexString(0xFF & hashValue[i]));
            }
            System.out.println("Hash:");
            System.out.println(hashValue);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        
    }
    
}
