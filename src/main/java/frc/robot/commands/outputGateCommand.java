package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class
outputGateCommand extends CommandBase {

  private IntakeSubsystem intakeSubsystem;
  private static IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.DOWN; //gets position of output gate

  public outputGateCommand(IntakeSubsystem intakeSubsystem) {
    this.intakeSubsystem = intakeSubsystem; // sets intake subsystem as subsystem used
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {
//there is nothing here
  }

  @Override
  public void execute() {
    intakeSubsystem.intakeGateCommand.setIntakeGatePosition(position);
  } //tells the gate to open if closed, or close if open

 @Override
  public boolean isFinished() {
    return true;
 } //only cycles once, no matter what

}
