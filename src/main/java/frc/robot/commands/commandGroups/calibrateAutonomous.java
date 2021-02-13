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
      //new goForward(10, drivesubsystem)

      //new goBackward(10, drivesubsystem)

      new encoderTurnLeft(90, drivesubsystem)

      //new encoderTurnRight(720, drivesubsystem)

      //Barrel Path

      /*new goForward(90.0/12, drivesubsystem),

      new encoderTurnRight(45, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnRight(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnRight(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnRight(45, drivesubsystem),

      new goForward(90.0/12, drivesubsystem),

      new encoderTurnLeft(45, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(127.279/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(45, drivesubsystem),

      new goForward(240/12, drivesubsystem)*/

      //Slalom

      /*new encoderTurnLeft(45, drivesubsystem),

      new goForward(76.011/12, drivesubsystem),

      new encoderTurnRight(45, drivesubsystem),

      new goForward(132.504/12, drivesubsystem),

      new encoderTurnRight(45, drivesubsystem),

      new goForward(76.011/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(42.426/12, drivesubsystem),

      new encoderTurnLeft(90, drivesubsystem),

      new goForward(75.06/12, drivesubsystem),

      new encoderTurnRight(45, drivesubsystem),

      new goForward(133.849/12, drivesubsystem),

      new encoderTurnRight(45, drivesubsystem),

      new goForward(75.08/12, drivesubsystem)*/







    );
  }
}
