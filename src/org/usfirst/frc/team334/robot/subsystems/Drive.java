package org.usfirst.frc.team334.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team334.robot.BNO055;
import org.usfirst.frc.team334.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * DriveTrain for 2018 Robot 6 Victors (3 per side)
 */

public class Drive extends Subsystem {

	public enum DriveControlState {
		TANK_DRIVE_JOYSTICK_CONTROL, TURN_TO_HEADING, DRIVE_TOWARDS_SWITCH, DRIVE_TOWARDS_SCALE
	}

	private DriveControlState mDriveControlState;

	// Sensor declarations
	public static Encoder rEncoderLeft;
	public static Encoder rEncoderRight;
	public static BNO055 rGyro;

	private WPI_TalonSRX miniCimL;
	private WPI_TalonSRX miniCimR;
	private WPI_TalonSRX cim1L;
	private WPI_TalonSRX cim2L;
	private WPI_TalonSRX cim1R;
	private WPI_TalonSRX cim2R;

	ArrayList<WPI_TalonSRX> left;
	ArrayList<WPI_TalonSRX> right;

	public Drive() {
		rEncoderLeft = new Encoder(Constants.ENCODER_L_DRIVETRAIN_A, Constants.ENCODER_L_DRIVETRAIN_B);
		rEncoderRight = new Encoder(Constants.ENCODER_R_DRIVETRAIN_A, Constants.ENCODER_R_DRIVETRAIN_B);

		rGyro = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);

		miniCimL = new WPI_TalonSRX(Constants.DRIVETRAIN_MC_L);
		cim1L = new WPI_TalonSRX(Constants.DRIVETRAIN_C1_L);
		cim2L = new WPI_TalonSRX(Constants.DRIVETRAIN_C2_L);
		miniCimR = new WPI_TalonSRX(Constants.DRIVETRAIN_MC_R);
		cim1R = new WPI_TalonSRX(Constants.DRIVETRAIN_C1_R);
		cim2R = new WPI_TalonSRX(Constants.DRIVETRAIN_C2_R);

		left = new ArrayList<WPI_TalonSRX>();
		right = new ArrayList<WPI_TalonSRX>();

		left.add(miniCimL);
		left.add(cim1L);
		left.add(cim2L);
		right.add(miniCimR);
		right.add(cim1R);
		right.add(cim2R);

		for (WPI_TalonSRX talon : left) {
			talon.setInverted(false);
		}
		for (WPI_TalonSRX talon : right) {
			talon.setInverted(false);
		}
	}

	public void stop() {
		setLeft(0);
		setRight(0);
	}

	public void setLeft(double speed) {
		for (WPI_TalonSRX talon : left) {
			talon.set(speed);
		}
	}

	public void setRight(double speed) {
		for (WPI_TalonSRX talon : right) {
			talon.set(speed);
		}
	}

	public void setInvert() {
		for (WPI_TalonSRX talon : left) {
			talon.setInverted(true);
		}
		for (WPI_TalonSRX talon : right) {
			talon.setInverted(true);
		}
	}

	public void setNormal() {
		for (WPI_TalonSRX talon : left) {
			talon.setInverted(false);
		}
		for (WPI_TalonSRX talon : right) {
			talon.setInverted(false);
		}
	}

	public void initDefaultCommand() {

	}

}