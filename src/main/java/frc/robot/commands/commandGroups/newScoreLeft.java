package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.moveCommands.moveBackward;
import frc.robot.commands.moveCommands.moveForward;
import frc.robot.commands.moveCommands.turnLeft45;
import frc.robot.commands.moveCommands.turnRight45;
import frc.robot.commands.outputGateCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class newScoreLeft extends SequentialCommandGroup {
  public newScoreLeft(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
    addCommands(
      new moveForward(9.92, driveSubsystem),

      new turnLeft45(driveSubsystem, 30),

      new outputGateCommand(intakeSubsystem),

      new turnRight45(driveSubsystem, 30),

      new moveBackward(8, driveSubsystem),

      new noCoronaCommand()
    );
  }
}
