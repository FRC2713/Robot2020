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
public final class RobotMap {

  // Config
  public static final int MAX_MOTOR_FREE_AMPS = 80;
  public static final int MAX_MOTOR_STALL_AMPS = 40;
  public static final double DEADBAND = 0.04;
  public static final float REGULAR_SPEED = .8f;

  //Motors
  public static int frontLeftTalonPort = 1; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int backLeftTalonPort = 2; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int frontRightTalonPort = 3; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL
  public static int backRightTalonPort = 4; //NEEDS TO BE CHANGED WHEN PORTS ARE OFFICIAL

}

