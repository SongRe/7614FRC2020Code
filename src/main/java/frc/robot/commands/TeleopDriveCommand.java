/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 * Add your docs here.
 */
public class TeleopDriveCommand extends CommandBase {
    private DriveTrainSubsystem d = new DriveTrainSubsystem();
    private XboxController controller = new XboxController(Constants.joystickPort);
    


    public TeleopDriveCommand(DriveTrainSubsystem driveSubsystem, XboxController c) {
        addRequirements(driveSubsystem);
        controller = c;
        d = driveSubsystem;
    }


    
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      d.teleopDrive(controller);
      
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
