package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class noEvilCommand extends CommandBase {

  private boolean turningEvil = true;

  public noEvilCommand() {
    addRequirements();
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (turningEvil) {
      dont();
    }
  }

  @Override
  public boolean isFinished() {
    return true;

  }
  private void dont() {
    turningEvil = !turningEvil;
    System.out.println("Robot, do not turn evil.");
  }
}
