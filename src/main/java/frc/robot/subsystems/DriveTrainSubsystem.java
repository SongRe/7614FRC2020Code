/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Constants;


public class DriveTrainSubsystem extends SubsystemBase {

  private PWMVictorSPX leftMaster = new PWMVictorSPX(Constants.leftMasterPort); //add this to project 
  private PWMVictorSPX leftSlave = new PWMVictorSPX(Constants.leftSlavePort);
  private PWMVictorSPX rightMaster = new PWMVictorSPX(Constants.rightMasterPort);
  private PWMVictorSPX rightSlave = new PWMVictorSPX(Constants.rightSlavePort);

  private SpeedControllerGroup leftControlGroup = new SpeedControllerGroup(leftMaster, leftSlave);
  private SpeedControllerGroup rightControlGroup = new SpeedControllerGroup(rightMaster, rightSlave);

  private DifferentialDrive baseDrive = new DifferentialDrive(leftControlGroup, rightControlGroup);

  



  //testing gitj

  /**
   * Creates a new DriveTrainSubsystem.
   */
  public DriveTrainSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    baseDrive.arcadeDrive(xSpeed, zRotation);
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
