/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMVictorSPX;

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

  



  

  /**
   * Creates a new DriveTrainSubsystem.
   */
  public DriveTrainSubsystem() {
    
    

  }


  //
  public void teleopDrive(XboxController controller) {
    baseDrive.arcadeDrive(controller.getY(Hand.kLeft), controller.getX(Hand.kLeft));
  }


  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
    //baseDrive.arcadeDrive(xSpeed, zRotation);
  }

  // public DifferentialDrive getDrive () {
  //   return this.baseDrive;
  // }

//   public void teleopDrive(XboxController xbox) {
//     // tells the drive train to drive based on a joystick
//     // the first parameter is speed, the second angle of turn
//     // the third parameter enables squared inputs, which "decreases sensitivity at
//     // low speeds
//     if(Robot.m_oi.turboOn){
//         System.err.printf("turbo");
//         base_drive.arcadeDrive(
//             -xbox.getY(Hand.kLeft),
//             xbox.getX(Hand.kLeft)/1.5,
//             true
//         );
//     }else{
//         System.err.printf("slow");
//         double DEFANG = 5;
//         base_drive.arcadeDrive(
//             xbox.getX(Hand.kRight)/DEFANG,
//             xbox.getY(Hand.kRight)/DEFANG,
//             false
//         );
//     }
    
// }

}
