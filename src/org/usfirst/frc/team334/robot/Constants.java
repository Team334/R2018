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
	public static final int DRIVETRAIN_L = 0;
	public static final int DRIVETRAIN_R = 1;

	// Pancake Solenoids - Drivetrain
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
	
	// Ultrasonics
	public static final int ULTRASONIC_L_DRIVETRAIN_PING = 0;
	public static final int ULTRASONIC_L_DRIVETRAIN_ECHO = 1;
	public static final int ULTRASONIC_R_DRIVETRAIN_PING = 2;
	public static final int ULTRASONIC_R_DRIVETRAIN_ECHO = 3;
	
	// Encoder
	public static final int ENCODER_L_DRIVETRAIN_A = 4;
	public static final int ENCODER_L_DRIVETRAIN_B = 5;
	public static final int ENCODER_R_DRIVETRAIN_A = 8;
	public static final int ENCODER_R_DRIVETRAIN_B = 9;

	// Vision
	public static final String VISION_NT_NAME = "vision";
	
	// Auton
	public static final double WALL_FOLLOW_PID_SPEED = .5;
	
	// Auton Distances
	public static final double ENCODER_REVOLUTIONS_PER_INCH = 20.38216560509554;
	public static final double DISTANCE_TO_BASELINE = ENCODER_REVOLUTIONS_PER_INCH * 15; // ~20 revolutions per inch (4 in wheels) * 15 inches to baseline
	public static final int DISTANCE_FROM_WALL = 20; //inches
	
	//Intake
	public static final int INTAKE_MOTOR_L = 0;
	public static final int INTAKE_MOTOR_R = 1;
	public static final int GRAB_CONTROL = 1;
	public static final int GRAB_BUTTON = 10;
	public static final int RELEASE_CONTROL = 1;
	public static final int RELEASE_BUTTON = 9;
	public static final int INTAKE_SPEED_HIGH_BUTTON = 11;
	public static final int INTAKE_SPEED_HIGH_CONTROL = 1;
	public static final int INTAKE_ULTRASONIC_PING = 3;
	public static final int INTAKE_ULTRASONIC_OUTPUT = 4;
	public static final double INTAKE_GRAB_DISTANCE = 0.5;
	public static final double INTAKE_RELEASE_DISTANCE = 10;
	public static final double INTAKE_SPEED = 0.25;
	public static final double INTAKE_SPEED_HIGH = 1;
	public static final double INTAKE_OUT_SPEED = -0.25;
	public static final double INTAKE_OUT_SPEED_HIGH = -1;
	
	//Climber
	public static final int CLIMBER_MOTOR_1 = 10000;
	public static final int CLIMER_MOTOR_2 = 10001;
	public static final int CLIMBER_LIMITSWITCH_BOTTOM = 7;
	public static final int CLIMBER_LIMITSWITCH_TOP = 9;
	public static final double CLIMBER_RETRACT_SPEED = -0.5;
	public static final double CLIMBER_EXTEND_SPEED = 0.5;
	public static final int EXTEND_CONTROL = 1;
	public static final int EXTEND_BUTTON = 11;
	public static final int RETRACT_CONTROL = 1;
	public static final int RETRACT_BUTTON = 3;
}
