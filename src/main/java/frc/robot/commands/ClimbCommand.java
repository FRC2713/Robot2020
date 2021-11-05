package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimbCommand extends CommandBase {
private ClimberSubsystem climberSubsystem;
  public void setClimberPosition() {
    update();
  }


public ClimbCommand(ClimberSubsystem climberSubsystem){

  this.climberSubsystem = climberSubsystem;
  addRequirements(climberSubsystem);

}
private void update() {
    //System.out.println("Update has been called");
  // climberSubsystem.ClimberUp.set(SM.leftAttack.getY());
  }
//Limit switch code: probably don't need
 // if (ClimberSubsystem.climberLimitSwitch.get()) {
 //   position = ClimberSubsystem.ClimberPosition.STOPPED;

 // }
}





