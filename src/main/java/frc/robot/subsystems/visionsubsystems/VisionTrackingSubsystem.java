package frc.robot.subsystems.visionsubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class VisionTrackingSubsystem extends SubsystemBase {
    public final Pixy2 frontPixy;

    public VisionTrackingSubsystem(){
      frontPixy = Pixy2.createInstance(new SPILink()); // creates an instance of the camera
      frontPixy.init(); // initializes and prepares camera to send/receive data (needs to have an int argument *remove after task completed)
    }

    @Override
    public void periodic(){

    }
}
