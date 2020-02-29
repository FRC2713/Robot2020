package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.moveCommands.moveForward8Feet;
import frc.robot.commands.moveCommands.turnLeft45;
import frc.robot.subsystems.DriveSubsystem;

public class scoreLeft extends SequentialCommandGroup {
  public scoreLeft(DriveSubsystem driveSubsystem) {
    addCommands(

      new moveForward8Feet(driveSubsystem),

      new turnLeft45(driveSubsystem),

      new turnLeft45(driveSubsystem),

      new scoreFront(driveSubsystem)
    );
  }
}
