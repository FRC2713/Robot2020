package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeGateCommand;
import frc.robot.commands.oldMoveCommands.moveForward8Feet;
import frc.robot.commands.oldMoveCommands.turnLeft45;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class scoreLeft extends SequentialCommandGroup {
  public scoreLeft(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, IntakeGateCommand intakeGateCommand) {
    addCommands(

      new moveForward8Feet(driveSubsystem),

      new turnLeft45(driveSubsystem, 90),

      new experimentalScoreFront(driveSubsystem, intakeSubsystem)
    );
  }
}
