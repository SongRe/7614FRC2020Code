/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {

  WPI_VictorSPX mainMotor = new WPI_VictorSPX(Constants.climbPort);
  WPI_VictorSPX springMotor = new WPI_VictorSPX(Constants.spinPort);
  /**
   * Creates a new ClimbSubsystem.
   */
  public ClimbSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extend() {
    mainMotor.set(Constants.generalSpeed*2);
  }

  public void climb() {
    mainMotor.set(Constants.generalSpeed * -2);
    
  }

  public void stop() {
    mainMotor.set(0);
  }

  public void springRetract(int dir) {
    springMotor.set(Constants.generalSpeed * dir);
  }

  public void springStop() {
    springMotor.stopMotor();
  }
}
