package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.SMDrive;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */



  /*Creates motors, getting motor controller (CANSparkMax) ports from RobotMap
  * MAKE SURE TEST BED IS SET TO BRUSHED*/
  public final CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  private final CANSparkMax backLeft = new CANSparkMax(RobotMap.backLeftTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  private final CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  private final CANSparkMax backRight = new CANSparkMax(RobotMap.backRightTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);

  //Differential drive coordinates motors, used for tank + arcade drive
  public SMDrive driveCommand = new SMDrive(this);
  public DifferentialDrive roboDrive = new DifferentialDrive(frontLeft, frontRight);

  public DriveSubsystem() {
    Robot.initializeSparkDefaults(frontLeft, frontRight);
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    roboDrive.setDeadband(RobotMap.DEADBAND);
    setDefaultCommand(driveCommand);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Given a target number, current number, and increment, adjust current number by increment until we reach target
   * This is useful particularly in {@link frc.robot.commands.SMDrive} where we need to ramp up to user input to avoid jerkiness
   *
   * @param target The number you eventually want to get to (ie. joystick speed)
   * @param current The current number you are at (so we know what to start at for the increment)
   * @param increment How much to increase current by until current = target
   *
   * @see <a href="https://en.wikipedia.org/wiki/Slew_rate">Wikipedia article on Slew rates</a>
   * @return Adjusted target
   */
  public static double slewLimit(double target, double current, double increment) {
    increment = Math.abs(increment); // Professionally validating user input right here 👌
    double change = target - current;
    if (Math.abs(current) > Math.abs(target)) return target; // Always slow down immediately for safety concerns
    if (change > increment) { change = increment; }
    else if (change < -increment) { change = -increment; }
    return current + change;
  }

}
