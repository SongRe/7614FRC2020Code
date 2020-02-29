/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class TurnWithTimeoutCommand extends CommandBase {
  /**
   * Creates a new TurnWithTimeoutCommand.
   * dir dictates turning direction, true for clockwise, false for counterclockwise
   */
  DriveTrainSubsystem driveTrain;
  boolean direction;
  public TurnWithTimeoutCommand(DriveTrainSubsystem d, boolean dir) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
    driveTrain=d;
    direction=dir;


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(direction) { //clockwise
      driveTrain.tankDrive(0.5, -0.5);


    } else { //counterclockwise
      driveTrain.tankDrive(-0.5, 0.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stopDriving();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
