package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class SM {
  public static XboxController xBoxController;
  public static Joystick arcadeController;
  public static Joystick leftAttack;
  //private static Joystick rightAttack;

  // Controllers
  public static final int BACKUP_XBOX_PORT = 0;
  public static final int BACKUP_ARCADE_PORT = 1;
  public static final int ATTACK_LEFT_PORT = 2;

  //public static final int ATTACK_RIGHT_PORT = 3;
  public static final String XBOX_NAME = "Controller (XBOX 360 For Windows)";
  public static final String ARCADE_NAME = "Mayflash Arcade Stick";
  public static final String ATTACK_NAME = "Logitech Attack 3";
  public static final String XBOX2_NAME = "Controller (Gamepad for Xbox 360)";
  public static final String XBOX3_NAME = "Controller (Gamepad)";
  public static final String XBOX4_NAME = "Logitech Dual Action";


  public SM() {
    initControllers();
  }

  /**
   * Scans all (7) controller ports and assigns them via known names
   */
  public static void initControllers() {
    // TODO Use generics
    int empty_port = 0;
    for (int i = 0; i < 6; i++) {
      Joystick test = new Joystick(i);
      //System.out.println("This is the name of the joystick " + test.getName());
      if (test.getName().equals(XBOX_NAME)||test.getName().equals(XBOX2_NAME)
        ||test.getName().equals(XBOX3_NAME)||test.getName().equals(XBOX4_NAME)) {
        xBoxController = new XboxController(i);
       // System.out.println("This should have been reached!!");
      } else if (test.getName().equals(ARCADE_NAME)) {
        arcadeController = new Joystick(i);
      } else if (test.getName().equals(ATTACK_NAME)) {
        leftAttack = new Joystick(i);
      }
      if (test.getName().isEmpty()){
        empty_port = i;
      }
    }
    if (xBoxController == null) {
      //System.out.println("THis should not be reached -Brigid");
      //System.out.println(xBoxController);
      //System.out.println(leftAttack);
      //System.exit(-1);
     xBoxController = new XboxController(empty_port);
    }
    if (arcadeController == null) {
      arcadeController = new Joystick(empty_port);
    }
    //rightAttack = new Joystick(ATTACK_RIGHT_PORT);
    if (leftAttack == null) {
      leftAttack = new Joystick(empty_port);
    }
  }

  /**
   * Rumbles a given controller for a specified time
   * @param stick Controller to rumble
   * @param ms Time in Milliseconds
   */
  public static void rumbleController(GenericHID stick, double intensity, int ms) {
    rumbleController(stick, intensity, ms, GenericHID.RumbleType.kLeftRumble);
  }

  /**
   * Rumbles a given controller for a specified time
   * Left rumble is like an earthquake, right rumble is like a vibrating toothbrush
   * @param stick Controller to rumble
   * @param ms Time in Milliseconds
   * @param rumbleType Type of rumble to use
   */
  public static void rumbleController(GenericHID stick, double intensity, int ms, GenericHID.RumbleType rumbleType) {
    if (ms > 0) {
      new Thread(() -> {
        _setRumble(stick, intensity, rumbleType);
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
        _setRumble(stick, 0, rumbleType);
      }).start();
    } else {
      _setRumble(stick, intensity, rumbleType);
    }
  }

  private static void _setRumble(GenericHID stick, double intensity, GenericHID.RumbleType rumbleType) {
    stick.setRumble(rumbleType, intensity);
  }

  /**
   * Returns the speed, corrected for the deadband. This is used usually when getting
   * speed inputs from a Joystick, as joysticks usually report values slightly
   * different then what is intended
   *
   * @param speed             The current desired speed (usually from the joystick)
   * @param deadbandTolerance The amount of deadband to remove from speed
   * @return The corrected speed
   */
  public static double getDeadband(double speed, double deadbandTolerance) {
    return Math.max(0, // If deadband is greater than abs(speed), do nothing
      Math.abs(speed) - Math.max(deadbandTolerance, 0) // Subtract abs(speed) from larger of deadbandTolerance and 0
    ) * Math.signum(speed); // Restore original sign sign of speed
  }

  public static DoubleSolenoid getDoubleSolenoid(int forwardChannel, int reverseChannel) {
    if (reverseChannel > 7) {
      return new DoubleSolenoid(1, forwardChannel - 8, reverseChannel - 8);
    }
    return new DoubleSolenoid(forwardChannel, reverseChannel);
  }
}
