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
  public double LRFinches = 0;
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
        if(port.readString().trim().equals("1")) {
          System.out.println("one");
        }
          else if(port.readString().trim().equals("0")) {
            System.out.println("zero");
        }
          else {
          System.out.println("Error for switch");
        }
          break;
    }
  }
}
