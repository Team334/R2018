package org.usfirst.frc.team334.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.pids.BNO055;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
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
	public static Encoder rEncoderLeft = new Encoder(Constants.ENCODER_L_DRIVETRAIN_A, Constants.ENCODER_L_DRIVETRAIN_B);
	public static Encoder rEncoderRight = new Encoder(Constants.ENCODER_R_DRIVETRAIN_A, Constants.ENCODER_R_DRIVETRAIN_B);
	public static Ultrasonic rUltrasonicR = new Ultrasonic(Constants.ULTRASONIC_L_DRIVETRAIN_PING, Constants.ULTRASONIC_L_DRIVETRAIN_ECHO);
	public static Ultrasonic rUltrasonicL = new Ultrasonic(Constants.ULTRASONIC_R_DRIVETRAIN_PING, Constants.ULTRASONIC_R_DRIVETRAIN_ECHO);
	public static BNO055 rGyro = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);
	
	private TalonSRX miniCimL,miniCimR,cim1L,cim2L,cim1R,cim2R;
	
	ArrayList<TalonSRX> left,right;
	
	public Drive() {
		miniCimL = new TalonSRX(Constants.DRIVETRAIN_MC_L);
		cim1L = new TalonSRX(Constants.DRIVETRAIN_C1_L);
		cim2L = new TalonSRX(Constants.DRIVETRAIN_C2_L);
		miniCimR = new TalonSRX(Constants.DRIVETRAIN_MC_R);
		cim1R = new TalonSRX(Constants.DRIVETRAIN_C1_R);
		cim2R = new TalonSRX(Constants.DRIVETRAIN_C2_R);

		left.add(miniCimL);
		left.add(cim1L);
		left.add(cim2L);
		right.add(miniCimR);
		right.add(cim1R);
		right.add(cim2R);
	}
	
	public void stop() {
		setLeft(0);
		setRight(0);
	}
	
	public void setLeft(double speed) {
		for(TalonSRX TSRX : left) {
			TSRX.set(com.ctre.phoenix.motorcontrol.ControlMode.Current, speed);
		}
	}
	
	public void setRight(double speed) {
		for(TalonSRX TSRX : right) {
			TSRX.set(com.ctre.phoenix.motorcontrol.ControlMode.Current, speed);
		}
	}

    public void initDefaultCommand() {
    	
    }
    
}