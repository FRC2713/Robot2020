package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.*;
import frc.robot.subsystems.DriveSubsystem;


public class barrelPathCommand extends SequentialCommandGroup {
  public barrelPathCommand(DriveSubsystem drivesubsystem){
     addCommands(
//Tina Chen Barrel Path
       new goForward(110/12, drivesubsystem),

       new gyroTurnRight(45, drivesubsystem),

       new goForward(46.426/12, drivesubsystem),

       new gyroTurnRight(90, drivesubsystem),

       new goForward(50.426/12, drivesubsystem),

       new gyroTurnRight(90, drivesubsystem),

       new goForward(50.426/12, drivesubsystem),

       new gyroTurnRight(90, drivesubsystem),

       new goForward(50.426/12, drivesubsystem), //finished first loop

       new gyroTurnRight(37, drivesubsystem), //should be parallel to start

       new goForward(98/12, drivesubsystem), //second straight

       new gyroTurnLeft(45, drivesubsystem),

       new goForward(46.426/12, drivesubsystem),

       new gyroTurnLeft(90, drivesubsystem),

       new goForward(54.426/12, drivesubsystem),

       new gyroTurnLeft(90, drivesubsystem),

       new goForward(56.426/12, drivesubsystem),

       new gyroTurnLeft(80, drivesubsystem), //second loop finished

       new goForward(139.279/12, drivesubsystem), //moving to third loop

       new gyroTurnLeft(90, drivesubsystem),

       new goForward(50.426/12, drivesubsystem),

       new gyroTurnLeft(90, drivesubsystem),

       new goForward(50.426/12, drivesubsystem),

       new gyroTurnLeft(21, drivesubsystem),

       new goForward(216/12, drivesubsystem) //all the way home :D
     );
  }
}
