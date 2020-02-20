package frc.robot.commands.visionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import edu.wpi.first.wpilibj.smartdashboard.*;
import java.util.ArrayList;

public class PixyTracking extends CommandBase {

  private final PixySubsystem m_pixySubsystem;

  int blockCount;
  int blockWidth;
  int blockHeight;

  public PixyTracking(PixySubsystem pixySubsystem) {
    m_pixySubsystem = pixySubsystem;
    addRequirements(pixySubsystem);
  }

  @Override
  public void initialize() {
    m_pixySubsystem.pixy.setLamp((byte) 1, (byte) 1);
    m_pixySubsystem.pixy.setLED(255, 255, 255);
  }

  @Override
  public void execute() {
    blockCount = m_pixySubsystem.pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 1); // change 1 to 10 or something later
    SmartDashboard.putNumber("Block Count", blockCount);

    ArrayList<Pixy2CCC.Block> blocks = m_pixySubsystem.getPixy().getCCC().getBlocks();
    System.out.println("count :" + blocks.size());

    if (blocks == null) {
      System.out.println("No blocks");
      return;
    }

    for (Pixy2CCC.Block block : blocks) {
      blockWidth = block.getWidth();
      blockHeight = block.getHeight();

      System.out.println("Block Width : " + blockWidth); // delete after testing
      System.out.println("Block Height :" + blockHeight); // delete after testing
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
