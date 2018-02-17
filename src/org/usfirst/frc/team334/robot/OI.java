package org.usfirst.frc.team334.robot;

import java.util.ArrayList;
import java.util.Arrays;

import org.usfirst.frc.team334.robot.commands.drivetrain.ToggleTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.elevator.CollapseElevatorCommand;
import org.usfirst.frc.team334.robot.commands.elevator.SetElevatorToExchangeCommand;
import org.usfirst.frc.team334.robot.commands.elevator.SetElevatorToScaleCommand;
import org.usfirst.frc.team334.robot.commands.elevator.SetElevatorToSwitchCommand;

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
		controls = new ArrayList<>(Arrays.asList(leftJoystick, rightJoystick, xbox));
    
		// Init Buttons
		Button shiftGears = new JoystickButton(controls.get(Constants.SWITCH_GEAR_CONTROL), Constants.SWITCH_GEAR_BUTTON);
		
		Button raiseElevatorToSwitch = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.ELEVATOR_TO_SWITCH_BUTTON);
		Button raiseElevatorToScale = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.ELEVATOR_TO_SCALE_BUTTON);
		Button raiseElevatorToExchange = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.ELEVATOR_TO_EXCHANGE_BUTTON);
		Button collapseElevator = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL), Constants.COLLAPSE_ELEVATOR_BUTTON);
		
		// Button Actions
		shiftGears.whenPressed(new ToggleTransmissionCommand());
		
		raiseElevatorToSwitch.whenPressed(new SetElevatorToSwitchCommand());
		raiseElevatorToScale.whenPressed(new SetElevatorToScaleCommand());
		raiseElevatorToExchange.whenPressed(new SetElevatorToExchangeCommand());
		collapseElevator.whenPressed(new CollapseElevatorCommand());
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
