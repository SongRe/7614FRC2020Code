/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class SpringRetractCommand extends CommandBase {
  ClimbSubsystem climbSubsystem;
  boolean dir;
  /**
   * Creates a new SpringRetractCommand.
   * Requires climbsubsystem c, and direction
   * @direction - true or false spins clockwise and counterclockwise
   */
  public SpringRetractCommand(ClimbSubsystem c, boolean direction) {
    addRequirements(c);
    climbSubsystem = c;
    dir = direction;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(dir) {
      climbSubsystem.springRetract(1);
    } else {
      climbSubsystem.springRetract(-1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
