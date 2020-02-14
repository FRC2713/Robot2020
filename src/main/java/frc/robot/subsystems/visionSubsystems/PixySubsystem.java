package frc.robot.subsystems.visionSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.visionCommands.PixyTracking;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class PixySubsystem extends SubsystemBase {

  public final Pixy2 pixy;
  public PixyTracking PT = new PixyTracking(this);

  public PixySubsystem() {
    pixy = Pixy2.createInstance(new SPILink());
    pixy.init();
    setDefaultCommand(PT);
  }

  public Pixy2 getPixy() {
    return pixy;
  }
}
