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
import frc.robot.commands.ArmAutoCommand;
import frc.robot.commands.ArmLiftCommand;
import frc.robot.commands.ArmLowerCommand;
import frc.robot.commands.ArmStopCommand;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.IntakeAutoCommand;
import frc.robot.commands.ArmAutoCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.ClimbStopCommand;
import frc.robot.commands.ExtendCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeStopCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.SpinCommand;
import frc.robot.commands.SpinStopCommand;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.commands.ToggleArmSpeedCommand;
import frc.robot.commands.TurnWithTimeoutCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.SpinSubsystem;
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
  private final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  private final ArmSubsystem arm = new ArmSubsystem();
  private final IntakeSubsystem intakeSystem = new IntakeSubsystem();
  private final ClimbSubsystem climbingThing = new ClimbSubsystem();
  private final SpinSubsystem spinny=new SpinSubsystem();




  //declare commands  
  private final TeleopDriveCommand driveCommand = new TeleopDriveCommand(driveTrain, controller);
  private final ArmLiftCommand liftArm = new ArmLiftCommand(arm);
  private final ArmLowerCommand lowerArm = new ArmLowerCommand(arm);
  private final ArmStopCommand stopArm = new ArmStopCommand(arm);
  private final ToggleArmSpeedCommand toggleArmSpeed = new ToggleArmSpeedCommand();

  private final ClimbCommand climbCommand = new ClimbCommand(climbingThing);
  private final ExtendCommand extendCommand = new ExtendCommand(climbingThing);
  private final ClimbStopCommand climbStop=new ClimbStopCommand(climbingThing);

private final AutonomousCommand autonomousCommand=new AutonomousCommand(arm, intakeSystem, driveTrain);
  
  //private final IntakeCommand succIn= new IntakeCommand(intakeSystem, controller);
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSystem, controller);
  private final OuttakeCommand spitOut = new OuttakeCommand(intakeSystem);
  private final IntakeStopCommand stopSucc = new IntakeStopCommand(intakeSystem);

  private final SpinStopCommand spinStop=new SpinStopCommand(spinny);
  private final SpinCommand spinStart=new SpinCommand(spinny);
  
  private final AutoDriveCommand forwardAutoCommand =new AutoDriveCommand(driveTrain, true);
  private final AutoDriveCommand backAutoDriveCommand = new AutoDriveCommand(driveTrain, false);
  private final TurnWithTimeoutCommand clockwiseAutoCommand = new TurnWithTimeoutCommand(driveTrain, true);
  private final TurnWithTimeoutCommand counterClockAutoCommand = new TurnWithTimeoutCommand(driveTrain, false);
  private final ArmAutoCommand liftAutoCommand = new ArmAutoCommand(arm);
  private final IntakeAutoCommand intakeAutoCommand = new IntakeAutoCommand(intakeSystem, true);
  private final IntakeAutoCommand outtakeAutoCommand = new IntakeAutoCommand(intakeSystem, false);
  //Buttons 2
  JoystickButton armUpButton = (JoystickButton) new JoystickButton(controller, Constants.BUTTON_Y);
  JoystickButton armDownButton = new JoystickButton(controller, Constants.BUTTON_A);

  // JoystickButton succButton   = new JoystickButton(controller, Constants.BUTTON_B);
  // JoystickButton spitButton   = new JoystickButton(controller, Constants.BUTTON_X);

  //JoystickButton toggleArmButton = new JoystickButton(controller, Constants.BUTTON_B);
  JoystickButton extendButton = new JoystickButton(controller, Constants.TRIGGER_R);
  JoystickButton climbButton = new JoystickButton(controller, Constants.TRIGGER_L);
  
  JoystickButton spinButton = new JoystickButton(controller, Constants.BUTTON_B);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // driveTrain.setDefaultCommand(driveCommand);
    //intakeSystem.setDefaultCommand(intakeCommand);
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
    armUpButton.whenPressed(liftArm);
    armDownButton.whenPressed(lowerArm);
    armUpButton.whenReleased(stopArm);
    armDownButton.whenReleased(stopArm);
    
    // succButton.whenPressed(succIn);
    // spitButton.whenPressed(spitOut);
    // succButton.whenReleased(stopSucc);
    // spitButton.whenReleased(stopSucc);
    //toggleArmButton.whenPressed(toggleArmSpeed);

    extendButton.whenPressed(extendCommand);
    climbButton.whenPressed(climbCommand);
    climbButton.whenReleased(climbStop);
    extendButton.whenReleased(climbStop);

    spinButton.whenPressed(spinStart);
    spinButton.whenReleased(spinStop);
    
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
  public AutoDriveCommand getForwardAutoCommand() {
    return forwardAutoCommand;
    // An ExampleCommand will run in autonomous

  }
  public AutoDriveCommand getBackAutoCommand() {
    return backAutoDriveCommand;
  }

  public TurnWithTimeoutCommand getTurnClockwiseCommand(){
    return clockwiseAutoCommand;
  }

  public TurnWithTimeoutCommand getTurnCounterClockwiseCommand() {
    return counterClockAutoCommand;
  }

  public IntakeAutoCommand getIntakeCommand() {
    return intakeAutoCommand;
  }

  public IntakeAutoCommand getOuttakeCommand() {
    return outtakeAutoCommand;
  }

  public ArmAutoCommand getArmLiftCommand() {
    return liftAutoCommand;
  }

  public AutonomousCommand getAutonomousCommand(){
    return autonomousCommand;
  }

  public void setDefaultDrive() {
    driveTrain.setDefaultCommand(driveCommand);
  }

  public void setDefaultIntake() {
    intakeSystem.setDefaultCommand(intakeCommand);

  }

  


  
}
