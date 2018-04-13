package org.usfirst.frc.team334.robot;

public class Constants {

    // > CONTROLLERS/OI

    // Joystick Ports
    public static final int JOYSTICK_LEFT = 0;
    public static final int JOYSTICK_RIGHT = 1;
    public static final int ELEVATOR_CONTROL = 2;
    public static final int JOYSTICK_INTAKE_PITCH = 3;
    
    // Button mappings for intake joystick
    public static final int GRAB_BUTTON = 3;
    public static final int RELEASE_BUTTON = 4;
    
    // Buttons mappings for left joystick
    public static final int SWITCH_GEAR_BUTTON = 1;

    // Subsystem Speed Multipliers
    public static final double DRIVETRAIN_SPEED_MULTIPLIER = 1;
    public static final double ELEVATOR_SPEED_MULTIPLIER = 1;
    public static final double INTAKE_FOLD_SPEED_MULTIPLIER = 1;
    
    // > DRIVETRAIN
    
    // Ports
    public static final int DRIVETRAIN_MC_L = 5;
    public static final int DRIVETRAIN_C1_L = 3;
    public static final int DRIVETRAIN_C2_L = 4;
    public static final int DRIVETRAIN_MC_R = 0;
    public static final int DRIVETRAIN_C1_R = 1;
    public static final int DRIVETRAIN_C2_R = 2;

    // Pancake Solenoids
    public static final int PANCAKE_L_INPUT = 0;
    public static final int PANCAKE_L_OUTPUT = 1;
    public static final int PANCAKE_R_INPUT = 2;
    public static final int PANCAKE_R_OUTPUT = 3;
    
    // Encoders
    public static final int ENCODER_L_DRIVETRAIN_A = 3;
    public static final int ENCODER_L_DRIVETRAIN_B = 2;
    public static final int ENCODER_R_DRIVETRAIN_A = 4;
    public static final int ENCODER_R_DRIVETRAIN_B = 5;

    // Compressor
    public static final int COMPRESSOR = 0;
    public static final int PRESSURE_SENSOR = 0;
    public static final int COMPRESS_ME = 4;

    // > ELEVATOR
    
    // Ports
    public static final int ELEVATOR_MOTOR_L = 0;
    public static final int ELEVATOR_MOTOR_R = 1;

    // Sensors (Limit Switches + Encoder)
    public static final int ELEVATOR_LIMIT_TOP = 6;
    public static final int ELEVATOR_LIMIT_BOTTOM = 7;
    public static final int ELEVATOR_ENCODER_A = 8;
    public static final int ELEVATOR_ENCODER_B = 9;

    // PID Values
    public static final double ELEVATOR_ENC_P = 0.01;
    public static final double ELEVATOR_ENC_I = 0;
    public static final double ELEVATOR_ENC_D = 0;

    // Encoder Height Positions (Encoder reads negative)
    public static final int ELEVATOR_SWITCH_HEIGHT = -800;
    public static final int ELEVATOR_SCALE_HEIGHT = -2000;
    public static final int ELEVATOR_EXCHANGE_HEIGHT = 0;
    public static final int ELEVATOR_BOTTOM_HEIGHT = 0;

    // > INTAKE
    
    // Ports
    public static final int INTAKE_MOTOR_L = 2;
    public static final int INTAKE_MOTOR_R = 3;
    public static final int INTAKE_WINDOW_MOTOR = 4;
    public static final int INTAKE_BOX_LIMITSWITCH_1 = 12; // PLACEHOLDER
    public static final int INTAKE_BOX_LIMITSWITCH_2 = 13; // PLACEHOLDER
    public static final double INTAKE_SPEED = 1;
    public static final double INTAKE_OUT_SPEED = -1;
    
    // > AUTON
    
    // PID Values
    public static final double DRIVE_HEADING_PID_P = 0.05;
    public static final double DRIVE_HEADING_PID_I = 0;
    public static final double DRIVE_HEADING_PID_D = 0;

    public static final double DRIVE_DISTANCE_PID_P = 0.085;
    public static final double DRIVE_DISTANCE_PID_I = 0;
    public static final double DRIVE_DISTANCE_PID_D = 0.02;

    public static final double TURN_P = 0.02; // 0.03 Original P-Value
    public static final double TURN_I = 0;
    public static final double TURN_D = 0.04;

    // Distances
    public static final double ENCODER_TICKS_PER_INCH = 20.3718327157626;
    public static final double DISTANCE_FROM_WALL = 20;
    public static final double DISTANCE_TO_SWITCH_PARALLEL = 135;
    public static final double DISTANCE_TO_SCALE_DIAGONAL = 230;
    public static final double SWITCH_GAP_DISTANCE_AFTER_TURN = 50;
    public static final double SWITCH_GAP_DISTANCE_AFTER_ALLEYWAY_TURN = 30;
    public static final double SWITCH_GAP_DISTANCE_AFTER_ALLEYWAY_DROP = 30;
    public static final double ALLEYWAY_GAP_DISTANCE_AFTER_TURN = 30;
    public static final double ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL = 190;
    public static final double ALLEYWAY_TOTAL_LENGTH = 3000 / ENCODER_TICKS_PER_INCH;
    public static final double DISTANCE_HALFWAY_TO_SWITCH = 60;
    public static final double DOUBLE_SCALE_GAP_DISTANCE = 20;
    public static final double DISTANCE_FIRST_TO_SECOND_CUBE = 5;
    
}
