package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.IntakeSubsystem;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;

public class IntakeGateCommand {

  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.UP;

  public IntakeGateCommand(IntakeSubsystem intakeSubsystem){
    this.intakeSubsystem = intakeSubsystem;
    update();
  }
  public static void setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition inputState){
    position = inputState;
  }

  public static IntakeSubsystem.IntakeGatePosition getIntakeGatePosition(){
    return position;
  }

  private void update() {
    switch(position) {
      default:
      case UP:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition.UP);
        break;

      case DOWN:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kForward);
        setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition.DOWN);
        break;

    }

       //if (getIntakeGatePosition() == IntakeSubsystem.IntakeGatePosition.DOWN) {
       //DriverStation.reportWarning("Gate Position not changed for safety reasons", false);
       //}

  }
 }

