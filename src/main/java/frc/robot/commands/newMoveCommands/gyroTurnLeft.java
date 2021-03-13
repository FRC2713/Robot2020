package frc.robot.commands.newMoveCommands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class gyroTurnLeft extends CommandBase {
  private double targetAngle;
  private double currentAngle;
  private double originalAngle;
  final double ACCEL_CONSTANT = 0.02;
  double SLEW_DIST = 0;
  private double rightSpeed = 0;
  private double leftSpeed = 0;
  ADXRS450_Gyro gyro;

  private final DriveSubsystem m_DS;

  public gyroTurnLeft(double Angle, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    addRequirements(driveSubsystem);
    gyro = m_DS.getGyro();
    targetAngle = gyro.getAngle() - (Angle * 0.8);
  }

  @Override
  public void initialize() {
//    gyro.reset();
//    gyro.calibrate();
    currentAngle = gyro.getAngle();
    originalAngle = currentAngle;
    System.out.println("Initial Angle: " + currentAngle);
  }

  @Override
  public void execute() {
    currentAngle = gyro.getAngle() - originalAngle;
    if (currentAngle < targetAngle-SLEW_DIST) {
      if(leftSpeed > -1) {
        leftSpeed -= ACCEL_CONSTANT;
        rightSpeed += ACCEL_CONSTANT;
        SLEW_DIST = currentAngle;
      }
    }
    else {
      if(leftSpeed > ACCEL_CONSTANT) {
        leftSpeed += ACCEL_CONSTANT;
        rightSpeed -= ACCEL_CONSTANT;
      }
      else {
        currentAngle = targetAngle + 1;
      }
    }
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    System.out.println("Turned " + currentAngle + " degrees left");
  }

  @Override
  public boolean isFinished() {
    if (currentAngle <= targetAngle) {
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
      return true;
    }
    else return false;
  }
}
