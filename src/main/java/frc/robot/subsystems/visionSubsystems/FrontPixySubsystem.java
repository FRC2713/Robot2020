package frc.robot.subsystems.visionSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.visionCommands.powerPortTracking;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.SPILink;
import frc.robot.commands.visionCommands.frontPixyDisplay;

public class FrontPixySubsystem extends SubsystemBase {

  public final Pixy2 frontPixy;

  private powerPortTracking PPT = new powerPortTracking(this);
  private frontPixyDisplay FPD = new frontPixyDisplay(this);

  public FrontPixySubsystem() {

    frontPixy = Pixy2.createInstance(new SPILink());
    frontPixy.init(); // initializes and prepares camera to send/receive data (needs to have an int argument *remove part of comment after task completed)
    setDefaultCommand(PPT); // sets powerPortTracking to the default command
  }

  public void initDisplay() {
    FPD.execute();
  }

  public Pixy2 getFrontPixy() {
    return frontPixy;
  }

  @Override
  public void periodic() {

  }
}