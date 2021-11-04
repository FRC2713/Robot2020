package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.visionSubsystems.PixySubsystem;

public class RobotContainerTheSequel {

  //Controllers
  public static XboxController xBoxController = new XboxController(0);

  //Subsystems
  public final DriveSubsystem driveSubsystem = new DriveSubsystem();
//  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
//  public final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  //Buttons
  public final JoystickButton buttonB = new JoystickButton(xBoxController, XboxController.Button.kB.value);
  public final JoystickButton bumperLeft = new JoystickButton(xBoxController, XboxController.Button.kBumperLeft.value);
  private final PixySubsystem pixySubsystem = new PixySubsystem();

  // TODO: declare sticks (tank drive)

  public RobotContainerTheSequel() {
    // Configure the button bindings
    configureButtonBindings();

    driveSubsystem.setDefaultCommand(new RunCommand(
      () -> {
        // function logic
        driveSubsystem.vroom(
          xBoxController.getTriggerAxis(GenericHID.Hand.kRight) - xBoxController.getTriggerAxis(GenericHID.Hand.kLeft),
          xBoxController.getX(GenericHID.Hand.kLeft)
        );
      }, driveSubsystem
    ));
  }

  private void configureButtonBindings() {
    // left = A value from [-1 to 1] that represents the left stick input
    // right = A value from [-1 to 1] that represents the right stick input
    // subsytem.setDefaultCommand(left, right)


//    climberSubsystem.initControls();
  }


}
