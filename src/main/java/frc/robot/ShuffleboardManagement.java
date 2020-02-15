package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import java.util.Map;

public class ShuffleboardManagement {

  private static ShuffleboardManagement defaultInstance = null;

  public static ShuffleboardManagement getInstance() {
    if(defaultInstance == null)
    {
      defaultInstance = new ShuffleboardManagement();
    }
    return defaultInstance;
  }
  public NetworkTableEntry slewLimit;
  public NetworkTableEntry reversedControls;

  public ShuffleboardManagement() {

        /*SlewRateLimiter filter = new SlewRateLimiter(0.5);
    filter.calculate(input);
    */

    //SmartDashboard.putBoolean("Driving Reverse", xbox.getBButtonPressed());
    //SmartDashboard.putNumber("Slew Limit", joystickChangeLimit);
    /**Below are the updated versions of above **/
    slewLimit = Shuffleboard.getTab("Test")
      .add("Slew Limit", true)
      .withWidget("Toggle Button")
      .getEntry();

    reversedControls = Shuffleboard.getTab("Test")
      .add("Reversed Controls", false)
      .withWidget("Boolean Box")
      .withProperties(Map.of("colorWhenTrue", "green", "colorWhenFalse", "red"))
      .getEntry();
    reversedControls.setBoolean(true);

  }
  public void setReversedControlValue(boolean value) {
    reversedControls.setBoolean(value);
  }
  public boolean getReversedControlValue() {
    return reversedControls.getBoolean(false);
  }
}
