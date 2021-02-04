package frc.robot.commands.newMoveCommands;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class goBackward extends CommandBase {
  double originalDist = 0;
  double newDist = 0;
  double accumulatedDist = 0;
  double leftSpeed = 0;
  double rightSpeed = 0;
  double targetDist = 0;
  CANEncoder encoder1;

  private final DriveSubsystem m_DS;

  public goBackward(double distanceToTravel, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    targetDist = distanceToTravel;
    addRequirements(driveSubsystem); //establishes drive subsystem as subsystem used
    accumulatedDist = 0;
  }

  @Override
  public void initialize() {
    encoder1 = m_DS.getEncoder(1);
    originalDist = m_DS.toFeet(encoder1.getPosition());
    newDist = originalDist;
    m_DS.resetEncoder(encoder1);
  }

  @Override
  public void execute() {
    System.out.println("Execute loop");
    leftSpeed = 0.5;
    rightSpeed = 0.5;
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    newDist = encoder1.getPosition();
    accumulatedDist = m_DS.improvedEncoderDist(encoder1); //adds old distance to encoder input, translated to feet;
    System.out.println("Should be moving right now");
    System.out.println("Traveled " + accumulatedDist + " Feet");
  }

  @Override
  public boolean isFinished() {
    if (accumulatedDist > targetDist) { //if traveled more than target amount of feet, stop motors and end autonomous
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
      return true;
    }
    else return false;
  }
}
