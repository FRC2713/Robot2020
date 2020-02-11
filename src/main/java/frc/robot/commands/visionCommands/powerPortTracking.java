package frc.robot.commands.visionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.visionSubsystems.FrontPixySubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;

import java.util.ArrayList;

public class powerPortTracking extends CommandBase {
  private FrontPixySubsystem frontPixySubsystem;

  public powerPortTracking(FrontPixySubsystem frontPixySubsystem) {
    this.frontPixySubsystem = frontPixySubsystem;
    addRequirements(frontPixySubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    int blocksDetected = frontPixySubsystem.frontPixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG2, 10);
    if (blocksDetected <= 0) {
      System.out.println("No signatures detected");
    }
    else {
      System.out.println(blocksDetected + " blocks detected");
    }
    ArrayList<Pixy2CCC.Block> blocks = frontPixySubsystem.frontPixy.getCCC().getBlocks();
    Pixy2CCC.Block block = null;
    double blockRatio = block.getWidth() / block.getHeight();
    System.out.println("Block Ratio : " + blockRatio);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
