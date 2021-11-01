package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class VroomCommandWooo extends CommandBase {
  double leftSpeed;
  double rightSpeed;

  private final DriveSubsystem m_DS;

  public VroomCommandWooo(double lSpeed, double rSpeed, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    leftSpeed = lSpeed;
    rightSpeed = rSpeed;
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_DS.vroom(leftSpeed, rightSpeed);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
