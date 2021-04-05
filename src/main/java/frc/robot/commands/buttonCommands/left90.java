//class is for command to turn the robot 90 degrees left

package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.newMoveCommands.gyroTurnLeft;

public class left90 extends CommandBase {

  ADXRS450_Gyro gyro;
  DriveSubsystem drive = new DriveSubsystem();
  private double turnFactor = 90;
  gyroTurnLeft gyroLeft = new gyroTurnLeft(turnFactor, drive);

  public left90() {

  }

  public void turnLeft90() {
//turn code goes here

  if(!gyroLeft.isFinished()) {
    gyroLeft.execute(); //yeah i do think you guys would be better off maybe just finding a way to directly find a way to use command
    System.out.println("Charles is it working :smerk:");
  }

  gyroLeft.isFinished();

  }

}
