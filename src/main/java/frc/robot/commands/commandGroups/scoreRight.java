package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeGateCommand;
import frc.robot.commands.moveCommands.moveForward15Feet;
import frc.robot.commands.moveCommands.turnRight45;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class scoreRight extends SequentialCommandGroup {
  public scoreRight(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, IntakeGateCommand intakeGateCommand) {
    addCommands(

      new moveForward15Feet(driveSubsystem),

      new turnRight45(driveSubsystem),

      new turnRight45(driveSubsystem),

      new scoreFront(driveSubsystem, intakeSubsystem, intakeGateCommand)
    );
  }

}
