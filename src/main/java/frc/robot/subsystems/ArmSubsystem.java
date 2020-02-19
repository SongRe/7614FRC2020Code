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

public class ArmSubsystem extends SubsystemBase {
  private WPI_VictorSPX motor = new WPI_VictorSPX(Constants.armPort);
  /**
   * Creates a new ArmSubsystem.
   */
  public ArmSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void lift() {
    motor.set(0.5);

  }

  public void lower() {
    motor.set(-0.5);
  }

  public void stop() {
    motor.set(0);
  }


}
