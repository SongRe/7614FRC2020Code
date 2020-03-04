/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeAutoCommand extends CommandBase {
  IntakeSubsystem intakeSystem;
  boolean direction = true;
  /**
   * Creates a new IntakeAutoCommand.
   * boolean dir dictates direction (true for intake, false for outtake)
   */
  public IntakeAutoCommand(IntakeSubsystem intakeSystem, boolean dir) {
    addRequirements(intakeSystem);
    this.intakeSystem = intakeSystem;
    direction = dir;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(direction) {
      intakeSystem.succ();
    } else {
      intakeSystem.blow();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
