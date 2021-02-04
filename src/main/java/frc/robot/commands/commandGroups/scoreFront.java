package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeGateCommand;
import frc.robot.commands.oldMoveCommands.moveBackwards10Feet;
import frc.robot.commands.oldMoveCommands.moveForward15Feet;
import frc.robot.commands.outputGateCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class scoreFront extends SequentialCommandGroup {
  public scoreFront(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem, IntakeGateCommand intakeGateCommand) {
    addCommands(

      new moveBackwards10Feet(driveSubsystem),

      new outputGateCommand(intakeSubsystem),

      new moveForward15Feet(driveSubsystem)
    );
  }
}
