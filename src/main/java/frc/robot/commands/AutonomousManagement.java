package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;


public class AutonomousManagement {
  public final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  public final AutoA autonomous1 = new AutoA(m_driveSubsystem);

  /* So basically, this class is gonna be where we figure out what commands are used, and when. */
  public void autoMaster() {
    if (1 == 1/*set for now; will be when rotary switch is set; idk how this actually works in practice*/) {
    } else {
      //run autonomous B
    }
  }
}
