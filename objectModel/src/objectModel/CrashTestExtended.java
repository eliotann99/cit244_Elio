/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectModel;

import inheritancepractice.CrashTestable;

/**
 *
 * @author eliot
 */
public interface CrashTestExtended extends CrashTestable {
    
    /*
    asks if the vehicle supports emergancy braking and rates it
    */
    public boolean hasEmergencyBrakes();
    
    /*
    asks if the vehicle supports blindspot detection and rates it
    */
    public boolean hasBlindSpotDetection();
    
    /*
    asks if the vehicel supports airbags
    */
    public boolean hasAirBags();
    
    /*
    gives back vehicle schore as a double
    */
    public void vehicleScore();
}// close class
