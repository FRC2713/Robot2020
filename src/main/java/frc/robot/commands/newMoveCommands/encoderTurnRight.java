package frc.robot.commands.newMoveCommands;

import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class encoderTurnRight extends CommandBase {
  double originalDist = 0;
  double newDist = 0;
  double accumulatedDist = 0;
  double leftSpeed = 0;
  double rightSpeed = 0;
  double targetAngle = 0;
  CANEncoder encoder1;

  private final DriveSubsystem m_DS;

  public encoderTurnRight(double angle, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    targetAngle = angle;
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
    leftSpeed = 0.25;
    rightSpeed = -0.25;
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    newDist = encoder1.getPosition();
    accumulatedDist = Math.abs(m_DS.improvedEncoderDist(encoder1)); //adds old distance to encoder input, translated to feet;
    System.out.println("Should be moving right now");
    System.out.println("Traveled " + accumulatedDist + " Feet");
  }

  public void turn90(){

    leftSpeed = 0.25;
    rightSpeed = -0.25;
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    newDist = encoder1.getPosition();
    accumulatedDist = Math.abs(m_DS.improvedEncoderDist(encoder1)); //adds old distance to encoder input, translated to feet;

    if (accumulatedDist > targetAngle/53.125) { //Guess-and-checked number
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
    }

  }


  @Override
  public boolean isFinished() {
    if (accumulatedDist > targetAngle/53.125) { //Guess-and-checked number
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
      return true;
    }
    else return false;
  }
}
