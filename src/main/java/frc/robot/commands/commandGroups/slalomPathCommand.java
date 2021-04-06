package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.encoderTurnLeft;
import frc.robot.commands.newMoveCommands.encoderTurnRight;
import frc.robot.commands.newMoveCommands.goForward;
import frc.robot.subsystems.DriveSubsystem;

public class slalomPathCommand extends SequentialCommandGroup {
  public slalomPathCommand(DriveSubsystem drivesubsystem) {
    addCommands(
      new goForward(2, drivesubsystem),

      new encoderTurnLeft(55, drivesubsystem),

      new goForward((76.011-4)/12, drivesubsystem),

      new encoderTurnRight(55, drivesubsystem),

      new goForward(9+10.5/12, drivesubsystem),//first long straight

      new encoderTurnRight(60, drivesubsystem),

      new goForward(76.011/12+2, drivesubsystem),//go between cones

      new encoderTurnLeft(90, drivesubsystem),//first turn around top

      new goForward(42.426/12, drivesubsystem),//drive to top

      new encoderTurnLeft(90, drivesubsystem),//turn at top

      new goForward(61.526/12, drivesubsystem),

      new encoderTurnLeft(106, drivesubsystem),

      new goForward(93.06/12, drivesubsystem),

      new encoderTurnRight(54, drivesubsystem),

      new goForward(118.849/12, drivesubsystem),//final long straight back

      new encoderTurnRight(65, drivesubsystem),

      new goForward(97.08/12, drivesubsystem)
    );

  }
}
