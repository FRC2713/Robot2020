package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakeSubsystem extends SubsystemBase {
  public final CANSparkMax intakePulley = new CANSparkMax(RobotMap.intakeTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final CANSparkMax intakeArm = new CANSparkMax(RobotMap.intakeArmTalonPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public final DoubleSolenoid intakeArmSolenoid = new DoubleSolenoid(RobotMap.intakeArmUpNode, RobotMap.intakeArmDownNode);
  public final DoubleSolenoid gateSolenoid = new DoubleSolenoid(RobotMap.IntakeGateUpNode, RobotMap.IntakeGateDownNode);
  private boolean isGateOpen = false;
  //public final DoubleSolenoid humanIntakeSolenoid = SM.getDoubleSolenoid(RobotMap.humanIntakeUpNode, RobotMap.humanIntakeDownNode);
  //public final iRaidersButton intakeGateUpButton = new iRaidersButton(SM.xBoxController, RobotMap.intakeGateUpButtonNum);
  //public final JoystickButton intakeGateDownButton = new JoystickButton(SM.xBoxController, RobotMap.intakeGateDownButtonNum);
  //public final JoystickButton intakeOnButton = new JoystickButton(SM.xBoxController, RobotMap.intakeOnButtonNum);
  //public final iRaidersButton intakeReverse = new iRaidersButton(SM.xBoxController, RobotMap.reverseIntakeButtonNum);
  //public final iRaidersButton humanIntake = new iRaidersButton(SM.xBoxController, RobotMap.reverseIntakeButtonNum);
  //private boolean toggleState = true;
  //private boolean testyIntake = false;
  //private double triggerPreviousValue;


  /*
    //public final IntakeCountCommand intakeCountCommand = new IntakeCountCommand(this);
    public final HumanIntakeCommand humanIntakeCommand = new HumanIntakeCommand(this);
    public final IntakeGateCommand intakeGateCommand = new IntakeGateCommand(this);
    public final IntakeConveyerCommand intakeConveyerCommand = new IntakeConveyerCommand(this);

   */
  public IntakeSubsystem() {

    // Robot.initializeSparkDefaults(intakeMotor, intakeConveyor);

  }


  public void initTeleop() {
    //new EncoderReporter(intakeTalon).start();

    //Robot.initializeTalonDefaults(intakeTalon);
  }

  public void setIntakeMotor(double speed) {
    intakeArm.set(speed);
  }
  public void setConveyorMotor(double speed){
    intakePulley.set(speed);
  }

  public void setSolState(boolean state){
    if(state) {
      System.out.println("ARM : " + state);
      intakeArmSolenoid.set(Value.kReverse);
    }
    else {
      System.out.println("ARM : " + state);
      intakeArmSolenoid.set(Value.kForward);
    }
  }
  public void setGateState(boolean isOpen){
    if(isOpen){
      gateSolenoid.set(Value.kForward);//open
      isGateOpen = true;
    }
    else{
      gateSolenoid.set(Value.kReverse);//closed
      isGateOpen = false;
    }
  }
  public boolean isGateOpen(){
    return isGateOpen;
  }

}

