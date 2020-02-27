package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ColorSensor;
import frc.robot.RobotMap;
import frc.robot.commands.ColorWheelCommand;

public class ColorWheelSubsystem extends SubsystemBase {
  public CANSparkMax sensorMotor;
  private ColorSensor colorsensor = new ColorSensor();

  /**
   * Creates a new ExampleSubsystem.
   */
 public ColorWheelCommand colorWheelCommand;

  public ColorWheelSubsystem() {
    colorWheelCommand = new ColorWheelCommand(this);

    sensorMotor = new CANSparkMax(12, CANSparkMaxLowLevel.MotorType.kBrushed);
    setDefaultCommand(colorWheelCommand);


  }

  @Override
  public void periodic() {


    // This method will be called once per scheduler run

   // colorWheelCommand.execute();

  }
}
