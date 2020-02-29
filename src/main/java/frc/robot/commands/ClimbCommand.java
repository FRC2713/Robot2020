package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimbCommand extends CommandBase {
private ClimberSubsystem climberSubsystem;
  private static ClimberSubsystem.ClimberPosition position = ClimberSubsystem.ClimberPosition.STOPPED;
  public void setClimberPosition(ClimberSubsystem.ClimberPosition inputState) {
    position = inputState;
    update();
  }


public ClimbCommand(ClimberSubsystem climberSubsystem){

  this.climberSubsystem = climberSubsystem;
  addRequirements(climberSubsystem);

  update();
}
private void update() {
    System.out.println("Update has been called");
  switch (position) {
    default:
    case UP:
      position = ClimberSubsystem.ClimberPosition.UP;
      ClimberSubsystem.ClimberUp.set(0.4);

      break;
    case DOWN:
      position = ClimberSubsystem.ClimberPosition.DOWN;
      ClimberSubsystem.ClimberUp.set(-0.4);

      break;
    case STOPPED:
      position = ClimberSubsystem.ClimberPosition.STOPPED;
      ClimberSubsystem.ClimberUp.set(0);
      break;
  }
//Limit switch code: probably don't need
 // if (ClimberSubsystem.climberLimitSwitch.get()) {
 //   position = ClimberSubsystem.ClimberPosition.STOPPED;

 // }
}




}
