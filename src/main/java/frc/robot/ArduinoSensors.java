package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;


public class ArduinoSensors  {
  private static ArduinoSensors defaultInstance = null;

  public static ArduinoSensors getInstance() {
    if(defaultInstance == null)
    {
      defaultInstance = new ArduinoSensors();
    }
    return defaultInstance;
  }

  private SerialPort port = new SerialPort(9600, SerialPort.Port.kUSB);
  private double LRFinches = 0;
  private int SwitchBool = -1;
  public ArduinoSensors() {
    port.enableTermination();

  }

  public void execute() {
    String str = null;
    str = port.readString().trim();

    switch (str) {

      case "LRF":


        try {
          LRFinches = Double.parseDouble(port.readString().trim()) * 0.0393701;
        } catch (NumberFormatException e) {
          LRFinches = -1;

        }
        if (LRFinches != -1) System.out.println("This is the distance: " + LRFinches);

        break;


      case "Switch":
        String cond = port.readString().trim() ;
        if(cond.equals("1")) {
          System.out.println("one");
          SwitchBool = 1;
        }
          else if(cond.equals("0")) {
            System.out.println("zero");
            SwitchBool = 0;
        }
          else {
          System.out.println("Error for switch");
          System.out.println("State is: " + cond);
          SwitchBool = -1;
        }

          break;
    }
  }
  public double getLRFinches(){
    return LRFinches;

  }
  public boolean getSwitchBool(){
    if(SwitchBool == 1) {
      return true;
    }
    if(SwitchBool == 0){
      return false;
    }
    if(SwitchBool == -1){
      System.out.println("Switch failed.");
    }
  }



}
