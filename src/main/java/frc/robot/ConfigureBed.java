package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DigitalInput;

public class ConfigureBed {

  //Creates jumpers
  DigitalInput configOne = new DigitalInput(RobotMap.configOnePort);
  DigitalInput configTwo = new DigitalInput(RobotMap.configTwoPort);
  DigitalInput configThree = new DigitalInput(RobotMap.configThreePort);

  Jumper config;

  public enum Jumper{
    ONE, TWO, THREE, FOUR; // one is last years robot, two is test bot, three is this years robot

  }

  private static ConfigureBed defaultInstance = null;

  public static ConfigureBed getInstance(){
    if(defaultInstance == null){
      defaultInstance = new ConfigureBed();
    }
    return defaultInstance;
  }

  public Jumper configBedInit(){

    if(configOne.get() == false && configTwo.get() == true){
      config = Jumper.ONE;

    }
    else if(configTwo.get() == false && configOne.get() == true){
      config = Jumper.TWO;

    }
    else if(configTwo.get() == false && configOne.get() == false){
      config = Jumper.THREE;

    }
    return config;

  }

}
