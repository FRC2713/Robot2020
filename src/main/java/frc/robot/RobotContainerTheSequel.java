package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;

public class RobotContainerTheSequel {

  //Controllers
  public static XboxController xBoxController;

  //Subsystems
  public final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final ClimberSubsystem climberSubsystem = new ClimberSubsystem();

  //Buttons
  public final JoystickButton buttonB = new JoystickButton(xBoxController, XboxController.Button.kB.value);
  public final JoystickButton bumperLeft = new JoystickButton(xBoxController, XboxController.Button.kBumperLeft.value);

  // TODO: declare sticks (tank drive)

  public RobotContainerTheSequel() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // left = A value from [-1 to 1] that represents the left stick input
    // right = A value from [-1 to 1] that represents the right stick input
    // subsytem.setDefaultCommand(left, right)


    climberSubsystem.initControls();
  }


}
