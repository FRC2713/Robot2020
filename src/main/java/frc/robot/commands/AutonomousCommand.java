package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SM;
import frc.robot.subsystems.DriveSubsystem;

public class AutonomousCommand extends CommandBase {
  double originalDist = 0;
  double newDist = 0;
  double accumulatedDist = 0;
  double leftSpeed = 0;
  double rightSpeed = 0;

  private final DriveSubsystem m_driveSubsystem;
  private boolean doAutonomous = false; //controls whether autonomous is activated

  public AutonomousCommand(DriveSubsystem driveSubsystem) {
    m_driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem); //establishes drive subsystem as subsystem used
  }

  @Override
  public void initialize() {
    originalDist = m_driveSubsystem.getEncoder(1).getPosition();
    newDist = originalDist;
  }

  @Override
  public void execute() {
    if (SM.xBoxController.getAButtonPressed()) {
      doAutonomous = !doAutonomous; //if A button is pressed, toggles autonomous
    }
    if (doAutonomous) {
      leftSpeed = 0.25;
      rightSpeed = 0.25;
      m_driveSubsystem.getRoboDrive().tankDrive(leftSpeed,rightSpeed);
      newDist = m_driveSubsystem.getEncoder(1).getPosition();
      accumulatedDist += m_driveSubsystem.toFeet(m_driveSubsystem.encoderDistance(m_driveSubsystem.getEncoder(1))); //adds old distance to encoder input, translated to feet
      System.out.println("I do kinda be moving forward exactly 10 feet tho, not gonna lie");
    }
  }

  @Override
  public boolean isFinished() {
    if (accumulatedDist > 10) { //if traveled more than 10 feet, end autonomous
      m_driveSubsystem.getRoboDrive().stopMotor();
      return true;
    } else return false;
  }
}
