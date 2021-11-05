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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.OutputGateCommand;
import frc.robot.commands.commandGroups.*;
import frc.robot.commands.visionCommands.PixyTracking;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;
import frc.robot.util.ToggleIntake;


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

  public  static Preferences prefs = Preferences.getInstance();

  public final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();
  private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
  private final PixyTracking pixyTracking = new PixyTracking(pixySubsystem);
  private final initLineOnly initLineOnly = new initLineOnly(driveSubsystem);
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final calibrateAutonomous calibrateAutonomous = new calibrateAutonomous(driveSubsystem);
  private final barrelPathCommand barrelPathCommand = new barrelPathCommand(driveSubsystem);

  private final XboxController driveController = new XboxController(0);

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

    climberSubsystem.initControls();

    driveSubsystem.setDefaultCommand(new RunCommand(
      () -> {
        // function logic
        driveSubsystem.vroom(
          driveController.getTriggerAxis(GenericHID.Hand.kRight) - driveController.getTriggerAxis(GenericHID.Hand.kLeft),
          driveController.getX(GenericHID.Hand.kLeft)
        );
      }, driveSubsystem
    ));

    new JoystickButton(driveController, XboxController.Button.kX.value)
      .whenPressed(new IntakeArmCommand(intakeSubsystem, ToggleIntake.STOP));

    new JoystickButton(driveController, XboxController.Button.kA.value)
      .whenPressed(new IntakeArmCommand(intakeSubsystem, ToggleIntake.IN)).whenReleased(new IntakeArmCommand(intakeSubsystem, ToggleIntake.STOP));
    new JoystickButton(driveController, XboxController.Button.kB.value)
      .whenPressed(new IntakeArmCommand(intakeSubsystem, ToggleIntake.OUT)).whenReleased(new IntakeArmCommand(intakeSubsystem, ToggleIntake.STOP));
    new JoystickButton(driveController, XboxController.Button.kY.value)
      .whenPressed(new OutputGateCommand(intakeSubsystem));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return barrelPathCommand;
  }

}
