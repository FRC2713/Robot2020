/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.commandGroups.initLineOnly;
import frc.robot.commands.moveCommands.AutonomousCommand;
import frc.robot.commands.moveCommands.turnLeft45;
import frc.robot.commands.moveCommands.turnRight45;
import frc.robot.commands.visionCommands.PixyTracking;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final SM sm = new SM(); //Subsystem Management (SM) needs to be instantiated first
  public  static Preferences prefs = Preferences.getInstance();

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();
  private final PixyTracking pixyTracking = new PixyTracking(pixySubsystem);
  private final AutonomousCommand m_autonomousCommand = new AutonomousCommand(driveSubsystem);
  private final turnLeft45 turnLeft = new turnLeft45(driveSubsystem);
  private final turnRight45 turnRight = new turnRight45(driveSubsystem);
  private final initLineOnly initLineOnly = new initLineOnly(driveSubsystem);
  private final ShuffleboardManagement shuffleboardManagement = new ShuffleboardManagement();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final ClimberSubsystem climberSubsystem = new ClimberSubsystem();


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
    // An ExampleCommand will run in autonomous
      return initLineOnly;
  }

}
