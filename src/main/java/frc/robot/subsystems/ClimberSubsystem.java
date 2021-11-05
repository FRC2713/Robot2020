package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.WitchCommand;
import frc.robot.iRaidersButton;


public class ClimberSubsystem extends SubsystemBase {

  public static final CANSparkMax ClimberUp = new CANSparkMax(RobotMap.ClimberUpMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public static final CANSparkMax WitchOne = new CANSparkMax(RobotMap.WitchOneMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public static final CANSparkMax WitchTwo = new CANSparkMax(RobotMap.WitchTwoMotorPort, CANSparkMaxLowLevel.MotorType.kBrushed);
  public static final DigitalInput climberLimitSwitch = new DigitalInput(RobotMap.climberLimitSwitchPort);

  // public final iRaidersButton climberButton = new iRaidersButton (SM.leftAttack, RobotMap.climberButton);


  // public final iRaidersButton witchDownButton = new iRaidersButton(SM.leftAttack, RobotMap.witchUpButton);
  // public final iRaidersButton witchUpButton = new iRaidersButton(SM.leftAttack, RobotMap.witchDownButton);

  public final ClimbCommand climbCommand = new ClimbCommand(this);
  public final WitchCommand witchCommand = new WitchCommand(this);



  public ClimberSubsystem(){
    WitchTwo.follow(WitchOne);

  }

  public void initControls() {
//    climberButton.whileHeld(new InstantCommand(() -> climbCommand.setClimberPosition()));
//
//    witchUpButton.whileHeld(new InstantCommand(() -> witchCommand.setWitchPosition(ClimberSubsystem.WitchPosition.UP)));
//    witchDownButton.whileHeld(new InstantCommand(() -> witchCommand.setWitchPosition(ClimberSubsystem.WitchPosition.DOWN)));
  }
  //public enum ClimberPosition {
 //   UP, DOWN, STOPPED
  //}
  public enum WitchPosition {
    UP, DOWN, STOPPED
  }
  @Override
  public void periodic(){
   // climbCommand.setClimberPosition(ClimberPosition.STOPPED);
    witchCommand.setWitchPosition(WitchPosition.STOPPED);

  }

}
