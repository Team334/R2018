package org.usfirst.frc.team334.robot;

public class Constants {

    // Joystick ports
    public static final int JOYSTICK_LEFT = 0;
    public static final int JOYSTICK_RIGHT = 1;
    public static final int ELEVATOR_CONTROL = 2;

    public static final int SWITCH_GEAR_CONTROL = 0;
    public static final int INTAKE_SPEED_HIGH_CONTROL = 2;
    
    // Button mappings for elevator joystick
    public static final int FOLD_INTAKE_BUTTON = 1;
    public static final int UNFOLD_INTAKE_BUTTON = 2;
    public static final int GRAB_BUTTON = 3;
    public static final int RELEASE_BUTTON = 4;
    
    // Buttons mappings for left joystick
    public static final int SWITCH_GEAR_BUTTON = 1;

    // Button mappings for right joystick
    public static final int ELEVATOR_TO_SWITCH_BUTTON = 2;
    public static final int ELEVATOR_TO_SCALE_BUTTON = 3;
    public static final int ELEVATOR_TO_EXCHANGE_BUTTON = 4;
    public static final int COLLAPSE_ELEVATOR_BUTTON = 5;

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

    // Encoders - Drivetrain
    public static final int ENCODER_L_DRIVETRAIN_A = 3;
    public static final int ENCODER_L_DRIVETRAIN_B = 2;
    public static final int ENCODER_R_DRIVETRAIN_A = 4;
    public static final int ENCODER_R_DRIVETRAIN_B = 5;

    // Compressor
    public static final int COMPRESSOR = 0;
    public static final int PRESSURE_SENSOR = 0;

    // Elevator ports
    public static final int ELEVATOR_MOTOR_L = 0;
    public static final int ELEVATOR_MOTOR_R = 1;

    // Elevator Sensors (Limit Switches + Encoder)
    public static final int ELEVATOR_LIMIT_TOP = 6;
    public static final int ELEVATOR_LIMIT_BOTTOM = 15; // PLACEHOLDER
    public static final int ELEVATOR_ENCODER_A = 8;
    public static final int ELEVATOR_ENCODER_B = 9;

    // Elevator Encoder PID
    public static final double ELEVATOR_ENC_P = 0.01;
    public static final double ELEVATOR_ENC_I = 0;
    public static final double ELEVATOR_ENC_D = 0;

    // Elevator Encoder Height Positions (Higher is negative)
    public static final int ELEVATOR_SWITCH_HEIGHT = -800;
    public static final int ELEVATOR_SCALE_HEIGHT = -2000;
    public static final int ELEVATOR_EXCHANGE_HEIGHT = 0;
    public static final int ELEVATOR_BOTTOM_HEIGHT = 0;

    // Vision
    public static final String VISION_NT_NAME = "vision";

    // Auton PID
    public static final double DRIVE_PID_SPEED = .75;

    public static final double DRIVE_HEADING_PID_P = 0.05;
    public static final double DRIVE_HEADING_PID_I = 0;
    public static final double DRIVE_HEADING_PID_D = 0;

    public static final double DRIVE_DISTANCE_PID_P = 0.085;
    public static final double DRIVE_DISTANCE_PID_I = 0;
    public static final double DRIVE_DISTANCE_PID_D = 0.02;

    // 0.03 Original P-Value
    public static final double TURN_P = 0.02;
    public static final double TURN_I = 0;
    public static final double TURN_D = 0.04;

    public static final double DRIVE_HEADING_PID_TARGET = 0;

    // Auton Movement (in inches)
    public static final double ENCODER_TICKS_PER_INCH = 20.3718327157626;
    public static final double DISTANCE_TO_BASELINE = ENCODER_TICKS_PER_INCH * 15;
    public static final int DISTANCE_FROM_WALL = 20;
    public static final int DISTANCE_TO_SWITCH_PARALLEL = 135;
    public static final int DISTANCE_TO_SWITCH_REAR = 147;
    public static final int DISTANCE_TO_SCALE_DIAGONAL = 230;
    public static final int SCALE_GAP_DISTANCE_AFTER_TURN = 5;
    public static final int BACK_AWAY_FROM_SCALE = -10;
    public static final int SWITCH_GAP_DISTANCE_AFTER_TURN = 50;
    public static final int ALLEYWAY_GAP_DISTANCE_AFTER_TURN = 30;
    public static final double ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL = 200;
    public static final double ALLEYWAY_TOTAL_LENGTH = 3000 / ENCODER_TICKS_PER_INCH;
    public static final double DISTANCE_HALFWAY_TO_SWITCH = 60;

    // Subsystem speed multipliers
    public static final double DRIVETRAIN_SPEED_MULTIPLIER = 1;
    public static final double ELEVATOR_SPEED_MULTIPLIER = 1;
    
    // Intake
    public static final int INTAKE_MOTOR_L = 2;
    public static final int INTAKE_MOTOR_R = 3;
    public static final int INTAKE_WINDOW_MOTOR = 4;
    public static final int INTAKE_BOX_LIMITSWITCH_1 = 12; // PLACEHOLDER
    public static final int INTAKE_BOX_LIMITSWITCH_2 = 13; // PLACEHOLDER
    public static final double INTAKE_SPEED = 1;
    public static final double INTAKE_OUT_SPEED = -1;
}
