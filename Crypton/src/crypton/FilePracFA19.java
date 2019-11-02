/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliot
 */
public class FilePracFA19 {
    public static void main(String[] args) {
        java.io.File file = new File("readmeJava.txt");
        System.out.println("File path: " + file.getAbsolutePath());
        System.out.println("Is directory: " + file.isDirectory());
        
        try {
            // once we have a file, we can pass it into a scanner for
            //readin line by line
            Scanner scan = new Scanner(file);
            System.out.println("File contents: ");
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }// close while
                System.out.println("End of File");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilePracFA19.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }// close main
} // close class
