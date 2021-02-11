package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.*;
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
  private boolean bPressed = false;

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
    joystickChangeLimit = RobotContainer.prefs.getDouble("JoystickChangeLimit", .03); //This is the slew variable. Bigger number = less slew, and vice versa.
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
    xbox = SM.xBoxController;
    //if(ArduinoSensors.getInstance().getSwitchBool()){
     //System.out.println(":)");
    //}
    //System.out.println(ArduinoSensors.getInstance().getLRFinches());
    if (xbox.getRawButtonPressed(7)) {
      useArcadeInsteadOfBradford = !useArcadeInsteadOfBradford;
      lastRightStickVal = 0;
      lastLeftStickVal = 0;
      SM.rumbleController(xbox, .5, 500);
      System.out.println("switch active");

    }
    System.out.println("reverse not active");

    //The Xbox command that switches the controls in order to drive backwards
    if (getBPressed()) {
      System.out.println("reverse active");
    //  Timer.delay(0.5);
      polarityBoolean = !polarityBoolean;
      ShuffleboardManagement.getInstance().setReversedControlValue(polarityBoolean); //connects shuffleboard to b button
      polarity *= -1;
      SM.rumbleController(xbox, 0.5, 500);
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

    if (RobotBase.isSimulation()) {
      System.out.print("Dive Mode: ");
      if (useArcadeInsteadOfBradford) {
        System.out.println("Arcade");
      } else {
        System.out.println("Bradford");
      }
      System.out.println("Speed: " + -measuredLeft * polarity);
      System.out.println("Turn: " + measuredRight * polarity);
      System.out.println("Polarity: " + polarity);
    }

    lastLeftStickVal = measuredLeft;
    lastRightStickVal = measuredRight;

    if(SM.xBoxController.getBButtonPressed()){
      setBPressed();
    } else if (getBPressed()) {
      setBPressed();
    }
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.roboDrive.stopMotor();
    DriverStation.reportWarning("Stopped SMDrive", false);
    //try {writer.close();} catch (Exception ex) {/*ignore*/}
  }

  public boolean getBPressed(){
    return bPressed;
  }

  public void setBPressed(){
    bPressed = !bPressed;
  }


  @Override
  public boolean isFinished() {
    return false;
  }




}
