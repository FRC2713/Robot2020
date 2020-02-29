package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

import static edu.wpi.first.wpilibj.shuffleboard.Shuffleboard.update;

public class outputGateCommand extends CommandBase {

  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.DOWN;

  public outputGateCommand(IntakeSubsystem intakeSubsystem, IntakeGateCommand intakeGateCommand) {
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    intakeSubsystem.intakeGateCommand.setIntakeGatePosition(position);
  }

 @Override
  public boolean isFinished() {
    return true;
 }

}
