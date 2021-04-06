package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.*;
import frc.robot.subsystems.DriveSubsystem;


public class barrelPathCommand extends SequentialCommandGroup {
  public barrelPathCommand(DriveSubsystem drivesubsystem){
     addCommands(
//Tina Chen Barrel Path

       new goForward(90/12, drivesubsystem),

      new gyroTurnRight(45, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnRight(90, drivesubsystem),

       new goForward(42.426/12, drivesubsystem),

       new gyroTurnRight(90, drivesubsystem),

       new goForward(42.426/12, drivesubsystem),

      new gyroTurnRight(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnRight(45, drivesubsystem),

       new goForward(90/12, drivesubsystem),

      new gyroTurnLeft(45, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(127.279/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new gyroTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

       new gyroTurnLeft(45, drivesubsystem),

      new goForward(240/12, drivesubsystem)
     );
  }
}
