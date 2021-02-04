package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeGateCommand;
import frc.robot.commands.oldMoveCommands.moveForward;
import frc.robot.commands.oldMoveCommands.turnRight45;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class scoreRight extends SequentialCommandGroup {
  public scoreRight(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, IntakeGateCommand intakeGateCommand) {
    addCommands(

      new moveForward(15, driveSubsystem),

      new turnRight45(driveSubsystem, 45),

      new turnRight45(driveSubsystem, 45),

      new experimentalScoreFront(driveSubsystem, intakeSubsystem)
    );
  }

}
