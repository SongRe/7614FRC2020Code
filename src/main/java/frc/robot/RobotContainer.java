/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  XboxController controller = new XboxController(Constants.joystickPort);


  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();



  //declare commands  
  private final TeleopDriveCommand driveCommand = new TeleopDriveCommand(driveTrain, controller);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Button button = new JoystickButton(joystick, buttonNumber); //buttons need a controller type, and button number based on that controller 
    //Joystick stick = new Joystick(Constants.joystickPort); // set to port 0 
    //new JoystickButton(joystick, buttonNumber).whenPressed(command);
    



    




    
//      // Grab the hatch when the 'A' button is pressed.
//      new JoystickButton(m_driverController, Button.kA.value)
//      .whenPressed(new GrabHatch(m_hatchSubsystem));
//  // Release the hatch when the 'B' button is pressed.
//  new JoystickButton(m_driverController, Button.kB.value)
//      .whenPressed(new ReleaseHatch(m_hatchSubsystem));
//  // While holding the shoulder button, drive at half speed
//  new JoystickButton(m_driverController, Button.kBumperRight.value)
//      .whenHeld(new HalveDriveSpeed(m_robotDrive));




  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }


  
}
