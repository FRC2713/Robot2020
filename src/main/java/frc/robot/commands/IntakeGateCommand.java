package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;

public class IntakeGateCommand extends CommandBase {

  private boolean isInitialized = false;

  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.DOWN;

  public IntakeGateCommand(IntakeSubsystem intakeSubsystem){
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
    update();
  }
  public void setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition inputState) {
    if (inputState != getIntakeGatePosition() && isInitialized) {
      position = inputState;
      update();
    }
    else if(!isInitialized){
      position = inputState;
      isInitialized = true;
      update();
    }
  }

  public IntakeSubsystem.IntakeGatePosition getIntakeGatePosition(){
    return position;
  }

  private void update() {
    switch(position) {
      default:
      case UP:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        position = IntakeSubsystem.IntakeGatePosition.UP;
        break;

      case DOWN:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kForward);
        position = IntakeSubsystem.IntakeGatePosition.DOWN;
        break;

    }

       //if (getIntakeGatePosition() == IntakeSubsystem.IntakeGatePosition.DOWN) {
       //DriverStation.reportWarning("Gate Position not changed for safety reasons", false);
       //}

  }
 }
