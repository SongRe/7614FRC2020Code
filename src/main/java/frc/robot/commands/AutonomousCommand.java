/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;


public class AutonomousCommand extends CommandBase {
  /**
   * Creates a new AutonomousCommand.
   */
  ArmSubsystem armSystem;
  IntakeSubsystem intakeSystem;
  DriveTrainSubsystem driveSystem;

  public AutonomousCommand(ArmSubsystem armSubsystem, IntakeSubsystem intakeSubsystem, DriveTrainSubsystem driveSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(armSubsystem, intakeSubsystem, driveSubsystem);
    armSystem = armSubsystem;
    intakeSystem = intakeSubsystem;
    driveSystem = driveSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   // System.out.println("autonomousCommand has been initialized");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //driveSystem.encReset();
   
    //how far you want it to go? Now i need actual measurements
    //turn first so we can move on an angle
    driveSystem.autoTankDrive();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // driveSystem.autoDrive(0,0);
     driveSystem.stopDriving();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
