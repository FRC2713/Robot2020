/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.IntakeGateCommand;
import frc.robot.commands.commandGroups.initLineOnly;
import frc.robot.commands.visionCommands.PixyTracking;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;
import frc.robot.commands.commandGroups.scoreFront;
import frc.robot.commands.commandGroups.scoreLeft;
import frc.robot.commands.commandGroups.scoreRight;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  DigitalInput PortSix = new DigitalInput(RobotMap.configSixPort);
  DigitalInput PortSeven = new DigitalInput(RobotMap.configSevenPort);
  DigitalInput PortEight = new DigitalInput(RobotMap.configEightPort);
  DigitalInput PortNine = new DigitalInput(RobotMap.configNinePort);

  // The robot's subsystems and commands are defined here...

  private final SM sm = new SM(); //Subsystem Management (SM) needs to be instantiated first
  public  static Preferences prefs = Preferences.getInstance();

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();
  private final PixyTracking pixyTracking = new PixyTracking(pixySubsystem);
  private final initLineOnly initLineOnly = new initLineOnly(driveSubsystem);
  private final ShuffleboardManagement shuffleboardManagement = new ShuffleboardManagement();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final IntakeGateCommand intakeGateCommand = new IntakeGateCommand(intakeSubsystem);
  private final scoreFront scoreFront = new scoreFront(driveSubsystem, intakeSubsystem, intakeGateCommand);
  private final scoreLeft scoreLeft = new scoreLeft(driveSubsystem, intakeSubsystem, intakeGateCommand);
  private final scoreRight scoreRight = new scoreRight(driveSubsystem, intakeSubsystem, intakeGateCommand);


  /**
   * The container for the robot.  Contains subsystems, SM devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    intakeSubsystem.initControls();
    climberSubsystem.initControls();
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //PORT 4 RETURNS INITIATION LINE ONLY
    //PORT 5 RETURNS SCORE FROM FRONT
    //PORT 6 RETURN SCORE FROM LEFT, FACING TOWARDS SCORING PORT
    //PORT 7 RETURNS SCORE FROM RIGHT, FACING TOWARDS SCORING PORT
    if(PortSix.get() == false) {
      return initLineOnly;
    }
    else if (PortSeven.get() == false) {
      return scoreFront;
    }
    else if (PortEight.get() == false) {
      return scoreLeft;
    }
    else if (PortNine.get() == false) {
      return scoreRight;
    }
    else return null;
  }

}
