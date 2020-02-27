package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ColorSensor;
import frc.robot.SM;
import frc.robot.subsystems.ColorWheelSubsystem;

public class ColorWheelCommand extends CommandBase {

  public  ColorSensor colorsensor = new ColorSensor();
  private XboxController xbox = SM.xBoxController;
//  private ColorWheelSubsystem m_colorwheelsubsystem = new ColorWheelSubsystem();
  private ColorWheelSubsystem colorwheelsubsystem;


  public ColorWheelCommand(ColorWheelSubsystem colorwheelsubsystem) {
    this.colorwheelsubsystem = colorwheelsubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorwheelsubsystem);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {




  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    String chosenColor = "no color";

    if (xbox.getAButtonPressed()) {
      SM.rumbleController(xbox, .5, 500);
      if (chosenColor == "no color") {

        chosenColor = "red";

      }
      if (chosenColor == "red") {

        chosenColor = "green";

      }
      if (chosenColor == "green") {

        chosenColor = "blue";

      }
      if (chosenColor == "blue") {

        chosenColor = "yellow";

      }
      if (chosenColor == "yellow") {

        chosenColor = "no color";

      }
    }

    if (xbox.getYButtonPressed()) {
      SM.rumbleController(xbox, .2, 200);
        //if (colorsensor.getColor() == chosenColor) {
         // colorwheelsubsystem.sensorMotor.set(0);

        //} else {
          colorwheelsubsystem.sensorMotor.set(0.5);


    //     }
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
