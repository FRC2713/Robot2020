package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LightSensor {

  public DigitalInput blightSensor = new DigitalInput(RobotMap.lightSensor);

  public  boolean isTripped() {
    return !blightSensor.get();
  }

  public void printOut() {
    System.out.println("LIGHT SENSOR OUTPUT:" + isTripped());
  }
  }
