package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.IntakeSubsystem;

import static javax.print.attribute.standard.PrinterState.STOPPED;
import static javax.swing.DropMode.ON;


public class IntakeConveyerCommand {/*
  private IntakeSubsystem intakeSubsystem;
  private IntakeSubsystem.IntakeConveyerPosition position = IntakeSubsystem.IntakeConveyerPosition.STOPPED;
  private void update() {
    switch(position) {
      default:
      case ON:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        intakeSubsystem.IntakeConveyerCommand.setBallIntakeState(ON);
        break;

      case STOPPED:
        intakeSubsystem.ballIntakeSolenoid.set(DoubleSolenoid.Value.kForward);
        intakeSubsystem.IntakeConveyerCommand.setIntakeGatePosition(STOPPED);
        break;

    }
    public IntakeSubsystem.IntakeConveyerPosition getIntakeGatePosition(){
      return position;
    }

    public IntakeSubsystem.IntakeConveyerPosition getIntakeConveyerPosition(){
      return position;
    }


    public boolean setIntakeJointPosition(IntakeSubsystem.IntakeArmPosition){
      currentState = desiredState;
    return true;
    }
    if (intakeSubsystem.IntakeGateCommand.getIntakeGatePosition() == IntakeSubsystem.IntakeGatePosition.STOPPED) {
      DriverStation.reportWarning("Conveyer state not changed for safety reasons", false);
      return false;
    }
    update();
    return true;
    */
}
