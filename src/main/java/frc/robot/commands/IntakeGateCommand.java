package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.IntakeSubsystem;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;

public class IntakeGateCommand {
  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakeGatePosition currentState;
  private IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.UP;
  public IntakeSubsystem.IntakeGatePosition getIntakeGatePosition(){
  return currentState;
  }
  public static boolean setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition inputState){
currentState = inputState;
return true;
  }

  private void update() {
    switch(position) {
      default:
      case UP:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        intakeSubsystem.intakeGateCommand.setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition.UP);
        break;

      case DOWN:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kForward);
        intakeSubsystem.intakeGateCommand.setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition.DOWN);
        break;

    }

    if (intakeSubsystem.intakeGateCommand.getIntakeGatePosition() == IntakeSubsystem.IntakeGatePosition.DOWN) {
      DriverStation.reportWarning("Gate Position not changed for safety reasons", false);
    }
    update();

      }
      }

