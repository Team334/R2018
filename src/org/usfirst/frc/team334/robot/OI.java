package org.usfirst.frc.team334.robot;

import java.util.ArrayList;

import org.usfirst.frc.team334.robot.commands.drivetrain.FillAirTanksCommand;
import org.usfirst.frc.team334.robot.commands.drivetrain.ToggleTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    
    // Joystick controls
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick elevatorJoystick;
    private Joystick intakeJoystick;
    private ArrayList<GenericHID> controls;

    // Button controls
    private Button shiftGears;

    private Button grabBox;
    private Button releaseBox;
    
    private Button compressme;

    public OI() {
        leftJoystick = new Joystick(Constants.JOYSTICK_LEFT);
        rightJoystick = new Joystick(Constants.JOYSTICK_RIGHT);
        elevatorJoystick = new Joystick(Constants.ELEVATOR_CONTROL);
        intakeJoystick = new Joystick(Constants.JOYSTICK_INTAKE_PITCH);
        controls = new ArrayList<>();
        controls.add(leftJoystick);
        controls.add(rightJoystick);
        controls.add(elevatorJoystick);
        controls.add(intakeJoystick);

        // Initialize Buttons
        shiftGears = new JoystickButton(controls.get(Constants.JOYSTICK_LEFT), Constants.SWITCH_GEAR_BUTTON);
        grabBox = new JoystickButton(controls.get(Constants.JOYSTICK_INTAKE_PITCH), Constants.GRAB_BUTTON);
        releaseBox = new JoystickButton(controls.get(Constants.JOYSTICK_INTAKE_PITCH), Constants.RELEASE_BUTTON);
        compressme = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.COMPRESS_ME);

        // Button Actions
        shiftGears.whenPressed(new ToggleTransmissionCommand());
        grabBox.whileHeld(new GrabPowerCubeCommand());
        releaseBox.whenPressed(new ReleasePowerCubeCommand());
        
        compressme.whileHeld(new FillAirTanksCommand());
        
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
    
    public Joystick getIntakeJoystick() {
        return this.intakeJoystick;
    }

}
