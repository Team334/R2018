package org.usfirst.frc.team334.robot;

import java.util.ArrayList;
import java.util.Arrays;

import org.usfirst.frc.team334.robot.commands.ShiftToHighSpeedTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.ShiftToLowSpeedTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.TankDriveCommand;
import org.usfirst.frc.team334.robot.commands.ToggleTransmissionCommand;

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
	
	//Buttons
	
	public OI() {
		leftJoystick = new Joystick(Constants.JOYSTICK_LEFT);
		rightJoystick = new Joystick(Constants.JOYSTICK_RIGHT);
		xbox = new XboxController(Constants.XBOX);
		controls = new ArrayList<>(
			Arrays.asList(leftJoystick, rightJoystick, xbox));
		
		// every time this button is pressed, new instance of Tank Drive starts
		Button shiftGears = new JoystickButton(controls.get(Constants.SWITCH_GEAR_CONTROL), Constants.SWITCH_GEAR_BUTTON);
		
		shiftGears.whenPressed(new ToggleTransmissionCommand(shiftState));
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
	
	//Toggle gearing functions
	public void setShiftState(boolean newShiftState) {
		shiftState = newShiftState;
	}
	public boolean getShiftState() {
		return shiftState;
	}
}
