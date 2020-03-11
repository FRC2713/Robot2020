package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShuffleboardManagement {

  private static ShuffleboardManagement defaultInstance = null;

  public static ShuffleboardManagement getInstance() {
    if (defaultInstance == null) {
      defaultInstance = new ShuffleboardManagement();
    }
    return defaultInstance;
  }

  public NetworkTableEntry slewLimit;
  public NetworkTableEntry reversedControls;
  private ShuffleboardTab shuffleTab;
  public ShuffleboardManagement() {
    /* This is how to declare HashMap */
    HashMap<Integer, String> hmap = new HashMap<Integer, String>();
    hmap.put(12, "Cool");
    hmap.put(2, "Beans");
    hmap.put(7, "This");
    hmap.put(49, "is");
    hmap.put(3, "Amazing");

    Set set = hmap.entrySet();
    Iterator iterator = set.iterator();
    while(iterator.hasNext()) {
      Map.Entry mentry = (Map.Entry) iterator.next();
      System.out.print("key is: " + mentry.getKey() + " & Value is: ");
      System.out.println(mentry.getValue());
    }

    /* Get values based on key*/
    String var= hmap.get(2);
    System.out.println("Value at index 2 is: "+var);

    /* Remove values based on key*/
    hmap.remove(3);
    System.out.println("Map key and values3 after removal:");
    Set set2 = hmap.entrySet();
    Iterator iterator2 = set2.iterator();
    while(iterator2.hasNext()) {
      Map.Entry mentry2 = (Map.Entry) iterator2.next();
      System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
      System.out.println(mentry2.getValue());
    }



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

  public void getSlewLimit(double value) {
    slewLimit.setDouble(value);
  }

  public double getSlewLimit() {
    return slewLimit.getDouble(0);
  }

  public void CreateWidget(String name) {
    for (ShuffleboardComponent widgetComponent : shuffleTab.getComponents()) {
      if (widgetComponent.getTitle().equals(name)) {
      }
    }
  }
}

