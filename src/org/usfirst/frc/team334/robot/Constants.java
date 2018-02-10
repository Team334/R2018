package org.usfirst.frc.team334.robot;

public class Constants {
	// Joystick ports
	public static final int JOYSTICK_LEFT = 0;
	public static final int JOYSTICK_RIGHT = 1;
	public static final int XBOX = 2;

	/* 
	 * Controls List -> Use in conjunction button mappings.
	 * 0 -> Left Joystick
	 * 1 -> Right Joystick
	 * 2 -> Xbox
	*/

	public static final int SWITCH_GEAR_CONTROL = 0;

	// Button mappings. The controller device for each button is set above.
	public static final int SWITCH_GEAR_BUTTON = 1;

	// Motors
	public static final int DRIVETRAIN_LEFT = 0;
	public static final int DRIVETRAIN_RIGHT = 1;

	// Pancake Solenoids
	public static final int PANCAKE_L_INPUT = 0;
	public static final int PANCAKE_L_OUTPUT = 1;
	public static final int PANCAKE_R_INPUT = 2;
	public static final int PANCAKE_R_OUTPUT = 3;

	// Compressor
	public static final int COMPRESSOR = 0;
	public static final int PRESSURE_SENSOR = 0;
	public static final int FORCE_COMPRESSOR_BUTTON = 2;

	// Elevator
	public static final int ELEVATOR_MOTOR_1 = 6;
	public static final int ELEVATOR_MOTOR_2 = 7;

	// Vision
	public static final String VISION_NT_NAME = "vision";
}