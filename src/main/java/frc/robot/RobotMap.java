/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class RobotMap {

  // Config
  public static final int MAX_MOTOR_FREE_AMPS = 80;
  public static final int MAX_MOTOR_STALL_AMPS = 40;
  public static final double DEADBAND = 0.04;
  public static final float REGULAR_SPEED = .8f;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  public static int getEncoderConstant() {
    return 2;
  }

  //Config Jumpers
  public static final int configOnePort = 0;
  public static final int configTwoPort = 1;
  public static final int configThreePort = 2;

  //Motors
  public static int frontLeftTalonPort = 1; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int backLeftTalonPort = 2; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int frontRightTalonPort = 3; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int backRightTalonPort = 4; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int intakeMotorTalonPort = 5; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int intakeConveyorTalonPort = 5; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int gateSolenoid = 13;
  public static int IntakeGateUpNode = 0;
  public static int IntakeGateDownNode = 1;


 // public static int hatchInNodeId = 2;
 // public static int hatchOutNodeId = 3;
  public static int plateCloseNodeId = 4;
  public static int plateOpenNodeId = 5;

  //Sensors
  public static int blightSensor = 5; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL


  JoystickButton intakeGateButton = new JoystickButton(SM.xBoxController, 5);

  //public static JoystickButton intakeConveyerButton = new JoystickButton(joystick, 5);
//  public static JoystickButton intakeArmButton= new JoystickButton(joystick, 5);

}

