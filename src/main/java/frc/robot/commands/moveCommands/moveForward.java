package frc.robot.commands.moveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class moveForward extends CommandBase {
  double originalDist = 0;
  double newDist = 0;
  double accumulatedDist = 0;
  double leftSpeed = 0;
  double rightSpeed = 0;
  double targetDist = 0;
  double distanceRatio = 0;



  private final DriveSubsystem m_driveSubsystem;

  public moveForward(double distanceToTravel, DriveSubsystem driveSubsystem) {
    m_driveSubsystem = driveSubsystem;
    targetDist = distanceToTravel;
    addRequirements(driveSubsystem); //establishes drive subsystem as subsystem used
    accumulatedDist = 0;
  }

  @Override
  public void initialize() {
    originalDist = m_driveSubsystem.toFeet(m_driveSubsystem.getEncoder(1).getPosition());
    newDist = originalDist;
    m_driveSubsystem.resetEncoder(m_driveSubsystem.getEncoder(1));
  }

  @Override
  public void execute() {
    distanceRatio = accumulatedDist/targetDist;
    System.out.println("This got to execute");
    if (distanceRatio <= 0.1) {
      rightSpeed = -5*distanceRatio;
      leftSpeed = -5*distanceRatio;
    } else if (distanceRatio >= 0.8) {
      leftSpeed = 2.5*distanceRatio - 2.5;
    } else {leftSpeed = -0.5; rightSpeed = -0.5;}
    m_driveSubsystem.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
    newDist = m_driveSubsystem.getEncoder(1).getPosition();
    accumulatedDist += -((m_driveSubsystem.toFeet(m_driveSubsystem.encoderDistance(m_driveSubsystem.getEncoder(1))))+ (m_driveSubsystem.toFeet(m_driveSubsystem.encoderDistance(m_driveSubsystem.getEncoder(2))))/2); //adds old distance to encoder input, translated to feet;
    System.out.println("It should be moving right now");
    System.out.println("Traveled " + accumulatedDist + "Feet");
  }

  @Override
  public boolean isFinished() {
    if (distanceRatio >= 1) { //if traveled more than 10 feet, end autonomous
      m_driveSubsystem.getRoboDrive().stopMotor();
      return true;
    }
    else return false;
  }
}
