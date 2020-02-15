package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.*;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeConveyerCommand;
import frc.robot.commands.IntakeCountCommand;
import frc.robot.commands.IntakeGateCommand;

import static frc.robot.RobotMap.*;
import static java.math.RoundingMode.UP;
import static javax.print.attribute.standard.PrinterState.STOPPED;

public class IntakeSubsystem extends SubsystemBase {
  //private final CANSparkMax intakeConveyor = new CANSparkMax(RobotMap.intakeConveyorTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
//  public final CANSparkMax intakeMotor = new CANSparkMax(RobotMap.intakeMotorTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
 // public final DoubleSolenoid ballIntakeSolenoid = SM.getDoubleSolenoid(RobotMap.ballIntakeUpNodeId, RobotMap.ballIntakeDownNodeId);
  public final DoubleSolenoid gateSolenoid = SM.getDoubleSolenoid(RobotMap.IntakeGateUpNode, RobotMap.IntakeGateDownNode);


  //public final  IntakeCountCommand intakeCountCommand = new IntakeCountCommand(this);
  //public final IntakeArmCommand intakeArmCommand = new IntakeArmCommand(this);
  public final IntakeGateCommand intakeGateCommand = new IntakeGateCommand(this);
//  public final IntakeConveyerCommand intakeConveyerCommand = new IntakeConveyerCommand(this, ballIntakeSolenoid);
  public IntakeSubsystem() {

    // Robot.initializeSparkDefaults(intakeMotor, intakeConveyor);

  }


    public void initTeleop () {
      //new EncoderReporter(intakeTalon).start();

      //Robot.initializeTalonDefaults(intakeTalon);
    }

    public static void initControls() {

    RobotMap.intakeGateButton.whenPressed(new InstantCommand(() -> IntakeGateCommand.setIntakeGatePosition(IntakeSubsystem.IntakeGatePosition.UP)));
     // intakeArmButton.whenReleased(new InstantCommand(() -> this.intakeArmCommand.setIntakeArmPosition(UP)));

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







