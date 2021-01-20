package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class XboxImpostor extends XboxController {

  /**
   * Allows Logitech Dual Action to act like an Xbox.
   * kLeftTrigger, if pressed, right stick is now Xbox triggers.
   */


  /**
   * Represents a digital button on an XboxController.
   */
  public enum Button {

    kBumperLeft(5),
    kBumperRight(6),
    kLeftTrigger(7),
    kRightTrigger(8),
    kStickLeft(11),
    kStickRight(12),
    kA(2),
    kB(3),
    kX(1),
    kY(4),
    kBack(9),
    kStart(10);

    @SuppressWarnings({"MemberName", "PMD.SingularField"})
    public final int value;

    Button(int value) {
      this.value = value;
    }
  }

  /**
   * Represents an axis on an XboxController.
   */
  public enum Axis {
    kLeftX(0),
    kRightX(2),
    kLeftY(1),
    kRightY(3),
    kLeftTrigger(2),
    kRightTrigger(3);

    @SuppressWarnings({"MemberName", "PMD.SingularField"})
    public final int value;

    Axis(int value) {
      this.value = value;
    }
  }


  /**
   * Construct an instance of a joystick. The joystick index is the USB port on the drivers
   * station.
   *
   * @param port The port on the Driver Station that the joystick is plugged into.
   */
  public XboxImpostor(int port) {
    super(port);
  }

  public boolean getRawButton(int button) {
    if (button == XboxController.Button.kA.value) {
      return super.getRawButton(Button.kA.value);
    }
    if (button == XboxController.Button.kB.value) {
      return super.getRawButton(Button.kB.value);
    }
    if (button == XboxController.Button.kX.value) {
      return super.getRawButton(Button.kX.value);
    }
    if (button == XboxController.Button.kY.value) {
      return super.getRawButton(Button.kY.value);
    }
    if (button == XboxController.Button.kBumperLeft.value) {
      return super.getRawButton(Button.kBumperLeft.value);
    }
    if (button == XboxController.Button.kBumperRight.value) {
      return super.getRawButton(Button.kBumperRight.value);
    }
    if (button == XboxController.Button.kStickLeft.value) {
      return super.getRawButton(Button.kStickLeft.value);
    }
    if (button == XboxController.Button.kStickRight.value) {
      return super.getRawButton(Button.kStickRight.value);
    }
    if (button == XboxController.Button.kBack.value) {
      return super.getRawButton(Button.kBack.value);
    }
    if (button == XboxController.Button.kStart.value) {
      return super.getRawButton(Button.kStart.value);
    }

    return super.getRawButton(button);
  }

  /**
   * Get the X axis value of the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The X axis value of the controller.
   */
  @Override
  public double getX(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawAxis(Axis.kLeftX.value);
    } else {
      return (!super.getRawButton(Button.kLeftTrigger.value)) ? getRawAxis(Axis.kRightX.value) : 0.0;
    }
  }

  /**
   * Get the Y axis value of the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The Y axis value of the controller.
   */
  @Override
  public double getY(Hand hand) {
    if (hand.equals(Hand.kLeft)) {
      return getRawAxis(Axis.kLeftY.value);
    } else {
      return (!super.getRawButton(Button.kLeftTrigger.value)) ? getRawAxis(Axis.kRightY.value) : 0.0;
    }
  }

  /**
   * Get the trigger axis value of the controller.
   *
   * @param hand Side of controller whose value should be returned.
   * @return The trigger axis value of the controller.
   */
  public double getTriggerAxis(Hand hand) {
    if (!super.getRawButton(Button.kLeftTrigger.value)) return 0.0;
    if (hand.equals(Hand.kLeft)) {
      return getRawAxis(Axis.kLeftTrigger.value);
    } else {
      return getRawAxis(Axis.kRightTrigger.value);
    }
  }
}
