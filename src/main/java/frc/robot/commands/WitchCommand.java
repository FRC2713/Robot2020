package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class WitchCommand extends CommandBase {
  private static ClimberSubsystem.WitchPosition position = ClimberSubsystem.WitchPosition.STOPPED;

  public void setWitchPosition(ClimberSubsystem.WitchPosition inputState) {
    position = inputState;
    update();
  }

  private final ClimberSubsystem climberSubsystem;

  public WitchCommand(ClimberSubsystem climberSubsystem) {
    this.climberSubsystem = climberSubsystem;
    addRequirements(climberSubsystem);
    update();
  }

  private void update() {
    System.out.println("Update has been called");
    switch (position) {
      default:
      case UP:
        position = ClimberSubsystem.WitchPosition.UP;
        ClimberSubsystem.ClimberUp.set(0.2);

        break;
      case DOWN:
        position = ClimberSubsystem.WitchPosition.DOWN;
        ClimberSubsystem.ClimberUp.set(-0.2);

        break;
      case STOPPED:
        position = ClimberSubsystem.WitchPosition.STOPPED;
        ClimberSubsystem.ClimberUp.set(0);
        break;
    }

  }
}
