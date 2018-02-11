package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.pids.BNO055;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * DriveTrain for 2018 Robot
 * 6 Victors (3 per side)
 */

public class Drive extends Subsystem {

	public enum DriveControlState {
		TANK_DRIVE_JOYSTICK_CONTROL,
		TURN_TO_HEADING,
		DRIVE_TOWARDS_SWITCH, // for auton
		DRIVE_TOWARDS_SCALE // for auton
	}
	
	private DriveControlState mDriveControlState;
	
	// Sensor declarations
	public static Encoder rEncoderLeft = new Encoder(Constants.DRIVETRAIN_ENCODER_L_A, Constants.DRIVETRAIN_ENCODER_L_B);
	public static Encoder rEncoderRight = new Encoder(Constants.DRIVETRAIN_ENCODER_R_A, Constants.DRIVETRAIN_ENCODER_R_B);
	public static Ultrasonic rUltrasonicR = new Ultrasonic(Constants.ULTRASONIC_R_PING, Constants.ULTRASONIC_R_ECHO);
	public static Ultrasonic rUltrasonicL = new Ultrasonic(Constants.ULTRASONIC_L_PING, Constants.ULTRASONIC_L_ECHO);
	public static BNO055 rGyro = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);
	
	private VictorSP left;
	private VictorSP right;
	
	public Drive() {
		left = new VictorSP(Constants.DRIVETRAIN_LEFT);
		right = new VictorSP(Constants.DRIVETRAIN_RIGHT);
		right.setInverted(true);
	}
	
	public void stop() {
		setLeft(0);
		setRight(0);
	}
	
	public void setLeft(double speed) {
		left.set(speed);
	}
	
	public void setRight(double speed) {
		right.set(speed);
	}

    public void initDefaultCommand() {
    	
    }
    
}
