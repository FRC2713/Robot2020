package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ClimbCommand extends CommandBase {
private ClimberSubsystem climberSubsystem;
  private static ClimberSubsystem.ClimberPosition position = ClimberSubsystem.ClimberPosition.STOPPED;
  public static void setClimberPosition(ClimberSubsystem.ClimberPosition inputState) {
    position = inputState;
  }


public ClimbCommand(ClimberSubsystem climberSubsystem){

  this.climberSubsystem = climberSubsystem;
  addRequirements(climberSubsystem);

  update();
}
private void update() {
  switch (position) {
    default:
    case ON:
      position = ClimberSubsystem.ClimberPosition.ON;

      break;
    case STOPPED:
      position = ClimberSubsystem.ClimberPosition.STOPPED;
      break;
  }

  if (ClimberSubsystem.climberLimitSwitch.get()) {
    position = ClimberSubsystem.ClimberPosition.STOPPED;

  }
}




}
