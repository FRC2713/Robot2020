package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.*;
import frc.robot.subsystems.DriveSubsystem;

public class bouncePathCommand extends SequentialCommandGroup{
  public bouncePathCommand(DriveSubsystem drivesubsystem) {

    //bounce path
    addCommands(

      new gyroTurnRight(63.435, drivesubsystem),

      new goForward(67.082, drivesubsystem),

      new gyroTurnLeft(40.601, drivesubsystem),

      new goBackward(123.693, drivesubsystem),

      new gyroTurnLeft(75.964, drivesubsystem),

      new goBackward(30, drivesubsystem),

      new gyroTurnLeft(45, drivesubsystem),

      new goBackward(42.426, drivesubsystem),

      new gyroTurnLeft(45, drivesubsystem),

      new goBackward(90, drivesubsystem),

      new goForward(90, drivesubsystem),

      new gyroTurnLeft(45, drivesubsystem),

      new goForward(42.426, drivesubsystem),

      new gyroTurnLeft(45, drivesubsystem),

      new goForward(60, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(120, drivesubsystem),

      new gyroTurnLeft(45, drivesubsystem),

      new goBackward(42.426, drivesubsystem)

      );


  }
}
