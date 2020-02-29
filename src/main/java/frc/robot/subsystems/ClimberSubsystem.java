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
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.WitchCommand;

public class ClimberSubsystem extends SubsystemBase {

  public static final CANSparkMax ClimberUp = new CANSparkMax(RobotMap.ClimberUpMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax WitchUpMotor = new CANSparkMax(RobotMap.WitchUpMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax WitchDownMotor = new CANSparkMax(RobotMap.WitchDownMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public static final DigitalInput climberLimitSwitch = new DigitalInput(RobotMap.climberLimitSwitchPort);

  public final JoystickButton climberUpButton = new JoystickButton (SM.leftAttack, RobotMap.climberUpButton);
  public final JoystickButton climberDownButton = new JoystickButton (SM.leftAttack, RobotMap.climberDownButton);


  public final JoystickButton witchDownButton = new JoystickButton(SM.leftAttack, RobotMap.WitchDownMotorPort);
  public final JoystickButton witchUpButton = new JoystickButton(SM.leftAttack, RobotMap.WitchUpMotorPort);

  public final ClimbCommand climbCommand = new ClimbCommand(this);
  public final WitchCommand witchCommand = new WitchCommand(this);


  public ClimberSubsystem(){
}

  public void initControls() {
    climberUpButton.whileHeld(new InstantCommand(() -> climbCommand.setClimberPosition(ClimberSubsystem.ClimberPosition.UP)));
    climberDownButton.whileHeld(new InstantCommand(() -> climbCommand.setClimberPosition(ClimberSubsystem.ClimberPosition.DOWN)));

    witchUpButton.whenPressed(new InstantCommand(() -> witchCommand.setWitchPosition(ClimberSubsystem.WitchPosition.UP)));
    witchDownButton.whenPressed(new InstantCommand(() -> witchCommand.setWitchPosition(ClimberSubsystem.WitchPosition.DOWN)));


    //intakeArmButton.whenReleased(new InstantCommand(() -> this.intakeArmCommand.setIntakeArmPosition(IntakeArmPosition.UP)));

  }
  public enum ClimberPosition {
    UP, DOWN, STOPPED
  }
  public enum WitchPosition {
    UP, DOWN, STOPPED
  }
  @Override
  public void periodic(){
    climbCommand.setClimberPosition(ClimberPosition.STOPPED);

  }

}
