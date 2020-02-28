package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.*;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeConveyerCommand;
import frc.robot.commands.IntakeGateCommand;

public class IntakeSubsystem extends SubsystemBase {
  public final CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax intakeArmMotor = new CANSparkMax(RobotMap.intakeArmTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final DoubleSolenoid intakeArmSolenoid = SM.getDoubleSolenoid(RobotMap.intakeArmUpNode, RobotMap.intakeArmDownNode);
  public final DoubleSolenoid gateSolenoid = SM.getDoubleSolenoid(RobotMap.IntakeGateUpNode, RobotMap.IntakeGateDownNode);
  public final JoystickButton intakeGateUpButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateUpButtonNum);
  public final JoystickButton intakeGateDownButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateDownButtonNum);
  public final JoystickButton intakeOnButton = new JoystickButton(SM.xBoxController, RobotMap.intakeOnButtonNum);
  boolean toggleState = true;



  //public final IntakeCountCommand intakeCountCommand = new IntakeCountCommand(this);
  public final IntakeArmCommand intakeArmCommand = new IntakeArmCommand(this);
  public final IntakeGateCommand intakeGateCommand = new IntakeGateCommand(this);
  public final IntakeConveyerCommand intakeConveyerCommand = new IntakeConveyerCommand(this, intakeArmSolenoid);
  public IntakeSubsystem() {

    // Robot.initializeSparkDefaults(intakeMotor, intakeConveyor);

  }


    public void initTeleop () {
      //new EncoderReporter(intakeTalon).start();

      //Robot.initializeTalonDefaults(intakeTalon);
    }

    public void initControls() {

      intakeGateUpButton.whenPressed(new InstantCommand(() -> intakeGateCommand.setIntakeGatePosition(IntakeGatePosition.UP)));
      intakeGateDownButton.whenPressed(new InstantCommand(() -> intakeGateCommand.setIntakeGatePosition(IntakeGatePosition.DOWN)));
      //intakeOnButton.whenPressed(new InstantCommand(() -> (toggleState)? intakeConveyerCommand.setIntakeMode(IntakePosition.ON): intakeConveyerCommand.setIntakeMode(IntakePosition.STOPPED))));
      //intakeArmButton.whenReleased(new InstantCommand(() -> this.intakeArmCommand.setIntakeArmPosition(IntakeArmPosition.UP)));
      intakeOnButton.whenPressed(new InstantCommand(() -> this.intakeConveyerCommand.setIntakeMode(IntakePosition.ON)));
      intakeOnButton.whenReleased(new InstantCommand(() -> this.intakeConveyerCommand.setIntakeMode(IntakePosition.STOPPED)));
    }

    public enum IntakeGatePosition {
      UP, DOWN
    }

    public enum IntakePosition {
      ON, STOPPED
    }

    public enum IntakeArmPosition {
      UP, DOWN
    }
  }







