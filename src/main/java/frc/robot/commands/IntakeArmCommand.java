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
  public static void setIntakeArmPosition(IntakeSubsystem.IntakeGatePosition inputState){
    position = inputState;
  }
  public static IntakeSubsystem.IntakeGatePosition getIntakeArmPosition(){
    return position;
  }


  private IntakeSubsystem intakeSubsystem;
  private IntakeSubsystem.IntakeArmPosition position = IntakeSubsystem.IntakeArmPosition.UP;
  private void update() {
    switch(position) {
      default:
      case UP:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        intakeSubsystem.intakeArmCommand.setIntakeArmPosition(UP);
        break;

      case DOWN:
        intakeSubsystem.ballIntakeSolenoid.set(DoubleSolenoid.Value.kForward);
        intakeSubsystem.intakeArmCommand.setIntakeGatePosition(DOWN);
        break;

    }
    public IntakeSubsystem.IntakeArmPosition getIntakeArmPosition(){
      return position;
    }


    public boolean setIntakeJointPosition(IntakeSubsystem.IntakeArmPosition){
      currentState = desiredState;
      return true;
    }
    }
    if (intakeSubsystem.intakeArmCommand.getIntakeArmPosition() == IntakeSubsystem.IntakeArmPosition.DOWN) {
      DriverStation.reportWarning("Arm Position not changed for safety reasons", false);
      return false;
    }
    update();
    return true;


