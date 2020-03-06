package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.ArduinoSensors;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.SM;
import frc.robot.ShuffleboardManagement;
import frc.robot.subsystems.DriveSubsystem;

import java.io.Writer;
import java.util.Map;

import static frc.robot.RobotMap.REGULAR_SPEED;

public class SMDrive extends CommandBase {

  //This class ...

  private DriveSubsystem driveSubsystem;
  private XboxController xbox = SM.xBoxController;
  private boolean useArcadeInsteadOfBradford = false;
  public boolean polarityBoolean = false;

  private double lastLeftStickVal = 0;
  private double lastRightStickVal = 0;
  private int polarity = 1;

  //Ultrasonic ultra = new Ultrasonic(RobotMap.ultraSonicPing,RobotMap.ultraSonicEcho);

  private double joystickChangeLimit;
  String chosenColor = "no color";

  Writer writer;

  public SMDrive(DriveSubsystem driveSubsystem) {
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }

  @Override
  public void initialize() {
    DriverStation.reportWarning("Starting SMDrive", false);
    joystickChangeLimit = RobotContainer.prefs.getDouble("JoystickChangeLimit", .03);
    driveSubsystem.roboDrive.setMaxOutput(RobotContainer.prefs.getFloat("SMMaxSpeed", REGULAR_SPEED));


    /*
    try {
      writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Timer.getFPGATimestamp() + ".txt"), StandardCharsets.UTF_8));
    } catch (IOException e) {
      e.printStackTrace();
    }*/
    //ultra.setAutomaticMode(true);
  }

  @Override
  public void execute() {


    double measuredLeft;
    double measuredRight;
    //if(ArduinoSensors.getInstance().getSwitchBool()){
     //System.out.println(":)");
    //}
    //System.out.println(ArduinoSensors.getInstance().getLRFinches());
    if (xbox.getRawButtonPressed(7)) {
      useArcadeInsteadOfBradford = !useArcadeInsteadOfBradford;
      lastRightStickVal = 0;
      lastLeftStickVal = 0;
      SM.rumbleController(xbox, .5, 500);
    }

    //The Xbox command that switches the controls in order to drive backwards
    if (xbox.getBButtonPressed()) {
      polarityBoolean = !polarityBoolean;
     ShuffleboardManagement.getInstance().setReversedControlValue(polarityBoolean); //connects shuffleboard to b button
      polarity *= -1;
      SM.rumbleController(xbox, 0.2, 500);

    }
    if (useArcadeInsteadOfBradford) {
      /*
      measuredLeft = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kLeft), lastLeftStickVal, joystickChangeLimit);
      measuredRight = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kRight), lastRightStickVal, joystickChangeLimit);
      driveSubsystem.roboDrive.tankDrive(measuredLeft, measuredRight, true);*/
      measuredLeft = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kLeft), lastLeftStickVal, joystickChangeLimit);
      measuredRight = DriveSubsystem.slewLimit(xbox.getX(GenericHID.Hand.kLeft), lastRightStickVal, joystickChangeLimit);
      driveSubsystem.roboDrive.arcadeDrive(-measuredLeft* polarity, measuredRight* polarity, true);
      /** changed to arcade at top **/
    } else {
      measuredLeft = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kLeft), lastLeftStickVal, joystickChangeLimit);
      measuredRight = DriveSubsystem.slewLimit(xbox.getX(GenericHID.Hand.kRight), lastRightStickVal, joystickChangeLimit);
      driveSubsystem.roboDrive.arcadeDrive(-measuredLeft* polarity, measuredRight* polarity, true);

      /*
      try {
        writer.write(Timer.getFPGATimestamp() + "measuredLeft" + measuredLeft + " measuredRight" + measuredRight + " rawXRight" + -xbox.getX(GenericHID.Hand.kRight));
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      */
    }

    lastLeftStickVal = measuredLeft;
    lastRightStickVal = measuredRight;
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.roboDrive.stopMotor();
    DriverStation.reportWarning("Stopped SMDrive", false);
    //try {writer.close();} catch (Exception ex) {/*ignore*/}
  }



  @Override
  public boolean isFinished() {
    return false;
  }




}
