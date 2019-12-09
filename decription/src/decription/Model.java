/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decription;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author eliot
 */
public class Model {
    private DescriptionController controller;
    private String hashedValue;
    
    
    public void messageDecripter() {
        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            
            digester.update(controller.getText().getBytes());
            if(controller.getText().isEmpty()){

            }else {
                hashedValue =DatatypeConverter.printHexBinary(digester.digest());
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }// close try catch
        controller.setHash(hashedValue);
    }// close method


    public DescriptionController getController() {
        return controller;
    }

    public void setController(DescriptionController controller) {
        this.controller = controller;
    }




}// close class
