package frc.robot.commands.newMoveCommands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class gyroTurnLeft extends CommandBase {
  private double targetAngle;
  private double currentAngle;
  private double originalAngle;
  final double ACCEL_CONSTANT = 0.003;
  double SLEW_DIST = 45;
  private double rightSpeed = 0;
  private double leftSpeed = 0;
  ADXRS450_Gyro gyro;

  private final DriveSubsystem m_DS;

  public gyroTurnLeft(double Angle, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    addRequirements(driveSubsystem);
    gyro = m_DS.getGyro();
    targetAngle = Angle;
  }

  @Override
  public void initialize() {
//    gyro.reset();
//    gyro.calibrate();
    currentAngle = gyro.getAngle();
    originalAngle = currentAngle;
    if (m_DS.printIterator() == true) {
      System.out.println("Initial Angle: " + currentAngle);
    }

    if(SLEW_DIST > (targetAngle/2)) {
      SLEW_DIST = targetAngle/2;
    }
  }

  @Override
  public void execute() {
    currentAngle = gyro.getAngle() - originalAngle;
    if (Math.abs(currentAngle) < (targetAngle-SLEW_DIST)) {
      if(leftSpeed > -0.5) {
        leftSpeed -= ACCEL_CONSTANT;
        rightSpeed += ACCEL_CONSTANT;
      }
    }
    else {
      if(leftSpeed < ACCEL_CONSTANT) {
        leftSpeed += ACCEL_CONSTANT;
        rightSpeed -= ACCEL_CONSTANT;
      }
      else {
        currentAngle = targetAngle + 1;
      }
    }
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    if (m_DS.printIterator() == true) {
      System.out.println("Turned " + currentAngle + " degrees left");
    }

  }

  @Override
  public boolean isFinished() {
    if (Math.abs(currentAngle) >= targetAngle) {
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
      return true;
    }
    else return false;
  }
}
