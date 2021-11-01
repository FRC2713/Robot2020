package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.oldMoveCommands.moveBackward;
import frc.robot.commands.oldMoveCommands.moveForward;
import frc.robot.commands.OutputGateCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.ToggleGate;

public class experimentalScoreFront extends SequentialCommandGroup {
  public experimentalScoreFront(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
    addCommands(

      new moveBackward(10, driveSubsystem),

      new OutputGateCommand(intakeSubsystem, ToggleGate.OPEN),

      new moveForward(15, driveSubsystem)
    );
  }
}
