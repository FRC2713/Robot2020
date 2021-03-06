package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.*;
import frc.robot.subsystems.DriveSubsystem;

public class calibrateAutonomous extends SequentialCommandGroup {
  public calibrateAutonomous(DriveSubsystem drivesubsystem) {
    addCommands( //comment out/edit unneeded commands as necessary - don't delete any :
      new goForward(10, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new gyroTurnRight(90, drivesubsystem)
    );
  }
}
