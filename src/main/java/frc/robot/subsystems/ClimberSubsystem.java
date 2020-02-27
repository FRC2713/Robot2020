package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.SM;
import frc.robot.commands.ClimbCommand;

public class ClimberSubsystem extends SubsystemBase {
  public static final CANSparkMax ClimberUp = new CANSparkMax(RobotMap.ClimberUpMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax WitchUpMotor = new CANSparkMax(RobotMap.WitchUpMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax WitchDownMotor = new CANSparkMax(RobotMap.WitchDownMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public static final DigitalInput climberLimitSwitch = new DigitalInput(RobotMap.climberLimitSwitchPort);

  public final JoystickButton climberUpButton = new JoystickButton (SM.leftAttack, RobotMap.ClimberUpMotorPort);
  public final JoystickButton WitchDownButton = new JoystickButton(SM.leftAttack, RobotMap.WitchDownMotorPort);
  public final JoystickButton WitchUpButton = new JoystickButton(SM.leftAttack, RobotMap.WitchUpMotorPort);


  public ClimberSubsystem(){
}

  public void initControls() {
    climberUpButton.whenPressed(new InstantCommand(() -> ClimbCommand.setClimberPosition(ClimberSubsystem.ClimberPosition.ON)));


    //intakeArmButton.whenReleased(new InstantCommand(() -> this.intakeArmCommand.setIntakeArmPosition(IntakeArmPosition.UP)));

  }
  public enum ClimberPosition {
    ON, STOPPED
  }

}
