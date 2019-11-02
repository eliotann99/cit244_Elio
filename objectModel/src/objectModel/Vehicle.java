/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectModel;

import inheritancepractice.CrashTestable;
import inheritancepractice.DrivingMode;
import java.util.Scanner;
/**
 *
 * @author eliot
 */
public class Vehicle implements CrashTestable, CrashTestExtended {

    
    private static double score;
    Scanner scan= new Scanner(System.in);
    
    public static double getScore(){
        return score;
    }// close getter
    
    public void negativeScoreFixer() {
        if (score <= 0) {
            score=0;
        }//close if 
    }// close method
    
    @Override
    public void vehicleScore() {
    getVehicleYear();
    getVehicleWeight();
    hasEmergencyBrakes();
    hasBlindSpotDetection();
    hasAirBags();
    negativeScoreFixer();
    }// close vehicleScore
    
    
    
    
    @Override
    public int getVehicleYear(){
        System.out.println("Vehicle's Year Model:");
        int yearModel = scan.nextInt();
        
        if (yearModel >=2008) {
            score= score +1;
        }
        return yearModel;
    }//close getVehicleYear
    
    @Override
    public double getVehicleWeight(){
        double weight;
        System.out.println("Vehicle's weight in lbs");
        weight= scan.nextDouble();
        
        if (weight > 2500) {
            score= score+ .5;
        }// close if statement
        return weight;
    }// close getDriving mode

    @Override
    public boolean hasEmergencyBrakes() {
        boolean supported;
        System.out.println("does this vehicle support emergency brakes? 0=Yes , 1=NO");
        int choice = scan.nextInt();
        if (choice == 0) {
            supported= true;
            score= score+.5;
        } else {
            supported = false;
            score = score -.3;
        }// close if else statment
        return supported;
    }// close emergency brakes

    @Override
    public boolean hasBlindSpotDetection() {
        boolean supported;
        System.out.println("does this vehicle support blindspot detection? 0=Yes ,1=No");
        int choice= scan.nextInt();
        if (choice == 0) {
            supported = true;
            score= score +.3;
        } else {
            supported = false;
            score= score -.2;
        }// close if else 
        return supported;
    }// close method

    @Override
    public boolean hasAirBags(){
        boolean supported;
        System.out.println("does this vehicle support airbags? 0=Yes , 1=No");
        int choice= scan.nextInt();
        if (choice == 0) {
            supported = true;
            score= score +.7;
        } else {
            supported = false;
            score= score -.5;
        }// close if else
        return supported;
    }// close hasairbahs
    
    @Override
    public DrivingMode getDrivingMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean driverAirbagPresent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public double getFrontBumberHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String frameMaterialIdentifer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getLengthOfWheelBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFrontWeightLevelWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getFrontWeightWhenRaised() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}// close class
