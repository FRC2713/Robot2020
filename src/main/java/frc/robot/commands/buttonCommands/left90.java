//class is for command to turn the robot 90 degrees left

package frc.robot.commands.buttonCommands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.newMoveCommands.gyroTurnLeft;

public class left90 {

  private DriveSubsystem m_DS;
  private double turnFactor = 90;


  public left90(DriveSubsystem driveSubsystem) {
    m_DS = driveSubsystem;
  }

  //drive = new DriveSubsystem();


  public void turnLeft90() {
   /* if(!gyroLeft.isFinished()) { //it should! in theory! im not 100% sure how commands work outside of command groups
      gyroLeft.execute(); //yeah i do think you guys would be better off maybe just finding a way to directly find a way to use command
      System.out.println("Charles is it working :smerk:");
    } */
    gyroTurnLeft gyroLeft = new gyroTurnLeft(turnFactor, m_DS);
   // }
  }

}
