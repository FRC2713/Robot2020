package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.moveCommands.AutonomousCommand;
import frc.robot.commands.moveCommands.turnLeft45;
import frc.robot.commands.moveCommands.turnRight45;
import frc.robot.subsystems.DriveSubsystem;

public class initLineOnly extends SequentialCommandGroup {
  public initLineOnly(DriveSubsystem driveSubsystem) {
    addCommands(
    //move forward 10 feet
      new AutonomousCommand(driveSubsystem),
    //turn left 45 degrees
      new turnLeft45(driveSubsystem, 45),
      //turn right 45 degrees
      new turnRight45(driveSubsystem, 45)
    );
  }
}
