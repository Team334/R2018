package org.usfirst.frc.team334.robot;

public class Constants {

    // Joystick ports
    public static final int JOYSTICK_LEFT = 0;
    public static final int JOYSTICK_RIGHT = 1;
    public static final int XBOX = 2;

    /*
     * Controls List -> Use in conjunction button mappings. 0 -> Left Joystick 1
     * -> Right Joystick 2 -> Xbox
     */

    public static final int SWITCH_GEAR_CONTROL = 0;
    public static final int ELEVATOR_CONTROL = 1;

    // Buttons mappings for left joystick
    public static final int SWITCH_GEAR_BUTTON = 1;

    // Button mappings for right joystick
    public static final int ELEVATOR_TO_SWITCH_BUTTON = 2;
    public static final int ELEVATOR_TO_SCALE_BUTTON = 3;
    public static final int ELEVATOR_TO_EXCHANGE_BUTTON = 4;
    public static final int COLLAPSE_ELEVATOR_BUTTON = 5;

    public static final int FORCE_COMPRESSOR_START_BUTTON = 2;

    // DriveTrain ports
    public static final int DRIVETRAIN_MC_L = 5;
    public static final int DRIVETRAIN_C1_L = 3;
    public static final int DRIVETRAIN_C2_L = 4;
    public static final int DRIVETRAIN_MC_R = 0;
    public static final int DRIVETRAIN_C1_R = 1;
    public static final int DRIVETRAIN_C2_R = 2;

    // Pancake Solenoids - Drivetrain
    public static final int PANCAKE_L_INPUT = 0;
    public static final int PANCAKE_L_OUTPUT = 1;
    public static final int PANCAKE_R_INPUT = 2;
    public static final int PANCAKE_R_OUTPUT = 3;

    // Ultrasonic Sensors - Drivetrain
    public static final int ULTRASONIC_L_DRIVETRAIN_PING = 0;
    public static final int ULTRASONIC_L_DRIVETRAIN_ECHO = 1;
    public static final int ULTRASONIC_R_DRIVETRAIN_PING = 2;
    public static final int ULTRASONIC_R_DRIVETRAIN_ECHO = 3;

    // Encoders - Drivetrain
    public static final int ENCODER_L_DRIVETRAIN_A = 4;
    public static final int ENCODER_L_DRIVETRAIN_B = 5;
    public static final int ENCODER_R_DRIVETRAIN_A = 8;
    public static final int ENCODER_R_DRIVETRAIN_B = 9;

    // Compressor
    public static final int COMPRESSOR = 0;
    public static final int PRESSURE_SENSOR = 0;

    // Elevator ports
    public static final int ELEVATOR_MOTOR_L = 0;
    public static final int ELEVATOR_MOTOR_R = 1;

    // Elevator Sensors (Limit Switches + Potentiometer)
    public static final int ELEVATOR_LIMIT_TOP = 6;
    public static final int ELEVATOR_LIMIT_BOTTOM = 7;
    public static final int ELEVATOR_POTENTIOMETER = 4;

    // Elevator Pot PID
    public static final double ELEVATOR_POT_P = 0;
    public static final double ELEVATOR_POT_I = 0;
    public static final double ELEVATOR_POT_D = 0;

    // Elevator Potentiometer Height Positions
    public static final int ELEVATOR_SWITCH_HEIGHT = 5;
    public static final int ELEVATOR_SCALE_HEIGHT = 5;
    public static final int ELEVATOR_EXCHANGE_HEIGHT = 5;
    public static final int ELEVATOR_BOTTOM_HEIGHT = 0;

    // Vision
    public static final String VISION_NT_NAME = "vision";

    // Auton
    public static final double WALL_FOLLOW_PID_SPEED = .5;
    public static final double DRIVE_PID_SPEED = .75;

    public static final double WALL_FOLLOW_P = 0.1;
    public static final double WALL_FOLLOW_I = 0;
    public static final double WALL_FOLLOW_D = 0.1;

    public static final double DRIVE_HEADING_PID_P = 0.01;
    public static final double DRIVE_HEADING_PID_I = 0;
    public static final double DRIVE_HEADING_PID_D = 0;

    public static final double DRIVE_DISTANCE_PID_P = 0.085;
    public static final double DRIVE_DISTANCE_PID_I = 0;
    public static final double DRIVE_DISTANCE_PID_D = 0.02;

    public static final double TURN_P = 0.07;
    public static final double TURN_I = 0;
    public static final double TURN_D = 0;

    public static final double DRIVE_HEADING_PID_TARGET = 0;

    // Auton Distances
    public static final double ENCODER_TICKS_PER_INCH = 20.38216560509554;
    public static final double DISTANCE_TO_BASELINE = ENCODER_TICKS_PER_INCH * 15;
    public static final int DISTANCE_FROM_WALL = 20;
    
    // Subsystem speed multipliers
    public static final double DRIVETRAIN_SPEED_MULTIPLIER = 1;
    public static final double ELEVATOR_SPEED_MULTIPLIER = 0.1;

}
