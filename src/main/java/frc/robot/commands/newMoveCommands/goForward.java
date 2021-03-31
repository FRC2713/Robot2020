package frc.robot.commands.newMoveCommands;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class goForward extends CommandBase {
//  double originalDist = 0;
//  double newDist = 0;
  double leftDist = 0;
  double rightDist = 0;
  double accumulatedDist = 0;
  double error = 1;
  final double ACCEL_CONSTANT = 0.006; //0.02 will bring speed from 0 to 1 in 1 second; scales linearly
  double SLEW_DIST = 5; //Determines how much distance the robot is given to slow down, in feet - will always be equal to the time taken to speed up.
  double leftSpeed = 0;
  double rightSpeed = 0;
  double targetDist = 0;
  CANEncoder encoder1;
  CANEncoder encoder2;

  private final DriveSubsystem m_DS;

  public goForward(double distanceToTravel, DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
    targetDist = distanceToTravel;
    addRequirements(driveSubsystem); //establishes drive subsystem as subsystem used
  }

  @Override
  public void initialize() {
    encoder1 = m_DS.getEncoder(1);
    encoder2 = m_DS.getEncoder(2);
//    originalDist = m_DS.toFeet(encoder1.getPosition());
//    newDist = originalDist;
    leftDist = 0;
    m_DS.resetEncoder(encoder1);
//    m_DS.resetEncoder(encoder2);
    if(SLEW_DIST > (targetDist/2)) {
      SLEW_DIST = targetDist/2;
    }

  }

  @Override
  public void execute()
  {
//    newDist = encoder1.getPosition();
    leftDist = Math.abs(m_DS.improvedEncoderDist(encoder1));
//    rightDist = Math.abs(m_DS.improvedEncoderDist(encoder2));
    accumulatedDist = /*(leftDist + rightDist)/2;*/ leftDist;
//    error = leftDist/rightDist;
    System.out.println("Traveled " + accumulatedDist + " Feet");
    if (accumulatedDist < (targetDist-SLEW_DIST))
    {
      if (leftSpeed < 1)
      {
      leftSpeed += ACCEL_CONSTANT;
      rightSpeed += ACCEL_CONSTANT;
      }
    }
    else
      {
        if(leftSpeed > ACCEL_CONSTANT)
        {
          leftSpeed -= ACCEL_CONSTANT;
          rightSpeed -= ACCEL_CONSTANT;
        }
        else
          {
            accumulatedDist = targetDist + 1;
          }
      }
    m_DS.getRoboDrive().tankDrive(leftSpeed, rightSpeed);
//    if(m_DS.printIterator() == true) {
  //  }
  }

  @Override
  public boolean isFinished() {
    if (accumulatedDist >= targetDist) { //if traveled more than target amount of feet, stop motors and end autonomous
      m_DS.getRoboDrive().stopMotor();
      Timer.delay(0.25);
      return true;
    }
    else return false;
  }
}
