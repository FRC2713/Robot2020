package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import static frc.robot.subsystems.IntakeSubsystem.IntakeArmPosition.UP;
import static frc.robot.subsystems.IntakeSubsystem.IntakePosition.ON;
import static frc.robot.subsystems.IntakeSubsystem.IntakePosition.STOPPED;


public class IntakeConveyerCommand extends CommandBase {
  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakePosition position = STOPPED;
  private static IntakeSubsystem.IntakeArmPosition armPosition = UP;

  public IntakeConveyerCommand(IntakeSubsystem intakeSubsystem){
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
        intakeSubsystem.intakeArmSolenoid.set(kReverse);
        intakeSubsystem.intakeArmMotor.set(.5);
        //.delay(.5);
        intakeSubsystem.intakeMotor.set(1);
        position = ON;
        break;

      case STOPPED:
        intakeSubsystem.intakeArmSolenoid.set(kForward);
        intakeSubsystem.intakeArmMotor.stopMotor();
        //Timer.delay(1.6);
        intakeSubsystem.intakeMotor.stopMotor();
        position = STOPPED;
        break;

      case REVERSED:
        intakeSubsystem.intakeArmMotor.set(-.5);
        intakeSubsystem.intakeMotor.set(-1);
    }
  }

  public IntakeSubsystem.IntakePosition getIntakeConveyerPosition(){
    return position;
  }

}
