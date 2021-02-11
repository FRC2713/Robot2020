package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.encoderTurnLeft;
import frc.robot.commands.newMoveCommands.encoderTurnRight;
import frc.robot.commands.newMoveCommands.goBackward;
import frc.robot.commands.newMoveCommands.goForward;
import frc.robot.subsystems.DriveSubsystem;

public class calibrateAutonomous extends SequentialCommandGroup {
  public calibrateAutonomous(DriveSubsystem drivesubsystem) {
    addCommands( //comment out/edit unneeded commands as necessary - don't delete any :)
      new goForward(1, drivesubsystem)

      //new goBackward(10, drivesubsystem),

      //new encoderTurnLeft(720, drivesubsystem),

      //new encoderTurnRight(720, drivesubsystem)
    );
  }
}
