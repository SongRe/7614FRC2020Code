/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ArmAutoCommand;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.IntakeAutoCommand;
import frc.robot.commands.TurnWithTimeoutCommand;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private AutoDriveCommand forwardAuto;
  private AutoDriveCommand backAuto;
  private TurnWithTimeoutCommand clockwiseAuto;
  private TurnWithTimeoutCommand counterclockAuto;
  private ArmAutoCommand armLiftAuto;
  private IntakeAutoCommand intakeAuto;
  private IntakeAutoCommand outtakeAuto;
  private AutonomousCommand autonomousCommand;
  // private TeleopDriveCommand driveCommand;
  // private XboxController controller=new XboxController(Constants.joystickPort);
  // private DriveTrainSubsystem drive=new DriveTrainSubsystem();
  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    
    camera.setResolution(640, 480);
    UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture();
    
    camera2.setResolution(640, 480);
    //   camera.setResolution(640, 480);
    //UsbCamera frontCamera = CameraServer.getInstance().startAutomaticCapture();
    
    //Thread for camera input copied from wpilib docs
    // new Thread(() -> {
    //   UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    //   camera.setResolution(640, 480);
    //   CvSink cvsink = CameraServer.getInstance().getVideo();
    //   CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
    //   Mat source = new Mat();
    //   while(!Thread.interrupted()) {
    //     if(cvsink.grabFrame(source) == 0) {
    //       continue;
    //     }
    //     outputStream.putFrame(source);
    //   }
    // }).start();

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    //forwardAuto = m_robotContainer.getForwardAutoCommand();
    backAuto = m_robotContainer.getBackAutoCommand();
    // clockwiseAuto = m_robotContainer.getTurnClockwiseCommand();
    // counterclockAuto = m_robotContainer.getTurnCounterClockwiseCommand();
    // armLiftAuto = m_robotContainer.getArmLiftCommand();
    // intakeAuto = m_robotContainer.getIntakeCommand();
    // outtakeAuto = m_robotContainer.getOuttakeCommand();
    autonomousCommand=m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if ((autonomousCommand) != null) {
      autonomousCommand.withTimeout(2).execute();
      // if (clockwiseAuto != null) {
      //   clockwiseAuto.withTimeout(1).schedule();
      //   if (forwardAuto != null) {
      //     forwardAuto.withTimeout(3).schedule();
      //   }
      // }
      if((backAuto) != null) {
      //  backAuto.withTimeout(2).execute();
      }
    }

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    autonomousCommand.end(true);
     m_robotContainer.setDefaultDrive();
     m_robotContainer.setDefaultIntake();

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // //i may have screwed this up
    if (backAuto != null) {
      backAuto.end(true);
    }

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
