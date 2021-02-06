package frc.robot.commands.visionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import edu.wpi.first.wpilibj.smartdashboard.*;
import java.util.ArrayList;

public class PixyTracking extends CommandBase {

  private final PixySubsystem m_pixySubsystem;

  int blockCountS1;
  int blockWidth;
  int blockHeight;
  double aspectRatio;
  double distanceInFeet;
  double focalLength;

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
    // blockCountS1 = m_pixySubsystem.pixy.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 1); // change 1 to 10 or something later

    ArrayList<Pixy2CCC.Block> blocks = m_pixySubsystem.getPixy().getCCC().getBlocks();

    if (blocks == null) {
      System.out.println("No blocks");
      return;
    }

    for (Pixy2CCC.Block block : blocks) {
      blockWidth = block.getWidth();
      blockHeight = block.getHeight();
      aspectRatio = (double)blockWidth / (double)blockHeight;
      System.out.println("Aspect Ratio : " + aspectRatio);

      // max height 207
      // max width 315
      if(aspectRatio >= 0.9 && aspectRatio <= 1.6) {
        // loading bay target
        focalLength = (74 * 60) / 7.0;
        distanceInFeet = (7 * focalLength) / blockWidth;
        System.out.println("Distance : " + distanceInFeet);
      }
      // else if(aspectRatio == ) {
        // power port target
        // focalLength = () /
        // distanceInFeet = ( * focalLength) /
        // System.out.println("Distance from object : " + distanceInFeet);
        // System.out.println("Block Width : " blockWidth);
      // }
    }
  }

  @Override
  public boolean isFinished() {
    return false;

  }
}
