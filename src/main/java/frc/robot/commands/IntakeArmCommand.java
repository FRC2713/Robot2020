package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.IntakeSubsystem;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;

public class IntakeArmCommand {
   public IntakeArmCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    update();
  }

  public void setIntakeArmPosition(IntakeSubsystem.IntakeArmPosition inputState) {
    position = inputState;
  }

  public IntakeSubsystem.IntakeArmPosition getIntakeArmPosition() {
    return position;
  }
  private IntakeSubsystem intakeSubsystem;
  private IntakeSubsystem.IntakeArmPosition position = IntakeSubsystem.IntakeArmPosition.UP;

  private void update() {
    switch (position) {
      default:
      case UP:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        position = IntakeSubsystem.IntakeArmPosition.UP;
        break;

      case DOWN:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kForward);
        position = IntakeSubsystem.IntakeArmPosition.DOWN;
        break;

    }
  }

  public boolean setIntakeJointPosition(IntakeSubsystem.IntakeArmPosition desiredState) {
    //currentState = desiredState;
    return true;
  }

}


