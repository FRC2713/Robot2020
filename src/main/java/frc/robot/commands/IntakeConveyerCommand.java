package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

import static javax.print.attribute.standard.PrinterState.STOPPED;
import static javax.swing.DropMode.ON;


public class IntakeConveyerCommand extends CommandBase {
  private IntakeSubsystem intakeSubsystem;
  private IntakeSubsystem.IntakePosition position = IntakeSubsystem.IntakePosition.STOPPED;

  public IntakeConveyerCommand(IntakeSubsystem intakeSubsystem, DoubleSolenoid intakeArmSolenoid){
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  private void update() {
    switch(position) {
      default:
      case ON:
        intakeSubsystem.gateSolenoid.set(DoubleSolenoid.Value.kReverse);
        position = IntakeSubsystem.IntakePosition.ON;
        break;

      case STOPPED:
        intakeSubsystem.intakeArmSolenoid.set(DoubleSolenoid.Value.kForward);
        position = IntakeSubsystem.IntakePosition.STOPPED;
        break;
    }
  }

  public IntakeSubsystem.IntakePosition getIntakeConveyerPosition(){
    return position;
  }
}
