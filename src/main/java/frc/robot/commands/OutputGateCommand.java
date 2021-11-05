package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.ToggleGate;



public class OutputGateCommand extends CommandBase {
  public final IntakeSubsystem gate;

  //private static IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.DOWN; //gets position of output gate

  public OutputGateCommand(IntakeSubsystem in) {
    this.gate = in;
    addRequirements(in);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if(gate.isGateOpen()){
      this.gate.setGateState(false);
    }
    else {
      this.gate.setGateState(true);
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
