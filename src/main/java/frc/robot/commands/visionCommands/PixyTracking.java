package frc.robot.commands.visionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class PixyTracking extends CommandBase {

  private final PixySubsystem m_pixySubsystem;

  Pixy2CCC.Block block;

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
    blockCount = m_pixySubsystem.pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 10);
    SmartDashboard.putNumber("Block Count", blockCount);

    block = null;
    blockWidth = block.getWidth();
    blockHeight = block.getHeight();

    System.out.println("Block Width : " + blockWidth); // delete after testing
    System.out.println("Block Height :" + blockHeight); // delete after testing
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
