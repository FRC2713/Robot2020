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
  private static final I2C.Port i2cPort = I2C.Port.kOnboard;
  public static int getEncoderConstant() {
    return 2;
  }

  //Config Jumpers
  public static final int configOnePort = 0;
  public static final int configTwoPort = 1;
  public static final int configThreePort = 2;

  //Motors
  public static final int frontLeftTalonPort = 1; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int backLeftTalonPort = 2; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int frontRightTalonPort = 3; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int backRightTalonPort = 4; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int intakeMotorTalonPort = 5; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int intakeConveyorTalonPort = 5; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static final int IntakeGateUpNode = 2;
  public static final int IntakeGateDownNode = 3;


 // public static final int hatchInNodeId = 2;
 // public static final int hatchOutNodeId = 3;
  public static final int plateCloseNodeId = 4;
  public static final int plateOpenNodeId = 5;

  //Sensors
  public static final int blightSensor = 4; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL

  //Buttons
  public static final int intakeGateUpButtonNum = 5;
  public static final int intakeGateDownButtonNum = 6;

}

