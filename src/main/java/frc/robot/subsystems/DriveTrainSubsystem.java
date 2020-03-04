/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrainSubsystem extends SubsystemBase {

  private WPI_VictorSPX leftMaster = new WPI_VictorSPX(Constants.leftMasterPort); //add this to project 
  private WPI_VictorSPX leftSlave = new WPI_VictorSPX(Constants.leftSlavePort);
  private WPI_VictorSPX rightMaster = new WPI_VictorSPX(Constants.rightMasterPort);
  private WPI_VictorSPX rightSlave = new WPI_VictorSPX(Constants.rightSlavePort);

  private SpeedControllerGroup leftControlGroup = new SpeedControllerGroup(leftMaster, leftSlave);
  private SpeedControllerGroup rightControlGroup = new SpeedControllerGroup(rightMaster, rightSlave);

  private DifferentialDrive baseDrive = new DifferentialDrive(leftControlGroup, rightControlGroup);

  Encoder left=new Encoder(Constants.leftEnc1,Constants.leftEnc2,false,Encoder.EncodingType.k4X);
  Encoder right = new Encoder(Constants.rightEnc1, Constants.rightEnc2, false, Encoder.EncodingType.k4X);

  



  

  /**
   * Creates a new DriveTrainSubsystem.
   */
  public DriveTrainSubsystem() {
    leftMaster.setSafetyEnabled(false);
    leftSlave.setSafetyEnabled(false);
    rightMaster.setSafetyEnabled(false);
    rightSlave.setSafetyEnabled(false);
    
    
    

  }

  



  //
  public void teleopDrive(XboxController controller) {
    baseDrive.arcadeDrive(-controller.getY(Hand.kLeft), controller.getX(Hand.kLeft));
  }

  public void autoDrive(double forwardSpeed, double horizontalSpeed){
    baseDrive.arcadeDrive(forwardSpeed, horizontalSpeed);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    baseDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void tankDrive(XboxController controller) {
    baseDrive.tankDrive(- controller.getY(Hand.kLeft) , - controller.getY(Hand.kRight));
  }

  
// /**
//  * Distance is in meters
//  */
  public void driveToDistance(double distance) {
    while(getDistance() < distance) {
      baseDrive.tankDrive(0.3, 0.3);
    }
    baseDrive.tankDrive(0, 0);
  }

  // /**
  //  * Turns the base to a certain angle. Positive degrees refers to left spin, negative to right spin 
  //  * @param degrees
  //  */
  // public void turnToAngle(double degrees){
  //   while(getDistance()<(360/degrees *3.032265)){
  //     if(degrees>0){
  //       baseDrive.tankDrive(0.5,-0.5);
  //     }
  //     if(degrees<0){
  //       baseDrive.tankDrive(-0.5,0.5);
  //     }
      
  //   }
  // }

  public void stopDriving(){
    baseDrive.stopMotor();
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
    //baseDrive.arcadeDrive(xSpeed, zRotation);
  }

  /**
   * Raw average value of the encoders
   * @return
   */
  public double getRawAvg(){
    return (left.getRaw() + right.getRaw())/2;
  }

  /**
   * Resets encoders
   */
  public void encReset(){
		left.reset();
		right.reset();
  }


  /**
   * Get the forward distance travelled
   * @return
   */
  public double getDistance(){
    return getRawAvg() *0.035;
  }

  /**
   * Get the distance travelled by the left encoder
   * @return
   */
  public double getLeftDistance(){
    return left.getRaw()*0.035;
  }
//wheels are 15.24cm in diameter
  /**
  * Get the distance travelled by right encoder
  * @return
  */
  public double getRightDistance(){
    return right.getRaw()*0.0;
  }

  public DifferentialDrive getDrive () {
    return this.baseDrive;
  }

  
   

}
