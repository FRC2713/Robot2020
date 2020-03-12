package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

import static frc.robot.subsystems.IntakeSubsystem.IntakeGatePosition.DOWN;
import static frc.robot.subsystems.IntakeSubsystem.IntakeGatePosition.UP;

public class HumanIntakeCommand extends CommandBase {

  IntakeSubsystem intakeSubsystem;
  private boolean isInitialized = false;
  private static IntakeSubsystem.HumanIntakePosition position = IntakeSubsystem.HumanIntakePosition.UP;

  public HumanIntakeCommand(IntakeSubsystem intakeSubsystem){
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
    update();
  }

  public IntakeSubsystem.HumanIntakePosition getHumanIntakePosition(){
    return position;
  }

  public void setIntakeGatePosition(IntakeSubsystem.HumanIntakePosition inputState) {
    if (inputState != getHumanIntakePosition() && isInitialized) {
      position = inputState;
      update();
    }
    else if(!isInitialized){
      position = inputState;
      isInitialized = true;
      update();
    }
  }

  public void update(){
      switch(position) {
        default:
        case UP:
          intakeSubsystem.humanIntakeSolenoid.set(DoubleSolenoid.Value.kReverse);
          position = IntakeSubsystem.HumanIntakePosition.DOWN;
          break;

        case DOWN:
          intakeSubsystem.humanIntakeSolenoid.set(DoubleSolenoid.Value.kForward);
          position = IntakeSubsystem.HumanIntakePosition.UP;
          break;
      }
  }
}
