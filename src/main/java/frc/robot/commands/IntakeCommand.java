/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
  IntakeSubsystem intakeSystem;
  XboxController c;
  /**
   * Creates a new IntakeCommand.
   */
  public IntakeCommand(IntakeSubsystem intakeSystem, XboxController c) {
    addRequirements(intakeSystem);
    this.c = c;
    this.intakeSystem = intakeSystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(c.getTriggerAxis(Hand.kRight) > 0) {
      intakeSystem.succ();
    } else if(c.getTriggerAxis(Hand.kLeft) > 0) {
      intakeSystem.blow();
    } else {
      intakeSystem.stop();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
