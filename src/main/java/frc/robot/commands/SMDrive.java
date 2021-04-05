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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.buttonCommands.left90;

import java.io.Writer;
import java.util.Map;

import static frc.robot.RobotMap.REGULAR_SPEED;

public class SMDrive extends CommandBase {

  //This class ...

  private DriveSubsystem driveSubsystem;
  private XboxController xbox = SM.xBoxController;
  private boolean polarityBoolean = false;
  String[] drivemode = {"Tank","Arcade","Bradford"};
  private int driveMode = 2;

  private double lastLeftStickVal = 0;
  private double lastRightStickVal = 0;
  private int polarity = 1;
  private boolean bPressed = false;
  private boolean autoTurn = false;
  private int povDeg = -1;
  left90 turnLeft = new left90();
  //Ultrasonic ultra = new Ultrasonic(RobotMap.ultraSonicPing,RobotMap.ultraSonicEcho);

  private double joystickChangeLimit;
  private String chosenColor = "no color";

  private Writer writer;

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
      driveMode++;
      if (driveMode > 2) {
        driveMode = 0;
      }
      lastRightStickVal = 0;
      lastLeftStickVal = 0;
      SM.rumbleController(xbox, .5, 500);
      System.out.println("switch active");

    }

    SmartDashboard.putString("Drive Mode is ",drivemode[driveMode]);

    //The Xbox command that switches the controls in order to drive backwards
    if (getBPressed()) {
      //  Timer.delay(0.5);
      polarityBoolean = !polarityBoolean;
      ShuffleboardManagement.getInstance().setReversedControlValue(polarityBoolean); //connects shuffleboard to b button
      polarity *= -1;
      SM.rumbleController(xbox, 0.5, 500);
    }

    if (!polarityBoolean) System.out.println("reverse not active");
    if (polarityBoolean) System.out.println("reverse active");

    //POV (D-pad) button commands linked to the turn functions
    povDeg = xbox.getPOV();
    switch (povDeg) {
      default:
      case -1:
        autoTurn = false;

        break;

      //Left 90
      case 90:
        autoTurn = true;
        break;
    }


    // 0 - Tank, 1 - Arcade, 2 - Bradford

    if(!autoTurn) {

      switch (driveMode) {
        //tank
        case 0:
          measuredLeft = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kLeft), lastLeftStickVal, joystickChangeLimit);
          measuredRight = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kRight), lastRightStickVal, joystickChangeLimit);
          driveSubsystem.roboDrive.tankDrive(-measuredLeft *polarity, -measuredRight * polarity, true);

          break;
        //arcade
        case 1:
          measuredLeft = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kLeft), lastLeftStickVal, joystickChangeLimit);
          measuredRight = DriveSubsystem.slewLimit(xbox.getX(GenericHID.Hand.kLeft), lastRightStickVal, joystickChangeLimit);
          driveSubsystem.roboDrive.arcadeDrive(-measuredLeft* polarity, measuredRight* polarity, true);

          break;
        //bradford
        default:
        case 2:
          measuredLeft = DriveSubsystem.slewLimit(xbox.getY(GenericHID.Hand.kLeft), lastLeftStickVal, joystickChangeLimit);
          measuredRight = DriveSubsystem.slewLimit(xbox.getX(GenericHID.Hand.kRight), lastRightStickVal, joystickChangeLimit);
          driveSubsystem.roboDrive.arcadeDrive(-measuredLeft* polarity, measuredRight* polarity, true);

          break;

    }

     /*
      try {
        writer.write(Timer.getFPGATimestamp() + "measuredLeft" + measuredLeft + " measuredRight" + measuredRight + " rawXRight" + -xbox.getX(GenericHID.Hand.kRight));
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      */

      if (RobotBase.isSimulation()) {
        System.out.print("Dive Mode: ");
        System.out.println(drivemode[driveMode]);
        System.out.println("Speed: " + -measuredLeft * polarity);
        System.out.println("Turn: " + measuredRight * polarity);
        System.out.println("Polarity: " + polarity);
      }

      lastLeftStickVal = measuredLeft;
      lastRightStickVal = measuredRight;
    }

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
    //try { writer.close(); } catch (Exception ex) {/*ignore*/}
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
