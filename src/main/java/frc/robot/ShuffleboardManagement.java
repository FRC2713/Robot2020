package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import java.util.HashMap;
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
  private NetworkTableEntry slewLimit;
  private NetworkTableEntry reversedControls;
  private NetworkTableEntry colorView;
  private PowerDistributionPanel powerPanel;
  private ShuffleboardTab shuffleTab;

  public final HashMap<String, ShuffleboardComponent> widget_map = new HashMap<>();


  public ShuffleboardManagement() {

    shuffleTab = Shuffleboard.getTab("True Tab");
    //powerPanel = new PowerPanel();

    //private shuffleboardTab selectTab = ;

    //public static void selectTab();

        /*SlewRateLimiter filter = new SlewRateLimiter(0.5);
    filter.calculate(input);
    */

    //SmartDashboard.putBoolean("Driving Reverse", xbox.getBButtonPressed());
    //SmartDashboard.putNumber("Slew Limit", joystickChangeLimit);
    /**Below are the updated versions of above **/

    slewLimit = shuffleTab
      .add("Slew Limit", 0)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 10))
      .getEntry();

    reversedControls = shuffleTab
      .add("Reversed Controls", false)
      .withWidget("Boolean Box")
      .withProperties(Map.of("colorWhenTrue", "green", "colorWhenFalse", "red"))
      .getEntry();
    reversedControls.setBoolean(true);

  /*  colorView = shuffleTab
      .add("Color Sensor", )
      .withWidget(BuiltInWidgets.kGraph)
      .withProperties(Map.of("colorWhenNone", "White", "colorWhenSeeing", "h"))
      .getEntry();
*/

      //kEncoder or  kPIDController //speed
    //kMecanumDrive camera
  }
  //public void createWidget(String widgetName) {
    //if () {

    //}
  //}
  public void setReversedControlValue(boolean value) {
    reversedControls.setBoolean(value);
  }
  public boolean getReversedControlValue() {
    return reversedControls.getBoolean(false);
  }
  public void getSlewLimit(double value) {
    slewLimit.setDouble(value);
  }
  public double getSlewLimit() {
    return slewLimit.getDouble(0);
  }
  public void CreateWidget(String name) {
    //widget_map.put(name,null);

   // for(ShuffleboardComponent widgetComponent : shuffleTab.getComponents()) {
     // widgetComponent.getTitle();
      //widget_map.put(name,);
    }


    }
    //get all widget tabs, make for each loop, if match store in map, else create widget and store in map
  //}
