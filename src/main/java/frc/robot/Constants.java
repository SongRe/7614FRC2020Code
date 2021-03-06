/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int leftMasterPort = 0; //left side of the drive train master motor
    public static final int leftSlavePort = 1;  //left side of drive train slave motor (there are two motors per side of the drivetrain)

    public static final int rightMasterPort = 4;  //same thing but for right
    public static final int rightSlavePort = 6;

    public static final int joystickPort = 0;

    public static final int armPort = 2;
    public static final int intakePort = 5;
    public static final int climbPort = 3;
    public static final int spinPort=7;

    public static final int leftEnc1 = 0;
    public static final int leftEnc2 = 1;
    public static final int rightEnc1 = 2;
    public static final int rightEnc2 = 3;


    //Multiple Modules, define both the port number and the module. For example:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    //PWM cable

    //DIO (digital input output)

    //CAN (bus) Idk what this is

    //USB ports

    //Other constants
    public static double intakeSpeed = 1;
    public static double generalSpeed = 0.5;
    public static double armSpeed = 0.5;

    //Constants
    //example: 
    // public static int driveSpeed = 100;

   //xbox controller
        // Digital
        public static final int BUTTON_A = 1;
        public static final int BUTTON_B = 2;
        public static final int BUTTON_X = 3;
        public static final int BUTTON_Y = 4; 

        public static final int START=8;
        public static final int BACK=7;

    
        
        public static final int TRIGGER_R = 6;
        public static final int TRIGGER_L = 5;
		
    






    
}
