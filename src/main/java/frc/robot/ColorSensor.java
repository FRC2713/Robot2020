
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.*;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a simple example to show how the REV Color Sensor V3 can be used to
 * detect pre-configured colors.
 */
public class ColorSensor {
  /**
   * Change the I2C port below to match the connection of your color sensor
   */

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  // private XboxController xbox = SM.xBoxController;
  private int color = 0;

  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a
   * parameter. The device will be automatically initialized with default
   * parameters.
   */

  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  /**
   * A Rev Color Match object is used to register and detect known colors. This can
   * be calibrated ahead of time or during operation.
   * <p>
   * This object uses a simple euclidian distance to estimate the closest match
   * with given confidence range.
   */

  public final ColorMatch m_colorMatcher = new ColorMatch();
  public edu.wpi.first.wpilibj.util.Color detectedColor = m_colorSensor.getColor();

  public  ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);


  /**58]0
   * Note: Any example colors should be calibrated as the user needs, these
   * are here as a basic example.
   */


  public final edu.wpi.first.wpilibj.util.Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  public final edu.wpi.first.wpilibj.util.Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  public final edu.wpi.first.wpilibj.util.Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  public final edu.wpi.first.wpilibj.util.Color kYellowTarget =  ColorMatch.makeColor(0.361, 0.524, 0.113);



  public void sensorInit() {

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);


  }


  public void testFunction() {



    /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     *
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the
     * measurements and make it difficult to accurately determine its color.
     */

    /**
     * Run the color match algorithm on our detected color
     */

    //int[] rgb;
    //rgb = new int[] {r,g,b};




  }

  //Brigid 1/27/20
//Returns the color detected
  public String getColor() {
    String colorString;
    edu.wpi.first.wpilibj.util.Color detectedColor = m_colorSensor.getColor();

    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);



    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }


    return colorString;
  }





  public boolean isFinished() {

     //if (getColor() == chosenColor) {

      // return true;


      return false;


  }

}
