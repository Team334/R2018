package org.usfirst.frc.team334.robot;

import java.util.ArrayList;

import org.usfirst.frc.team334.robot.commands.drivetrain.ToggleTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    
    // Joysticks controls
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick elevatorJoystick;
    private ArrayList<GenericHID> controls;

    // Button controls
    private Button shiftGears;

    private Button grabBox;
    private Button releaseBox;
    private Button foldIntake;
    private Button unfoldIntake;

    public OI() {
        leftJoystick = new Joystick(Constants.JOYSTICK_LEFT);
        rightJoystick = new Joystick(Constants.JOYSTICK_RIGHT);
        elevatorJoystick = new Joystick(Constants.ELEVATOR_CONTROL);
        controls = new ArrayList<>();
        controls.add(leftJoystick);
        controls.add(rightJoystick);
        controls.add(elevatorJoystick);

        // Initialize Buttons
        shiftGears = new JoystickButton(controls.get(Constants.SWITCH_GEAR_CONTROL), Constants.SWITCH_GEAR_BUTTON);
        grabBox = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.GRAB_BUTTON);
        releaseBox = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.RELEASE_BUTTON);
        foldIntake = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.FOLD_INTAKE_BUTTON);
        unfoldIntake = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.UNFOLD_INTAKE_BUTTON);

        // Button Actions
        shiftGears.whenPressed(new ToggleTransmissionCommand());
        grabBox.whileHeld(new GrabPowerCubeCommand());
        releaseBox.whenPressed(new ReleasePowerCubeCommand());
        foldIntake.whenPressed(new FoldIntakeCommand());
        unfoldIntake.whenPressed(new UnfoldIntakeCommand());
        
    }

    public Joystick getLeftJoystick() {
        return this.leftJoystick;
    }

    public Joystick getRightJoystick() {
        return this.rightJoystick;
    }

    public Joystick getElevatorJoystick() {
        return this.elevatorJoystick;
    }

}
