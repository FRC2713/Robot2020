package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

import static edu.wpi.first.wpilibj.util.ErrorMessages.requireNonNullParam;

public class iRaidersButton extends Button {
  private GenericHID m_joystick;
  private final int m_buttonNumber;

  public iRaidersButton(GenericHID joystick, int buttonNumber) {
    requireNonNullParam(joystick, "joystick", "iRaidersButton");
    m_joystick = joystick;
    m_buttonNumber = buttonNumber;
  }

  public void updateJoystick(GenericHID joystick) {
    m_joystick = joystick;
  }

  @Override
  public boolean get() {
    return m_joystick.getRawButton(m_buttonNumber);
  }
}
