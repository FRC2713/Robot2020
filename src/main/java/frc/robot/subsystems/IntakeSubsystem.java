package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.*;
import frc.robot.commands.HumanIntakeCommand;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeConveyerCommand;
import frc.robot.commands.IntakeGateCommand;

public class IntakeSubsystem extends SubsystemBase {
  public final CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax intakeArmMotor = new CANSparkMax(RobotMap.intakeArmTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final DoubleSolenoid intakeArmSolenoid = SM.getDoubleSolenoid(RobotMap.intakeArmUpNode, RobotMap.intakeArmDownNode);
  public final DoubleSolenoid gateSolenoid = SM.getDoubleSolenoid(RobotMap.IntakeGateUpNode, RobotMap.IntakeGateDownNode);
  public final DoubleSolenoid humanIntakeSolenoid = SM.getDoubleSolenoid(RobotMap.humanIntakeUpNode, RobotMap.humanIntakeDownNode);
  public final JoystickButton intakeGateUpButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateUpButtonNum);
 // public final JoystickButton intakeGateDownButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateDownButtonNum);
  //public final JoystickButton intakeOnButton = new JoystickButton(SM.xBoxController, RobotMap.intakeOnButtonNum);
  //public final JoystickButton intakeReverse = new JoystickButton(SM.xBoxController, RobotMap.reverseIntakeButtonNum);
  boolean toggleState = true;
  boolean testyIntake = false;



  //public final IntakeCountCommand intakeCountCommand = new IntakeCountCommand(this);
  public final HumanIntakeCommand humanIntakeCommand = new HumanIntakeCommand(this);
  public final IntakeGateCommand intakeGateCommand = new IntakeGateCommand(this);
  public final IntakeConveyerCommand intakeConveyerCommand = new IntakeConveyerCommand(this);
  public IntakeSubsystem() {

    // Robot.initializeSparkDefaults(intakeMotor, intakeConveyor);

  }


    public void initTeleop () {
      //new EncoderReporter(intakeTalon).start();

      //Robot.initializeTalonDefaults(intakeTalon);
    }

    public void initControls() {

      intakeGateUpButton.whenReleased(new InstantCommand(() -> intakeGateCommand.setIntakeGatePosition(IntakeGatePosition.UP)));
      intakeGateUpButton.whenPressed(new InstantCommand(() -> intakeGateCommand.setIntakeGatePosition(IntakeGatePosition.DOWN)));
      //intakeOnButton.whenPressed(new InstantCommand(() -> (toggleState)? intakeConveyerCommand.setIntakeMode(IntakePosition.ON): intakeConveyerCommand.setIntakeMode(IntakePosition.STOPPED))));
      //intakeArmButton.whenReleased(new InstantCommand(() -> this.intakeArmCommand.setIntakeArmPosition(IntakeArmPosition.UP)));
      //intakeOnButton.whenPressed(new InstantCommand(() -> this.intakeConveyerCommand.setIntakeMode(IntakePosition.ON)));
      //intakeOnButton.whenReleased(new InstantCommand(() -> this.intakeConveyerCommand.setIntakeMode(IntakePosition.STOPPED)));
      //intakeReverse.whenPressed(new InstantCommand(() -> this.intakeConveyerCommand.setIntakeMode(IntakePosition.REVERSED)));
      //intakeReverse.whenReleased(new InstantCommand(() -> this.intakeConveyerCommand.setIntakeMode(IntakePosition.STOPPED)));
    }

    @Override
    public void periodic() {
      if(SM.xBoxController.getTriggerAxis(GenericHID.Hand.kRight) == 1 && !testyIntake){
        this.intakeConveyerCommand.setIntakeMode(IntakePosition.ON);

        testyIntake = !testyIntake;
      }
      else if(testyIntake){
        this.intakeConveyerCommand.setIntakeMode(IntakePosition.STOPPED);
        testyIntake = !testyIntake;
      }
    }

    public enum IntakeGatePosition {
      UP, DOWN
    }

    public enum IntakePosition {
      ON, STOPPED, REVERSED
    }

    public enum IntakeArmPosition {
      UP, DOWN
    }
    public enum HumanIntakePosition {
      UP, DOWN
    }
  }







