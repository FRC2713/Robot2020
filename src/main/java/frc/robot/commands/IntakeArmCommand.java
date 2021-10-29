package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.ToggleIntake;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;

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
    if(toggle==ToggleIntake.FORWARD) {
      this.intake.setIntakeMotor(1.0);
    }
    else if(toggle==ToggleIntake.BACKWARD){
      this.intake.setIntakeMotor(-1.0);
    }
    else if(toggle==ToggleIntake.STOP){
      this.intake.setIntakeMotor(0.0);
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


