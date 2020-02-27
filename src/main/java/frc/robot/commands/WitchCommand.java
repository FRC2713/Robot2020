package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class WitchCommand extends CommandBase {


  private final ClimberSubsystem climberSubsystem;

  public WitchCommand(ClimberSubsystem climberSubsystem)
  {
    this.climberSubsystem = climberSubsystem;
  }
}
