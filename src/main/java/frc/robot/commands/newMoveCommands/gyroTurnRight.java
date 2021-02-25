package frc.robot.commands.newMoveCommands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class gyroTurnRight extends CommandBase {
  private double targetAngle;
  private double currentAngle;
  private double originalAngle;
  private double rightSpeed;
  private double leftSpeed;
  ADXRS450_Gyro gyro;

  private final DriveSubsystem m_DS;

  public gyroTurnRight( double Angle, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    targetAngle = Angle;
    addRequirements(driveSubsystem);
    gyro = m_DS.getGyro();
  }

  @Override
  public void initialize() {
    gyro.reset();
    currentAngle = gyro.getAngle();
    originalAngle = currentAngle;
  }

  @Override
  public void execute() {
    leftSpeed = 0.25;
    rightSpeed = -0.25;
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    currentAngle = Math.abs(gyro.getAngle());
    System.out.println("Turned " + currentAngle + " degrees left");
  }

  @Override
  public boolean isFinished() {
    if (currentAngle >= targetAngle) {
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
      return true;
    }
    else return false;
  }
}
