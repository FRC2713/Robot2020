package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class noCoronaCommand extends CommandBase {

  private boolean coronavirus = true;

  public noCoronaCommand() {
    addRequirements();
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (coronavirus) {
      cure();
    }
  }

  @Override
  public boolean isFinished() {
    return true;

  }
  private void cure() {
    coronavirus = !coronavirus;
    System.out.println("bing bong coronavirus is gone");
  }
}
