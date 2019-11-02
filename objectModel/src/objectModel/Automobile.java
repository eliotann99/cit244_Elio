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
public class Automobile {
    
    private String vIN;
    private String engineType;
    private int numberOfWheels;
    private String transmisionType;
    private int numOfGears;
    private int numberOfSeats;
    private double cargoCapasity;
    private String driveTrain;
    private int numberOfDoors;
    /**
     * @return the vIN
     */
    public String getvIN() {
        return vIN;
    }// close getter

    /**
     * @param vIN the vIN to set
     */
    public void setvIN(String vIN) {
        this.vIN = vIN;
    }// close setter

    /**
     * @return the engineType
     */
    public String getEngineType() {
        return engineType;
    }//closer getter

    /**
     * @param engineType the engineType to set
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * @return the numberOfWheels
     */
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * @param numberOfWheels the numberOfWheels to set
     */
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * @return the transmisionType
     */
    public String getTransmisionType() {
        return transmisionType;
    }

    /**
     * @param transmisionType the transmisionType to set
     */
    public void setTransmisionType(String transmisionType) {
        this.transmisionType = transmisionType;
    }

    /**
     * @return the numOfGears
     */
    public int getNumOfGears() {
        return numOfGears;
    }

    /**
     * @param numOfGears the numOfGears to set
     */
    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }

    /**
     * @return the numberOfSeats
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * @param numberOfSeats the numberOfSeats to set
     */
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * @return the cargoCapasity
     */
    public double getCargoCapasity() {
        return cargoCapasity;
    }

    /**
     * @param cargoCapasity the cargoCapasity to set
     */
    public void setCargoCapasity(double cargoCapasity) {
        this.cargoCapasity = cargoCapasity;
    }

    /**
     * @return the driveTrain
     */
    public String getDriveTrain() {
        return driveTrain;
    }

    /**
     * @param driveTrain the driveTrain to set
     */
    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    /**
     * @return the numberOfDoors
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * @param numberOfDoors the numberOfDoors to set
     */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    
}// close class
