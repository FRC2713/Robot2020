package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeConveyerCommand extends CommandBase {
  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakePosition position = IntakeSubsystem.IntakePosition.STOPPED;
  private static IntakeSubsystem.IntakeArmPosition armPosition = IntakeSubsystem.IntakeArmPosition.UP;

  public IntakeConveyerCommand(IntakeSubsystem intakeSubsystem, DoubleSolenoid intakeArmSolenoid){
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  public void setIntakeMode(IntakeSubsystem.IntakePosition newPosition){
    if(position != newPosition) position = newPosition;
    updateConveyer();
  }

  public IntakeSubsystem.IntakeArmPosition getIntakeArmPosition() {
    return armPosition;
  }


  public void setIntakeArmPosition(IntakeSubsystem.IntakeArmPosition inputState) {
    armPosition = inputState;
  }

  private void updateConveyer(){
    switch(position) {
      default:
      case ON:
        //intakeSubsystem.intakeArmSolenoid.set(DoubleSolenoid.Value.kReverse);
        intakeSubsystem.intakeArmMotor.set(1);
        intakeSubsystem.intakeMotor.set(1);
        position = IntakeSubsystem.IntakePosition.ON;
        System.out.println("hi folkssssssssssssssssssss!!!!!!!!!!!!!!");
        break;

      case STOPPED:
        //intakeSubsystem.intakeArmSolenoid.set(DoubleSolenoid.Value.kForward);
        intakeSubsystem.intakeArmMotor.stopMotor();
        intakeSubsystem.intakeMotor.stopMotor();
        position = IntakeSubsystem.IntakePosition.STOPPED;
        break;
    }
  }

  public IntakeSubsystem.IntakePosition getIntakeConveyerPosition(){
    return position;
  }

}
