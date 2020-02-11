package frc.robot.commands.visionCommands;

import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.shuffleboard.ComplexWidget;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.subsystems.visionSubsystems.FrontPixySubsystem;

public class frontPixyDisplay extends CommandBase {
  private FrontPixySubsystem frontPixyDisplay;

  public frontPixyDisplay(FrontPixySubsystem frontPixySubsystem){
    this.frontPixyDisplay = frontPixySubsystem;

  }

  @Override
  public void execute(){

  }
  public boolean isFinished(){
    return false;
  }
}
