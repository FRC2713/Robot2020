//10-28-21
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.ToggleIntake;

public class IntakeArmCommand extends CommandBase {
  public final IntakeSubsystem intake;
  public ToggleIntake toggle;

  public IntakeArmCommand(IntakeSubsystem in, ToggleIntake tog){
    this.intake = in;
    toggle = tog;
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    if(toggle==ToggleIntake.IN) {
      this.intake.setIntakeMotor(1.0);
      this.intake.setConveyorMotor(1.0);
      this.intake.setSolState(true);
    }
    else if(toggle==ToggleIntake.OUT){
      this.intake.setIntakeMotor(-1.0);
      this.intake.setConveyorMotor(-1.0);
      this.intake.setSolState(true);
    }
    else if(toggle==ToggleIntake.STOP){
      this.intake.setIntakeMotor(0.0);
      this.intake.setConveyorMotor(0.0);
      this.intake.setSolState(false);
    }
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
