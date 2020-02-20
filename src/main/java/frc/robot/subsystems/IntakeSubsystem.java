package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.*;
import frc.robot.commands.IntakeGateCommand;

public class IntakeSubsystem extends SubsystemBase {
  //private final CANSparkMax intakeConveyor = new CANSparkMax(RobotMap.intakeConveyorTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  //public final CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeMotorTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  //public final DoubleSolenoid ballIntakeSolenoid = SM.getDoubleSolenoid(RobotMap.ballIntakeUpNodeId, RobotMap.ballIntakeDownNodeId);
  public final DoubleSolenoid gateSolenoid = SM.getDoubleSolenoid(RobotMap.IntakeGateUpNode, RobotMap.IntakeGateDownNode);
  public static final JoystickButton intakeGateUpButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateUpButtonNum);
  public static final JoystickButton intakeGateDownButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateDownButtonNum);



  //public final IntakeCountCommand intakeCountCommand = new IntakeCountCommand(this);
  //public final IntakeArmCommand intakeArmCommand = new IntakeArmCommand(this);
  //public final IntakeGateCommand intakeGateCommand = new IntakeGateCommand(this);
  //public final IntakeConveyerCommand intakeConveyerCommand = new IntakeConveyerCommand(this, ballIntakeSolenoid);
  public IntakeSubsystem() {

    // Robot.initializeSparkDefaults(intakeMotor, intakeConveyor);

  }


    public void initTeleop () {
      //new EncoderReporter(intakeTalon).start();

      //Robot.initializeTalonDefaults(intakeTalon);
    }

    public static void initControls() {

    intakeGateUpButton.whenPressed(new InstantCommand(() -> IntakeGateCommand.setIntakeGatePosition(IntakeGatePosition.UP)));
    intakeGateDownButton.whenPressed(new InstantCommand(() -> IntakeGateCommand.setIntakeGatePosition(IntakeGatePosition.DOWN)));
    //intakeArmButton.whenReleased(new InstantCommand(() -> this.intakeArmCommand.setIntakeArmPosition(UP)));

    }

    public enum IntakeGatePosition {
      UP, DOWN
    }

    /*public enum IntakeConveyerPosition {
      ON, STOPPED
    }
    public enum IntakeArmPosition {
      UP, DOWN
    }*/
  }







