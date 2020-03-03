package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ColorSensor;
import frc.robot.RobotMap;
import frc.robot.SM;
import frc.robot.subsystems.ColorWheelSubsystem;

public class ColorWheelCommand extends CommandBase {

  private XboxController xbox = SM.xBoxController;
  private ColorWheelSubsystem colormatchwheelsubsystem;
  public int stop = -1;
  public String chosenColor = "no color";
  public int chosenColorInt = 1;

  public ColorWheelCommand(ColorWheelSubsystem colorwheelsubsystem) {
    this.colormatchwheelsubsystem = colorwheelsubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorwheelsubsystem);

  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    //colormatchwheelsubsystem.sensorMotor.set(0.5);



  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    String colorString;
    colorString = colormatchwheelsubsystem.colorsensor.getColor();




    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the
     * sensor.
     */
    if (xbox.getRawButtonPressed(RobotMap.colorWheelButtonNum)) {
      SM.rumbleController(xbox, .5, 500);
      chosenColorInt ++;
      if(chosenColorInt >= 5){

        chosenColorInt = 1;

      }

    }

    if(chosenColorInt == 1){

      chosenColor = "Red";
    }

    if(chosenColorInt == 2){

      chosenColor = "Green";
    }
    if(chosenColorInt == 3){

      chosenColor = "Blue";
    }
    if(chosenColorInt == 4){

      chosenColor = "Yellow";
    }
    System.out.println("Color is: " + colorString);
    System.out.println("Red: " + colormatchwheelsubsystem.colorsensor.detectedColor.red);
    System.out.println("Green: " + colormatchwheelsubsystem.colorsensor.detectedColor.green);
    System.out.println("Blue: " + colormatchwheelsubsystem.colorsensor.detectedColor.blue);
    System.out.println("Confidence: " + colormatchwheelsubsystem.colorsensor.match.confidence);

    SmartDashboard.putNumber("Red", colormatchwheelsubsystem.colorsensor.detectedColor.red);
    SmartDashboard.putNumber("Green", colormatchwheelsubsystem.colorsensor.detectedColor.green);
    SmartDashboard.putNumber("Blue", colormatchwheelsubsystem.colorsensor.detectedColor.blue);
    SmartDashboard.putString("Match Color", chosenColor);
    //SmartDashboard.putNumber("Confidence", colormatchwheelsubsystem.colorsensor.match.confidence);
    SmartDashboard.putString("Detected Color", colorString);

    System.out.println("hey look this is working");



   // if(colormatchwheelsubsystem.colorsensor.getColor() == "Red"){

    //  colormatchwheelsubsystem.sensorMotor.set(0);

 //   }




    if(colormatchwheelsubsystem.colorsensor.getColor() == chosenColor ){

      colormatchwheelsubsystem.sensorMotor.set(0);

    }


    if (xbox.getRawButtonPressed(RobotMap.colorWheelButtonNum2)) {
        //if (colorsensor.getColor() == chosenColor) {
         // colormathwheelsubsystem.sensorMotor.set(0);
     // stop = stop * -1;
      SM.rumbleController(xbox, .4, 200);

      //} else {
     // if(stop == 1) {

        colormatchwheelsubsystem.sensorMotor.set(0.5);

     // }else{
       // colormatchwheelsubsystem.sensorMotor.set(0);
     // }

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
