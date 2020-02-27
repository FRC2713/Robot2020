package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class AutoA extends SequentialCommandGroup {
  public AutoA(DriveSubsystem driveSubsystem) {
    addCommands(
    //move forward 10 feet
      new AutonomousCommand(driveSubsystem),
    //turn left 45 degrees
      new turnLeft45(driveSubsystem),
      //turn right 45 degrees
      new turnRight45(driveSubsystem)
    );
  }
}
