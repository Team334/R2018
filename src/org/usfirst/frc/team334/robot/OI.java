package org.usfirst.frc.team334.robot;

import java.util.ArrayList;
import java.util.Arrays;

import org.usfirst.frc.team334.robot.commands.ShiftToHighSpeedTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.ShiftToLowSpeedTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// Joysticks and Xbox controls
	private Joystick leftJoystick;
	private Joystick rightJoystick;
	private XboxController xbox;
	private ArrayList<GenericHID> controls;
	
	//Buttons
	
	public OI() {
		leftJoystick = new Joystick(Constants.JOYSTICK_LEFT);
		rightJoystick = new Joystick(Constants.JOYSTICK_RIGHT);
		xbox = new XboxController(Constants.XBOX);
		controls = new ArrayList<>(
			Arrays.asList(leftJoystick, rightJoystick, xbox));
		
		// every time this button is pressed, new instance of Tank Drive starts
		Button toLowSpeed = new JoystickButton(controls.get(Constants.SWITCH_TO_LOW_SPEED_TRANSIMISSION_CONTROL), Constants.SWITCH_TO_LOW_SPEED_TRANSMISSION_BUTTON);
		Button toHighSpeed = new JoystickButton(controls.get(Constants.SWITCH_TO_HIGH_SPEED_TRANSMISSION_CONTROL), Constants.SWITCH_TO_HIGH_SPEED_TRANSMISSION_BUTTON);
		
		toHighSpeed.whenPressed(new ShiftToHighSpeedTransmissionCommand());
		toLowSpeed.whenPressed(new ShiftToLowSpeedTransmissionCommand());
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
