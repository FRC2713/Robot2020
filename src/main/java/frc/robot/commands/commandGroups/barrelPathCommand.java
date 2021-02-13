package frc.robot.commands.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.newMoveCommands.encoderTurnLeft;
import frc.robot.commands.newMoveCommands.encoderTurnRight;
import frc.robot.commands.newMoveCommands.goForward;
import frc.robot.subsystems.DriveSubsystem;


public class barrelPathCommand extends SequentialCommandGroup {
  public barrelPathCommand(DriveSubsystem drivesubsystem){
     addCommands(

      new goForward(42.67/12, drivesubsystem),

      new encoderTurnRight(30, drivesubsystem),

      new goForward(64.64/12, drivesubsystem),

      new encoderTurnLeft(30, drivesubsystem),

      new goForward(150.0/12, drivesubsystem),

      new encoderTurnLeft(60, drivesubsystem),

      new goForward(60.0/12, drivesubsystem),

      new encoderTurnRight(60, drivesubsystem),

      new goForward(30.0/12, drivesubsystem),

      new encoderTurnRight(60, drivesubsystem),

      new goForward(30.0/12, drivesubsystem),

      new encoderTurnRight(60, drivesubsystem),

      new goForward(30.0/12, drivesubsystem),

      new encoderTurnRight(60, drivesubsystem),

      new goForward(30.0/12, drivesubsystem),

      new encoderTurnRight(60, drivesubsystem),

      new goForward(60.0/12, drivesubsystem),

      new encoderTurnLeft(60, drivesubsystem),

      new goForward(150.0/12, drivesubsystem),

      new encoderTurnLeft(60, drivesubsystem),

      new goForward(64.641/12, drivesubsystem),

      new encoderTurnRight(60, drivesubsystem),

      new goForward(42.67/12, drivesubsystem)

    );
  }
}
