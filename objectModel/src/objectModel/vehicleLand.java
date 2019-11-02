/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectModel;

/**
 *
 * @author eliot
 */
public class vehicleLand extends Vehicle {

    public static void main(String[] args) {
        Vehicle car = new Vehicle();
        
        car.vehicleScore();
        double finalscore = Vehicle.getScore();
        if (finalscore >= 0) {
        System.out.println("vehicle's score is " + finalscore);
        }// close if
    }// clsoe main method
}// close class
