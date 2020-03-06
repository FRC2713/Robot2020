/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import edu.wpi.cscore.*;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.SMDrive;
import frc.robot.subsystems.IntakeSubsystem;
import org.opencv.core.Mat;

import static frc.robot.subsystems.IntakeSubsystem.IntakeGatePosition.DOWN;
import static frc.robot.subsystems.IntakeSubsystem.IntakeGatePosition.UP;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  private LightSensor lightsensor = new LightSensor();
  public static final Compressor compressor = new Compressor();
  public WPI_TalonSRX sensorMotor;
  private ColorSensor m_colorSensor;
  VideoSink cs;
  private UsbCamera frontCamera;
  private UsbCamera backCamera;
  private int currCam = 1;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    SmartDashboard.putBoolean("is this running", false);
    initCamera();
    compressor.start();
  }
  private void initCamera() {
    frontCamera = CameraServer.getInstance().startAutomaticCapture(0);
    backCamera = CameraServer.getInstance().startAutomaticCapture(1);
    cs = CameraServer.getInstance().addSwitchedCamera("Switcheroo");

    frontCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    backCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    changeCamera();
  }
  private void changeCamera(){
    if(currCam == 1){
      currCam = 0;
      cs.setSource(frontCamera);
      SmartDashboard.putBoolean("is this running", true);
    }
    else if(currCam == 0){
      currCam = 1;
      cs.setSource(backCamera);
      SmartDashboard.putBoolean("is this running", true);
    }
    //outputStream.putFrame(image);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    //m_colorSensor.testFunction();
    //blightsensor.printOut();
    if(ConfigureBed.getInstance().configBedInit()== ConfigureBed.Jumper.ONE){
      //System.out.println("this is a test; 1");
    }
    else if(ConfigureBed.getInstance().configBedInit()== ConfigureBed.Jumper.TWO){
    //  System.out.println("this is a test; 2");
    }
    else if(ConfigureBed.getInstance().configBedInit()== ConfigureBed.Jumper.THREE){
  //    System.out.println("this is a test; 3");
    }
    else{
//      System.out.println("this is a test; 4");
    }

  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    m_robotContainer.intakeSubsystem.intakeGateCommand.setIntakeGatePosition(DOWN);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }
  //private final ColorSensor m_colorSensor = new ColorSensor();

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    if(SM.leftAttack.getRawButtonPressed(11)){
      SmartDashboard.putBoolean("joystick test", true);
    }

  }

  /**
   * This function is called periodically during operator control.
   */

  @Override
  public void teleopPeriodic() {
    if(SM.xBoxController.getBButtonPressed()){
      changeCamera();
    }
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public static void initializeSparkDefaults(CANSparkMax... sparks) {
    for (CANSparkMax spark : sparks) {
      spark.setSmartCurrentLimit(RobotMap.MAX_MOTOR_STALL_AMPS, RobotMap.MAX_MOTOR_FREE_AMPS);

    }
  }
}
