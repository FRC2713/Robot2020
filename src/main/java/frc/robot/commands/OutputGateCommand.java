package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.util.ToggleGate;



public class OutputGateCommand extends CommandBase {
  public final IntakeSubsystem gate;
  public ToggleGate toggle;

  //private static IntakeSubsystem.IntakeGatePosition position = IntakeSubsystem.IntakeGatePosition.DOWN; //gets position of output gate

  public OutputGateCommand(IntakeSubsystem in, ToggleGate tog) {
    this.gate = in;
    addRequirements(in);
    toggle = tog;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if(toggle==ToggleGate.OPEN){
      this.gate.setGateState(true);
    }
    else if(toggle==ToggleGate.CLOSE){
      this.gate.setGateState(false);

    }

    Timer.delay(5);
  }

  @Override
  public void end(boolean interrupted) {

  }

 @Override
  public boolean isFinished() {
    return true;
  }

}
