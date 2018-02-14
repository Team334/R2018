package org.usfirst.frc.team334.robot;

import java.util.ArrayList;
import java.util.Arrays;

import org.usfirst.frc.team334.robot.commands.Drivetrain.ToggleTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.Intake.GrabPowerCubeCommand;
import org.usfirst.frc.team334.robot.commands.Intake.ReleasePowerCubeCommand;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	boolean shiftState;
	// Joysticks and Xbox controls
	private Joystick leftJoystick;
	private Joystick rightJoystick;
	private XboxController xbox;
	private ArrayList<GenericHID> controls;
	
	public OI() {
		leftJoystick = new Joystick(Constants.JOYSTICK_LEFT);
		rightJoystick = new Joystick(Constants.JOYSTICK_RIGHT);
		xbox = new XboxController(Constants.XBOX);
		controls = new ArrayList<>(
			Arrays.asList(leftJoystick, rightJoystick, xbox));

		// Init Buttons
		Button shiftGears = new JoystickButton(controls.get(Constants.SWITCH_GEAR_CONTROL), Constants.SWITCH_GEAR_BUTTON);
		Button grabBox = new JoystickButton(controls.get(Constants.GRAB_CONTROL),Constants.GRAB_BUTTON);
		Button releaseBox = new JoystickButton(controls.get(Constants.RELEASE_CONTROL),Constants.RELEASE_BUTTON);
		
		// Button Actions
		shiftGears.whenPressed(new ToggleTransmissionCommand());
		grabBox.whileHeld(new GrabPowerCubeCommand());
		releaseBox.whileHeld(new ReleasePowerCubeCommand());

	 }
	
	public Joystick getLeftJoystick() {
		return this.leftJoystick;
	}
	
	public Joystick getRightJoystick() {
		return this.rightJoystick;
	}
	
	public XboxController getXBoxController() {
		return this.xbox;
	}
	
}
