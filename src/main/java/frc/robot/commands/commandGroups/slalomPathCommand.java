package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.*;
import frc.robot.subsystems.DriveSubsystem;

public class slalomPathCommand extends SequentialCommandGroup {
  public slalomPathCommand(DriveSubsystem drivesubsystem) {

    //slalom path
    addCommands(

      new gyroTurnLeft(45, drivesubsystem),

      new goForward(76.011/12, drivesubsystem),

      new gyroTurnRight(45, drivesubsystem),

      new goForward(132.504/12, drivesubsystem),

      new gyroTurnRight(45, drivesubsystem),

      new goForward(76.011/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(75.06/12, drivesubsystem),

      new gyroTurnRight(45, drivesubsystem),

      new goForward(133.849/12, drivesubsystem),

      new gyroTurnRight(45, drivesubsystem),

      new goForward(75.08/12, drivesubsystem)
    );

  }
}
